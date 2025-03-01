package org.example.demo;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class category {
    public static void category_scene(Stage stage, ObservableList<String> observableList, double width, double height) {
        // Create the "Log out" button
//        Button log_out_butt = new Button("Log out");
//        HBox log_out = new HBox(10);
//        log_out.setAlignment(Pos.CENTER);
//        log_out.getChildren().add(log_out_butt);
//        log_out_butt.setOnAction(e -> {
//            current_user.clearCurrentUser();
//            stage.setScene(new login().login_scene(stage, stage.getWidth(), stage.getHeight()));
//        });

//        Button my_books_butt = new Button("My Books");
//        my_books_butt.setOnAction(e -> {
//            MyBooks.My_books_scene(stage,stage.getWidth(),stage.getHeight());
//        });

        // Create the "Back" button
//        Button backButton = new Button("Back");
//        HBox topBox = new HBox(10);
//        topBox.setAlignment(Pos.CENTER_LEFT); // Align children to the left
//        topBox.setPadding(new Insets(15));
//        topBox.getChildren().add(backButton);
//
//        // Add a spacer to push the "My Books" button to the right
//        HBox spacer = new HBox();
//        HBox.setHgrow(spacer, Priority.ALWAYS);
//        topBox.getChildren().add(spacer);
//        topBox.getChildren().add(my_books_butt);
//
//        backButton.setCancelButton(true);
//
//        // Set action for the "Back" button
//        backButton.setOnAction(e -> {
//            stage.setScene(new home().home_scene(stage, stage.getWidth(), stage.getHeight()));
//        });

        // Create the ListView and bind its size
        ListView<String> categoryListView = new ListView<>();
        categoryListView.setItems(observableList);
        // To make the list resizable with the window
        categoryListView.prefWidthProperty().bind(stage.widthProperty().multiply(0.45));
        categoryListView.prefHeightProperty().bind(stage.heightProperty().multiply(0.85));

        // Layout for the center (ListView)
        HBox root = new HBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(categoryListView);


        //menu bar
        HBox top_bar = scene_manager.menu_bar(stage);
        // Use BorderPane to organize the layout
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(top_bar);
        borderPane.setCenter(root);
        //borderPane.setBottom(log_out);
        //BorderPane.setMargin(log_out, new Insets(15));

        // Create the scene
        Scene scene = new Scene(borderPane, width-10, height-5);
        scene.getStylesheets().add(category.class.getResource("styles.css").toExternalForm());

        // Set the scene to the stage
        stage.setScene(scene);
        stage.setTitle("Category Screen");
    }
}
