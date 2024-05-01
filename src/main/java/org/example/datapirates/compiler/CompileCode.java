package org.example.datapirates.compiler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CompileCode {

    public static output compile(String codeSnippet, String language) throws IOException, InterruptedException, URISyntaxException {
        Code code = new Code();
        code.setCode(codeSnippet);
        code.setLanguage(language);
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

        return gson.fromJson(postResponse.body(), output.class);
    }
}
