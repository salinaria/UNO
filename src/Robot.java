public class Robot extends Player {
    public int chooseCard(Card card){
        int choose=0;
        for(Card i:getCards()){
            if(i.getNumber()==card.getNumber())return choose;
            else if(i.getColor().equals(card.getColor()))return choose;
            choose++;
        }
        return 200;
    }
}
