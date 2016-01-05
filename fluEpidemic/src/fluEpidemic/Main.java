package fluEpidemic;

import java.io.IOException;

public class Main {
	public static void main(String[] args){
	    Simulation a = new Simulation(128, 128, new FourConnectedNeighbourhood());
	    
	    try {
		a.run();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
}
