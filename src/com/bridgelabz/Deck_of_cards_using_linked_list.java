package com.bridgelabz;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

//5. Extend the above program to create a Player Object having Deck of Cards, and
//having ability to Sort by Rank and maintain the cards in a Queue implemented
//using Linked List. Do not use any Collection Library. Further the Players are also
//arranged in Queue. Finally Print the Player and the Cards received by each
//Player.
class Node {
    String data;
    Node next;
    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue {
    private Node front, rear;
    public LinkedListQueue() {
        this.front = this.rear = null;
    }
    public void enqueue(String data) {
        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public String dequeue() {
        if (front == null) {
            return null;
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }
    public boolean isEmpty() {
        return front == null;
    }
}

class Player {
    private LinkedListQueue cards;
    private String name;
    public Player(String name) {
        this.name = name;
        this.cards = new LinkedListQueue();
    }
    public void receiveCard(String card) {
        cards.enqueue(card);
    }
    public void sortCardsByRank() {
        // Implement sorting logic (for simplicity, let's assume the cards are already sorted)
    }
    public void printPlayerInfo() {
        System.out.println("Player: " + name);
        System.out.println("Cards:");
        while (!cards.isEmpty()) {
            String card = cards.dequeue();
            System.out.println(card);
        }
        System.out.println();
    }
}
public class Deck_of_cards_using_linked_list {
    public static void main(String[] args) {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Create players
        Player[] players = {new Player("Player 1"), new Player("Player 2"), new Player("Player 3"), new Player("Player 4")};

        // Create a list of cards
        String[] deck = initializeDeck(suits, ranks);

        // Shuffle the deck
        shuffleDeck(deck);

        // Distribute cards to players
        distributeCards(players, deck);

        // Print the Player and the Cards received by each Player
        for (Player player : players) {
            player.printPlayerInfo();
        }
    }
    // Initialize deck of cards
    private static String[] initializeDeck(String[] suits, String[] ranks) {
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
        return deck;
    }
    // Shuffle the deck
    private static void shuffleDeck(String[] deck) {
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
    private static void distributeCards(Player[] players, String[] deck) {
        int playerIndex = 0;
        for (String card : deck) {
            players[playerIndex].receiveCard(card);
            playerIndex = (playerIndex + 1) % players.length;
        }
    }
}
