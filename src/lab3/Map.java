package lab3;

public class Map extends Item {
	public Map(String n, String d) {
		super(n,d);
	}
	
	@Override
	public void use() {
		System.out.println("This is a map of rooms from the cafe.\n North: Rehab\nEast: Washroom\nSouth: Front Door\nWest: Surgery Room.");
	}
}
