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

    public void print() {
        String ANSI_RESET = "\u001B[0m";
        for (Card card : cards) {
            if (card.getColor().equals("blue")) {
                String ANSI_BLUE = "\u001B[34m";
                System.out.print(ANSI_BLUE + "###########   " + ANSI_RESET);
            } else if (card.getColor().equals("green")) {
                String ANSI_GREEN = "\u001B[32m";
                System.out.print(ANSI_GREEN + "###########   " + ANSI_RESET);
            } else if (card.getColor().equals("red")) {
                String ANSI_RED = "\u001B[31m";
                System.out.print(ANSI_RED + "###########   " + ANSI_RESET);
            } else if (card.getColor().equals("yellow")) {
                String ANSI_YELLOW = "\u001B[33m";
                System.out.print(ANSI_YELLOW + "###########   " + ANSI_RESET);
            } else {
                String ANSI_BLACK = "\u001B[30m";
                System.out.print(ANSI_BLACK + "###########   " + ANSI_RESET);
            }
        }
        System.out.println("");
        for (Card card : cards) {
            if (card.getColor().equals("blue")) {
                String ANSI_BLUE = "\u001B[34m";
                System.out.print(ANSI_BLUE + "|         |   " + ANSI_RESET);
            } else if (card.getColor().equals("green")) {
                String ANSI_GREEN = "\u001B[32m";
                System.out.print(ANSI_GREEN + "|         |   " + ANSI_RESET);
            } else if (card.getColor().equals("red")) {
                String ANSI_RED = "\u001B[31m";
                System.out.print(ANSI_RED + "|         |   " + ANSI_RESET);
            } else if (card.getColor().equals("yellow")) {
                String ANSI_YELLOW = "\u001B[33m";
                System.out.print(ANSI_YELLOW + "|         |   " + ANSI_RESET);
            } else {
                String ANSI_BLACK = "\u001B[30m";
                System.out.print(ANSI_BLACK + "|         |   " + ANSI_RESET);
            }
        }
        System.out.println("");
        for (Card card : cards) {
            if (card.getColor().equals("blue")) {
                String ANSI_BLUE = "\u001B[34m";
                if (card.getNumber() < 10) {
                    System.out.print(ANSI_BLUE + "|    " + card.getNumber() + "    |   " + ANSI_RESET);
                }
                else if(card.getNumber()==10){
                    System.out.print(ANSI_BLUE + "| S K I P |   " + ANSI_RESET);
                }
                else if(card.getNumber()==11){
                    System.out.print(ANSI_BLUE+"|  R E V  |   ");
                }
                else if(card.getNumber()==12){
                    System.out.print(ANSI_BLUE+"|   + 2   |   ");
                }

            }
            else if (card.getColor().equals("green")) {
                String ANSI_GREEN = "\u001B[32m";
                if (card.getNumber() < 10) {
                    System.out.print(ANSI_GREEN + "|    " + card.getNumber() + "    |   " + ANSI_RESET);
                }
                else if(card.getNumber()==10){
                    System.out.print(ANSI_GREEN + "| S K I P |   " + ANSI_RESET);
                }
                else if(card.getNumber()==11){
                    System.out.print(ANSI_GREEN + "|  R E V  |   " + ANSI_RESET);
                }
                else if(card.getNumber()==12){
                    System.out.print(ANSI_GREEN + "|   + 2   |   " + ANSI_RESET);
                }
            }
            else if (card.getColor().equals("red")) {
                String ANSI_RED = "\u001B[31m";
                if (card.getNumber() < 10) {
                    System.out.print(ANSI_RED + "|    " + card.getNumber() + "    |   " + ANSI_RESET);
                }
                else if(card.getNumber()==10){
                    System.out.print(ANSI_RED + "| S K I P |   " + ANSI_RESET);
                }
                else if(card.getNumber()==11){
                    System.out.print(ANSI_RED + "|  R E V  |   " + ANSI_RESET);
                }
                else if(card.getNumber()==12){
                    System.out.print(ANSI_RED + "|   + 2   |   " + ANSI_RESET);
                }
            }
            else if (card.getColor().equals("yellow")) {
                String ANSI_YELLOW = "\u001B[33m";
                if (card.getNumber() < 10) {
                    System.out.print(ANSI_YELLOW + "|    " + card.getNumber() + "    |   " + ANSI_RESET);
                }
                else if(card.getNumber()==10){
                    System.out.print(ANSI_YELLOW + "| S K I P |   " + ANSI_RESET);
                }
                else if(card.getNumber()==11){
                    System.out.print(ANSI_YELLOW + "|  R E V  |   " + ANSI_RESET);
                }
                else if(card.getNumber()==12){
                    System.out.print(ANSI_YELLOW + "|   + 2   |   " + ANSI_RESET);
                }
            }
            else {
                String ANSI_BLACK = "\u001B[30m";
                if(card.getNumber()==13){
                    System.out.print(ANSI_BLACK + "|   + 4   |   " + ANSI_RESET);
                }
                else{
                    System.out.print(ANSI_BLACK + "|C O L O R|   " + ANSI_RESET);
                }
            }
        }
        System.out.println("");
        for (Card card : cards) {
            if (card.getColor().equals("blue")) {
                String ANSI_BLUE = "\u001B[34m";
                System.out.print(ANSI_BLUE + "|         |   " + ANSI_RESET);
            } else if (card.getColor().equals("green")) {
                String ANSI_GREEN = "\u001B[32m";
                System.out.print(ANSI_GREEN + "|         |   " + ANSI_RESET);
            } else if (card.getColor().equals("red")) {
                String ANSI_RED = "\u001B[31m";
                System.out.print(ANSI_RED + "|         |   " + ANSI_RESET);
            } else if (card.getColor().equals("yellow")) {
                String ANSI_YELLOW = "\u001B[33m";
                System.out.print(ANSI_YELLOW + "|         |   " + ANSI_RESET);
            } else {
                String ANSI_BLACK = "\u001B[30m";
                System.out.print(ANSI_BLACK + "|         |   " + ANSI_RESET);
            }
        }
        System.out.println("");
        for (Card card : cards) {
            if (card.getColor().equals("blue")) {
                String ANSI_BLUE = "\u001B[34m";
                System.out.print(ANSI_BLUE + "###########   " + ANSI_RESET);
            } else if (card.getColor().equals("green")) {
                String ANSI_GREEN = "\u001B[32m";
                System.out.print(ANSI_GREEN + "###########   " + ANSI_RESET);
            } else if (card.getColor().equals("red")) {
                String ANSI_RED = "\u001B[31m";
                System.out.print(ANSI_RED + "###########   " + ANSI_RESET);
            } else if (card.getColor().equals("yellow")) {
                String ANSI_YELLOW = "\u001B[33m";
                System.out.print(ANSI_YELLOW + "###########   " + ANSI_RESET);
            } else {
                String ANSI_BLACK = "\u001B[30m";
                System.out.print(ANSI_BLACK + "###########   " + ANSI_RESET);
            }
        }
        System.out.println("");
        System.out.println(name);
    }
    public boolean availableCard(Card card){
        for(Card i:cards){
            if(i.getColor().equals("black"))return true;
            else if(i.getColor().equals(card.getColor()))return true;
            else if(i.getNumber()==card.getNumber())return true;
        }
        return false;
    }
}
