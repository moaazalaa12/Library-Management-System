package org.example.demo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SinUp {
    private String username;
    private String email;
    private String password;

    public Scene sinup_scene(Stage stage,double width,double height){
        Font fontAwesome = Font.loadFont(getClass().getResourceAsStream("/fontawesome-webfont.ttf"),25);
        //  name - email - password
        TextField nameField = new TextField();
        nameField.setPromptText("Enter your Username");
        Text userIcon = new Text("\uf007");
        userIcon.setFont(fontAwesome);
        userIcon.getStyleClass().add("icon");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        Text emailIcon = new Text("\uf0e0");
        emailIcon.setFont(fontAwesome);
        emailIcon.getStyleClass().add("icon");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        Text passIcon = new Text("\uf023");
        passIcon.setFont(fontAwesome);
        passIcon.getStyleClass().add("icon");

        home h = new home();
        Button registerButton = new Button("Register");
        registerButton.setDefaultButton(true);
        registerButton.setOnAction(e -> {
            //add code to add info to DB and go to the home screen
            this.username = nameField.getText();
            this.email = emailField.getText();
            this.password = passwordField.getText();

            User user = new User(username,password,email,null);
            current_user.setCurrentUser(user);

            System.out.println("Name: " + username);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);

            stage.setScene(h.home_scene(stage,stage.getWidth(),stage.getHeight()));
            stage.setTitle("Home Screen");
        });

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(registerButton);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(nameField, 1, 0);
        grid.add(userIcon, 0, 0);
        grid.add(emailField, 1, 1);
        grid.add(emailIcon, 0, 1);
        grid.add(passwordField, 1, 2);
        grid.add(passIcon, 0, 2);
        grid.add(hbBtn, 1, 3);

        Hyperlink loginLink = new Hyperlink(" I have an account ");
        loginLink.setOnAction(e -> {
            stage.setScene(new login().login_scene(stage,stage.getWidth()-5,stage.getHeight()-10));
            stage.setTitle("Sin-up Screen");

        });
        loginLink.getStyleClass().add("hyperlink");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(grid, loginLink);


        Scene scene = new Scene(vbox, width-10, height-5);
        scene.getStylesheets().add(SinUp.class.getResource("styles.css").toExternalForm());

        return scene;
    }
}
