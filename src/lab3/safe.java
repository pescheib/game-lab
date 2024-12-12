package lab3;

public class safe extends Item{
	public safe(String name, String description) {
		super("safe","hidden in corner");
		
	}
	public void open() {
		if(game.getIteminventory("combination") == null) {
			game.print("the safe is locked and you dont have the combination");
		}
		else {
			game.print("you used the combination and found the diamond");
			game.print("congratulations you beat the game! Feel free to roam around and talk to the puppy if you can find it!");
			Item diamond = new Item("diamond","big and expensive");
			game.inventory.add(diamond);
		}
		
	}
}

