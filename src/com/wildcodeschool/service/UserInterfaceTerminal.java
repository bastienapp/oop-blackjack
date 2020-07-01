package com.wildcodeschool.service;

import java.util.Scanner;

public class UserInterfaceTerminal implements UserInterface {

    @Override
    public String askText(String string) {
        Scanner scanner = new Scanner(System.in);
        print(string);
        return scanner.next();
    }

    @Override
    public boolean askQuestion(String question) {
        Scanner scanner = new Scanner(System.in);
        print(question, "(y/n)");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("y");
    }

    @Override
    public void print(String... text) {
        System.out.println(String.join(" ", text));
    }
}
