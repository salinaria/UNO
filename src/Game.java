import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int numPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();
    private Card card;
    private int changer=1;
    private int turn=0;
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

    public void print() {

    }

    public void start() {
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
        for (int i = 0; i < numPlayers; i++) {
            Player player = new Player();
            for (int j = 0; j < 7; j++) {
                int rand = (int) (Math.random() * cards.size());
                player.addCard(cards.get(rand));
                cards.remove(rand);
            }
            players.add(player);
        }
        Scanner sc = new Scanner(System.in);
        int j = 1;
        for (Player i : players) {
            System.out.print("Player " + j + " name:");
            i.setName(sc.next());
            j++;
        }
        int rand = (int) (Math.random() * (cards.size() - 1));
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
    public void applyTurn(Card choose){
        card=choose;
        players.get(turn).removeCard(choose);
        if(choose.getNumber()==10)turn=turn+changer;
        if(choose.getNumber()==11)changer=changer*-1;
        if(choose.getNumber()==12){
            for(int i=0;i<2;i++){
                int rand = (int) (Math.random() * (cards.size() - 1));
                players.get(turn+changer).addCard(cards.get(rand));
                cards.remove(rand);
            }
        }
        if(choose.getNumber()==13){
            for(int i=0;i<4;i++){
                int rand = (int) (Math.random() * (cards.size() - 1));
                players.get(turn+changer).addCard(cards.get(rand));
                cards.remove(rand);
            }
            System.out.println("Choose your color:");
            Scanner sc=new Scanner(System.in);
            String color=sc.next();
            card=new Card(color,13);
        }
        if(choose.getNumber()==14){
            System.out.println("Choose your color:");
            Scanner sc=new Scanner(System.in);
            String color=sc.next();
            card=new Card(color,14);
        }
    }
    public void game() {
        start();
        while (!endGame()) {
            card.print();

            if(turn<0)turn=turn+numPlayers;
            if(turn>=numPlayers)turn=turn-numPlayers;

            players.get(turn % numPlayers).print();

            if (!players.get(turn).availableCard(card)) {
                System.out.println("You don't have any cards to choose it we will get you a card Are you ok?(1.Yes 2.No)");
                Scanner sc = new Scanner(System.in);
                sc.next();

               int rand = (int) (Math.random() * (cards.size() - 1));
                cards.remove(rand);
                players.get(turn).addCard(cards.get(rand));
                players.get(turn).print();
            }
            if (players.get(turn).availableCard(card)) {
                System.out.print("Your choose:");
                Scanner sc = new Scanner(System.in);
                int choose = sc.nextInt() - 1;
                while(!rightChoose(players.get(turn).getCards().get(choose))){
                    System.out.print("Your last choose is wrong please choose right card:");
                    sc = new Scanner(System.in);
                    choose = sc.nextInt() - 1;
                }
                applyTurn(players.get(turn).getCards().get(choose));
            }
            turn = turn + changer;
        }
    }
}
