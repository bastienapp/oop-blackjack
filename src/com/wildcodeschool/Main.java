package com.wildcodeschool;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BlackJack blackJack = new BlackJack();
        blackJack.start(stage);
    }
}
