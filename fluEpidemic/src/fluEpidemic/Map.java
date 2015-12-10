package fluEpidemic;

import java.util.List;

public class Map {
	private Entity map[][];

	/**
	 * Initialize a map of dimensions (x, y)
	 * @param x horizontal dimensions
	 * @param y vertical dimensions
	 */
	public Map(int x, int y){
		map = new Entity[x][y];
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
	public Entity putEntity(Entity e, int x, int y){
		return map[x][y];
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
				if (e.getDead())
					e.clear();
			}
		}
		
	}
	
	/**
	 * Returns the neighbourhood of the case of coordinates (x,y)
	 * This is to say the entities which are on the 4x4 square
	 * around the case (x, y)
	 */
	public List<Entity> neighbourhood(int x, int y) {
		int width = map.length;
		int height = map[0].length;

		//		if ()
		return null;
	}
}
