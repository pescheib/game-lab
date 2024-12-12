package lab3;

public class combination extends Item {
	public combination(String name1, String description1) {
		super("combination", "numbers on spinning dial");
		
	}
	public void use() {
		game.print("try to open the safe, if you can find it");
	}
}
