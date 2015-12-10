package fluEpidemic;

public class Animals extends Entity {
	AnimalName type;
	
	Animals(boolean s,String name, int count , String type){
		super(s, name, count);
		this.type = AnimalName.valueOf(type);
		
	}
	
	
}
