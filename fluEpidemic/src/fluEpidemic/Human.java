package fluEpidemic;

import java.util.Random;

/**
 * author : @CésarCollé and @BasilDali Class which represents an human in the
 * simulation
 */
public class Human extends Entity {
	/**
	 * Instanciate a sick human
	 * 
	 * @param disease
	 *            The type of disease
	 */
	public Human(Disease disease) {
		super(disease);
	}

	/**
	 * Instanciate an healty human 
	 */
	public Human() {
		super();
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
