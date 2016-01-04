package fluEpidemic;

import java.util.Set;
import java.util.HashSet;

public interface NeighbourhoodStrategy {
    public Set<Entity> getNeighbours(Field field, int x, int y);
}
