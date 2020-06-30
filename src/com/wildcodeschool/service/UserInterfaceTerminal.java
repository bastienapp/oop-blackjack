package com.wildcodeschool.service;

import java.util.Scanner;

public class UserInterfaceTerminal implements UserInterface {

    @Override
    public boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        print("Play again ? (y/n)");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("y");
    }

    @Override
    public boolean drawAgain() {
        Scanner scanner = new Scanner(System.in);
        print("Draw again ? (y/n)");
        String answer = scanner.next();
        return answer.equalsIgnoreCase("y");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
