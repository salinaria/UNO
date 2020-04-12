import java.util.ArrayList;

public class Player {
    private String name;
    protected Deck deck=new Deck();

    /**
     * Getter for name
     *
     * @return An string
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name An String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for deck
     *
     * @return deck
     */
    public Deck getDeck() {
        return deck;
    }
    public void addCard(Card card){
        deck.addCard(card);
    }
    public void removeCard(Card card){
        deck.removeCard(card);
    }
    public int numCard(){
        return deck.size();
    }
    public boolean availableCard(Card card){
        return deck.availableCard(card);
    }
    public boolean havePlus2(){
        return deck.havePlus2();
    }
    public boolean havePlus4(){
        return deck.havePlus4();
    }
}
