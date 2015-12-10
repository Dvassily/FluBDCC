package fluEpidemic;

public abstract class Entity {
	protected boolean sick;
	protected Disease nameDisease;
	protected int countDisease;
	protected boolean dead;
	//todo : finir de remplir
	
	Entity(boolean b, String str, int count){
		sick = b;
		nameDisease = Disease.valueOf(str);
		countDisease = count;
	}
	
	Entity(){
		sick = false;
		nameDisease = null;
		countDisease = 0;
		dead = false;		
	}
	
	Entity(Entity E){
		this.sick = E.sick;
		this.nameDisease =E.nameDisease;
		this.countDisease = E.countDisease;
	}
	public void clear(){
		this.sick = false;
		this.nameDisease= null;
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
	public boolean getSick(){
		return this.sick;
	}
	public boolean getDead(){
		return this.dead;
	}
	public void setCountDisease(int mCount){
		this.countDisease = mCount;
	}

	public String toString(){
		String res = "";
		if (this.nameDisease == null)res = res+ "null ";
		else res = this.nameDisease.getName();
		
		res = res + this.countDisease + this.sick;
		return res;
	}
	
	
}
