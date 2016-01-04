package fluEpidemic;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class Map {
    private Entity map[][];
    private NeighbourhoodStrategy ns;
    
    /**
     * Initialize a map of dimensions (x, y)
     * @param x horizontal dimensions
     * @param y vertical dimensions
     */
    public Map(int x,
	       int y,
	       NeighbourhoodStrategy ns){
	this.map = new Entity[x][y];
	this.ns = ns;
    }

    /**
     * Get the horizontal dimensions of the map
     * @return the horizontal dimensions
     */	
    public int getHorizontalDimensions() {
	return map.length;
    }
	
    /**
     * Get the vertical dimensions of the map
     * @return the vertical dimensions
     */	
    public int getVerticalDimensions() {
	return map[0].length;
    }
	
    /**
     * Get the entity of the case (x, y)
     * @param x horizontal coordinates
     * @param y vertical coordinates
     */
    public Entity reportEntity(int x, int y){
	return map[x][y];
    }

    /**
     * Put an entity on the case (x, y)
     * @param x horizontal coordinates
     * @param y vertical coordinates
     * @param e the entity to put
     */
    public void putEntity(Entity e, int x, int y){
	this.map[x][y] = e;
    }

    public void moveRandomly(int x, int y) {
	// TODO: Improve algorithm to avoid infinite loop
	Boolean moveSucceded = false;
	while (! moveSucceded) {
	    Direction d = Direction.randomDirection();

	    switch(d) {
	    case NORTH: moveSucceded = moveToNorth(x, y); break;
	    case EAST:  moveSucceded = moveToEast(x, y);  break;
	    case SOUTH: moveSucceded = moveToSouth(x, y); break;
	    case WEST:  moveSucceded = moveToWest(x, y);  break;
	    }
	}
	System.out.println(" ");

    }

    public boolean moveToNorth(int x, int y) {
	if (y > 1 && isEmpty(x, y - 1)) {
	    this.moveTo(x, y, x, y - 1);
	    return true;
	}
	return false;
    }

    public boolean moveToEast(int x, int y) {
	if (x < this.getHorizontalDimensions() - 1 && isEmpty(x + 1, y)) {
	    this.moveTo(x, y, x + 1, y);
	    return true;
	}
	return false;
    }
    
    public boolean moveToSouth(int x, int y) {
	if (y < this.getVerticalDimensions() - 1 && isEmpty(x, y + 1)) {
	    this.moveTo(x, y, x, y + 1);
	    return true;
	}
	return false;
    }

    public boolean moveToWest(int x, int y) {
	if (x > 1 && this.isEmpty(x - 1, y)){
	    this.moveTo(x, y, x - 1, y);
	    return true;
	}
	return false;
    }
    
    /**
     * Move an entity from a case to another
     * @param x Original horizontal coordinates
     * @param y Original vertical coordinates
     * @param toX New horizontal coordinates
     * @param toY New vertical coordinates
     */
    public void moveTo(int x, int y, int toX, int toY){
	Entity e = map[x][y];
	map[x][y] = null;
	map[toX][toY] = e;
    }

    /**
     * Check wheter the case of coordinates (x, y) is empty or not
     * @param x Horizontal coordinates
     * @param y Vertical coordinates
     */
    public boolean isEmpty(int x, int y){
	return map[x][y] == null;		
    }

    /**
     * Removes the dead entities on the map
     */
    public void cleanDead(){
	for(int i = 0; i < map.length; i++){
	    for(Entity e : map[i]){
		if (e.isDead())
		    e.clear();
	    }
	}
		
    }
	
    /**
     * Returns the neighbourhood of the case of coordinates (x,y)
     * This is to say the entities which are on the 4x4 square
     * around the case (x, y)
     */
    public Set<Entity> getNeighbours(int x, int y) {
	return ns.getNeighbours(this, x, y);
    }
}
