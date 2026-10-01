package com.example.hellofx;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SuspectScreen {

    private int wrongAttempts = 0;

    public void showSuspectScreen(Stage stage) {

        VBox mainLayout = new VBox(30);
        mainLayout.setStyle("-fx-background-color: #0d0d0d;");
        mainLayout.setAlignment(Pos.CENTER);


        Image img1 = new Image(getClass().getResource("/influencer.png").toExternalForm());
        Image img2 = new Image(getClass().getResource("/husband.png").toExternalForm());
        Image img3 = new Image(getClass().getResource("/bestfriend.png").toExternalForm());
        Image img4 = new Image(getClass().getResource("/maid.png").toExternalForm());

        ImageView v1 = createEqualImage(img1);
        ImageView v2 = createEqualImage(img2);
        ImageView v3 = createEqualImage(img3);
        ImageView v4 = createEqualImage(img4);


        Label n1 = createName("Rival Influencer");
        Label n2 = createName("Husband");
        Label n3 = createName("Best Friend");
        Label n4 = createName("Maid");


        VBox s1 = createSuspectBox(v1, n1, stage, 1,
                "• History with Victim:\n" +
                        "The victim and the influencer had frequent aggressive talks over messages. \n" +
                        "• Events on the Night of the Murder:\n" +
                        "(No specific visit reported, but he had motive due to ongoing conflict with the victim).\n" +
                        "• CCTV Evidence:\n" +
                        "(No CCTV evidence available yet).\n" +
                        "• Suspicious Behavior:\n" +
                        "Wore glasses due to eyesight issues.\n" +
                        "• Physical Evidence:\n" +
                        "Shoe size 42.\n" +
                        "• Legal Conflict:\n" +
                        "The victim was actively collecting evidence against him to get him punished.");

        VBox s2 = createSuspectBox(v2, n2, stage, 2,
                "•\tHistory with Victim:\n" +
                        "Had a long history of severe and frequent arguments with the victim.\n" +
                        "•\tEvents on the Night of the Murder:\n" +
                        "Visited the victim’s house on the night of the murder.\n" +
                        "•\tCCTV Evidence:\n" +
                        "CCTV footage shows his arrival and departure between 11:35 PM and 12:10 PM\n while the timing of murder was between 11:00 PM and 12:00 PM\n" +
                        "•\tSuspicious Behavior:\n" +
                        "When leaving the house, he appeared extremely nervous, sweating heavily, and visibly disturbed.\n" +
                        "•\tPhysical Evidence:\n" +
                        "Shoe size 42.\n" +
                        "•\tLegal Conflict:\n" +
                        "Had previously sent divorce papers to the victim.");

        VBox s3 = createSuspectBox(v3, n3, stage, 3,

                "• History with Victim:\n" +
                        "Had an argument with the victim a few days ago.\n" +
                        "• Events on the Night of the Murder:\n" +
                        "Visited the victim’s house on the night of the murder, carrying a fruit basket.\n" +
                        "• CCTV Evidence:\n" +
                        "CCTV footage shows her visit between 9:00 PM and 11:30 PM. murder timimg 11:00 PM to12:00 PM.\n" +
                        "• Suspicious Behavior:\n" +
                        "Appeared drunk and not fully in control of her senses when leaving the house. Wore glasses.\n" +
                        "• Physical Evidence:\n" +
                        "Two fingers were missing, which may be relevant.\n" +
                        "• Legal Conflict / Motive:\n" +
                        "Recent argument with the victim may indicate a possible motive.");

        VBox s4 = createSuspectBox(v4, n4, stage, 4,
                "• History with Victim:\n" +
                        "Frequently argued with the victim about her salary, according to neighbors.\n" +
                        "• Events on the Night of the Murder:\n" +
                        "CCTV shows she was at the victim’s house until 11:10 PM and quit her job that day.\n" +
                        "• CCTV Evidence:\n" +
                        "Footage shows her leaving the house at 11:10 PM. Her facial expressions appeared very aggressive.\n" +
                        "• Suspicious Behavior:\n" +
                        "Aggressive demeanor when leaving the house.\n" +
                        "• Physical Evidence:\n" +
                        "Shoe size 37. Handwriting on threatening letters for money found in victim’s bedroom matches hers.\n" +
                        "• Legal Conflict :\n" +
                        "Disputes over salary and connection to threatening letters indicate a possible motive.");

        HBox suspectsRow = new HBox(40, s1, s2, s3, s4);
        suspectsRow.setAlignment(Pos.CENTER);


        Button back = new Button("← Want to inspect rooms again?");
        back.setStyle("-fx-font-size: 18px; -fx-padding: 10px; -fx-background-color: #222;"
                + "-fx-text-fill: white; -fx-border-color: #00c8ff;");
        back.setOnAction(e -> RoomSelectionScreen.show(stage));

        mainLayout.getChildren().addAll(suspectsRow, back);

        Scene scene = new Scene(mainLayout, 1000, 700);
        stage.setScene(scene);
        stage.setTitle("Suspect Selection");
        stage.show();
    }


    private ImageView createEqualImage(Image img) {
        ImageView iv = new ImageView(img);
        iv.setFitWidth(180);
        iv.setFitHeight(180);
        iv.setPreserveRatio(false);
        iv.setStyle("-fx-border-color: #00c8ff; -fx-border-width: 2;");
        return iv;
    }


    private Label createName(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");
        return label;
    }


    private String buttonStyle() {
        return "-fx-font-size: 15px; -fx-padding: 6px 14px;"
                + "-fx-background-color: #222; -fx-text-fill: white; -fx-border-color: #00c8ff;";
    }


    private VBox createSuspectBox(ImageView img, Label name, Stage stage, int suspectNumber, String detailsText) {

        Button details = new Button("Details");
        details.setStyle(buttonStyle());
        details.setOnAction(e -> showDetailsPopup(name.getText(), detailsText));

        Button murdererBtn = new Button("Murderer?");
        murdererBtn.setStyle(buttonStyle());
        murdererBtn.setOnAction(e -> {

            Stage dialog = new Stage();
            dialog.setTitle("Confirm Choice");

            VBox box = new VBox(20);
            box.setStyle("-fx-background-color: #111; -fx-padding: 25; -fx-border-color: #00c8ff; -fx-border-width: 2;");
            box.setAlignment(Pos.CENTER);


            Label ask = new Label("Are you sure this is the murderer?");
            ask.setStyle("-fx-text-fill: #00c8ff; -fx-font-size: 20px; -fx-font-weight: bold;");


            Button yesBtn = new Button("Yes");
            yesBtn.setStyle("-fx-background-color: #222; -fx-text-fill: white; -fx-border-color: #00c8ff; -fx-padding: 6 18;");

            Button noBtn = new Button("No");
            noBtn.setStyle("-fx-background-color: #222; -fx-text-fill: white; -fx-border-color: #00c8ff; -fx-padding: 6 18;");

            HBox btnRow = new HBox(20, yesBtn, noBtn);
            btnRow.setAlignment(Pos.CENTER);

            yesBtn.setOnAction(e2 -> {
                dialog.close();
                processMurdererSelection(suspectNumber, stage);
            });

            noBtn.setOnAction(e2 -> dialog.close());

            box.getChildren().addAll(ask, btnRow);

            Scene sc = new Scene(box, 380, 180);
            dialog.setScene(sc);
            dialog.show();

        });

        VBox box = new VBox(10, img, name, details, murdererBtn);
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-background-color: #1a1a1a; -fx-padding: 15px; -fx-border-color: #00c8ff;");

        return box;
    }


    private void showDetailsPopup(String heading, String detailsText) {

        Stage dialog = new Stage();
        dialog.setTitle(heading);

        AnchorPane layout = new AnchorPane();
        layout.setStyle("-fx-background-color: #0d0d0d; -fx-border-color: #00c8ff;"
                + "-fx-border-width: 2; -fx-padding: 20;");

        Label title = new Label(heading);
        title.setStyle("-fx-text-fill: #00c8ff; -fx-font-size: 22px; -fx-font-weight: bold;");

        Label details = new Label(detailsText);
        details.setStyle("-fx-text-fill: #e8e8e8; -fx-font-size: 15px; -fx-wrap-text: true;");
        details.setPrefWidth(550);
        details.setWrapText(true);

        Label tapToClose = new Label("Click anywhere to close");
        tapToClose.setStyle("-fx-text-fill: #888; -fx-font-size: 12;");

        VBox box = new VBox(15, title, details, tapToClose);
        AnchorPane.setTopAnchor(box, 20.0);
        AnchorPane.setLeftAnchor(box, 20.0);

        layout.getChildren().add(box);

        Scene scene = new Scene(layout, 650, 450);
        scene.setOnMouseClicked(e -> dialog.close());

        dialog.setScene(scene);
        dialog.show();
    }


    private void showConfettiCelebration(Pane parent) {
        for (int i = 0; i < 40; i++) {
            Circle c = new Circle(5, Color.hsb(Math.random() * 360, 1, 1));
            c.setLayoutX(300);
            c.setLayoutY(200);

            parent.getChildren().add(c);

            TranslateTransition tt = new TranslateTransition(Duration.seconds(1.5), c);
            tt.setByX((Math.random() - 0.5) * 600);
            tt.setByY((Math.random() - 0.5) * 400);

            FadeTransition ft = new FadeTransition(Duration.seconds(1.5), c);
            ft.setToValue(0);

            ParallelTransition pt = new ParallelTransition(tt, ft);
            pt.play();
        }
    }

    private void showFullScreenCongratulations(Stage stage) {
        Pane base = (Pane) stage.getScene().getRoot();

        StackPane overlay = new StackPane();
        overlay.setStyle("-fx-background-color: rgba(0,0,0,0.85);");
        overlay.setPickOnBounds(true);
        overlay.setOpacity(0);

        Label congrats = new Label("🎉 CONGRATULATIONS! 🎉\nYou Found the Murderer!");
        congrats.setStyle(
                "-fx-text-fill: #00d1ff;" +
                        "-fx-font-size: 55px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-family: 'Arial Black';"

        );

        overlay.getChildren().add(congrats);
        overlay.setAlignment(Pos.CENTER);

        if (base instanceof StackPane sp) {
            sp.getChildren().add(overlay);
        } else {
            StackPane newRoot = new StackPane();
            newRoot.getChildren().addAll(base, overlay);
            stage.getScene().setRoot(newRoot);
        }


        FadeTransition fade = new FadeTransition(Duration.seconds(0.1), overlay);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();


        ScaleTransition bounce = new ScaleTransition(Duration.seconds(0.7), congrats);
        bounce.setFromX(0.4);
        bounce.setFromY(0.4);
        bounce.setToX(1);
        bounce.setToY(1);
        bounce.setInterpolator(Interpolator.EASE_OUT);
        bounce.play();


        DropShadow neonGlow = new DropShadow();
        neonGlow.setColor(Color.web("#00d1ff"));
        neonGlow.setRadius(2);   // very small - text stays sharp
        neonGlow.setSpread(0.02); // no blur
        neonGlow.setOffsetX(0);
        neonGlow.setOffsetY(0);
        congrats.setEffect(neonGlow);


        Timeline glowPulse = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(neonGlow.radiusProperty(), 2)
                ),
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(neonGlow.radiusProperty(), 4)
                )
        );
        glowPulse.setAutoReverse(true);
        glowPulse.setCycleCount(Animation.INDEFINITE);
        glowPulse.play();



        showConfettiCelebration(base);
    }



    private void processMurdererSelection(int suspect, Stage stage) {
        if (suspect == 3) {
            showFullScreenCongratulations(stage);

            PauseTransition delay = new PauseTransition(Duration.seconds(9));
            delay.setOnFinished(e -> Platform.exit());
            delay.play();
        }


        else {
            wrongAttempts++;

            if (wrongAttempts < 2) {
                Alert wrong = new Alert(Alert.AlertType.ERROR);
                wrong.setTitle("Wrong Choice!");
                wrong.setHeaderText("❌ Not The Murderer!");
                wrong.setContentText("Try again! You have " + (2 - wrongAttempts) + " attempt left.");

                DialogPane pane = wrong.getDialogPane();
                pane.setStyle("-fx-background-color: #0d0d0d;" +
                        "-fx-border-color: #ff004c;" +
                        "-fx-border-width: 2;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 16px;"
                );


                Label header = (Label) pane.lookup(".header-panel .label");
                if (header != null) {
                    header.setStyle("-fx-text-fill: #ff004c; -fx-font-size: 20px; -fx-font-weight: bold;");
                }


                Label content = (Label) pane.lookup(".content.label");
                if (content != null) {
                    content.setStyle("-fx-text-fill: white;");
                }


                FadeTransition fade = new FadeTransition(Duration.seconds(0.35), pane);
                fade.setFromValue(0);
                fade.setToValue(1);

                TranslateTransition shake = new TranslateTransition(Duration.seconds(0.1), pane);
                shake.setByX(12);
                shake.setCycleCount(6);
                shake.setAutoReverse(true);

                ParallelTransition wrongAnim = new ParallelTransition(fade, shake);

                wrong.show();
                wrongAnim.play();
            }

            else {
                Alert fail = new Alert(Alert.AlertType.ERROR);
                fail.setTitle("Game Over");
                fail.setHeaderText("❌ You Failed!");
                fail.setContentText("You selected the wrong person twice.\nRestart the investigation from the beginning!");

                DialogPane paneFail = fail.getDialogPane();
                paneFail.setStyle("-fx-background-color: #0d0d0d;" +
                        "-fx-border-color: #ff0000;" +
                        "-fx-border-width: 2;" +
                        "-fx-font-size: 16px;" +
                        "-fx-text-fill: white;"
                );

                Label headerFail = (Label) paneFail.lookup(".header-panel .label");
                if (headerFail != null) {
                    headerFail.setStyle("-fx-text-fill: #ff3333; -fx-font-size: 22px; -fx-font-weight: bold;");
                }


                Label contentFail = (Label) paneFail.lookup(".content.label");
                if (contentFail != null) {
                    contentFail.setStyle("-fx-text-fill: white;");
                }


                TranslateTransition shake = new TranslateTransition(Duration.seconds(0.1), paneFail);
                shake.setByX(10);
                shake.setCycleCount(6);
                shake.setAutoReverse(true);
                shake.play();

                fail.show();

                BackstoryScreen.show(stage);
            }

        }
    }

}
