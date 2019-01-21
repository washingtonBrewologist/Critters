import java.awt.*;
import java.util.Collections;

public class Bear extends Critter {

    private int counter;
    private boolean polar;

    // Constructor
    public Bear(boolean polar){
        this.counter = 0;
        this.polar = polar;
    }

    public String toString(){
        this.counter = this.counter + 1;
        if (counter % 2 == 1){
            return "/";
        } else {
            return "\\";
        }
    }

    public Action getMove(CritterInfo info){
        // always infect if a neighbor is in front
        if (info.getFront() == Neighbor.OTHER){
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY){
            return Action.HOP;
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor(){
        if (polar){
            return Color.white;
        } else {
            return Color.black;
        }
    }

}
