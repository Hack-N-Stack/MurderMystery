package com.example.hellofx;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LivingRoom {

    public void start(Stage window) {

        AnchorPane layout = new AnchorPane();

        Image roomImg = new Image(getClass().getResource("/living room.jpeg").toExternalForm());
        ImageView view = new ImageView(roomImg);
        view.setFitWidth(800);
        view.setFitHeight(600);

        layout.getChildren().add(view);


        Button backBtn = new Button("⟵ Back");
        backBtn.setStyle(
                "-fx-background-color: #222;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16;" +
                        "-fx-padding: 5 12;" +
                        "-fx-border-color: white;" +
                        "-fx-border-width: 1;"
        );
        backBtn.setOnAction(e -> RoomSelectionScreen.show(window));
        AnchorPane.setTopAnchor(backBtn, 10.0);
        AnchorPane.setLeftAnchor(backBtn, 10.0);

        layout.getChildren().add(backBtn);


        view.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();


            if (x >= 230 && x <= 300 && y >= 390 && y <= 460) {
                showClue("Divorce Papers Found",
                        "Official divorce papers were discovered on the table.\n"
                                + "The victim was preparing to separate legally.");
            }

            else if (x >= 460 && x <= 520 && y >= 320 && y <= 370) {
                showClue("Diary Entry Found",
                        "A diary was found containing details of a fight\n"
                                + "between the victim and her friend.");
            }

            else if (x >= 700 && x <= 800 && y >= 290 && y <= 380) {
                showClue("Burned Photograph",
                        "A half‑burned photograph of two girls.\n"
                                + "One face is destroyed intentionally.");
            }
        });

        Scene scene = new Scene(layout, 800, 600);
        window.setScene(scene);
        window.setTitle("Murder Mystery – Living Room");
        window.show();
    }


    private void showClue(String title, String message) {
        Stage dialog = new Stage();
        dialog.setTitle(title);

        AnchorPane pane = new AnchorPane();
        pane.setStyle(
                "-fx-background-color: #0c0c0c;" +
                        "-fx-border-color: #00eaff;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 12;"
        );

        Label label = new Label(message);
        label.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 12.5;" +
                        "-fx-font-family: 'Consolas';"
        );
        label.setPrefWidth(240);
        label.setWrapText(true);


        pane.getChildren().add(label);
        AnchorPane.setTopAnchor(label, 10.0);
        AnchorPane.setLeftAnchor(label, 10.0);

        Scene scene = new Scene(pane, 270, 150);
        scene.setOnMouseClicked(ev -> dialog.close());

        dialog.setScene(scene);
        dialog.show();
    }
}
