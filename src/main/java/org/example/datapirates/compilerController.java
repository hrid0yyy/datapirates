package org.example.datapirates;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.datapirates.dataBaseConnection.dbHandler;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static org.example.datapirates.dbOperation.connection;

public class compilerController implements Initializable {

    @FXML
    private TextArea codebox;

    @FXML
    private Label description;

    @FXML
    private Text result;

    @FXML
    private ChoiceBox<String> langChoice;
    private String[] language = {"python3","c","java","cpp17"};

    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public Problems getProblems() {
        return problems;
    }

    private Problems problems;

    @FXML
    private Label pid;

    @FXML
    private Label pname;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void loadProblems(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("problems.fxml"));
        root = loader.load();
        problemController problemHome = loader.getController();
        problemHome.setUserInfo(getUserInfo());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setProblems(Problems problems) {
        this.problems = problems;
        pid.setText(" Problem ID : "+problems.getProblemID());
        pname.setText(" Problem Name : "+problems.getProblemName());
        description.setText(" Description : "+problems.getProblemDescription());
        codebox.setText(problems.getCodeFormat());
    }
    private String Lang;

    public String getLang() {
        return Lang;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        langChoice.getItems().addAll(language);
        langChoice.setOnAction(this::setLang);
    }

    private void setLang(ActionEvent event) {
        this.Lang = langChoice.getValue();
    }
    @FXML
    void homeBtn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
        root = loader.load();
        dashboardcontroller home = loader.getController();
        home.setUserInfo(userInfo);
        home.initialize(null, null);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void compile(ActionEvent event) throws IOException, InterruptedException, URISyntaxException, SQLException {
        Code code = new Code();
        code.setCode(codebox.getText()+"\n"+problems.getDriverCode());
        code.setLanguage(getLang());
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Code.class, new CodeTypeAdapter())
                .create();

        String json = gson.toJson(code);
       System.out.println(json);


        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://online-code-compiler.p.rapidapi.com/v1/"))
                .header("X-RapidAPI-Key", "0bef477c4emshfa0da64e0b9b356p1de2a2jsn69aa87927c82")
                .header("X-RapidAPI-Host", "online-code-compiler.p.rapidapi.com")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        // Handle the response as needed
       gson = new GsonBuilder()
                .registerTypeAdapter(output.class, new OutputDeserializer())
                .create();

        output res = gson.fromJson(postResponse.body(), output.class);
        StringBuilder outputBuilder = new StringBuilder();
        if(res.getOutput().equals(problems.getOutput()))
        {
            outputBuilder.append("Accepted"+"\n").append(res.getOutput()).append("\n")
                    .append("Cpu Time : ").append(res.getCpuTime()).append("\n")
                    .append("Memory : ").append(res.getMemory());
            try {
                // Establish database connection
                Connection connection = dbHandler.getDbConnection();

                String insertSql = "DELETE FROM solved WHERE problemID = ? and userMail = ?";
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setInt(1, problems.getProblemID()); // Assuming problems.getProblemID() returns the problem ID
                insertStatement.setString(2, userInfo.getMail()); // Assuming userInfo is properly set

                // Execute the insert statement
                insertStatement.executeUpdate();


                // Prepare SQL statement to insert into the solved table
                insertSql = "INSERT INTO solved (problemID, userMail) VALUES (?, ?)";
                insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setInt(1, problems.getProblemID()); // Assuming problems.getProblemID() returns the problem ID
                insertStatement.setString(2, userInfo.getMail()); // Assuming userInfo is properly set

                // Execute the insert statement
                insertStatement.executeUpdate();

                // Close resources
                insertStatement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {

            outputBuilder.append("Not Accepted"+"\n").append(res.getOutput()).append("\n")
                    .append("Cpu Time : ").append(res.getCpuTime()).append("\n")
                    .append("Memory : ").append(res.getMemory());
        }



        // Prepare SQL statement to insert into the solved table
        String insertSql = "INSERT INTO attempted (problemID, userMail) VALUES (?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(insertSql);
        insertStatement.setInt(1, problems.getProblemID()); // Assuming problems.getProblemID() returns the problem ID
        insertStatement.setString(2, userInfo.getMail()); // Assuming userInfo is properly set

        // Execute the insert statement
        insertStatement.executeUpdate();
        result.setText(outputBuilder.toString());
    }

}
class OutputDeserializer implements JsonDeserializer<output> {

    @Override
    public output deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String cpuTime = jsonObject.get("cpuTime").getAsString();
        String memory = jsonObject.get("memory").getAsString();
        String output = jsonObject.get("output").getAsString();

        output outputObj = new output();
        outputObj.setCpuTime(cpuTime);
        outputObj.setMemory(memory);
        outputObj.setOutput(output);

        // Handle deserialization of the 'Language' field if needed

        return outputObj;
    }
}

class CodeTypeAdapter extends TypeAdapter<Code> {

    @Override
    public void write(JsonWriter out, Code code) throws IOException {
        out.beginObject();
        out.name("code").value(code.getCode());
        out.name("language").value(code.getLanguage());
        // Serialize other fields if needed
        out.endObject();
    }

    @Override
    public Code read(JsonReader in) throws IOException {
        // Implement deserialization if needed
        throw new UnsupportedOperationException("Deserialization is not supported.");
    }
}
class Code {
    private String code;
    private String language;

    private String version;
    private String input;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
class output {
    private String cpuTime;
    private String memory;
    private String output;
    private Language language;

    public String getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(String cpuTime) {
        this.cpuTime = cpuTime;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}



class Language {
    private String id;
    private int version;
    private String versionName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}


