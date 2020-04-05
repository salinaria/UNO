public class Card {
    //green red blue yellow black
    private String color;
    /*
    0 to 9: normal cards
    10: skip card
    11: reverse card
    12: +2 cards
    13: +4 cards
    14: change color
    */
    private int number;

    /**
     * Constructor for Card
     * @param color Color of card
     * @param number number of card
     */
    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    /**
     * Getter for color
     *
     * @return A string
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter for number
     *
     * @return An integer
     */
    public int getNumber() {
        return number;
    }

    public void print() {
        System.out.println(color+number);
    }
}

