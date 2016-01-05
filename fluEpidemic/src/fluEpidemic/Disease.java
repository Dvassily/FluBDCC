package fluEpidemic;

import java.util.Random;

/**
 * Represent a disease in the simulation.
 * Each disease is associated with a mortality rate, an incubation period, a recovering period and a name
 * @author CésarCollé
 * @author BasilDali
 */
public enum Disease {
    H1N1("H1N1", 4, 100, 90, 10),
    H2N2("H2N2", 37, 100, 10, 10);

    private String name;
    private int ratio;
    private int duration;
    private int incubationPeriod;
    private int recoveringPeriod;
	
    /**
     * Construct a disease
     * @param ratio the mortality rate
     * @param incubationPeriod the duration of incubation period
     * @param name
     */
    Disease(String name, int ratio, int duration, int incubationPeriod, int recoveringPeriod) {
	this.name = name;
	this.ratio = ratio;
	this.duration = duration;
	this.incubationPeriod = incubationPeriod;
	this.recoveringPeriod = recoveringPeriod;
    }

    /**
     * @return
     *        The name of the disease
     */
    public String getName() {
	return name;
    }

    /**
     * @return
     *        The mortality rate
     */
    public int getRatio() {
	return ratio;
    }

    /**
     * @return
     *        The duration of incubation period
     */
    public int getIncubationPeriod() {
	return this.incubationPeriod;
    }

    /**
     * @return
     *        The duration of the disease
     */
    public int getDuration() {
	return this.duration;
    }

    /**
     * @return
     *        The duration of recovering period
     */
    public int getRecoveringPeriod() {
	return this.recoveringPeriod;
    }

    /**
     * @return
     *        A random-generated disease
     */
    public static Disease drawDisease() {
	return Disease.values()[(new Random().nextInt(Disease.values().length))];
    }
}
