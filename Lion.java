import java.awt.*;

public class Lion extends Critter {

    private int count;
    private Color initColor;

    public Lion() {
        this.count = 0;
    }

    public Color getColor() {

        this.count = this.count + 1;
        if ((this.count - 1) % 3 == 0) {
            Color randomColor = getRandomColor();
            this.initColor = randomColor;
            return randomColor;
        } else {
            return this.initColor;
        }

    }

    public Action getMove(CritterInfo info) {

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }

    }

    private Color getRandomColor() {

        double number = Math.random() * 10;
        if (number < (10/3)) {
            return Color.BLUE;
        } else if (number > (20/3)) {
            return Color.RED;
        } else {
            return Color.GREEN;
        }

    }

    public String toString() {
        return "L";
    }

}