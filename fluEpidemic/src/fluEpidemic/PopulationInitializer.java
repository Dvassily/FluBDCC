package fluEpidemic;

import java.util.Random;

/**
 *author : @CésarCollé and @BasilDali
 * Class for initialize the simulation population
 */
public class PopulationInitializer {
    private Map map;
    private int nbHumans;
    private int nbAnimal;
    private int maxDayRecover;
    private int maxDayDead;

    /**
     * Constructs a population intialize
     * @param map The map to populate
     * @param maxDayRecover The maximum number of day before a human can recover
     * @param maxDayDead The maximum number of day before a entity dies
     * @param nbAnimal the number of animals in the simulation
     * @param nbHumans the number of humans in the simulation
     */
    public PopulationInitializer(Map map,
				 int maxDayRecover,
				 int maxDayDead,
				 int nbAnimal,
				 int nbHumans) {
	Random rand = new Random();
	this.maxDayRecover = maxDayRecover;
	this.maxDayDead = maxDayDead;
	this.map = map;
	this.nbHumans = rand.nextInt(map.getHorizontalDimensions())+1;
	this.nbAnimal = rand.nextInt(map.getHorizontalDimensions())+1;
    }

    /**
     * Initializes the population
     */
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
