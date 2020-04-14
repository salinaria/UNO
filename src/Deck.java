import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        for (int i=0;i<size();i++) {
            if (card.equals(cards.get(i))) {
                cards.remove(i);
                break;
            }
        }
    }

    public void remove(int index) {
        cards.remove(index);
    }

    public int size() {
        return cards.size();
    }

    public boolean availableCard(Card card) {
        for (Card i : cards) {
            if (i.getColor().equals("black")) return true;
            else if (i.getColor().equals(card.getColor())) return true;
            else if (i.getNumber() == card.getNumber()) return true;
        }
        return false;
    }

    public boolean havePlus2() {
        for (Card i : cards) {
            if (i.getNumber() == 12) return true;
        }
        return false;
    }

    public boolean havePlus4() {
        for (Card i : cards) {
            if (i.getNumber() == 13) return true;
        }
        return false;
    }

    public void print() {
        String ANSI_RESET = "\u001B[0m";
        for (int i = 0; i <= size() / 8; i++) {
            int j=0;
            for (int k=i*7;k<size();k++) {
                Card card=cards.get(k);
                if(j<7)j++;
                else break;
                switch (card.getColor()) {
                    case "blue":
                        String ANSI_BLUE = "\u001B[34m";
                        System.out.print(ANSI_BLUE + "###########   " + ANSI_RESET);
                        break;
                    case "green":
                        String ANSI_GREEN = "\u001B[32m";
                        System.out.print(ANSI_GREEN + "###########   " + ANSI_RESET);
                        break;
                    case "red":
                        String ANSI_RED = "\u001B[31m";
                        System.out.print(ANSI_RED + "###########   " + ANSI_RESET);
                        break;
                    case "yellow":
                        String ANSI_YELLOW = "\u001B[33m";
                        System.out.print(ANSI_YELLOW + "###########   " + ANSI_RESET);
                        break;
                    default:
                        String ANSI_BLACK = "\u001B[30m";
                        System.out.print(ANSI_BLACK + "###########   " + ANSI_RESET);
                        break;
                }
            }
            System.out.println("");
            j=0;
            for (int k=i*7;k<size();k++) {
                Card card=cards.get(k);
                if(j<7)j++;
                else break;
                switch (card.getColor()) {
                    case "blue":
                        String ANSI_BLUE = "\u001B[34m";
                        System.out.print(ANSI_BLUE + "|         |   " + ANSI_RESET);
                        break;
                    case "green":
                        String ANSI_GREEN = "\u001B[32m";
                        System.out.print(ANSI_GREEN + "|         |   " + ANSI_RESET);
                        break;
                    case "red":
                        String ANSI_RED = "\u001B[31m";
                        System.out.print(ANSI_RED + "|         |   " + ANSI_RESET);
                        break;
                    case "yellow":
                        String ANSI_YELLOW = "\u001B[33m";
                        System.out.print(ANSI_YELLOW + "|         |   " + ANSI_RESET);
                        break;
                    default:
                        String ANSI_BLACK = "\u001B[30m";
                        System.out.print(ANSI_BLACK + "|         |   " + ANSI_RESET);
                        break;
                }
            }
            System.out.println("");
            j=0;
            for (int k=i*7;k<size();k++) {
                Card card=cards.get(k);
                if(j<7)j++;
                else break;
                switch (card.getColor()) {
                    case "blue":
                        String ANSI_BLUE = "\u001B[34m";
                        if (card.getNumber() < 10) {
                            System.out.print(ANSI_BLUE + "|    " + card.getNumber() + "    |   " + ANSI_RESET);
                        } else if (card.getNumber() == 10) {
                            System.out.print(ANSI_BLUE + "| S K I P |   " + ANSI_RESET);
                        } else if (card.getNumber() == 11) {
                            System.out.print(ANSI_BLUE + "|  R E V  |   ");
                        } else if (card.getNumber() == 12) {
                            System.out.print(ANSI_BLUE + "|   + 2   |   ");
                        }

                        break;
                    case "green":
                        String ANSI_GREEN = "\u001B[32m";
                        if (card.getNumber() < 10) {
                            System.out.print(ANSI_GREEN + "|    " + card.getNumber() + "    |   " + ANSI_RESET);
                        } else if (card.getNumber() == 10) {
                            System.out.print(ANSI_GREEN + "| S K I P |   " + ANSI_RESET);
                        } else if (card.getNumber() == 11) {
                            System.out.print(ANSI_GREEN + "|  R E V  |   " + ANSI_RESET);
                        } else if (card.getNumber() == 12) {
                            System.out.print(ANSI_GREEN + "|   + 2   |   " + ANSI_RESET);
                        }
                        break;
                    case "red":
                        String ANSI_RED = "\u001B[31m";
                        if (card.getNumber() < 10) {
                            System.out.print(ANSI_RED + "|    " + card.getNumber() + "    |   " + ANSI_RESET);
                        } else if (card.getNumber() == 10) {
                            System.out.print(ANSI_RED + "| S K I P |   " + ANSI_RESET);
                        } else if (card.getNumber() == 11) {
                            System.out.print(ANSI_RED + "|  R E V  |   " + ANSI_RESET);
                        } else if (card.getNumber() == 12) {
                            System.out.print(ANSI_RED + "|   + 2   |   " + ANSI_RESET);
                        }
                        break;
                    case "yellow":
                        String ANSI_YELLOW = "\u001B[33m";
                        if (card.getNumber() < 10) {
                            System.out.print(ANSI_YELLOW + "|    " + card.getNumber() + "    |   " + ANSI_RESET);
                        } else if (card.getNumber() == 10) {
                            System.out.print(ANSI_YELLOW + "| S K I P |   " + ANSI_RESET);
                        } else if (card.getNumber() == 11) {
                            System.out.print(ANSI_YELLOW + "|  R E V  |   " + ANSI_RESET);
                        } else if (card.getNumber() == 12) {
                            System.out.print(ANSI_YELLOW + "|   + 2   |   " + ANSI_RESET);
                        }
                        break;
                    default:
                        String ANSI_BLACK = "\u001B[30m";
                        if (card.getNumber() == 13) {
                            System.out.print(ANSI_BLACK + "|   + 4   |   " + ANSI_RESET);
                        } else {
                            System.out.print(ANSI_BLACK + "|C O L O R|   " + ANSI_RESET);
                        }
                        break;
                }
            }
            System.out.println("");
            j=0;
            for (int k=i*7;k<size();k++) {
                Card card=cards.get(k);
                if(j<7)j++;
                else break;
                switch (card.getColor()) {
                    case "blue":
                        String ANSI_BLUE = "\u001B[34m";
                        System.out.print(ANSI_BLUE + "|         |   " + ANSI_RESET);
                        break;
                    case "green":
                        String ANSI_GREEN = "\u001B[32m";
                        System.out.print(ANSI_GREEN + "|         |   " + ANSI_RESET);
                        break;
                    case "red":
                        String ANSI_RED = "\u001B[31m";
                        System.out.print(ANSI_RED + "|         |   " + ANSI_RESET);
                        break;
                    case "yellow":
                        String ANSI_YELLOW = "\u001B[33m";
                        System.out.print(ANSI_YELLOW + "|         |   " + ANSI_RESET);
                        break;
                    default:
                        String ANSI_BLACK = "\u001B[30m";
                        System.out.print(ANSI_BLACK + "|         |   " + ANSI_RESET);
                        break;
                }
            }
            System.out.println("");
            j=0;
            for (int k=i*7;k<size();k++) {
                Card card=cards.get(k);
                if(j<7)j++;
                else break;
                switch (card.getColor()) {
                    case "blue":
                        String ANSI_BLUE = "\u001B[34m";
                        System.out.print(ANSI_BLUE + "###########   " + ANSI_RESET);
                        break;
                    case "green":
                        String ANSI_GREEN = "\u001B[32m";
                        System.out.print(ANSI_GREEN + "###########   " + ANSI_RESET);
                        break;
                    case "red":
                        String ANSI_RED = "\u001B[31m";
                        System.out.print(ANSI_RED + "###########   " + ANSI_RESET);
                        break;
                    case "yellow":
                        String ANSI_YELLOW = "\u001B[33m";
                        System.out.print(ANSI_YELLOW + "###########   " + ANSI_RESET);
                        break;
                    default:
                        String ANSI_BLACK = "\u001B[30m";
                        System.out.print(ANSI_BLACK + "###########   " + ANSI_RESET);
                        break;
                }
            }
            System.out.println(ANSI_RESET);
        }
    }

    public void printMini() {
        int j = size();
        for (int i = 0; i < j; i++) {
            System.out.print("--- ");
        }
        System.out.println();
        for (int i = 0; i < j; i++) {
            System.out.print("| | ");
        }
        System.out.println();
        for (int i = 0; i < j; i++) {
            System.out.print("--- ");
        }
    }

    public Card get(int index) {
        return cards.get(index);
    }
}
