package fluEpidemic;

import java.util.Random;

public enum Disease {
	NONE("NONE", 0),
	H1N1("H1N1", 45),
	H2N2("H2N2", 37);
	
	private int ratio;
	private String name;
	
	Disease() {
		ratio = 0;
		name = null;
	}
	
	Disease(String name) {
		this.name= name;
	}
	
	Disease(String n, int k) {
		ratio = k;
		name =n;
	}
	
	public void getDiseaseWithOrdinal(int j) {
		for (Disease s : Disease.values()){
			if (s.ordinal() == j){
				this.name=  s.name;
				this.ratio = s.ratio;
			}
		}
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
	
	public static Disease drawDisease() {
	    return Disease.values()[(new Random().nextInt(Disease.values().length))];
	}
}
