import java.awt.*;

public class Giant extends Critter {
    private int counter;
    private final String[] giantNames = {"fee", "fie", "foe", "fum"};
    private int index;

    public Giant(){

    }

    public Color getColor(){
        return Color.GRAY;
    }

    public Action getMove(CritterInfo info){
        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.RIGHT;
        }
    }

    public String toString(){
        String prevElement;
        this.counter = this.counter + 1;
        if ((this.counter -1) % 6 == 0){
            checkForReset();
            this.index++;
            return giantNames[index - 1];
        } else {
            prevElement = giantNames[index -1];
        }
        return prevElement;
    }

    public void checkForReset(){
        if (this.index == 4){
            this.index = 0;
        }
    }
}