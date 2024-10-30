package lab3;

public class Room {
	private String description;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	
	public Room(String u) {
		description = u;
	}	//closes room
	
	private Item item;
	private Item p;
	public Item getItem() {
		return item;
	}
	public void setItem(Item i) {
		item = i;
	}
	public Item takeItem() {
		p = item;
		item = null;
		return p;
	}
	public void addItem(Item i) {
		item = i;
		
	}
	public Room getExit(char dir) {
		if (dir == 'e') {
			return east;
		}
		else if (dir == 'w') {
				return west;	
		}
		else if (dir == 'n') {
			return north;
		}
		else if (dir == 's') {
			return south;
		}
		else if (dir == 'u') {
			return up;
		}
		else if (dir == 'd') {
			return down;
		} else {
			return null;
		}
	} // closes getexit
	
		public void addExit(Room a,char leave) {
			if (leave == 'e') {
				east = a;
		}
			else if (leave == 'w') {
				west = a;
		}
			else if (leave == 'n') {
				north = a;
		}
			else if (leave == 's') {
				south = a;
		}
			else if (leave == 'u') {
				up = a;
		}
			else if (leave == 'd') {
				down = a;
		}
	}//closes addexit
		public String toString() {
			return description;
		}
		
}
	
