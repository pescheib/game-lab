package lab3;
import java.util.ArrayList;
import java.util.Scanner;


public class game {
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static void main(String[] args) {
			runGame();
	}
	public static void runGame() {
		Room currentRoom = World.buildworld();
		Scanner input = new Scanner(System.in);
		String command; // player's command
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			command = input.nextLine();
			switch(command) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				currentRoom = currentRoom.getExit(command.charAt(0));
				break;
			case "take":
				if(currentRoom.getItem() != null) {
					inventory.add(currentRoom.getItem());
					System.out.println("You now have " +currentRoom.getItem().getname());
					currentRoom.takeItem();
					break;
				}
				else {
					System.out.print("no items found");
					break;
				}
			case "i":
				if(inventory.size()==0) {
					System.out.println("nothing in your inventory");
					break;
				}
				else {
					System.out.println("you are carrying: ");
					for(Item item : inventory) {
						System.out.println(item.getname());
					}
					break;
				}
		case "x":
		System.out.println("Thanks for walking through my game!");
		break;
		default:
		System.out.println("I don't know what that means.");
		}
		} while(!command.equals("x"));
		input.close();
	}
	
}

