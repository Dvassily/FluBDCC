package fluEpidemic;

public class Humans extends Entity {
	private int recovery;
	
	
	
	Humans(boolean b, String name, int count, int recover){
		super(b, name, count);
		recovery = recover;
	}
	Humans(){
		super();
		recovery = 0;
	}
	public String toString(){
		String res = new String();
		res = "HUMANS";
		return res;
	}

}
