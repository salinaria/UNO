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
     *
     * @param color  Color of card
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
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLACK = "\u001B[30m";
        if (color.equals("blue")) System.out.print(ANSI_BLUE);
        else if (color.equals("green")) System.out.print(ANSI_GREEN);
        else if (color.equals("red")) System.out.print(ANSI_RED);
        else if (color.equals("yellow")) System.out.print(ANSI_YELLOW);
        else System.out.print(ANSI_BLACK);
        System.out.print("###########\n|         |\n|");
        if(number<10) System.out.print("    "+number+"    ");
        else if(number==10) System.out.print(" S K I P ");
        else if(number==11) System.out.print("  R E V  ");
        else if(number==12) System.out.print("   + 2   ");
        else if(number==13) System.out.print("   + 4   ");
        else if(number==14) System.out.print("C O L O R");
        System.out.println("|\n|         |\n###########");
    }

}

