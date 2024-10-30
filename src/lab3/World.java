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
		Item ID = new Item("ID", "you have acquired your ID for passage");
		Item bed = new Item("Bed", "you now have a bed to block off doors");

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
		Emergency.addItem(wheelchair);
		Cafe.addItem(ID);
		Surgery.addItem(bed);
		return frontDoor;
		}
	}