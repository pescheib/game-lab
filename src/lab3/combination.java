package lab3;

public class combination extends Item {
	public combination(String name, String description) {
		super("combination", "combo for safe");
		
	}
	public void use() {
		game.print("try to open the safe, if you can find it");
	}
}
