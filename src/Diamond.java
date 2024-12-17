
import lab3.Item;
import lab3.game;

public class Diamond extends Item{
	public Diamond(String name, String description) {
		super("Diamond", "Bright and shiny, can be used to open an exit");
	}
	public void use() {
		if(game.getcurrentroom().getExit('s').getname() == "Outside"){
			game.print("You used the diamond to unlock the front door");
			game.getcurrentroom().getExit('s').setlock(false);
		}
	}
}
