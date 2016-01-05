package fluEpidemic;

import java.util.Random;
import java.util.Collections;
import java.util.LinkedList;

/*
 * Direction enum manage direction of entity on the map
 */
public enum Direction {
	NORTH, SOUTH, WEST, EAST;

	public static Direction randomDirection() {
		return Direction.values()[new Random().nextInt(Direction.values().length - 1)];
	}

	public static LinkedList<Direction> getList() {
		LinkedList<Direction> list = new LinkedList<>();

		for (Direction d : Direction.values()) {
			list.add(d);
		}

		Collections.shuffle(list);

		return list;
	}
}
