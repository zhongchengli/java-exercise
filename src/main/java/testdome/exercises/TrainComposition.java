package testdome.exercises;

import java.util.LinkedList;
import java.util.List;

/*
A TrainComposition is built by attaching and detaching wagons from the left and the right sides, efficiently with respect to time used.

For example, if we start by attaching wagon 7 from the left followed by attaching wagon 13, again from the left, we get a composition of two wagons (13 and 7 from left to right). Now the first wagon that can be detached from the right is 7 and the first that can be detached from the left is 13.

Implement a TrainComposition that models this problem.
 */

// https://www.testdome.com/questions/java/train-composition/38909?visibility=3&skillId=4

public class TrainComposition {

    List<Integer> wagonIds = new LinkedList<Integer>();

    public void attachWagonFromLeft(int wagonId) {
        wagonIds.add(0, Integer.valueOf(wagonId));
    }

    public void attachWagonFromRight(int wagonId) {
        wagonIds.add(Integer.valueOf(wagonId));
    }

    public int detachWagonFromLeft() {
        int wagonId = 0;
        if (wagonIds.size() > 0) {
            wagonId = wagonIds.get(0);
            wagonIds.remove(0);
        }
        return wagonId;
    }

    public int detachWagonFromRight() {
        int wagonId = 0;
        if (wagonIds.size() > 0) {
            wagonId = wagonIds.get(wagonIds.size() - 1);
            wagonIds.remove(wagonIds.size() - 1);
        }
        return wagonId;
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
