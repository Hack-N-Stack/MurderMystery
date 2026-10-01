package com.example.hellofx;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        FrontScreen.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

