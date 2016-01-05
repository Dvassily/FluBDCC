package fluEpidemic;

import java.util.Random;

/**
 * author : @CésarCollé and @BasilDali Class which represents an human in the
 * simulation
 */
public class Human extends Entity {
    int countRecover;

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

    public Boolean canMove() {
	return (! this.isDead());
    }

    /**
     * Update the state of an human
     * If the numbers of days remaining is 0, the entity die
     * If the human is recovering and the duration of recovery is reached, he recover
     */
    @Override
    public void update() {
	if (isRecovering())  {
	    if (--this.countRecover == 0) {
		this.disease = null;
	    } 
	} else {
	    if (!decrease()) {
		if ((new Random().nextInt(101)) < this.disease.getRatio()) {
		    this.kill();
		} else {
		    this.recover();
		}
	    }
	}
    }

    private void recover() {
	this.countRecover = this.disease.getRecoveringPeriod();
    }

    public boolean isRecovering() {
	return this.countRecover > 0;
    }
}
