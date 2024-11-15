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
		Item wheelchair = new Item("Wheelchair", "You may now use the wheelchair");
		Item ID = new Item("ID", "An ID for passage");
		Item bed = new Item("Bed", "A bed to block off doors");
		Item key = new Key("Key", "A key to a door");
		Item Chair = new Item("Chair", "king in the castle, this is a chair");
		combination Combination = new combination("Combination", "numbers on spinning dial");
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
	
		
		Wash.addExit(Cafe, 'w');
		
		
		Rehab.addExit(Cafe, 's');
		
		Radiation.addExit(Cafe, 'd');
		Radiation.addItem("note", note);
		
		Emergency.addExit(Cafe, 'u');
		Emergency.addItem("Box", box);
				
		frontDoor.addExit(Cafe, 'n');
		frontDoor.addItem("Map", map);
		Emergency.addItem("wheelchair", wheelchair);
		Cafe.addItem("ID", ID);
		Cafe.addItem("Key", key);
		Cafe.addItem("Chair", Chair);
		surgery.addItem("bed", bed);
		Radiation.addItem("Safe", safe);
		Rehab.addItem("Combination", Combination);
		return frontDoor;
		}
	}