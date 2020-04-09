import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int numPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();
    private Card card;
    private int changer = 1;
    private int turn = 0;

    public Game(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<Card> firstCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            Card card1 = new Card("green", i);
            cards.add(card1);
            Card card2 = new Card("red", i);
            cards.add(card2);
            Card card3 = new Card("blue", i);
            cards.add(card3);
            Card card4 = new Card("yellow", i);
            cards.add(card4);
        }
        for (int i = 1; i < 13; i++) {
            Card card1 = new Card("green", i);
            cards.add(card1);
            Card card2 = new Card("red", i);
            cards.add(card2);
            Card card3 = new Card("blue", i);
            cards.add(card3);
            Card card4 = new Card("yellow", i);
            cards.add(card4);
        }
        for (int i = 0; i < 4; i++) {
            Card card1 = new Card("black", 13);
            cards.add(card1);
            Card card2 = new Card("black", 14);
            cards.add(card2);
        }
        return cards;
    }


    public void print() {

    }

    public void start() {
        cards = firstCards();
        for (int i = 0; i < numPlayers - 1; i++) {
            Robot player = new Robot();
            for (int j = 0; j < 7; j++) {
                int rand = (int) (Math.random() * cards.size());
                player.addCard(cards.get(rand));
                cards.remove(rand);
            }
            players.add(player);
        }
        RealPlayer realPlayer = new RealPlayer();
        for (int j = 0; j < 7; j++) {
            int rand = (int) (Math.random() * cards.size());
            realPlayer.addCard(cards.get(rand));
            cards.remove(rand);
        }
        players.add(realPlayer);
        int rand = (int) (Math.random() * (cards.size() - 1));
        while (cards.get(rand).getNumber() >= 10) {
            rand = (int) (Math.random() * (cards.size() - 1));
        }
        card = cards.get(rand);
        cards.remove(rand);
    }

    public boolean endGame() {
        for (Player i : players) {
            if (i.numCard() == 0) return true;
        }
        return false;
    }

    public boolean rightChoose(Card choose) {
        if (card.getNumber() == choose.getNumber()) return true;
        else if (card.getColor().equals(choose.getColor())) return true;
        else return choose.getColor().equals("black");
    }

    public void applyTurn(Card choose) {
        card = choose;
        players.get(turn).removeCard(choose);
        cards.add(choose);
        if (choose.getNumber() == 10) turn = turn + changer;
        if (choose.getNumber() == 11) changer = changer * -1;
        if (choose.getNumber() == 12) {
            int turner = 1;
            while (players.get((turn + changer + numPlayers) % numPlayers).havePlus2()) {
                turn = turn + changer;
                turner++;
            }
            for (int i = 0; i < turner * 2; i++) {
                int rand = (int) (Math.random() * (cards.size() - 1));
                players.get((turn + changer + numPlayers) % numPlayers).addCard(cards.get(rand));
                cards.remove(rand);
            }
        }
        if (choose.getNumber() == 13) {
            int turner = 1;
            while (players.get((turn + changer + numPlayers) % numPlayers).havePlus4()) {
                turn = turn + changer;
                turner++;
            }
            for (int i = 0; i < 4 * turner; i++) {
                int rand = (int) (Math.random() * (cards.size() - 1));
                players.get((turn + changer + numPlayers) % numPlayers).addCard(cards.get(rand));
                cards.remove(rand);
            }
            System.out.println(players.get(turn).getName() + " choose your color:");
            Scanner sc = new Scanner(System.in);
            String color = sc.next();
            card = new Card(color, 13);
        }
        if (choose.getNumber() == 14) {
            System.out.println("Choose your color:");
            Scanner sc = new Scanner(System.in);
            String color = sc.next();
            card = new Card(color, 14);
        }
    }

    public void game() {
        start();
        int j = 1;
        Scanner sc = new Scanner(System.in);
        for (Player i : players) {
            System.out.print("Player " + j + " name:");
            i.setName(sc.next());
            j++;
        }
        while (!endGame()) {
            card.print();
            if (players.get(turn) instanceof RealPlayer) {
                RealPlayer player = (RealPlayer) players.get(turn);
                player.print();
                if (!player.availableCard(card)) {
                    System.out.println("You don't have any cards to choose it we will get you a card Are you ok?(1.Yes 2.No)");
                    sc.next();
                    int rand = (int) (Math.random() * (cards.size() - 1));
                    cards.remove(rand);
                    player.addCard(cards.get(rand));
                    player.print();
                }
                if (player.availableCard(card)) {
                    System.out.print("Your choose:");
                    int choose = sc.nextInt() - 1;
                    while (!rightChoose(player.getCards().get(choose))) {
                        System.out.print("Your last choose is wrong please choose right card:");
                        sc = new Scanner(System.in);
                        choose = sc.nextInt() - 1;
                    }
                    applyTurn(player.getCards().get(choose));
                }
            } else if (players.get(turn) instanceof Robot) {
                Robot player = (Robot) players.get(turn);
                if (player.availableCard(card)) {
                    int choose = player.chooseCard(card);
                    if (choose != 200)
                        applyTurn(player.getCards().get(choose));
                } else {
                    int rand = (int) (Math.random() * (cards.size() - 1));
                    cards.remove(rand);
                    player.addCard(cards.get(rand));
                    int choose = player.chooseCard(card);
                    if (choose != 200)
                        applyTurn(player.getCards().get(choose));
                }
            }
            turn = (turn + changer + numPlayers) % numPlayers;
        }
    }
}
