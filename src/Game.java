import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int numPlayers;
    private ArrayList<Player>players=new ArrayList<>();
    private ArrayList<Card> cards=new ArrayList<>();

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

    public void print(){

    }
    public void start(){
        for(int i=0;i<13;i++){
            Card card1=new Card("green",i);
            cards.add(card1);
            Card card2=new Card("red",i);
            cards.add(card2);
            Card card3=new Card("blue",i);
            cards.add(card3);
            Card card4=new Card("yellow",i);
            cards.add(card4);
        }
        for(int i=1;i<13;i++){
            Card card1=new Card("green",i);
            cards.add(card1);
            Card card2=new Card("red",i);
            cards.add(card2);
            Card card3=new Card("blue",i);
            cards.add(card3);
            Card card4=new Card("yellow",i);
            cards.add(card4);
        }
        for(int i=0;i<4;i++){
            Card card1=new Card("black",13);
            cards.add(card1);
            Card card2=new Card("black",14);
            cards.add(card2);
        }
        for(int i=0;i<numPlayers;i++){
            Player player=new Player();
            for(int j=0;j<7;j++){
                int rand=(int) (Math.random()*cards.size());
                player.addCard(cards.get(rand));
                cards.remove(rand);
            }
            players.add(player);
        }
        Scanner sc=new Scanner(System.in);
        int j=1;
        for(Player i:players){
            System.out.print("Player "+j+"name:");
            i.setName(sc.next());
            j++;
        }
    }
    public boolean endGame(){
        for(Player i:players){
            if(i.numCard()==0)return true;
        }
        return false;
    }
    public void reverse(int turn,int changer,Card card){
        players.get(Math.abs(turn)%numPlayers).removeCard(card);
        changer=changer*-1;
    }
    public void skip(int turn,Card card){
        players.get(Math.abs(turn)%numPlayers).removeCard(card);
        turn++;
    }
    public void plus2(int turn,Card card){
        players.get(Math.abs(turn)%numPlayers).removeCard(card);
        for(int j=0;j<2;j++){
            int rand1=(int) (Math.random()*(cards.size()-1));
            players.get(Math.abs(turn+1)%numPlayers).addCard(cards.get(rand1));
            cards.remove(rand1);
        }
    }
    public String plus4(int turn,Card card){
        players.get(Math.abs(turn)%numPlayers).removeCard(card);
        for(int j=0;j<4;j++){
            int rand1=(int) (Math.random()*(cards.size()-1));
            players.get(Math.abs(turn+1)%numPlayers).addCard(cards.get(rand1));
            cards.remove(rand1);
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose your color");
        return sc.next();
    }
    public String changeColor(int turn,Card card){
        players.get(Math.abs(turn)%numPlayers).removeCard(card);
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose your color");
        return sc.next();
    }
    public void game(){
        start();
        int turn=0;
        int changer=1;
        int rand=(int) (Math.random()*(cards.size()-1));
        cards.remove(rand);
        Card card=cards.get(rand);
        while (!endGame()){
            card.print();
            players.get(Math.abs(turn%numPlayers)).print();
            if(!players.get(Math.abs(turn%numPlayers)).availableCard(card)) {
                System.out.println("You don't have any cards to choose it we will get you a card Are you ok?(1.Yes 2.No)");
                Scanner sc = new Scanner(System.in);
                sc.nextInt();
                rand = (int) (Math.random() * (cards.size() - 1));
                cards.remove(rand);
                players.get(Math.abs(turn%numPlayers)).addCard(cards.get(rand));
            }
            if(players.get(Math.abs(turn%numPlayers)).availableCard(card)){
                System.out.print("Your choose:");
                Scanner sc=new Scanner(System.in);
                int choose=sc.nextInt()-1;
                card=players.get(Math.abs(turn%numPlayers)).getCards().get(choose);
                if(players.get(Math.abs(turn%numPlayers)).getCards().get(choose).getNumber()==10)skip(turn,players.get(Math.abs(turn%numPlayers)).getCards().get(choose));
                else if(players.get(Math.abs(turn%numPlayers)).getCards().get(choose).getNumber()==11)reverse(turn,changer,players.get(Math.abs(turn%numPlayers)).getCards().get(choose));
                else if(players.get(Math.abs(turn%numPlayers)).getCards().get(choose).getNumber()==12)plus2(turn,players.get(Math.abs(turn%numPlayers)).getCards().get(choose));
                else if(players.get(Math.abs(turn%numPlayers)).getCards().get(choose).getNumber()==13){
                    card=new Card(plus4(turn,players.get(Math.abs(turn%numPlayers)).getCards().get(choose)),13);
                }
                else if(players.get(Math.abs(turn%numPlayers)).getCards().get(choose).getNumber()==14){
                    String color=changeColor(turn,players.get(Math.abs(turn%numPlayers)).getCards().get(choose));
                    card=new Card(color,14);
                }
            }
            turn=turn+changer;
        }
    }
}
