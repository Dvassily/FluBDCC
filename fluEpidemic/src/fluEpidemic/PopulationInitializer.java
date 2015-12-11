package fluEpidemic;

import java.util.Random;

public class PopulationInitializer {
    private Map map;
    private int nbHumans;
    private int nbAnimal;
    private int maxDayRecup;
    private int maxDayDead;
	
    public PopulationInitializer(Map map,
				 int maxDayRecup,
				 int maxDayDead,
				 int nbAnimal,
				 int nbHumans) {
	Random rand = new Random();
	this.maxDayRecup = maxDayRecup;
	this.maxDayDead = maxDayDead;
	this.map = map;
	this.nbHumans = rand.nextInt(map.getHorizontalDimensions())+1;
	this.nbAnimal = rand.nextInt(map.getHorizontalDimensions())+1;
    }

    public void initializePopulation() {
	this.fillMapHumans();
	this.fillMapAnimal();
    }

    private void fillMapHumans() {
	Random rand = new Random();
		
	for (int i = 0; i < nbHumans;) {
	    int cX = rand.nextInt(map.getHorizontalDimensions() - 1) + 1;
	    int cY = rand.nextInt(map.getVerticalDimensions());
	    if (map.isEmpty(cX, cY)){
		map.putEntity(new Human(),
			      cX, cY);
		i++;
	    }
	}
    }

    private void fillMapAnimal() {
	Random rand = new Random();
	map.putEntity(new Animal(Species.CHICKEN, Disease.H1N1, maxDayDead), 0, 0);

	for (int i = 0; i < nbAnimal;) {
	    int cX = rand.nextInt(map.getHorizontalDimensions());
	    int cY = rand.nextInt(map.getVerticalDimensions());
	    if (map.isEmpty(cX, cY)) {
		Boolean isHeSick = rand.nextBoolean();
		Animal a = new Animal();
		if (rand.nextBoolean()) a.infect(Disease.drawDisease(), maxDayDead);
		map.putEntity(a, cX, cY);
		i++;
	    }
			
	}
    }
}
