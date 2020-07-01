package com.wildcodeschool.service;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Optional;

public class UserInterfaceJavaFX implements UserInterface {

    private TextArea field;

    @Override
    public void init(Stage stage) {

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX(screenBounds.getWidth() / 2 - 150);
        stage.setY(screenBounds.getHeight() / 2);

        GridPane root = new GridPane();
        root.setPadding(new Insets(30));

        field = new TextArea();
        field.setEditable(false);
        field.setPrefWidth(360);
        field.setPrefHeight(200);
        root.add(field, 0, 0, 3, 1);

        Scene scene = new Scene(root, 400, 250);
        stage.setTitle("BlackJack");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public String askText(String string) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setVisible(false);
        dialog.getDialogPane().setContentText(string);
        Optional<String> result = dialog.showAndWait();
        return result.orElse("");
    }

    @Override
    public boolean askQuestion(String question) {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        ((Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");
        ((Button) dialog.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
        dialog.setContentText(question);
        Optional<ButtonType> result = dialog.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

    @Override
    public void print(String... text) {
        field.appendText(String.join(" ", text) + "\n");
    }

    @Override
    public boolean clear() {
        field.setText("");
        return true;
    }
}
