package ui;

import framework.validation.ConstraintViolation;
import framework.validation.Validation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;

import java.util.Set;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sign In");

        //UI
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);

        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(1);
        gridPane.setVgap(10);

        Label title = new Label("Sign In");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        title.setTextFill(Color.BLUE);

        Label labelEmail = new Label();
        labelEmail.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        labelEmail.setTextFill(Color.RED);

        TextField fieldEmail = new TextField();
        fieldEmail.setPromptText("Enter your name");
        fieldEmail.setPrefSize(400,30);
        fieldEmail.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));

        Label labelPhoneNumber = new Label();
        labelPhoneNumber.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        labelPhoneNumber.setTextFill(Color.RED);

        TextField fieldPhoneNumber = new TextField();
        fieldPhoneNumber.setPromptText("Enter your number phone");
        fieldPhoneNumber.setPrefSize(400,30);
        fieldPhoneNumber.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));

        Label labelPassword = new Label();
        labelPassword.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        labelPassword.setTextFill(Color.RED);

        PasswordField fieldPassword = new PasswordField();
        fieldPassword.setPromptText("Enter password");
        fieldPassword.setPrefSize(400,30);
        fieldPassword.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));

        Label labelDoB = new Label();
        labelDoB.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
        labelDoB.setTextFill(Color.RED);

        TextField fieldDoB = new TextField();
        fieldDoB.setPromptText("Enter day of birth");
        fieldDoB.setPrefSize(400,30);
        fieldDoB.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));

        Button signIn = new Button("Submit");
        signIn.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        signIn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            User user = new User(fieldEmail.getText(), fieldPhoneNumber.getText(), fieldPassword.getText(),
                    fieldDoB.getText());

            Validation validation = Validation.getInstance();
            Set<ConstraintViolation> violations = validation.validate(user);

            String notifyEmail = "";
            String notifyPhone = "";
            String notifyPassword = "";
            String notifyDateOfBirth = "";

            for (ConstraintViolation violation : violations) {
                switch (violation.getProperty()) {
                    case "email":
                        notifyEmail += violation.getMessage() + ", ";
                        break;
                    case "phone":
                        notifyPhone += violation.getMessage() + ", ";
                        break;
                    case "password":
                        notifyPassword += violation.getMessage() + ", ";
                        break;
                    case "dob":
                        notifyDateOfBirth += violation.getMessage() + ", ";
                        break;
                }

                System.out.println(violation.getProperty() + "->" + violation.getMessage());
            }

            labelEmail.setText(notifyEmail);
            labelPhoneNumber.setText(notifyPhone);
            labelPassword.setText(notifyPassword);
            labelDoB.setText(notifyDateOfBirth);
        });

        gridPane.add(title, 0, 0);
        gridPane.add(labelEmail, 0, 1);
        gridPane.add(fieldEmail, 0, 2);
        gridPane.add(labelPhoneNumber, 0, 3);
        gridPane.add(fieldPhoneNumber, 0, 4);
        gridPane.add(labelPassword,0,5);
        gridPane.add(fieldPassword, 0, 6);
        gridPane.add(labelDoB, 0, 7);
        gridPane.add(fieldDoB, 0, 8);
        gridPane.add(signIn, 0, 9);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
