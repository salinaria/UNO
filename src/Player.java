import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards=new ArrayList<>();

    /**
     * Getter for name
     * @return An string
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for cards
     * @return An array of cards
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Add a card to player
     * @param card Card
     */
    public void addCard(Card card){
        cards.add(card);
    }

    /**
     * Remove a card from player
     * @param card Card
     */
    public void removeCard(Card card){
        cards.remove(card);
    }

    /**
     * Return number of player's cards
     * @return An integer
     */
    public int numCard(){
        return cards.size();
    }
}
