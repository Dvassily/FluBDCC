package fluEpidemic;

import java.util.Random;

public enum Direction {
    NORTH, SOUTH, WEST, EAST;

    public static Direction randomDirection() {
	return Direction.values()[new Random().nextInt(Direction.values().length - 1)];
    }
}

