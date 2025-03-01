package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class MyBooks {
    public static Scene My_books_scene(Stage stage, double width, double height) {
        // Create the "Log out" button
        Button log_out_butt = new Button("Log out");
        HBox log_out = new HBox(10);
        log_out.setAlignment(Pos.CENTER);
        log_out.getChildren().add(log_out_butt);
        log_out_butt.setOnAction(e -> {
            stage.setScene(new login().login_scene(stage, stage.getWidth(), stage.getHeight()));
        });


        // Create the "Back" button
        Button backButton = new Button("Back");
        backButton.setCancelButton(true);
        backButton.setOnAction(e -> {
            stage.setScene(new home().home_scene(stage, stage.getWidth(), stage.getHeight()));
        });
        // this code is temp
        List<String> kinds = new ArrayList<>();
        kinds.add("my Book1");
        kinds.add("my Book2");
        kinds.add("my Book3");
        kinds.add("my Book4");
        kinds.add("my Book5");
        kinds.add("my Book6");
        kinds.add("my Book7");
        kinds.add("my Book8");
        kinds.add("my Book9");
        kinds.add("my Book10");
        kinds.add("my Book11");
        kinds.add("my Book12");
        // Create the ListView and bind its size
        ListView<String> categoryListView = new ListView<>();
        //ObservableList<String> categories = FXCollections.observableArrayList(manager.getMyBooks(current_user.getCurrentUser().getName()));
        ObservableList<String> categories = FXCollections.observableArrayList(kinds);
        categoryListView.setItems(categories);
        categoryListView.prefWidthProperty().bind(stage.widthProperty().multiply(0.45));
        categoryListView.prefHeightProperty().bind(stage.heightProperty().multiply(0.85));


        // Layout for the center (ListView)
        HBox root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(categoryListView);

        HBox bar = scene_manager.menu_bar_for_my_books(stage);

        // Use BorderPane to organize the layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(bar);
        borderPane.setCenter(root);

        // Create the scene
        Scene scene = new Scene(borderPane, width-10, height-5);
        scene.getStylesheets().add(category.class.getResource("styles.css").toExternalForm());

        // Set the scene to the stage
        return scene;
//        stage.setScene(scene);
//        stage.setTitle("My Books Screen");
    }
}
