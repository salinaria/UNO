import java.util.ArrayList;

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
    }
    public void game(){
    }
}
