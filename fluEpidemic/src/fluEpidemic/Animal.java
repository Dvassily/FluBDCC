package fluEpidemic;

import java.util.Random;


/**
 * Class which represent an animal in the simulation
 */
public class Animal extends Entity {
    private Species type;

    /**
     * Instanciate a sick animal
     * @param type the specy of the animal
     * @param disease the disease name
     * @param countDisease the duration of the disease
     */
    public Animal(Species type, Disease disease, int countDisease) {
	super(disease, countDisease);
	this.type = type;	
    }

    /**
     * Instanciate an random generated animal
     */
    public Animal() {
	this(Species.values()[(new Random()).nextInt(Species.values().length)],
	     null,
	     0);
    }

    public String toString(){
	String res = "";
	res = res+ type.getName();
	return res;
    }
}
