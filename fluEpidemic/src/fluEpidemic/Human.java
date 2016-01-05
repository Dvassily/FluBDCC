package fluEpidemic;

import java.util.Random;

/**
 * author : @CésarCollé and @BasilDali Class which represents an human in the
 * simulation
 */
public class Human extends Entity {
	private int recovery;

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
	    return (! this.isDead());
	}

	@Override
	public void update() {
		if (!decrease()) {
			if ((new Random().nextInt(101)) < this.disease.getRatio()) {
				this.kill();
			} else {
				this.recover();
			}
		}
	}

	private void recover() {
		this.disease = null;
		this.countDisease = 0;
	}
}
