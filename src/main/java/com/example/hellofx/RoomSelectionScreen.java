package com.example.hellofx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RoomSelectionScreen {

    public static void show(Stage stage) {

        Text title = new Text("Choose a Room");
        title.setFont(Font.font("Serif", 28));
        title.setFill(javafx.scene.paint.Color.WHITE);

        Button bedroomBtn = new Button("Bedroom");
        Button livingRoomBtn = new Button("Living Room");
        Button kitchenBtn = new Button("Kitchen");
        Button bathroomBtn = new Button("Bathroom");
        Button studyRoomBtn = new Button("Study Room");
        Button suspectBtn = new Button("Suspects");


        Button[] buttons = {bedroomBtn, livingRoomBtn, kitchenBtn, bathroomBtn, studyRoomBtn, suspectBtn};

        for (Button btn : buttons) {
            btn.setPrefWidth(220);
            btn.setFont(Font.font("Serif", 20));
            btn.setStyle(
                    "-fx-background-color: #2e2e2e;" +
                            "-fx-text-fill: white;" +
                            "-fx-border-color: white;" +
                            "-fx-border-width: 2;" +
                            "-fx-background-radius: 10;" +
                            "-fx-border-radius: 10;"
            );

            btn.setOnMouseEntered(e -> btn.setStyle(
                    "-fx-background-color: #444;" +
                            "-fx-text-fill: white;" +
                            "-fx-border-color: white;" +
                            "-fx-border-width: 2;" +
                            "-fx-background-radius: 10;" +
                            "-fx-border-radius: 10;"
            ));

            btn.setOnMouseExited(e -> btn.setStyle(
                    "-fx-background-color: #2e2e2e;" +
                            "-fx-text-fill: white;" +
                            "-fx-border-color: white;" +
                            "-fx-border-width: 2;" +
                            "-fx-background-radius: 10;" +
                            "-fx-border-radius: 10;"
            ));
        }


        bedroomBtn.setOnAction(e -> new Bedroom().start(stage));
        livingRoomBtn.setOnAction(e -> new LivingRoom().start(stage));
        kitchenBtn.setOnAction(e -> new Kitchen().start(stage));
        bathroomBtn.setOnAction(e -> new Bathroom().start(stage));
        studyRoomBtn.setOnAction(e -> new StudyRoom().start(stage));


        suspectBtn.setOnAction(e -> new SuspectScreen().showSuspectScreen(stage));

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                title,
                bedroomBtn,
                livingRoomBtn,
                kitchenBtn,
                bathroomBtn,
                studyRoomBtn,
                suspectBtn
        );

        layout.setStyle("-fx-background-color: linear-gradient(to bottom, #111, #000); -fx-padding: 40;");

        stage.setTitle("Room Selection");
        stage.setScene(new Scene(layout, 900, 600));
        stage.show();
    }
}
