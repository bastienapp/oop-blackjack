package com.wildcodeschool;

import com.wildcodeschool.model.Card;
import com.wildcodeschool.model.Deck;
import com.wildcodeschool.model.Player;
import com.wildcodeschool.service.UserInterface;
import com.wildcodeschool.service.UserInterfaceTerminal;

public class Main {

    private static UserInterface userInterface = new UserInterfaceTerminal();

    public static void main(String[] args) {

        // Tant que le joueur le désire, rejouer
        do {
            play();
        } while (userInterface.playAgain());
    }

    public static void play() {
        Deck deck = new Deck();
        // Initialiser un joueur
        Player player = new Player("Michel");
        // Initialiser un croupier
        Player dealer = new Player("Dealer");

        // Le joueur pioche deux cartes
        // Le joueur révèle deux cartes
        userInterface.print(player.draw(deck));
        userInterface.print(player.draw(deck));

        // Le croupier pioche deux cartes
        // Le croupier révèle une carte
        userInterface.print(dealer.draw(deck));
        dealer.draw(deck);

        // Tant que le joueur n'a pas perdu et qu'il souhait piocher
        while (player.getScore() < 21 && userInterface.drawAgain()) {
            //     Le joueur pioche une carte
            //     Le joueur révèle une carte
            userInterface.print(player.draw(deck));
        }
        // Fin tant que

        // Si le joueur n'a pas perdu
        //    Le croupier révèle une carte
        //    Tant que le croupier à un score < 17
        //         Le joueur pioche une carte
        //         Le joueur révèle une carte
        //     Fin tant que
        // Fin si

        // Afficher le vainqueur
    }
}
