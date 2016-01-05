package fluEpidemic;

/**
 * Class for representing entities in the field
 */
public abstract class Entity {
	protected Disease disease;
	protected int countDisease;
	protected boolean dead;

	public Entity() {
		this.disease = null;
		this.countDisease = 0;
		this.dead = false;
	}

	public Entity(Disease d) {
		this.infect(d);
	}

	/**
	 * @return 
	 *        A string that contains the type of entity
	 */
	public abstract String getName();

	/**
	 * @return 
	 *        Returns true if the entity can move, false otherwise
	 */
	public abstract Boolean canMove();

	/**
	 * @return 
	 *        Returns true if the entity is sick, false otherwise
	 */	
	public boolean isSick() {
	    return this.disease != null && ! this.isDead();
	}

	/**
	 * @return 
	 *        Returns true if the entity is contagious, false otherwise
	 */	
	public boolean isContagious() {
		return this.countDisease >= (this.disease.getDuration() - this.disease.getIncubationPeriod());
	}

	/**
	 * @return 
	 *        Returns true if the entity is dead, false otherwise
	 */	
	public boolean isDead() {
		return this.dead;
	}

	/**
	 * @return
	 *        Returns the number of days remaining before death
	 */
	public int getCountDisease() {
		return this.countDisease;
	}

	/**
	 * @return
	 *        Returns the type of disease that infected the entity
	 */
	public Disease getDisease() {
		return this.disease;
	}

	/**
	 * Infect the entity with a given type of disease
	 * @param d
	 *        The type of Disease
	 */
	public void infect(Disease d) {
		this.disease = d;
		this.countDisease = d.getDuration();
	}

	/**
	 * Update the state of the entity
	 * If the numbers of days remaining is 0, the entity die
	 */
	public void update() {
		if (!decrease()) {
			this.kill();
		}
	}

	/**
	 * Decrease the numbers of days remaining
	 * @return
	 *        Returns true if the animal is still alive, false otherwise
	 */
	protected boolean decrease() {
		if (this.countDisease > 1) {
			this.countDisease--;
			return true;
		}
		return false;
	}

	/**
	 * Kill the entity
	 */
	protected void kill() {
		if (!this.dead) {
			this.dead = true;
		}
	}

	public String toString() {
		String res = "";
		if (this.isDead())
			res = ColorAnsi.RED.getCodeColor();
		else if (this.isSick())
			res = ColorAnsi.GREEN.getCodeColor();
		res += this.getName();
		res += ColorAnsi.RESET.getCodeColor();
		return res;
	}
}
