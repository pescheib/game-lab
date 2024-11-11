package lab3;
import java.util.ArrayList;
import java.util.Scanner;


public class game {
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static void print(Object obj) {
		System.out.println(obj.toString());
		
		}
	static Room currentRoom = World.buildworld();
	
	public static Room getcurrentroom() {
		return currentRoom;
	}
	
	public static Item getIteminventory(String name) {
		for(Item i: inventory) {
			if(i.getname().equals(name))
				return i;
		}
		return null;
	}
	
	public static void main(String[] args) {
			runGame();
	}
	
	public static void runGame() {
		
		Scanner input = new Scanner(System.in);
		String command; // player's command
		do {
			System.out.println(currentRoom);
			System.out.print("Where do you want to go? ");
			command = input.nextLine();
			String[] words = command.split(" ");
			switch(words[0]) {
			case "e":
			case "w":
			case "n":
			case "s":
			case "u":
			case "d":
				Room nextRoom = currentRoom.getExit(command.charAt(0));
				if(nextRoom == null)
					System.out.println("You cant go that way.");
				else
					currentRoom = nextRoom;
				break;
			case "take":
				System.out.println("You are trying to take the " + words[1] + ".");
				Item i = currentRoom.getItem(words[1]);
				if(i == null) {
					System.out.println("Items not here.");
				}
				else {
					currentRoom.addItem(null, null);
					inventory.add(i);
					System.out.println("You have " + i.getname());
				}
				break;
			case "look":
				if(currentRoom.getItem(words[1])!=null) {
					System.out.println(currentRoom.getItem(words[1]).getobject());
					break;
				}
				else if(currentRoom.getItem(words[1]) == null){
					for(Item j : inventory) {
						if(j.getname().equals(words[1])){
							System.out.println(j.getobject());
							break;
						}
					}
					System.out.println("Item not in room or players inventory.");
				}
				break;
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
			case "use":
				System.out.println("you are trying to use the" + words[1]+".");
				
				if(currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).use();
				}
				else {
					if(currentRoom.getItem(words[1]) == null) {
						System.out.print("There is no such item");
					}
					else{
						getIteminventory(words[1]).use();
						System.out.println();
							
						}
				}
				
				break;
			case "open":
				System.out.println("you are trying to open the " + words[1]+".");
				
				if(currentRoom.getItem(words[1]) != null) {
					currentRoom.getItem(words[1]).open();
				}
				else{
					if(currentRoom.getItem(words[1]) == null) {
						System.out.print("There is no such item");
					}
					else{
						getIteminventory(words[1]).open();
						System.out.println();
							
						}
				}
				break;
				
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

