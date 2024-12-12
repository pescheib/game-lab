package lab3;

public class World {
public static Room buildworld() {
		Room frontDoor = new Room("The Front","You are at the front of the building.");
		Room Cafe = new Room("Cafeteria","You are in the cafeteria.");
		Room surgery = new Room("Surgery Room","You are in the surgery room.");
		Room Wash = new Room("Wash Room" , "You are in the wash room.");
		Room Rehab = new Room("Rehabilitation Room","You are in the rehabilitation room.");
		Room Radiation = new Room("X-Ray Room", "You are in the X-Ray room.");
		Room Emergency = new Room("Emergency Room", "you are in the emergency room.");
		Room Outside = new Room("Outside", "gloomy and nighttime");
		Item wheelchair = new Item("Wheelchair", "You may now use the wheelchair");
		Item ID = new Item("ID", "An ID for passage");
		Item bed = new Item("Bed", "A bed to block off doors");
		Key key = new Key("Key", "A key to a door");
		Item Chair = new Item("Chair", "king in the castle, this is a chair");
		Puppy Puppy = new Puppy("Puppy", "A hideous puppy wags his tail");
		Ghost Ghost = new Ghost("Ghost", "frightening, hideous, and partially see-through");
		combination Combination = new combination("combination", "numbers on spinning dial");
		safe safe = new safe("Safe", "hidden in corner");
		Note note = new Note("Note", "This is a note, What does it say?");
		Map map = new Map("Map", "This is a map. May be useful.");
		Container box = new Container("box", "Small cardboard box. feels a bit heavy...");
		
		
		Cafe.addExit(frontDoor, 's'); 
		Cafe.addExit(surgery, 'w'); 
		Cafe.addExit(Wash, 'e'); 
		Cafe.addExit(Rehab, 'n'); 
		Cafe.addExit(Radiation, 'u');
		Cafe.addExit(Emergency, 'd');
		
		
		surgery.addExit(Cafe, 'e');
		surgery.setlock(true);
		Outside.setlock(true);
	
		
		Wash.addExit(Cafe, 'w');
		
		
		Rehab.addExit(Cafe, 's');
		
		Radiation.addExit(Cafe, 'd');
		Cafe.addItem("note", note);
		Radiation.addItem("Safe", safe);
		
		Emergency.addExit(Cafe, 'u');
		Emergency.addItem("Box", box);
		Emergency.addItem("wheelchair", wheelchair);
				
		frontDoor.addExit(Cafe, 'n');
		frontDoor.addItem("Map", map);
		frontDoor.addExit(Outside, 's');
		
		
		
		Cafe.addItem("ID", ID);
		Emergency.addItem("Key", key);
		Cafe.addItem("Chair", Chair);
		
		surgery.addItem("bed", bed);
		surgery.addNPC("Ghost", Ghost);
		
		
		
		Rehab.addItem("Combination", Combination);
		
		
		Wash.addNPC("Puppy", Puppy);
		return frontDoor;
		}
	}