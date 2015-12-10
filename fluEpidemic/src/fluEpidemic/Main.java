package fluEpidemic;

public class Main {

	public static void main(String[] args){
		AllMap a = new AllMap(4, 5);
		a.fillMapHumans(20, 20);
		System.out.println(a.toString());
		
	}
}
