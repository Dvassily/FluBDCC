package fluEpidemic;

import java.util.Set;
import java.util.HashSet;

public class Neighbourhood4x4 implements NeighbourhoodStrategy {
    public Set<Entity> getNeighbours(Field field, int x, int y) {
	System.out.println("foo");
	Set<Entity> neighbours = new HashSet<Entity>();
	
	if (x < field.getHorizontalDimensions() - 1 && (! field.isEmpty(x + 1, y)))
	    neighbours.add(field.reportEntity(x + 1, y));
	if (y < field.getVerticalDimensions() - 1 && (! field.isEmpty(x, y + 1)))
	    neighbours.add(field.reportEntity(x, y + 1));
	if (x >= 1 && (! field.isEmpty(x - 1, y))) neighbours.add(field.reportEntity(x - 1, y));
	if (y >= 1 && (! field.isEmpty(x, y - 1))) neighbours.add(field.reportEntity(x, y - 1));
	
	return neighbours;
    }
}
