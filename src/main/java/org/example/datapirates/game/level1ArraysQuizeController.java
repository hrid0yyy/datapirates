package org.example.datapirates.game;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class level1ArraysQuizeController {

    @FXML
    public Label question;

    @FXML
    public Button opt1, opt2, opt3, opt4;

    static int counter = 0;
    static int correct = 0;
    static int wrong = 0;

    @FXML
    private void initialize() {
        loadQuestions();
    }

    private void loadQuestions() {

        if (counter == 0) { //Question 1
            question.setText("1. What is the declaration of an array in Java?");
            opt1.setText("int[] arr = new int[5];");
            opt2.setText("int arr[5];");
            opt3.setText("int arr = [5];");
            opt4.setText("int arr[] = int[5];");
        }
        if (counter == 1) { //Question 2
            question.setText("2. Which method is used to find the length of an array in Java?");
            opt1.setText("arr.length();");
            opt2.setText("arr.size();");
            opt3.setText("arr.count();");
            opt4.setText("arr.length;");
        }
        if (counter == 2) { //Question 3
            question.setText("3. How do you access the third element of an array named 'arr'?");
            opt1.setText("arr[3];");
            opt2.setText("arr(3);");
            opt3.setText("arr[2];");
            opt4.setText("arr.get(3);");
        }
        if (counter == 3) { //Question 4
            question.setText("4. Which of the following statements is true about array indices in Java?");
            opt1.setText("Array indices start from 1.");
            opt2.setText("Array indices start from -1.");
            opt3.setText("Array indices start from 0.");
            opt4.setText("Array indices start from 10.");
        }
        if (counter == 4) {//Question 5
            question.setText("5. How do you access the fifth element of an array named 'arr' in Java?");
            opt1.setText("arr[4]");
            opt2.setText("arr[5]");
            opt3.setText("arr[0]");
            opt4.setText("arr[6]");
        }
        if (counter == 5) { //Question 6
            question.setText("6.What is the maximum number of elements that an array in Java can hold?");
            opt1.setText("255");
            opt2.setText("1000");
            opt3.setText("65535");
            opt4.setText("It depends on memory available.");
        }
        if (counter == 6) { //Question 7
            question.setText("7.Which of the following data structures is not based on arrays?");
            opt1.setText("Stack");
            opt2.setText("Queue");
            opt3.setText("Linked List");
            opt4.setText("Binary Search Tree");
        }
        if (counter == 7) { //Question 8
            question.setText("8.How do you initialize an array with predefined values in Java?");
            opt1.setText(" int[] numbers = {1, 2, 3, 4, 5};");
            opt2.setText("int[] numbers = new int[5]{1, 2, 3, 4, 5};");
            opt3.setText("int[] numbers = new int[5] {1, 2, 3, 4, 5};");
            opt4.setText("int numbers[] = {1, 2, 3, 4, 5};");
        }
        if (counter == 8) { //Question 9
            question.setText("9.What is the time complexity of accessing an element in an array in Java?");
            opt1.setText("O(1)");
            opt2.setText("O(log n)");
            opt3.setText("O(n)");
            opt4.setText("O(n^2)");
        }
        if (counter == 9) { //Question 10
            question.setText("10. World Environment Day is on -");
            opt1.setText("5th June");
            opt2.setText("5th July");
            opt3.setText("15th June");
            opt4.setText("25th June");
        }

    }


    @FXML
    public void opt1clicked(ActionEvent event) {
        checkAnswer(opt1.getText().toString());
        if (checkAnswer(opt1.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 9) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                BackgroundMusicPlayer.getInstance().playMusic("/org/example/datapirates/images/proceedmusic.mp3");
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/level1ArraysQuizeResult.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }

    }

    boolean checkAnswer(String answer) {

        if (counter == 0) {
            if (answer.equals("int[] arr = new int[5];")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 1) {
            if (answer.equals("arr.length();")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 2) {
            if (answer.equals("arr[2];")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 3) {
            if (answer.equals("Array indices start from 0.")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 4) {
            if (answer.equals("arr[4]")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 5) {
            if (answer.equals("It depends on memory available.")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 6) {
            if (answer.equals("Linked List")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 7) {
            if (answer.equals("int[] numbers = {1, 2, 3, 4, 5};")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 8) {
            if (answer.equals("O(1)")) {
                return true;
            } else {
                return false;
            }
        }
        if (counter == 9) {
            if (answer.equals("5th June")) {
                return true;
            } else {
                return false;
            }
        }
        return false;


    }

    @FXML
    public void opt2clicked(ActionEvent event) {
        checkAnswer(opt2.getText().toString());
        if (checkAnswer(opt2.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 9) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                BackgroundMusicPlayer.getInstance().playMusic("/org/example/datapirates/images/proceedmusic.mp3");
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/level1ArraysQuizeResult.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void opt3clicked(ActionEvent event) {
        checkAnswer(opt3.getText().toString());
        if (checkAnswer(opt3.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 9) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                BackgroundMusicPlayer.getInstance().playMusic("/org/example/datapirates/images/proceedmusic.mp3");
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/level1ArraysQuizeResult.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

    @FXML
    public void opt4clicked(ActionEvent event) {
        checkAnswer(opt4.getText().toString());
        if (checkAnswer(opt4.getText().toString())) {
            correct = correct + 1;
        } else {
            wrong = wrong + 1;
        }
        if (counter == 9) {
            try {
                System.out.println(correct);
                Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                thisstage.close();
                BackgroundMusicPlayer.getInstance().playMusic("/org/example/datapirates/images/proceedmusic.mp3");
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("/org/example/datapirates/game/level1ArraysQuizeResult.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            counter++;
            loadQuestions();
        }
    }

}

