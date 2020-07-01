package com.wildcodeschool;

import com.wildcodeschool.model.Card;
import com.wildcodeschool.model.Deck;
import com.wildcodeschool.model.Player;
import com.wildcodeschool.service.UserInterface;
import com.wildcodeschool.service.UserInterfaceTerminal;

public class Main {

    private static final UserInterface userInterface = new UserInterfaceTerminal();

    public static void main(String[] args) {

        String name = userInterface.askText("What's your name?");
        do {
            play(name);
        // Tant que le joueur le désire, rejouer
        } while (userInterface.askAnswer("Play again? (y/n)"));
        userInterface.print("Game over");
    }

    public static void play(String name) {
        Deck deck = new Deck();
        // Initialiser un joueur
        Player player = new Player(name);
        // Initialiser un croupier
        Player dealer = new Player("Dealer");

        // Le joueur pioche deux cartes
        // Le joueur révèle deux cartes
        userInterface.print(player.getName(), "draws", player.draw(deck).toString());
        userInterface.print(player.getName(), "draws", player.draw(deck).toString());

        // Le croupier pioche deux cartes
        // Le croupier révèle une carte
        userInterface.print(dealer.getName(), "draws", dealer.draw(deck).toString());
        Card dealerFaceDown = dealer.draw(deck);
        userInterface.print(dealer.getName(), "draws a card face-down");

        // Tant que le joueur n'a pas perdu et qu'il souhait piocher
        while (player.getScore() < 21 && userInterface.askAnswer("Draw again? (y/n)")) {
            // Le joueur pioche une carte
            // Le joueur révèle une carte
            userInterface.print(player.getName(), "draws", player.draw(deck).toString());
        }

        // Si le joueur n'a pas perdu
        if (player.getScore() < 21) {
            // Le croupier révèle sa carte cachée
            userInterface.print(player.getName(), "reveals", dealerFaceDown.toString());
            // Tant que le croupier à un score < 17
            while (dealer.getScore() < 17) {
                // Le dealer pioche une carte
                // Le dealer révèle une carte
                userInterface.print(dealer.draw(deck).toString());
            }
        }

        // Afficher le vainqueur
        if (player.getScore() > 21 || dealer.getScore() > player.getScore()) {
            userInterface.print("You lose!");
        } else if (player.getScore().equals(dealer.getScore())) {
            userInterface.print("It's a draw!");
        } else {
            userInterface.print("You win!");
        }
    }
}
