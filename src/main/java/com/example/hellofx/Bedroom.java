package com.example.hellofx;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Bedroom {

    public void start(Stage stage) {

        AnchorPane bedroomLayout = new AnchorPane();


        Image bedroomImage = new Image(getClass().getResource("/bedroom.png").toExternalForm());
        ImageView bedroomView = new ImageView(bedroomImage);
        bedroomView.setFitWidth(900);
        bedroomView.setFitHeight(600);

        bedroomLayout.getChildren().add(bedroomView);


        Button backBtn = new Button("← Back to Rooms");
        backBtn.setStyle(
                "-fx-background-color: #222;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16;" +
                        "-fx-border-color: white;"
        );
        backBtn.setOnAction(e -> RoomSelectionScreen.show(stage));

        AnchorPane.setTopAnchor(backBtn, 20.0);
        AnchorPane.setLeftAnchor(backBtn, 20.0);

        bedroomLayout.getChildren().add(backBtn);


        bedroomView.setOnMouseClicked(event -> {
            double x = event.getX();
            double y = event.getY();


            if (x >= 500 && x <= 600 && y >= 300 && y <= 400) {
                showClue(
                        "Glasses Found on Desk",
                        "A pair of glasses was found on the table." +
                                "Indicates someone with strong"+
                                " eyesight issues."
                );
            }


            else if (x >= 450 && x <= 510 && y >= 190 && y <= 250) {
                showClue(
                        "Threatening Letters",
                        "Several unsigned threatening letters on the shelf.\n" +
                                "The suspect was demanding heavy amount of money!"
                );
            }


            else if (x >= 480 && x <= 580 && y >= 500 && y <= 590) {
                showClue(
                        "Shoe Print Detected",
                        "A clear shoe print was found on the floor.\n" +
                                "Shoe size: 42.\n" +
                                "This indicates the suspect was present in the room."
                );
            }
        });

        Scene bedroomScene = new Scene(bedroomLayout, 900, 600);
        stage.setScene(bedroomScene);
        stage.setTitle("Murder Mystery - Bedroom");
        stage.show();
    }


    private void showClue(String title, String message) {
        Stage dialog = new Stage();
        dialog.setTitle(title);

        AnchorPane layout = new AnchorPane();
        layout.setStyle("-fx-background-color: #0d0d0d;"
                + "-fx-border-color: #00c8ff;"
                + "-fx-border-width: 1;"
                + "-fx-padding: 15;"
        );

        Label label = new Label(message);
        label.setStyle("-fx-text-fill: #e8e8e8;"
                + "-fx-font-size: 12.5;"
                + "-fx-font-family: 'Consolas';"
        );

        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        label.setPrefWidth(Double.MAX_VALUE);

        AnchorPane.setLeftAnchor(label, 0.0);
        AnchorPane.setRightAnchor(label, 0.0);
        AnchorPane.setTopAnchor(label, 10.0);

        layout.getChildren().add(label);

        Scene scene = new Scene(layout, 300, 180);
        scene.setOnMouseClicked(e -> dialog.close());
        dialog.setScene(scene);
        dialog.show();
    }

}
