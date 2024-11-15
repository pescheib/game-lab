package lab3;

public class safe extends Item{
	public safe(String name, String description) {
		super(name, description);
		
	}
	public void open() {
		if(getIteminventory("combination") == null) {
			game.print("the safe is locked and you dont have the combination");
		}
		else {
			game.print("use combinaion on safe to find diamond");
			Item diamond = new Item("diamond","big and expensive");
			game.inventory.add(diamond);
		}
		
	}
}

