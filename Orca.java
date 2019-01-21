import java.awt.*;
import java.util.Random;

    public class Orca extends Critter {
        private int counter;

        public Orca(){

        }
        public Color getColor(){
            return Color.BLACK;
        }

        public String toString(){
            this.counter = this.counter + 1;
            if (counter % 2 == 0){
                return "><>";
            } else {
                return "<<>";
            }
        }

        public Action getMove(CritterInfo info){
            if (info.getFront() == Neighbor.OTHER){ // infect other mofos/critters
                return Action.INFECT;
            }

            if (info.getLeft() == Neighbor.SAME && info.getRight() == Neighbor.SAME
                    && info.getBack() == Neighbor.SAME) { // if surrounded L,R,B by same then break off
                return Action.HOP;
            }


            if (info.getLeft() == Neighbor.SAME || info.getRight() == Neighbor.SAME
                    &&  info.getFront() == Neighbor.SAME || info.getBack() == Neighbor.SAME) {
                if (info.getLeft() == Neighbor.OTHER) {
                    return Action.LEFT;
                }else if (info.getLeft() == Neighbor.SAME && info.getRight() == Neighbor.SAME
                        && info.getBack() == Neighbor.SAME){
                    return Action.HOP;
                } else if (info.getLeft() == Neighbor.WALL || info.getLeft() == Neighbor.SAME) {
                    return Action.RIGHT;
                } else if (info.getRight() == Neighbor.WALL || info.getRight() == Neighbor.SAME) {
                    return Action.LEFT;
                } else if (Math.random() < 0.5) {
                    return  Action.LEFT;
                } else {
                    return Action.RIGHT;
                }
            } else {
                if (info.getLeft() == Neighbor.OTHER) {
                    return Action.LEFT;
                } else if (info.getFront() == Neighbor.EMPTY) {
                    return Action.HOP;
                } else if (info.getFront() == Neighbor.OTHER) {
                    return Action.INFECT;
                } else {
                    if (info.getLeft() == Neighbor.WALL) {
                        return Action.RIGHT;
                    } else if (info.getRight() == Neighbor.WALL) {
                        return Action.LEFT;
                    }
                }
            }
            return Action.LEFT;
        }

    }
