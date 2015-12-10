package fluEpidemic;
import java.util.Random;

public class AllMap extends Map {
	private int nbHumans;
	private int nbAnimals;
	private int dimX;
	private int dimY;
	
	AllMap(int x, int y){
		super(x, y);
		dimX = x;
		dimY = y;
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
			tmp1 = rand.nextInt(dimX-1) +1;
			tmp2 = rand.nextInt(dimY);
			if (map[tmp1][tmp2] == null){
				map[tmp1][tmp2] = new Humans(false,"NONE", rand.nextInt(maxDayDead), rand.nextInt(maxDayRecup) );
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
		map[0][0] = new Animals(true, "H1N1", maxDayDead,"duck" );
		while (i < nbAnimals){
			
			if (map[rand.nextInt(dimX)][rand.nextInt(dimY)] != null){
				
			}
		}	
	}
	//TODO : créer processus
	public void cleanDead(){
		for(int i = 0; i < this.dimX; i++){
			for(Entity e : map[i]){
				if (e.getDead())
					e.clear();
			}
		}
		
	}
	public String toString(){
		String res = "";
		res = "dimX = "+ dimX + " dimY = " + dimY + " nbHumans ="+ nbHumans + "nbAnimals = "+nbAnimals + "\n";
		for (int i = 0; i < dimX; i++){
			for (int j = 0; j < dimY; j++){
				if (map[i][j] != null)
				res = res + map[i][j].toString() + " ";
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

	public int getDimX() {
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
	}

}
