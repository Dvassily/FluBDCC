package fluEpidemic;

import java.util.Random;

/**
 * Class which represent an animal in the simulation
 */
public class Animal extends Entity {
	private Species type;

	/**
	 * Instanciate a sick animal
	 * 
	 * @param type
	 *            the specy of the animal
	 * @param disease
	 *            the disease name
	 * @param countDisease
	 *            the duration of the disease
	 */
	public Animal(Species type, Disease disease) {
		this.infect(disease);
		this.type = type;
	}

	/**
	 * Instanciate an random generated healthy animal
	 */
	public Animal() {
		super();
		this.type = Species.values()[(new Random()).nextInt(Species.values().length)];
	}

	public String getName() {
		return type.getName();
	}

	public Boolean canMove() {
		return false;
	}
}
