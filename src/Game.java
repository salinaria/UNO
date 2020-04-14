import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private int numRealPlayers;
    private int numRobots;
    private int numPlayers;
    private ArrayList<Player> players = new ArrayList<>();
    private Deck cards;
    private Card pile;
    private int changer = 1;
    private int turn = 0;

    public Game(int numRealPlayers, int numRobots) {
        this.numRealPlayers = numRealPlayers;
        this.numRobots = numRobots;
    }
    public Deck firstCards() {
        Deck cards = new Deck();
        for (int i = 0; i < 13; i++) {
            Card card1 = new Card("green", i);
            cards.addCard(card1);
            Card card2 = new Card("red", i);
            cards.addCard(card2);
            Card card3 = new Card("blue", i);
            cards.addCard(card3);
            Card card4 = new Card("yellow", i);
            cards.addCard(card4);
        }
        for (int i = 1; i < 13; i++) {
            Card card1 = new Card("green", i);
            cards.addCard(card1);
            Card card2 = new Card("red", i);
            cards.addCard(card2);
            Card card3 = new Card("blue", i);
            cards.addCard(card3);
            Card card4 = new Card("yellow", i);
            cards.addCard(card4);
        }
        for (int i = 0; i < 4; i++) {
            Card card1 = new Card("black", 13);
            cards.addCard(card1);
            Card card2 = new Card("black", 14);
            cards.addCard(card2);
        }
        return cards;
    }


    public void print() {
        for(Player i:players){
            System.out.println(i.getName()+" "+i.getDeck().size());
        }
        if(players.get(turn) instanceof RealPlayer){
            ((RealPlayer) players.get(turn)).print();
        }
        else System.out.println(players.get(turn).getName()+" turn");
    }

    public void start() {
        cards = firstCards();
        numPlayers = numRealPlayers + numRobots;
        for (int i = 0; i < numRobots; i++) {
            Robot robot = new Robot();
            for (int j = 0; j < 7; j++) {
                int rand = (int) (Math.random() * cards.size());
                robot.addCard(cards.get(rand));
                cards.remove(rand);
            }
            players.add(robot);
        }
        for (int i = 0; i < numRealPlayers; i++) {
            RealPlayer player = new RealPlayer();
            for (int j = 0; j < 7; j++) {
                int rand = (int) (Math.random() * cards.size());
                player.addCard(cards.get(rand));
                cards.remove(rand);
            }
            players.add(player);
        }
        int rand = (int) (Math.random() * (cards.size() - 1));
        while (cards.get(rand).getNumber() >= 10) {
            rand = (int) (Math.random() * (cards.size() - 1));
        }
        pile = cards.get(rand);
        cards.remove(rand);
    }

    public boolean end() {
        for (Player i : players) {
            if (i.numCard() == 0) return true;
        }
        return false;
    }

    public void applyTurn(Card choose) throws InterruptedException {
        if(choose.getNumber()<10){
            pile=choose;
            pile.print();
            players.get(turn).removeCard(choose);
            cards.addCard(choose);
        }
        else if (choose.getNumber() == 10) {
            pile=choose;
            pile.print();
            players.get(turn).removeCard(choose);
            cards.addCard(choose);
            turn = turn + changer;
        }
        else if (choose.getNumber() == 11) {
            pile=choose;
            pile.print();
            players.get(turn).removeCard(choose);
            cards.addCard(choose);
            changer = changer * -1;
        }
        else if (choose.getNumber() == 12) {
            pile=choose;
            players.get(turn).removeCard(choose);
            cards.addCard(choose);
            int turner=1;
            while(players.get((turn+changer+numPlayers)%numPlayers).havePlus2()){
                if(players.get((turn+changer+numPlayers)%numPlayers) instanceof RealPlayer){
                    pile.print();
                    turn=(turn+changer+numPlayers)%numPlayers;
                    print();
                    turn=(turn-changer+numPlayers)%numPlayers;
                    System.out.print("Your choice:");
                    Scanner sc=new Scanner(System.in);
                    int choice=sc.nextInt()-1;
                    if(players.get((turn+changer+numPlayers)%numPlayers).getDeck().get(choice).getNumber()!=12){
                        pile=players.get((turn+changer+numPlayers)%numPlayers).getDeck().get(choice);
                        pile.print();
                        applyTurn(players.get((turn+changer+numPlayers)%numPlayers).getDeck().get(choice));
                        players.get((turn+changer+numPlayers)%numPlayers).getDeck().remove(choice);
                        turn=(turn+changer+numPlayers)%numPlayers;
                        break;
                    }
                    else{
                        pile=players.get((turn+changer+numPlayers)%numPlayers).getDeck().get(choice);
                        players.get((turn+changer+numPlayers)%numPlayers).getDeck().remove(choice);
                        turn=(turn+changer+numPlayers)%numPlayers;
                        pile.print();
                        print();
                        turner++;
                    }
                }
                else{
                    int time=3;
                    TimeUnit.SECONDS.sleep(time);
                    Card c=((Robot)players.get((turn+changer+numPlayers)%numPlayers)).choosePlus2();
                    players.get((turn+changer+numPlayers)%numPlayers).removeCard(((Robot)players.get((turn+changer+numPlayers)%numPlayers)).choosePlus2());
                    pile=c;
                    turn=(turn+changer+numPlayers)%numPlayers;
                    print();
                    pile.print();
                    turner++;
                }
            }
            for(int i=0;i<turner*2;i++){
                int rand = (int) (Math.random() * (cards.size() - 1));
                players.get((turn+changer+numPlayers)%numPlayers).addCard(cards.get(rand));
                cards.remove(rand);
            }
            pile.print();
        }
        else if (choose.getNumber() == 13) {
            players.get(turn).removeCard(new Card("black",13));
            if(players.get(turn) instanceof RealPlayer){
                System.out.print("Choose your color:");
                Scanner sc=new Scanner(System.in);
                String color=sc.next();
                pile=new Card(color,13);
                pile.print();
            }
            int turner=1;
            while(players.get((turn+changer+numPlayers)%numPlayers).havePlus4()){
                if(players.get((turn+changer+numPlayers)%numPlayers) instanceof RealPlayer){
                    turn=(turn+changer+numPlayers)%numPlayers;
                    print();
                    turn=(turn-changer+numPlayers)%numPlayers;
                    System.out.print("Your choice:");
                    Scanner sc=new Scanner(System.in);
                    int choice=sc.nextInt()-1;
                    if(players.get((turn+changer+numPlayers)%numPlayers).getDeck().get(choice).getNumber()!=13){
                        pile=players.get((turn+changer+numPlayers)%numPlayers).getDeck().get(choice);
                        applyTurn(players.get((turn+changer+numPlayers)%numPlayers).getDeck().get(choice));
                        cards.addCard(players.get((turn+changer+numPlayers)).getDeck().get(choice));
                        players.get((turn+changer+numPlayers)%numPlayers).getDeck().remove(choice);
                        turn=(turn+changer+numPlayers)%numPlayers;
                        break;
                    }
                    else{
                        System.out.print("Choose your color:");
                        String color=sc.next();
                        pile=new Card(color,13);
                        players.get((turn+changer+numPlayers)%numPlayers).getDeck().remove(choice);
                        turn=(turn+changer+numPlayers)%numPlayers;
                        pile.print();
                        turner++;
                    }
                }
                else{
                    int time=3;
                    TimeUnit.SECONDS.sleep(time);
                    Card c=((Robot)players.get((turn+changer+numPlayers)%numPlayers)).choosePlus4();
                    players.get((turn+changer+numPlayers)%numPlayers).removeCard(((Robot)players.get((turn+changer+numPlayers)%numPlayers)).choosePlus4());
                    pile=c;
                    print();
                    pile.print();
                    turn=(turn+changer+numPlayers)%numPlayers;
                    turner++;
                }
            }
            for(int i=0;i<turner*4;i++){
                int rand = (int) (Math.random() * (cards.size() - 1));
                players.get((turn+changer+numPlayers)%numPlayers).addCard(cards.get(rand));
                cards.remove(rand);
            }
        }
        else if(choose.getNumber()==14) {
            if(players.get(turn) instanceof RealPlayer){
                pile=choose;
                players.get(turn).removeCard(choose);
                System.out.print("Choose your color:");
                Scanner sc=new Scanner(System.in);
                String color=sc.next();
                pile=new Card(color,14);
                pile.print();
            }
            else{
                pile=((Robot)players.get(turn)).chooseCard(pile);
                players.get(turn).removeCard(choose);
            }
        }
    }

    public void game() throws InterruptedException {
        start();
        int j = 1;
        Scanner sc = new Scanner(System.in);
        for (Player i : players) {
            System.out.print("Player " + j + " name:");
            i.setName(sc.next());
            j++;
        }
        pile.print();
        while (!end()) {
            long time=1;
            TimeUnit.SECONDS.sleep(time);
            print();
            if (players.get(turn) instanceof RealPlayer) {
                RealPlayer player = (RealPlayer) players.get(turn);
                if (!player.availableCard(pile)) {
                    System.out.println("You don't have any cards to choose it we will get you a card Are you ok?(1.Yes 2.No)");
                    sc.next();
                    int rand = (int) (Math.random() * (cards.size() - 1));
                    player.addCard(cards.get(rand));
                    cards.remove(rand);
                    player.print();
                }
                if (player.availableCard(pile)) {
                    System.out.print("Your choice:");
                    int choose = sc.nextInt() - 1;
                    while ( choose>= player.getDeck().size() || !player.rightChoose(pile, player.getDeck().get(choose))) {
                        System.out.print("Your choice is wrong please choose right card:");
                        sc = new Scanner(System.in);
                        choose = sc.nextInt() - 1;
                    }
                    applyTurn(player.getDeck().get(choose));
                }
            } else if (players.get(turn) instanceof Robot) {
                Robot player = (Robot) players.get(turn);
                time=3;
                TimeUnit.SECONDS.sleep(time);
                if (!player.availableCard(pile)) {
                    int rand = (int) (Math.random() * (cards.size() - 1));
                    player.addCard(cards.get(rand));
                    cards.remove(rand);
                    System.out.println(player.getName()+"had'nt a appropriate card");
                }
                if (player.availableCard(pile)) {
                    applyTurn(player.chooseCard(pile));
                }
            }
            turn = (turn + changer + numPlayers) % numPlayers;
        }
    }
}
