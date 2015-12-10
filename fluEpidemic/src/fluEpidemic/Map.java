package fluEpidemic;

public class Map {
	protected Entity map[][];
	
	Map(int x, int y){
		map = new Entity[x][y];
	}
	
	public Entity reportEntity(int x, int y){
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
		map[x][y].clear();
	}
	
	public boolean isEmpty(int x, int y){
		return map[x][y] == null;		
	}
	
	
}
