package fluEpidemic;

import java.util.Set;
import java.util.HashSet;

public interface NeighbourhoodStrategy {
    public Set<Entity> getNeighbours(Map map, int x, int y);
}
