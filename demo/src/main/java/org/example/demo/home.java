package org.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;



public class home {
    public Scene home_scene(Stage stage,double width,double height) {

        HBox bar = scene_manager.menu_bar(stage);

        List<String> kinds = new ArrayList<>();
        kinds.add("Category 1");
        kinds.add("Category 2");
        kinds.add("Category 3");
        kinds.add("Category 4");
        kinds.add("Category 5");
        kinds.add("Category 6");
        kinds.add("Category 6");
        kinds.add("Category 6");
        kinds.add("Category 6");
        kinds.add("Category 6");
        kinds.add("Category 6");
        kinds.add("Category 6");

        ListView<String> categoryListView = new ListView<>();
        //ObservableList<String> categories = FXCollections.observableArrayList(manager.getCategories());
        ObservableList<String> categories = FXCollections.observableArrayList(kinds);
        categoryListView.setItems(categories);
        categoryListView.prefWidthProperty().bind(stage.widthProperty().multiply(0.45));
        categoryListView.prefHeightProperty().bind(stage.heightProperty().multiply(0.85));

        List<String> Books = new ArrayList<>();
        Books.add("book 1");
        Books.add("book 2");
        Books.add("book 3");
        Books.add("book 4");
        Books.add("book 5");
        Books.add("book 6");

        categoryListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                //ObservableList<String> books = FXCollections.observableArrayList(manager.getBooksInCategory(newValue));
                ObservableList<String> books = FXCollections.observableArrayList(Books);
                category.category_scene(stage, books,stage.getWidth(),stage.getHeight());
            }
        });

        HBox list_hbox = new HBox(10);
        list_hbox.setPadding(new Insets(5));
        list_hbox.setAlignment(Pos.CENTER);
        list_hbox.getChildren().addAll(categoryListView);

        VBox vBox = new VBox(15);
        vBox.getChildren().addAll(list_hbox);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(bar);
        borderPane.setCenter(vBox);

        Scene scene = new Scene(borderPane, width-10, height-5);
        scene.getStylesheets().add(home.class.getResource("styles.css").toExternalForm());
        return scene;
    }
}