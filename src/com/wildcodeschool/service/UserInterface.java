package com.wildcodeschool.service;

public interface UserInterface {

    default void init() {};

    String askText(String string);

    boolean askQuestion(String question);

    void print(String... text);

    default void close() {};
}
