// This defines a simple class of critters that infect whenever they can and
// otherwise just spin around, looking for critters to infect.  This simple
// strategy turns out to be surpisingly successful.

import java.awt.*;
import java.util.Random;

public class FlyTrap extends Critter {
    public Action getMove(CritterInfo info) {
        Random r = new Random();
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.SAME){
            if(r.nextInt(4) == 0){
                return Action.LEFT;
            } else {
                return Action.INFECT;
            }
        } else if(info.getLeft() == Neighbor.SAME && info.getBack() == Neighbor.SAME && info.getRight() == Neighbor.SAME){
            return Action.HOP;
        } else {
            if(r.nextInt(1) == 0){
                return Action.LEFT;
            } else {
                return Action.INFECT;
            }
        }
    }

    public Color getColor() {
        return Color.RED;
    }

    public String toString() {
        return "T";
    }
}