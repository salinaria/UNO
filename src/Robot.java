public class Robot extends Player {
    public String color() {
        int blue = 0, green = 0, red = 0, yellow = 0;
        for (Card i : deck.getCards()) {
            switch (i.getColor()) {
                case "green":
                    green++;
                case "red":
                    red++;
                case "blue":
                    blue++;
                case "yellow":
                    yellow++;
            }
        }
        if(blue>=green && blue>=yellow && blue>=red) return "blue";
        else if(green>=blue && green>=yellow && green>=red) return "green";
        else if(yellow>=green && yellow>=blue && yellow>=red)return "yellow";
        else return "red";
    }
    public Card choosePlus2(){
        for(Card i: deck.getCards()){
            if(i.getNumber()==12)return i;
        }
        return deck.getCards().get(0);
    }
    public Card choosePlus4(){
        for(Card i: deck.getCards()){
            if(i.getNumber()==13)return i;
        }
        return deck.getCards().get(0);
    }
    public Card chooseCard(Card card) {
        Card choose=deck.getCards().get(0);
        for (Card i : deck.getCards()) {
            if (i.getNumber() == card.getNumber()) return i;
            else if (i.getColor().equals(card.getColor())) return i;
            else if (i.getColor().equals("black")) choose=new Card(color(),i.getNumber());
        }
        return choose;
    }
}
