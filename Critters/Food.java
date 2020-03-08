// This defines a simple class of critters that sit around waiting to be
// taken over by other critters.

import java.awt.*;
import java.util.Random;

public class Food extends Critter {
    public Action getMove(CritterInfo info) {
        Random r = new Random();
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if(info.getFront() != Neighbor.WALL) {
            if(r.nextInt(2) == 1){
                return Action.HOP;
            } else if(r.nextInt(5) == 1){
                return Action.LEFT;
            } else if(r.nextInt(5) == 1){
                return Action.RIGHT;
            } else {
                return Action.INFECT;
            }

        } else {
            return Action.LEFT;
        }
    }

    public Color getColor() {
        return Color.GREEN;
    }

    public String toString() {
        return "F";
    }
}
