package fluEpidemic;
import java.util.Random;

public class Simulation {
	private int nbHumans;
	private int nbAnimals;
	private Map map;
	
	Simulation(int x, int y){
		this.map = new Map(x, y);
		Random rand = new Random();
		nbHumans = rand.nextInt(x)+1;
		nbAnimals = rand.nextInt(x)+1;
	}

	public void fillMapHumans(int maxDayRecup, int maxDayDead){
		Disease d;
		Random rand = new Random();
		int tmp1;
		int tmp2;
		boolean tmp3;
		
		int i=0;
		while (i < nbHumans){
			tmp1 = rand.nextInt(map.getHorizontalDimensions() - 1) + 1;
			tmp2 = rand.nextInt(map.getVerticalDimensions());

			if (map.isEmpty(tmp1, tmp2)) {
				Entity e = new Humans(false,"NONE", rand.nextInt(maxDayDead), rand.nextInt(maxDayRecup));
				map.putEntity(e, tmp1, tmp2);
				i++;
			}
		}
	}
	
	public void fillMapAnimals(int maxDayDead){
		int lengthAnimalName = AnimalName.values().length;
		int lengthDisease = Disease.values().length;
		int i = 0;
		int rX, rY;
		Random rand = new Random();
		
		map.putEntity(new Animals(true, "H1N1", maxDayDead, "duck"), 0, 0);

		while (i < nbAnimals){
			if (map.isEmpty(rand.nextInt(map.getHorizontalDimensions()),
					rand.nextInt(map.getVerticalDimensions()))) {
				
			}
		}	
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

	public void setNbHumans(int nbHumans) {
		this.nbHumans = nbHumans;
	}

	public int getNbAnimals() {
		return nbAnimals;
	}

	public void setNbAnimals(int nbAnimals) {
		this.nbAnimals = nbAnimals;
	}

	/*public int getDimX() {
		return dimX;
	}

	public void setDimX(int dimX) {
		this.dimX = dimX;
	}

	public int getDimY() {
		return dimY;
	}

	public void setDimY(int dimY) {
		this.dimY = dimY;
		}*/
	
}
