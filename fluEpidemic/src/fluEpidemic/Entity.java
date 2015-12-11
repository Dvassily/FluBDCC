package fluEpidemic;

public abstract class Entity {
    protected Disease disease;
    protected int countDisease;
    
    protected boolean dead;
    
    public Entity () {
	this.disease = null;
	this.countDisease = 0;
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
	if (!this.dead){
	    this.dead = true;
	}
    }
	
    public int getCountDisease(){
	return this.countDisease;
    }
    
    public boolean isSick(){
	return disease != null;
    }
    
    public boolean getDead(){
	return this.dead;
    }

    public void setCountDisease(int mCount){
	this.countDisease = mCount;
    }

    public String toString(){
	String res = "";
	
	if (this.disease == null) res += "null";
	else res = this.disease.getName();
		
	res += " " + this.countDisease + this.isSick();
	return res;
    }
	
    public void infect(Disease d, int countDisease) {
	this.disease = d;
    }
}
