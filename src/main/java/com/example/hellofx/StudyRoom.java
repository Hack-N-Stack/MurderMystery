package com.example.hellofx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StudyRoom {

    public void start(Stage stage) {
        show(stage);
    }

    public void show(Stage stage) {

        AnchorPane layout = new AnchorPane();


        Image bg = new Image(getClass().getResource("/studyroom.jpeg").toExternalForm());
        ImageView bgView = new ImageView(bg);
        bgView.setFitWidth(800);
        bgView.setFitHeight(600);
        layout.getChildren().add(bgView);


        Button backBtn = new Button("← Back");
        backBtn.setStyle(
                "-fx-background-color: #222;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16;" +
                        "-fx-border-color: white;" +
                        "-fx-border-width: 2;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-radius: 8;"
        );

        backBtn.setLayoutX(20);
        backBtn.setLayoutY(20);


        backBtn.setOnAction(e -> RoomSelectionScreen.show(stage));

        layout.getChildren().add(backBtn);


        bgView.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();


            if (x >= 450 && x <= 500 && y >= 300 && y <= 370) {
                showClue("Lamp Investigation",
                        "The desk lamp has burn marks near the switch.\n" +
                                "This suggests someone used it recently to hide or read documents at night.");
            }


            else if (x >= 500 && x <= 640 && y >= 470 && y <= 520) {
                showClue("Scattered Evidence",
                        "Several printed documents were found scattered on the floor."+
                        "These include screenshots and notes collected against a famous influencer."
                );
            }


            else if (x >= 720 && x <= 790 && y >= 350 && y <= 400) {
                showClue("Confidential File",
                        "A folder marked 'PRIVATE' was found inside the shelf "+
                        "about the victim's secret partnerships."
                );
            }
        });

        Scene studyScene = new Scene(layout, 800, 600);
        stage.setTitle("Study Room");
        stage.setScene(studyScene);
        stage.show();
    }


    private void showClue(String title, String message) {
        Stage dialog = new Stage();
        dialog.setTitle(title);

        AnchorPane pane = new AnchorPane();
        pane.setStyle(
                "-fx-background-color: #0d0d0d;" +
                        "-fx-border-color: #00c8ff;" +
                        "-fx-border-width: 1.2;" +
                        "-fx-effect: dropshadow(one-pass-box, #00c8ff, 20, 0.5, 0, 0);" +
                        "-fx-padding: 15;"
        );

        Label label = new Label(message);
        label.setStyle(
                "-fx-text-fill: #e8e8e8;" +
                        "-fx-font-size: 13;" +
                        "-fx-font-family: 'Consolas';" +
                        "-fx-wrap-text: true;"
        );
        label.setPrefWidth(240);
        label.setWrapText(true);


        pane.getChildren().add(label);
        AnchorPane.setTopAnchor(label, 10.0);
        AnchorPane.setLeftAnchor(label, 10.0);

        Scene scene = new Scene(pane, 300, 170);
        scene.setOnMouseClicked(e -> dialog.close());
        dialog.setScene(scene);
        dialog.show();
    }
}
