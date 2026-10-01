package com.example.hellofx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Bathroom {

    public void start(Stage window) {

        AnchorPane layout = new AnchorPane();

        Image img = new Image(getClass().getResource("/bathroom.png").toExternalForm());
        ImageView view = new ImageView(img);
        view.setFitWidth(800);
        view.setFitHeight(600);

        layout.getChildren().add(view);


        Button backBtn = new Button("← Back");
        backBtn.setStyle(
                "-fx-background-color: black;" +
                        "-fx-text-fill: white;" +
                        "-fx-border-color: white;" +
                        "-fx-background-radius: 5;"
        );
        backBtn.setLayoutX(20);
        backBtn.setLayoutY(20);
        backBtn.setOnAction(e -> RoomSelectionScreen.show(window));

        layout.getChildren().add(backBtn);


        view.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();


            if (x >= 400 && x <= 480 && y >= 190 && y <= 260) {
                showClue(
                        "Bloody Handprint",
                        "A bloody handprint was found on the mirror.\n"
                                + "Two fingers appear to be missing.\n"
                                + "This suggests the suspect has an injured or deformed hand."
                );
            }


            else if (x >= 220 && x <= 300 && y >= 400 && y <= 490) {
                showClue(
                        "Suspicious Basket",
                        "Printed WhatsApp screenshots showing threats were found.\n"
                                + "Someone warned the victim to delete evidence."
                );
            }


            else if (x >= 330 && x <= 390 && y >= 390 && y <= 470) {
                showClue(
                        "Blood Droplet",
                        "A dried blood droplet lies near the sink.\n"
                                + "Someone was injured inside this bathroom."
                );
            }
        });

        Scene scene = new Scene(layout, 800, 600);
        window.setScene(scene);
        window.setTitle("Murder Mystery – Bathroom");
        window.show();
    }


    private void showClue(String title, String msg) {

        Stage dialog = new Stage();
        dialog.setTitle(title);

        AnchorPane pane = new AnchorPane();
        pane.setStyle(
                "-fx-background-color: #0c0c0c;" +
                        "-fx-border-color: #00eaff;" +
                        "-fx-border-width: 1;" +
                        "-fx-effect: dropshadow(one-pass-box, #00eaff, 12, 0.5, 0, 0);" +
                        "-fx-padding: 12;"
        );

        Label label = new Label(msg);
        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 13;" +
                        "-fx-font-family: 'Consolas';" +
                        "-fx-wrap-text: true;"
        );
        label.setPrefWidth(240);
        label.setWrapText(true);


        pane.getChildren().add(label);
        AnchorPane.setTopAnchor(label, 10.0);
        AnchorPane.setLeftAnchor(label, 10.0);

        Scene scene = new Scene(pane, 270, 150);


        scene.setOnMouseClicked(e -> dialog.close());

        dialog.setScene(scene);
        dialog.show();
    }
}
