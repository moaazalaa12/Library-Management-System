package org.example.demo;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Stack;

public class scene_manager {
    private static Stack<Scene> previous_scenes = new Stack<>();
    private static Stack<Scene> next_scenes = new Stack<>();


    public static HBox menu_bar(Stage stage)
    {
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(5));
        topBar.setSpacing(10);
        topBar.setId("top_bar");

        //back button
        ImageView bimageView  = new ImageView("D:/New folder (3)/demo/src/main/resources/org/example/demo/back_arrow.png");
        bimageView.setFitHeight(15);
        bimageView.setFitWidth(15);
        Button backButton = new Button("",bimageView); // Unicode for FontAwesome arrow-left icon
        backButton.setId("next_back");
        Tooltip tooltip1 = new Tooltip("Back");
        tooltip1.setShowDelay(Duration.millis(100));
        tooltip1.setHideDelay(Duration.millis(0));
        backButton.setTooltip(tooltip1);
        backButton.getStyleClass().add("next_back");
        backButton.setOnAction(e->{
            if(!scene_manager.previous_scenes.isEmpty())
            {
                stage.setScene(scene_manager.get_previous_scene());
            }else System.out.println("no previous");
        });

        //next button
        ImageView nimageView  = new ImageView("D:/New folder (3)/demo/src/main/resources/org/example/demo/next_arrow.png");
        nimageView.setFitHeight(15);
        nimageView.setFitWidth(15);
        Button nextButton = new Button("",nimageView);
        nextButton.setId("next_back");
        nextButton.getStyleClass().add("next_back");
        Tooltip tooltip2 = new Tooltip("Next");
        tooltip2.setShowDelay(Duration.millis(100));
        tooltip2.setHideDelay(Duration.millis(0));
        nextButton.setTooltip(tooltip2);
        nextButton.setOnAction(e ->{

        });

        // Profile menu
        MenuItem item1 = new MenuItem("My Books");
        MenuItem item2 = new MenuItem("Log Out");
        item1.setId("menu-item");
        item2.setId("menu-item");
        item1.setOnAction(event -> {
            Scene s = MyBooks.My_books_scene(stage,stage.getWidth(),stage.getHeight());
            stage.setTitle("My Books Screen");
            stage.setScene(s);
        });
        item2.setOnAction(event -> {
            current_user.clearCurrentUser();
            stage.setScene(new login().login_scene(stage,stage.getWidth(),stage.getHeight()));
        });
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(item1,item2);
        // icon
        ImageView profile  = new ImageView("D:/New folder (3)/demo/src/main/resources/org/example/demo/profile-user.png");
        profile.setFitHeight(28);
        profile.setFitWidth(30);
        Button profile_button = new Button("",profile);
        profile_button.setId("profile");
        profile_button.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent actionEvent) {
                contextMenu.show(profile_button,actionEvent.getScreenX(),actionEvent.getScreenY());
            }
        });
        Tooltip tooltip_profile = new Tooltip("Your Profile");
        tooltip_profile.setShowDelay(Duration.millis(100));
        tooltip_profile.setHideDelay(Duration.millis(0));
        profile_button.setTooltip(tooltip_profile);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topBar.getChildren().addAll(backButton,nextButton,spacer,profile_button);
        return topBar;
    }

    public static HBox menu_bar_for_my_books(Stage stage)
    {
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(5));
        topBar.setSpacing(10);
        topBar.setId("top_bar");

        //back button
        ImageView bimageView  = new ImageView("D:/New folder (3)/demo/src/main/resources/org/example/demo/back_arrow.png");
        bimageView.setFitHeight(15);
        bimageView.setFitWidth(15);
        Button backButton = new Button("",bimageView); // Unicode for FontAwesome arrow-left icon
        backButton.setId("next_back");
        Tooltip tooltip1 = new Tooltip("Back");
        tooltip1.setShowDelay(Duration.millis(100));
        tooltip1.setHideDelay(Duration.millis(0));
        backButton.setTooltip(tooltip1);
        backButton.getStyleClass().add("next_back");

        //next button
        ImageView nimageView  = new ImageView("D:/New folder (3)/demo/src/main/resources/org/example/demo/next_arrow.png");
        nimageView.setFitHeight(15);
        nimageView.setFitWidth(15);
        Button nextButton = new Button("",nimageView);
        nextButton.setId("next_back");
        nextButton.getStyleClass().add("next_back");
        Tooltip tooltip2 = new Tooltip("Next");
        tooltip2.setShowDelay(Duration.millis(100));
        tooltip2.setHideDelay(Duration.millis(0));
        nextButton.setTooltip(tooltip2);

        // Profile menu
        MenuItem item2 = new MenuItem("Log Out");
        item2.setId("menu-item");
        item2.setOnAction(event -> {
            current_user.clearCurrentUser();
            stage.setScene(new login().login_scene(stage,stage.getWidth(),stage.getHeight()));
        });
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(item2);
        // icon
        ImageView profile  = new ImageView("D:/New folder (3)/demo/src/main/resources/org/example/demo/profile-user.png");
        profile.setFitHeight(28);
        profile.setFitWidth(30);
        Button profile_button = new Button("",profile);
        profile_button.setId("profile");
        profile_button.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent actionEvent) {
                contextMenu.show(profile_button,actionEvent.getScreenX(),actionEvent.getScreenY());
            }
        });
        Tooltip tooltip_profile = new Tooltip("Your Profile");
        tooltip_profile.setShowDelay(Duration.millis(100));
        tooltip_profile.setHideDelay(Duration.millis(0));
        profile_button.setTooltip(tooltip_profile);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        topBar.getChildren().addAll(backButton,nextButton,spacer,profile_button);
        return topBar;
    }


    public static Scene get_next_scene()
    {

        return null;
    }

    public static Scene get_previous_scene()
    {
        return previous_scenes.peek();
    }

    public static void setPrevious_scene(Scene scene)
    {
        previous_scenes.push(scene);
    }

    public static void setNext_scene(Scene scene)
    {
        next_scenes.push(scene);
    }
}
