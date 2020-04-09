import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards = new ArrayList<>();

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
     * Getter for cards
     *
     * @return An array of cards
     */

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Add a card to player
     *
     * @param card Card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Remove a card from player
     *
     * @param card Card
     */
    public void removeCard(Card card) {

        cards.remove(card);
    }

    /**
     * Return number of player's cards
     *
     * @return An integer
     */
    public int numCard() {
        return cards.size();
    }


    public boolean availableCard(Card card){
        for(Card i:cards){
            if(i.getColor().equals("black"))return true;
            else if(i.getColor().equals(card.getColor()))return true;
            else if(i.getNumber()==card.getNumber())return true;
        }
        return false;
    }
    public boolean havePlus2(){
        for(Card i:cards){
            if(i.getNumber()==12)return true;
        }
        return false;
    }
    public boolean havePlus4(){
        for(Card i:cards){
            if(i.getNumber()==13)return true;
        }
        return false;
    }
}
