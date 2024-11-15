package lab3;

public class Container extends Item{
	public Container(String n, String d) {
		super(n,d);
	}
	
	public void open() {
		System.out.println("You open the box and find a clown nose. It's stupid, but you keep it anyway.");
		game.inventory.add(new Item("Clown Nose", "A red clown nose."));
	}
}
