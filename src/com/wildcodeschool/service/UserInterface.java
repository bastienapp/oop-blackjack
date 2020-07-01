package com.wildcodeschool.service;

import javafx.stage.Stage;

public interface UserInterface {

    default void init(Stage stage) {};

    String askText(String string);

    boolean askQuestion(String question);

    void print(String... text);

    boolean clear();
}
