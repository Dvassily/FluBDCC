package fluEpidemic;

import java.util.Random;

/**
 * author : @CésarCollé and @BasilDali Class for initialize the simulation
 * population
 */
public class PopulationInitializer {
    private Field field;
    private int nbHumans;
    private int nbAnimal;

    /**
     * Constructs a population intialize
     * @param field The field to populate
     * @param maxDayRecover The maximum number of day before a human can recover
     * @param maxDayDead The maximum number of day before a entity dies
     * @param nbAnimal the number of animals in the simulation
     * @param nbHumans the number of humans in the simulation
     */
    public PopulationInitializer(Field field,
				 int nbAnimal,
				 int nbHumans) {
	Random rand = new Random();
	this.field = field;
	this.nbHumans = rand.nextInt(field.getHorizontalDimensions()) + 1;
	this.nbAnimal = rand.nextInt(field.getHorizontalDimensions()) + 1;
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
	    int cX = rand.nextInt(field.getHorizontalDimensions() - 1) + 1;
	    int cY = rand.nextInt(field.getVerticalDimensions());
	    if (field.isEmpty(cX, cY)){
		field.putEntity(new Human(),
				cX, cY);
		i++;
	    }
	}
    }

    private void fillMapAnimal() {
	Random rand = new Random();
	field.putEntity(new Animal(Species.CHICKEN, Disease.H1N1), 0, 0);

	for (int i = 0; i < nbAnimal;) {
	    int cX = rand.nextInt(field.getHorizontalDimensions());
	    int cY = rand.nextInt(field.getVerticalDimensions());
	    if (field.isEmpty(cX, cY)) {
		Boolean isHeSick = rand.nextBoolean();
		Animal a = new Animal();
		if (rand.nextBoolean())
		    a.infect(Disease.drawDisease());
		field.putEntity(a, cX, cY);
		i++;
	    }
	}
    }
}
