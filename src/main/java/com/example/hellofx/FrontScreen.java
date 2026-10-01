package com.example.hellofx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FrontScreen {

    public static void show(Stage stage) {

        MusicManager.play("music.mp3");
        Image bg = new Image(FrontScreen.class.getResource("/frontscreen.jpeg").toExternalForm());
        ImageView bgView = new ImageView(bg);


        bgView.fitWidthProperty().bind(stage.widthProperty());
        bgView.fitHeightProperty().bind(stage.heightProperty());
        bgView.setPreserveRatio(false);


        Button startBtn = new Button("START");
        startBtn.setStyle(
                "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: #c20000;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 12 35;"
        );


        startBtn.setOnMouseEntered(e -> startBtn.setStyle(
                "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: #ff0000;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 12 35;"
        ));
        startBtn.setOnMouseExited(e -> startBtn.setStyle(
                "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-color: #c20000;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 12 35;"
        ));


        StackPane.setAlignment(startBtn, Pos.BOTTOM_CENTER);
        StackPane.setMargin(startBtn, new Insets(0, 0, 60, 0));


        StackPane root = new StackPane(bgView, startBtn);
        Scene scene = new Scene(root, 900, 600);

        stage.setScene(scene);
        stage.setTitle("Murder Mystery");
        stage.show();


        startBtn.setOnAction(e -> BackstoryScreen.show(stage));
    }
}
