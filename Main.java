import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private int balance = 100;
    static ArrayList<Card> deck;

    public static void main(String[] args) {
        playOrQuit();

    }

    static void playOrQuit() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Play or quit?");
            String choice = input.nextLine();

            if (choice.equalsIgnoreCase("quit")) {
                break;
            } else {
                playGame();

            }


        }
        System.out.println("Good bye");


    }

    static void playGame() {
        Scanner input = new Scanner(System.in);
        createDeck();
        shuffleDeck();

        int playerPoints = 0;
        int dealerPoints = 0;

        Player dealer = new Player("Dealer");
        Player player = new Player("Player");

        dealer.drawCard(deck);
        dealer.drawCard(deck);
        player.drawCard(deck);
        player.drawCard(deck);

        if (player.points == 21 && dealer.points == 21) {
            System.out.println("Draw.  Nobody wins");
            return;
        }

        if (dealer.points == 21) {
            System.out.println("Dealer wins! ");
            return;
        }

        if (player.points == 21) {
            System.out.println("Player wins ! ");
            return;
        }


        while (true) {
            System.out.println("Fold or Draw?");
            System.out.println("Player points: " + player.points);
            System.out.println("Dealer points: " + dealer.points);
            String choice = input.nextLine();
            if (choice.equalsIgnoreCase("fold")) {
                while (dealer.points <= player.points) {
                    dealer.drawCard(deck);
                }


                if (dealer.points == 21) {
                    System.out.println("Dealer wins");
                    break;

                } else if (dealer.points > 21) {
                    System.out.println("Player wins! ");
                    break;
                } else {
                    System.out.println("Dealer wins!");
                    break;
                }
            } else {
                player.drawCard(deck);

                if (player.points > 21) {
                    System.out.println("Dealer wins!");
                    break;
                } else if (player.points == 21) {
                    System.out.println("Player wins!");
                    break;
                }
            }


        }
    }


    static void createDeck() {
        deck = new ArrayList<>();
        String[] ranks = {"Spades", "Diamonds", "Hearts", "Clubs"};
        String[] classes = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "King", "Queen"};


        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < classes.length; j++) {
                if (j < 10) {
                    deck.add(new Card(classes[j] + " of " + ranks[i], j + 1));
                } else {
                    deck.add(new Card(classes[j] + " of " + ranks[i], 10));
                }
            }
        }
    }

    static void shuffleDeck() {
        for (int i = 0; i < 10000; i++) { // 10000 random swaps to shuffle

            int x = (int) (Math.random() * 52); //out of the 52 cards
            int y = (int) (Math.random() * 52); //same here
            Card temp = deck.get(x);  //sets a temp card to the deck and index x

            deck.set(x, deck.get(y));
            deck.set(y, temp);

        }
    }

    //check for money will do later
    public String checkBalance() {
        if (balance == 0) {
            return "You don't have enough money to bet";
        }
        return "";
    }
}

