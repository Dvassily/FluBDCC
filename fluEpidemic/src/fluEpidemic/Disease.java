package fluEpidemic;

import java.util.Random;

/**
 * author : @CésarCollé and @BasilDali Enum for representing diseases. Each
 * disease is associated with a mortality rate, an incubation period and a name
 */
public enum Disease {
	H1N1("H1N1", 4, 100, 90),
	H2N2("H2N2", 37, 100, 10);

	private String name;
	private int ratio;
	private int duration;
	private int incubationPeriod;
	
	/**
	 * Construct a disease
	 * @param ratio the mortality rate
	 * @param incubationPeriod the duration of incubation period
	 * @param name
	 */
	Disease(String name, int ratio, int duration, int incubationPeriod) {
	    this.name = name;
	    this.ratio = ratio;
	    this.duration = duration;
	    this.incubationPeriod = incubationPeriod;
	}

	public int getSize() {
		return Disease.values().length;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRatio() {
		return ratio;
	}

	public int getIncubationPeriod() {
		return this.incubationPeriod;
	}

	public int getDuration() {
		return this.duration;
	}

	public static Disease drawDisease() {
		return Disease.values()[(new Random().nextInt(Disease.values().length))];
	}
}
