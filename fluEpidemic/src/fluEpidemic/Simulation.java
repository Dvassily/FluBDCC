package fluEpidemic;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.IOException;

/**
 * author : @CésarCollé and @BasilDali The simulation class
 */
public class Simulation {
	private int nbHumans;
	private int nbAnimals;
	private Map map;
	private int maxDayRecover;
	private int maxDayDead;

	/**
	 * The simulation class
	 * 
	 * @param x
	 *            The horizontal dimension of the map
	 * @param y
	 *            The horizontal dimension of the mapa
	 * @param maxDayRecover
	 *            The maximum number of day before a human can recover
	 * @param maxDayDead
	 *            The maximum number of day before a entity dies
	 * @param ns
	 *            The way of compute the neighbourhood of a case
	 */
	Simulation(int x, int y, int maxDayRecover, int maxDayDead, NeighbourhoodStrategy ns) {
		this.map = new Map(x, y, ns);
		Random rand = new Random();
		new PopulationInitializer(this.map, maxDayRecover, maxDayDead, rand.nextInt(x) + 1, rand.nextInt(x) + 1)
				.initializePopulation();
	}

	public void run() throws IOException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter 'quit' for stop the simulation");
		for (String s = scanner.next(); (!s.equals("quit")); s = scanner.next()) {
			this.step();
			System.out.println(this);
		}
	}

	public void step() {
		for (int x = 0; x < map.getHorizontalDimensions(); ++x) {
			for (int y = 0; y < map.getVerticalDimensions(); ++y) {
				if (!map.isEmpty(x, y) && map.reportEntity(x, y).canMove()) {
					map.moveRandomly(x, y);
				}
			}
		}

		for (int x = 0; x < map.getHorizontalDimensions(); ++x) {
			for (int y = 0; y < map.getVerticalDimensions(); ++y) {
				if (!map.isEmpty(x, y) && map.reportEntity(x, y).isSick()) {
					Set<Entity> neighbours = map.getNeighbours(x, y);
					for (Entity neighbour : neighbours)
						neighbour.infect(map.reportEntity(x, y).getDisease(), maxDayDead);
				}
			}
		}
	}

	public String toString() {
		int dimX = map.getHorizontalDimensions();
		int dimY = map.getVerticalDimensions();

		String res = "dimX     = " + dimX + " dimY      = " + dimY + "\n" + "nbHumans = " + nbHumans + " nbAnimals = "
				+ nbAnimals + "\n\n";

		for (int i = 0; i < dimX; i++) {
			for (int j = 0; j < dimY; j++) {
				if (!map.isEmpty(i, j))
					res = res + map.reportEntity(i, j).toString() + " ";
				else
					res = res + "null ";
			}
			res = res + "\n";
		}

		return res;
	}

	public int getNbHumans() {
		return nbHumans;
	}

	public int getNbAnimals() {
		return nbAnimals;
	}
}
