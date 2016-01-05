package fluEpidemic;

import java.util.Set;
import java.util.HashSet;

public class HeightConnectedNeighbourhood implements NeighbourhoodStrategy {
    public Set<Entity> getNeighbours(Field field, int x, int y) {
	Set<Entity> neighbours = new HashSet<Entity>();
	boolean onLeftCorner   = (x == 0);
	boolean onTopCorner    = (y == 0);
	boolean onRightCorner  = (x == field.getHorizontalDimensions() - 1);
	boolean onBottomCorner = (y == field.getVerticalDimensions() - 1);

	if (! onLeftCorner) {
	    if (! field.isEmpty(x - 1, y))
		neighbours.add(field.reportEntity(x - 1, y));
	    if (! onTopCorner && (! field.isEmpty(x - 1, y - 1)))
		neighbours.add(field.reportEntity(x - 1, y - 1));
	    if (! onBottomCorner && (! field.isEmpty(x - 1, y + 1)))
		neighbours.add(field.reportEntity(x - 1, y + 1));
	}

	if (! onTopCorner) {
	    if (! field.isEmpty(x, y - 1))
	    neighbours.add(field.reportEntity(x, y - 1));
	    if (! onRightCorner && (! field.isEmpty(x + 1, y - 1)))
		neighbours.add(field.reportEntity(x + 1, y - 1));
	}

	if (! onRightCorner) {
	    if (! field.isEmpty(x + 1, y))
		neighbours.add(field.reportEntity(x + 1, y));
	    if (! onBottomCorner && (! field.isEmpty(x + 1, y + 1)))
		neighbours.add(field.reportEntity(x + 1, y + 1));
	}

	if (! onBottomCorner) {
	    if (! field.isEmpty(x, y + 1))
		neighbours.add(field.reportEntity(x, y + 1));
	}
	
	return neighbours;
    }
}
