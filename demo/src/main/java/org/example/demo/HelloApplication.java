package org.example.demo;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Login Screen");
        scene_manager.setPrevious_scene(new login().login_scene(stage,500,400));
        stage.setScene(new login().login_scene(stage,500,400));
        stage.show();

    }

    public static void main(String[] args) { launch(); }
}