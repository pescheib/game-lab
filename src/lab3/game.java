package lab3;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class game {
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
	static ArrayList <Item> Inventory = new ArrayList<Item>();
    
    static HashMap <String, String> roomDescriptions = new HashMap<String, String>();

    static HashMap<String, Room> RoomObjects = new HashMap<String, Room>();
	
    public static Scanner input = new Scanner(System.in);
   
    public static void print(Object obj) {
		gui.textArea.append((obj.toString() + "\n"));
		
		
		}
   
    
    
	static Room currentRoom = World.buildworld();

	public static void processCommand(String command) {
			
			String[] words = command.split(" ");
		switch(words[0]) {
		case "e":
		case "w":
		case "n":
		case "s":
		case "u":
		case "d":
			Room nextRoom = currentRoom.getExit(command.charAt(0));
			if(nextRoom == null) {
				game.print("You cant go that way.");
			}
			else if (nextRoom.getlock() == true) {
				game.print("The room is locked.");
					
			}
			else {
				currentRoom = nextRoom;
				game.print(currentRoom);
			}
			
			break;
		case "take":
			game.print("You are trying to take the " + words[1] + ".");
			Item i = currentRoom.getItem(words[1]);
			if(i == null) {
				game.print("Items not here.");
			}
			else {
				currentRoom.addItem(null, null);
				inventory.add(i);
				game.print("You have " + i.getname());
			}
			break;
		case "look":
			if(currentRoom.getItem(words[1])!=null) {
				game.print(currentRoom.getItem(words[1]).getobject());
				break;
			}
			else if(currentRoom.getItem(words[1]) == null){
				for(Item j : inventory) {
					if(j.getname().equals(words[1])){
						game.print(j.getobject());
						break;
					}
				}
				game.print("Item not in room or players inventory.");
			}
			break;
		case "i":
			if(inventory.size()==0) {
				game.print("nothing in your inventory");
				break;
			}
			else {
				game.print("you are carrying: ");
				for(Item item : inventory) {
					game.print(item.getname());
				}
				break;
			}
		case "use":
			game.print("you are trying to use the" + words[1]+".");
			
			if(currentRoom.getItem(words[1]) != null) {
				currentRoom.getItem(words[1]).use();
			}
			else {
				if(getIteminventory(words[1]) == null) {
					game.print("There is no such item");
				}
				else{
					getIteminventory(words[1]).use();
					game.print("used");
						
					}
			}
			
			break;
		case "open":
			game.print("you are trying to open the " + words[1]+".");
			
			if(currentRoom.getItem(words[1]) != null) {
				currentRoom.getItem(words[1]).open();
			}
			else{
				if(currentRoom.getItem(words[1]) == null) {
					game.print("There is no such item");
				}
				else{
					getIteminventory(words[1]).open();
					game.print("opened");
						
					}
			}
			break;
			
		case "talk":
			game.print("You are trying to talk to the" + words[1] + ".");
			
			if(currentRoom.getNPC(words[1]) != null) {
				currentRoom.getNPC(words[1]).talk();
				game.print("/n");
				
			}
			else {
				game.print("There is no such thing!");
			}
			break;
		
		case "save":
			saveList("SaveFile");
			game.print("game saved");
			break;	
			

    	case "load":
    		loadList("SaveFile");
    		game.print("Game loaded");
		break;	
			
		case "x":
			game.print("Thanks for walking through my game!");
				break;
		default:
			game.print("I don't know what that means.");
		}
		
		
	}




	
	
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
	
	public static void textFile() {
		try {
			Scanner input = new Scanner(new File("RoomDescriptions.txt"));
			while(input.hasNextLine()) {
				String name = input.nextLine();
				String description = input.nextLine();
				
				if(!name.equals("#") && !description.equals("#"));
				Room.put(name, description);
			}
		input.close();
	} catch (FileNotFoundException e) {
		System.out.println("file not found! ");
	}
}

	public static void saveGame(String save) {
		File f = new File(save);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(RoomObjects);
			stream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File " + save + "not found");
			System.exit(0);
		}
		catch (IOException ex) {
			System.out.println("nards man");
		}
	}
	
    @SuppressWarnings("unchecked")
	
    public static void loadGame(String fileName) {
    	File f = new File(fileName);
    	try {
    		FileInputStream fos = new FileInputStream(f);
    		ObjectInputStream stream = new ObjectInputStream(fos);
    		currentRoom = (Room) stream.readObject();
    		inventory =  (ArrayList<Item>) stream.readObject();
    		RoomObjects = (HashMap<String, Room>) stream.readObject();
    		stream.close();
    	} 
    	catch (FileNotFoundException e) {
    		System.out.println("File "+fileName+" not found.");
    		System.exit(0);
    	} 
    	catch (IOException ex) {
    		System.out.println("Bummers, man.");
    	} 
    	catch (ClassNotFoundException ex) {
    		System.out.println("Something went horribly wrong.");
    	}
    	
    }
    
    
    
 
    public static void main(String[] args) {
			
			gui = new GUI();
			game.print(currentRoom);
			
	}
    private static GUI gui = new GUI();

	
/*	public static void runGame() {
		
		
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
				if(nextRoom == null) {
					System.out.println("You cant go that way.");
				}
				else if (nextRoom.getlock() == true) {
					System.out.println("The room is locked.");
						
				}
				else {
					currentRoom = nextRoom;
				}
				
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
					if(getIteminventory(words[1]) == null) {
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
				
			case "talk":
				game.print("You are trying to talk to the " + words[1] + ".");
				if(currentRoom.getNPC(words[1]) != null) {
					currentRoom.getNPC(words[1]).talk();
					game.print("/n");
				}
				
				else{
					game.print("there is no such thing");
				}
	
				break;
			case "save":
				saveList("SaveFile");
				System.out.println("game saved");
				break;	
				

	    	case "load":
	    		loadList("SaveFile");
	    		System.out.println("Game loaded");
			break;	
				
			case "x":
				System.out.println("Thanks for walking through my game!");
					break;
			default:
				System.out.println("I don't know what that means.");
			}
*/	

	private static void loadList(String string) {
		// TODO Auto-generated method stub
		
	}

	private static void saveList(String string) {
		// TODO Auto-generated method stub
		
	}
}


