package org.example.demo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;


public class login {

    public Scene login_scene(Stage stage,double width,double height)
    {
        Font fontAwesome = Font.loadFont(getClass().getResourceAsStream("/fontawesome-webfont.ttf"),25);

        Text userIcon = new Text("\uf007");
        userIcon.setFont(fontAwesome);
        userIcon.getStyleClass().add("icon");


        //Label emailLabel = new Label("Email:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");

        // Create the password field
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        Text passIcon = new Text("\uf023");
        passIcon.setFont(fontAwesome);
        passIcon.getStyleClass().add("icon");

        //checkbox for remember me
        CheckBox rememberMeCheckBox = new CheckBox("Remember Me");
        rememberMeCheckBox.getStyleClass().add("check-box");
        HBox check_box = new HBox(10);
        check_box.setAlignment(Pos.CENTER);
        check_box.getChildren().add(rememberMeCheckBox);
        check_box.setPadding(new Insets(10));

        //create the login button
        Button loginButton = new Button("Login");
        //to trigger button by enter
        loginButton.setDefaultButton(true);
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            // add the methods that add email and password to Data Base
            // and go to the home page
            List<String> my_books = manager.getMyBooks(username);
            User user = new User(username,password,null,my_books);
            current_user.setCurrentUser(user);

            Scene s = new home().home_scene(stage,stage.getWidth(),stage.getHeight());
            scene_manager.setPrevious_scene(s);
            stage.setScene(s);

            stage.setTitle("Home Screen");
        });
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(loginButton);

        // Create a grid pane and arrange the components
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Add components to the grid
        grid.add(userIcon, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passIcon, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(check_box, 1, 2);
        grid.add(hbBtn, 1, 3);


        // add action to the link to go the sin-up screen
        Hyperlink signupLink = new Hyperlink(" I don't have an account ");
        signupLink.setOnAction(e -> {
            stage.setScene(new SinUp().sinup_scene(stage,stage.getWidth(),stage.getHeight()));
            stage.setTitle("Sin-up Screen");

        });
        signupLink.getStyleClass().add("hyperlink");

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(grid, signupLink);

        // Create the scene and set it on the stage
        Scene scene = new Scene(vbox, width-10, height-5);

        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        return scene;
    }
}
