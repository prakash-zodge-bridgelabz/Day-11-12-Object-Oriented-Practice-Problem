package com.bridgelabz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//4. Write a Program DeckOfCards.java, to initialize deck of cards having suit
//("Clubs", "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8",
//"9", "10", "Jack", "Queen", "King", "Ace"). Shuffle the cards using Random
//method and then distribute 9 Cards to 4 Players and Print the Cards received by
//the 4 Players using 2D Array...

public class Deck_of_cards {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Create a list of cards
        List<String> deck = Arrays.asList(new String[52]);
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.set(index++, rank + " of " + suit);
            }
        }

        // Converting list to string array
        String[] cards = deck.toArray(new String[0]);
        System.out.println(cards.length);

        // Shuffle the deck
        shuffleDeck(cards);

        // Distribute cards to players
        int numPlayers = 4;
        int cardsPerPlayer = 9;
        String[][] playersCards = distributeCards(cards, numPlayers, cardsPerPlayer);

        // Print the cards received by each player
        printPlayerCards(playersCards);
    }
    static void shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap deck[i] and deck[j]
            String temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    // Distribute cards to players
    static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        String[][] playersCards = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playersCards[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }

        return playersCards;
    }

    // Print the cards received by each player
    static void printPlayerCards(String[][] playersCards) {
        for (int i = 0; i < playersCards.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < playersCards[i].length; j++) {
                System.out.println(playersCards[i][j]);
            }
            System.out.println();
        }
    }
}
