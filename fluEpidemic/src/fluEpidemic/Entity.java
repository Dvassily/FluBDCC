package fluEpidemic;

public abstract class Entity {
    protected Disease disease;
    protected int countDisease;
    protected boolean dead;
    
    public Entity (Species species) {
	this.disease = null;
	this.countDisease = 0;
	this.dead = false;
    }

    public Entity(Disease disease, int countDisease) {
	this.disease = disease;
	this.countDisease = countDisease;
    }

    public void clear(){
	this.disease = null;
	this.countDisease = 0;
    }
	
    public boolean decrease(){
	if (this.countDisease > 1){
	    this.countDisease--;
	    return true;
	}
	return false;
    }
    
    public void kill(){
	if (! this.dead){
	    this.dead = true;
	}
    }
	
    public int getCountDisease() {
	return this.countDisease;
    }

    public void setCountDisease(int mCount){
	this.countDisease = mCount;
    }

    public Disease getDisease() {
	return this.disease;
    }

    public void infect(Disease d, int countDisease) {
	this.disease = d;
    }
    
    public boolean isSick(){
	return this.disease != null;
    }
    
    public boolean isDead(){
	return this.dead;
    }

    public String toString() {
	String res = "";
	
	if      (this.isDead()) res = Simulation.ANSI_RED;
	else if (this.isSick()) res = Simulation.ANSI_GREEN;
	res +=  this.getName();
	res += Simulation.ANSI_RESET;

	return res;
    }

    public abstract String getName();
    public abstract Boolean canMove();
}
