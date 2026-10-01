package com.example.hellofx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BackstoryScreen {

    public static void show(Stage stage) {

        VBox root = new VBox(20);
        root.setPadding(new Insets(40, 60, 40, 60));
        root.setAlignment(Pos.TOP_CENTER);


        BackgroundFill bgFill = new BackgroundFill(
                new javafx.scene.paint.LinearGradient(
                        0, 0, 0, 1, true,
                        javafx.scene.paint.CycleMethod.NO_CYCLE,
                        new javafx.scene.paint.Stop[]{
                                new javafx.scene.paint.Stop(0, Color.rgb(25, 25, 25)),
                                new javafx.scene.paint.Stop(1, Color.BLACK)
                        }
                ),
                CornerRadii.EMPTY,
                Insets.EMPTY
        );
        root.setBackground(new Background(bgFill));


        Text title = new Text("BACKSTORY");
        title.setFont(Font.font("Serif", 40));
        title.setFill(Color.WHITE);


        Text storyText = new Text(
                "It was a stormy night when the news broke —\n" +
                        "Raina Khan, a famous journalist, was found dead in her home.\n\n" +
                        "No forced entry.\n" +
                        "No signs of theft.\n" +
                        "Everything felt... staged.\n\n" +
                        "You, a junior detective, have been assigned to the case.\n\n" +
                        "You won't be working alone — Your assistant will guide you through the\n" +
                        "investigation.\n" +
                        "There are many clues out there...\n" +
                        "Let’s begin."
        );
        storyText.setFont(Font.font("Serif", 22));
        storyText.setFill(Color.WHITE);
        storyText.setWrappingWidth(750);

        ScrollPane scrollPane = new ScrollPane(storyText);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setPrefViewportHeight(450);
        scrollPane.setPadding(new Insets(10));


        Button startBtn = new Button("Start Investigation");
        startBtn.setFont(Font.font("SansSerif", 18));
        startBtn.setPadding(new Insets(8, 20, 8, 20));
        startBtn.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: white;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 5;"
        );

        startBtn.setOnMouseEntered(e ->
                startBtn.setStyle(
                        "-fx-background-color: white;" +
                                "-fx-text-fill: black;" +
                                "-fx-border-color: white;" +
                                "-fx-border-width: 2;" +
                                "-fx-border-radius: 5;"
                )
        );

        startBtn.setOnMouseExited(e ->
                startBtn.setStyle(
                        "-fx-background-color: transparent;" +
                                "-fx-text-fill: white;" +
                                "-fx-border-color: white;" +
                                "-fx-border-width: 2;" +
                                "-fx-border-radius: 5;"
                )
        );


        startBtn.setOnAction(e -> RoomSelectionScreen.show(stage));


        root.getChildren().addAll(title, scrollPane, startBtn);
        VBox.setMargin(startBtn, new Insets(20, 0, 0, 0));


        stage.setTitle("Backstory");
        stage.setScene(new Scene(root, 900, 600));
        stage.show();
    }
}