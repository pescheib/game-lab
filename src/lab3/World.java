package lab3;

public class World {
public static Room buildworld() {
		Room frontDoor = new Room("You are at the front of the building.");
		Room Cafe = new Room("You are in the cafeteria.");
		Room Surgery = new Room("You are in the surgery room.");
		Room Wash = new Room("You are in the wash room.");
		Room Rehab = new Room("You are in the rehabilitation room.");
		Room Radiation = new Room("You are in the X-Ray room.");
		Room Emergency = new Room("You are in the emergency room.");
		Item wheelchair = new Item("Wheelchair", "You may now use the wheelchair");
		Item ID = new Item("ID", "An ID for passage");
		Item bed = new Item("Bed", "A bed to block off doors");
		Item Key = new Item("Key", "A key to a chest");
		Item Chair = new Item("Chair", "king in the castle, this is a chair");
		combination Combination = new combination("Combination", "numbers on spinning dial");
		safe Safe = new safe("Safe", "hidden in corner");
		
		
		Cafe.addExit(frontDoor, 's'); 
		Cafe.addExit(Surgery, 'w'); 
		Cafe.addExit(Wash, 'e'); 
		Cafe.addExit(Rehab, 'n'); 
		Cafe.addExit(Radiation, 'u');
		Cafe.addExit(Emergency, 'd');
		
		
		Surgery.addExit(Cafe, 'e');
	
		
		Wash.addExit(Cafe, 'w');
		
		
		Rehab.addExit(Cafe, 's');
		
		Radiation.addExit(Cafe, 'd');
		
		Emergency.addExit(Cafe, 'u');
				
		frontDoor.addExit(Cafe, 'n');
		Emergency.addItem("wheelchair", wheelchair);
		Cafe.addItem("ID", ID);
		Cafe.addItem("Key", Key);
		Cafe.addItem("Chair", Chair);
		Surgery.addItem("bed", bed);
		Radiation.addItem("Safe", Safe);
		Rehab.addItem("Combination", Combination);
		return frontDoor;
		}
	}