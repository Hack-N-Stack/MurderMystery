package com.example.hellofx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Kitchen {

    public void start(Stage stage) {


        AnchorPane layout = new AnchorPane();


        Image kitchenImg = new Image(getClass().getResource("/kitchen.jpeg").toExternalForm());
        ImageView kitchenView = new ImageView(kitchenImg);
        kitchenView.setFitWidth(800);
        kitchenView.setFitHeight(600);
        layout.getChildren().add(kitchenView);


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


        kitchenView.setOnMouseClicked(event -> {

            double x = event.getX();
            double y = event.getY();


            if (x >= 550 && x <= 680 && y >= 280 && y <= 350) {

                showClue(
                        "Alcohol Bottle Found",
                        "A bottle was found on the kitchen table.\n" +
                                "Post-mortem report confirms the victim did NOT drink.\n\n" +
                                "The culprit was drinking here shortly before the incident."
                );
            }


            else if (x >= 360 && x <= 430 && y >= 220 && y <= 400) {

                showClue(
                        "Packed Fruits Found",
                        "Fresh fruits were found inside the fridge.\n" +
                                "Someone visited the victim earlier that day and brought them as a gift."
                );
            }
        });


        Scene scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Kitchen Room");
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
