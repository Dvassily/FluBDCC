package fluEpidemic;
import java.util.Random;

public class Simulation {
	private int nbHumans;
	private int nbAnimals;
	private Map map;
	
	Simulation(int x, int y, int maxDayRecup, int maxDayDead) {
		this.map = new Map(x, y);
		Random rand = new Random();
		new PopulationInitializer(this.map,
					  maxDayRecup,
					  maxDayDead,
					  rand.nextInt(x) + 1,
					  rand.nextInt(x) + 1).initializePopulation();
	}
	
	public String toString(){
		int dimX = map.getHorizontalDimensions();
		int dimY = map.getVerticalDimensions();
		
		String res = "dimX = "+ dimX + " dimY = " + dimY + " nbHumans ="+ nbHumans + "nbAnimals = "+nbAnimals + "\n";
		for (int i = 0; i < dimX; i++){
			for (int j = 0; j < dimY; j++){
				if (! map.isEmpty(i, j))
					res = res + map.reportEntity(i,j).toString() + " ";
				else res = res + "null ";
			}
			res = res+ "\n";
		}
		
		return res;
	}
	
	public int getNbHumans() {
		return nbHumans;
	}

	public int getNbAnimals() {
		return nbAnimals;
	}
}
