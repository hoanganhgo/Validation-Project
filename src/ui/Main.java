package ui;

import framework.validation.ConstraintViolation;
import framework.validation.Validation;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

        DatePicker datePicker = new DatePicker();
        datePicker.setPrefSize(400, 40);
        datePicker.setStyle("-fx-font-size: 20px;");
        String pattern = "dd/MM/yyyy";
        datePicker.setPromptText(pattern);
        datePicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });

        Button signIn = new Button("Submit");
        signIn.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        signIn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            User user = new User(fieldEmail.getText(), fieldPhoneNumber.getText(), fieldPassword.getText(),
                    datePicker.getValue());

            Validation validation = Validation.getInstance();
            Set<ConstraintViolation> violations = validation.validate(user);

//            if (!ValidationHelper.isPhoneNumber(user.getPhone())) {
//                String message = "Phone number is invalid";
//                violations.add(new ConstraintViolationImpl(message, user.getPhone(), "phone", false));
//            }

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

            if (Controller.checkSubmit(notifyEmail, notifyPhone, notifyPassword, notifyDateOfBirth)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Sign Up");
                alert.setContentText("Submit form success!");

                alert.showAndWait();
            }
        });

        gridPane.add(title, 0, 0);
        gridPane.add(labelEmail, 0, 1);
        gridPane.add(fieldEmail, 0, 2);
        gridPane.add(labelPhoneNumber, 0, 3);
        gridPane.add(fieldPhoneNumber, 0, 4);
        gridPane.add(labelPassword,0,5);
        gridPane.add(fieldPassword, 0, 6);
        gridPane.add(labelDoB, 0, 7);
        gridPane.add(datePicker, 0, 8);
        gridPane.add(signIn, 0, 9);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
