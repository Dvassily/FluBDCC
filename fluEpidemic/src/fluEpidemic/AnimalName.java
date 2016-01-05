package fluEpidemic;

public enum AnimalName {
	DUCK("duck"), CHICKEN("chicken"), PIG("pig");

	private String name;

	AnimalName(String n) {
		name = n;
	}

	AnimalName getAnimalNameWithOrdinal(int j) {
		for (AnimalName s : AnimalName.values()) {
			if (s.ordinal() == j) {
				return s;
			}
		}
		return null;
	}

	public int getSize() {
		return AnimalName.values().length;
	}
}
