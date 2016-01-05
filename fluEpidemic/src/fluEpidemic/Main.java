package fluEpidemic;

import java.io.IOException;

public class Main {
	public static void main(String[] args){
	    Simulation a = new Simulation(128, 128, 20, 20, new Neighbourhood4x4());
	    
	    try {
		a.run();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
}
