package fluEpidemic;

import java.util.Random;

/**
 * author : @CésarCollé and @BasilDali Class which represents an human in the
 * simulation
 */
public class Human extends Entity {
	private int recovery;
	private boolean incubation = false;
	private int countIncubation = 4;

	/**
	 * Instanciate an human with a disease
	 * 
	 * @param disease
	 *            The type of disease
	 * @param count
	 *            The duration of the disease
	 * @param count
	 *            The duration of recovery
	 */
	public Human(Disease disease, int countDisease, int recover) {
		super(disease, countDisease);
		this.recovery = recover;
	}

	/**
	 * Instanciate an human without diseases
	 */
	public Human() {
		this(null, 0, 0);
		recovery = 0;
	}

	public String getName() {
		return "HUMAN";
	}

	public void clear() {
		this.disease = null;
		this.countDisease = 0;
	}

	public Boolean canMove() {
		return true;
	}

	public boolean isHeSick() {
		return this.countIncubation == 0;
	}

	@Override
	public void update() {
		if (!incubation) {
			Random r = new Random();
			int luck = r.nextInt(5);
			if (luck == 5) {
				this.incubation = true;
			}
		} else {
			if (this.countIncubation == 0) {
				this.disease = null;
			} else {
				this.countIncubation--;
			}
		}

		if (!decrease()) {
			this.kill();
		}

	}
}
