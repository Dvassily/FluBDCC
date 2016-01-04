package fluEpidemic;

import java.util.Set;
import java.util.HashSet;

public class Neighbourhood4x4 implements NeighbourhoodStrategy {
    public Set<Entity> getNeighbours(Map map, int x, int y) {
	Set<Entity> neighbours = new HashSet<Entity>();
	
	if (x < map.getHorizontalDimensions() - 1 && (! map.isEmpty(x + 1, y)))
	    neighbours.add(map.reportEntity(x + 1, y));
	if (y < map.getVerticalDimensions() - 1 && (! map.isEmpty(x, y + 1)))
	    neighbours.add(map.reportEntity(x, y + 1));
	if (x >= 1 && (! map.isEmpty(x - 1, y))) neighbours.add(map.reportEntity(x - 1, y));
	if (y >= 1 && (! map.isEmpty(x, y - 1))) neighbours.add(map.reportEntity(x, y - 1));
	
	return neighbours;
    }
}
