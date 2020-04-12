public class RealPlayer extends Player {
    public void print(){
        deck.print();
        System.out.println(getName());
    }
    public boolean rightChoose(Card card,Card choose) {
        if (card.getNumber() == choose.getNumber()) return true;
        else if (card.getColor().equals(choose.getColor())) return true;
        else return choose.getColor().equals("black");
    }
}
