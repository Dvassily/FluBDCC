package fluEpidemic;

/**
 * Class which represents an human in the simulation
 */
public class Human extends Entity {
    private int recovery;

    /**
     * Instanciate an human with a disease
     * @param disease The type of disease
     * @param count The duration of the disease
     * @param count The duration of recovery
     */
    public Human(Disease disease, int countDisease, int recover){
	super(disease, countDisease);
	this.recovery = recover;
    }

    /**
     * Instanciate an human without diseases
     */
    public Human(){
	this(null, 0, 0);
	recovery = 0;
    }

    public String toString(){
	String res = new String();
	res = "HUMANS";
	return res;
    }
}
