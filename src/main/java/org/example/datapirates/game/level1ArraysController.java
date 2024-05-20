package org.example.datapirates.game;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class level1ArraysController {

    @FXML
    private Button previousbtn;

    @FXML
    private Button checkVisually;

    @FXML
    private Button chooseQuize;

    @FXML
    private Button playquizbtn;

    @FXML
    private TextArea textarea;

    @FXML
    private Button next;

    @FXML
    private Label label;

    private String[] texts = {
            "Introduction to Arrays\n\n" +
                    "An array is a fundamental data structure in computer programming that allows you to store a collection of elements of the same type. Arrays provide a convenient way to organize and access data sequentially, making them essential for many programming tasks.\n\n" +
                    "In an array, each element is identified by its index, which represents its position in the array. The index starts from 0 for the first element and increments by 1 for each subsequent element. This indexing scheme allows for efficient access to array elements.\n\n" +
                    "Arrays have a fixed size, meaning that once you create an array with a certain number of elements, you cannot change its size. This fixed size property makes arrays suitable for situations where you know the exact number of elements you need to store.\n\n" +
                    "Arrays are used in a wide range of applications, from simple list processing to complex algorithms. Understanding how arrays work is essential for mastering programming and solving various computational problems.",
            "How Arrays Work\n\n" +
                    "Arrays are typically initialized with a fixed size and a specific data type. For example, you can create an array of integers with ten elements using the following syntax in Java:\n\n" +
                    "int[] numbers = new int[10];\n\n" +
                    "This statement creates an array called \"numbers\" with a length of ten elements. The indices of the elements range from 0 to 9.\n\n" +
                    "To access an element in an array, you use its index within square brackets. For example, to access the third element in the \"numbers\" array, you would use the following syntax:\n\n" +
                    "int thirdElement = numbers[2];\n\n" +
                    "Notice that array indices start at 0, so the third element has an index of 2.\n\n" +
                    "Arrays can be modified by assigning new values to their elements. For example, you can change the value of the fifth element in the \"numbers\" array like this:\n\n" +
                    "numbers[4] = 42;\n\n" +
                    "This statement assigns the value 42 to the fifth element (index 4) of the \"numbers\" array.\n\n" +
                    "Understanding how arrays are initialized, accessed, and modified is crucial for effectively working with them in programming. Arrays provide a powerful tool for organizing and manipulating data in various algorithms and applications.",
            "Real-life Examples\n\n" +
                    "1. Shopping List: Imagine you're creating a shopping list in a program. You can use an array to store the items you need to buy, such as 'apples', 'bananas', 'bread', etc.\n\n" +
                    "2. Student Grades: Suppose you're developing a grading system. You can use an array to store the grades of students in a class, making it easy to calculate averages and analyze performance.\n\n" +
                    "3. Calendar Events: In a calendar application, you can use an array to store events scheduled for different dates. Each element of the array could represent a specific day, and you can store event details for that day."
    };

    private String[] labels = {
            "Introduction to Arrays",
            "How Arrays Work",
            "Real-life Examples"
    };

    private int currentIndex = 0;
    private int clickCount = 0;

    @FXML
    public void initialize() {
        //transition.createBackButtonHoverAnimation(previousbtn);
        updateText();
        //transition.createButtonScaleAnimation(next);
        transition.fadeInFadeOut(label);
    }


    @FXML
    void checkVisually(ActionEvent event) {
        openVisualScene(event);
    }

    @FXML
    void chooseQuize(ActionEvent event) {
        openTestQuizeHomeScene(event);
    }

    private void openVisualScene(ActionEvent event) {
        BackgroundMusicPlayer.getInstance().stopMusic();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/level1ArraysVisual.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            currentStage.close();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openTestQuizeHomeScene(ActionEvent event) {
        BackgroundMusicPlayer.getInstance().stopMusic();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/level1ArraysTestQuizeHome.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            currentStage.close();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void playQuize(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/level1ArraysQuize.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            currentStage.close();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onNextClicked(ActionEvent event) {
        clickCount++;
        if (clickCount < 3) {
            currentIndex++;
            if (currentIndex >= texts.length) {
                currentIndex = 0;
            }
            updateText();
        } else {
            openChooseScene(event);
        }
    }


    @FXML
    void backButton(ActionEvent event) {
        BackgroundMusicPlayer.getInstance().playMusic("/org/example/datapirates/images/proceedmusic.mp3");
        transition.backButtonClick(event, "/org/example/datapirates/game/map.fxml");
    }

    private void updateText() {
        if (textarea != null) {
            textarea.setText(texts[currentIndex]);
            label.setText(labels[currentIndex]);
        } else {
            System.out.print(" ");
        }
    }

    private void openChooseScene(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/choose.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            currentStage.close();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backToChooseOption(ActionEvent event) {
        BackgroundMusicPlayer.getInstance().playMusic("/org/example/datapirates/images/lvmusic.mp3");
        transition.backButtonClick(event, "/org/example/datapirates/game/choose.fxml");
    }

    @FXML
    void mainMap(ActionEvent event) {
        BackgroundMusicPlayer.getInstance().playMusic("/org/example/datapirates/images/proceedmusic.mp3");
        transition.backButtonClick(event, "/org/example/datapirates/game/map.fxml");
    }



//    private void updateNextButtonAnimation() {
//        double scaleFactor = 1.0 - (clickCount * 0.1);
//        transition.createButtonScaleAnimation(next, scaleFactor);
//    }

}
