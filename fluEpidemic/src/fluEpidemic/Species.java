package fluEpidemic;

public enum Species {
	DUCK("duck"), CHICKEN("chicken"), PIG("pig");

	private String name;

	Species(String str) {
		name = str;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return Species.values().length;
	}
}
