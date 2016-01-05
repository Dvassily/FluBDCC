package fluEpidemic;

import fluEpidemic.graph.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.IOException;
import java.awt.Color;

/**
 * author : @CésarCollé and @BasilDali The simulation class
 */
public class Simulation {
    public static final int MIN_SPEED_VALUE = 100;
    public static final int MAX_SPEED_VALUE = 1000;
    
    private int nbHumans;
    private int nbAnimals;
    private Field field;
    private SimulatorView view;
    private Controls controlsFrame;
    private int delay = MIN_SPEED_VALUE;
    private long timer;
    
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED   = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    /**
     * The simulation class
     * @param x The horizontal dimension of the field
     * @param y The horizontal dimension of the fielda
     * @param ns The way of compute the neighbourhood of a case
     */
    Simulation(int x, int y, NeighbourhoodStrategy ns) {
	this.field = new Field(x, y, ns);
	Random rand = new Random();
	new PopulationInitializer(this.field,
				  rand.nextInt(x) + 1,
				  rand.nextInt(x) + 1).initializePopulation();

	SimulatorView view = new GridView(x, y);
	view.setColor(Entity.class, Color.RED);
	this.view = view;
	this.controlsFrame = new Controls(this);
    }

    public void run() throws IOException {
	this.timer = System.currentTimeMillis();
	
	while(! isEnded()) {
	    if (System.currentTimeMillis() >= this.timer + this.delay) {
		this.step();
		this.timer = System.currentTimeMillis();
		System.out.println("Foo");
	    }
	}
    }

    public void step() {
	for (int x = 0; x < field.getHorizontalDimensions(); ++x) {
	    for (int y = 0; y < field.getVerticalDimensions(); ++y) {
		if (! field.isEmpty(x, y) && field.reportEntity(x, y).canMove()) {
		    field.moveRandomly(x, y);
		}
	    }
	}
	
	for (int x = 0; x < field.getHorizontalDimensions(); ++x) {
	    for (int y = 0; y < field.getVerticalDimensions(); ++y) {
		if (! field.isEmpty(x, y)) {
		    Entity e = field.reportEntity(x, y);
		    if (e.isSick()) {
			if (e.isContagious()) {
			    Set<Entity> neighbours = field.getNeighbours(x, y);
			    for (Entity neighbour : neighbours) {
				if (! neighbour.isSick()) {
				    neighbour.infect(e.getDisease());
				}
			    }
			}
			field.reportEntity(x, y).update();
		    }
		}
	    }
	}
	view.showStatus(0, this.field);
    }
	
    public String toString() {
	int dimX = field.getHorizontalDimensions();
	int dimY = field.getVerticalDimensions();

	String res = "dimX     = " + dimX + " dimY      = " + dimY + "\n" + "nbHumans = " + nbHumans + " nbAnimals = "
	    + nbAnimals + "\n\n";

	for (int i = 0; i < dimX; i++) {
	    for (int j = 0; j < dimY; j++) {
		if (!field.isEmpty(i, j))
		    res = res + field.reportEntity(i, j).toString() + " ";
		else
		    res = res + "null ";
	    }
	    res = res + "\n";
	}

	return res;
    }

    public boolean isEnded() {
	boolean hasHumansRemaining = false;
	
	for (int x = 0; x < field.getHorizontalDimensions(); ++x) {
	    for (int y = 0; y < field.getVerticalDimensions(); ++y) {
		if (! field.isEmpty(x, y)) {
			Entity e = field.reportEntity(x, y);
			if (e.isSick()) return false;
			if (e.getName().equals("HUMAN")) hasHumansRemaining = true;
		}
	    }
	}
	
	return ! hasHumansRemaining;
    }

    public int getNbHumans() {
	return nbHumans;
    }

    public int getNbAnimals() {
	return nbAnimals;
    }

    public void setDelay(int delay) {
	this.delay = delay;
    }

    public void setNeighbourHoodStrategy(NeighbourhoodStrategy ns) {
	this.field.setNeighbourhoodStrategy(ns);
    }
}
