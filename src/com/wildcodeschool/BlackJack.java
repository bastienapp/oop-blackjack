package com.wildcodeschool;

import com.wildcodeschool.model.Card;
import com.wildcodeschool.model.Deck;
import com.wildcodeschool.model.Player;
import com.wildcodeschool.service.UserInterface;
import com.wildcodeschool.service.UserInterfaceTerminal;

public class BlackJack {

    private final UserInterface userInterface = new UserInterfaceTerminal();

    public void start() {
        userInterface.init();
        String name = userInterface.askText("What's your name?");
        do {
            play(name);
            // Tant que le joueur le désire, rejouer
        } while (userInterface.askQuestion("Play again?"));
        userInterface.print("Game over");
        userInterface.close();
    }

    public void play(String name) {
        Deck deck = new Deck();
        // Initialiser un joueur
        Player player = new Player(name);
        // Initialiser un croupier
        Player dealer = new Player("Dealer");

        Card card;
        // Le joueur pioche deux cartes et les révèle
        card = player.draw(deck);
        userInterface.print(player.getName(), "draws", card.toString());
        card = player.draw(deck);
        userInterface.print(player.getName(), "draws", card.toString());

        // Le croupier pioche une carte et la révèle
        card = dealer.draw(deck);
        userInterface.print(dealer.getName(), "draws", card.toString());
        // Le croupier pioche une carte face cachée
        Card faceDown = dealer.draw(deck);
        userInterface.print(dealer.getName(), "draws a card face-down");

        // Tant que le joueur n'a pas perdu et qu'il souhait piocher
        while (player.getScore() < 21 && userInterface.askQuestion("Draw again?")) {
            // Le joueur pioche une carte et la révèle
            card = player.draw(deck);
            userInterface.print(player.getName(), "draws", card.toString());
        }

        // Si le joueur n'a pas perdu
        if (player.getScore() < 21) {
            // Le croupier révèle sa carte cachée
            userInterface.print(dealer.getName(), "reveals", faceDown.toString());
            // Tant que le croupier à un score < 17
            while (dealer.getScore() < 17) {
                // Le dealer pioche une carte et la révèle
                card = dealer.draw(deck);
                userInterface.print(dealer.getName(), "draws", card.toString());
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
