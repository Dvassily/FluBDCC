package fluEpidemic;

import java.io.IOException;

public class Main {
	public static void main(String[] args){
	    //Simulation a = new Simulation(128, 128, new Neighbourhood4x4());
	    Simulation a = new Simulation(128, 128, new HeightConnectedNeighbourhood());
	    
	    try {
		a.run();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
}
