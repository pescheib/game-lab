package lab3;
import java.util.HashMap;


public class Room {
	
	private HashMap<String, Item> item = new HashMap<String, Item>();
	
	
	private boolean lock;
	private String name;
	private String object;
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	
	public Room(String n, String u) {
		object = u;
		name = n;
	}	//closes room
	
	public boolean getlock() {
		return lock;
	}
	
	public void setlock(Boolean lock) {
		this.lock = lock;
	}
	
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	
	public Item getItem(String i) {
		return item.get(i);
	}
	public void setItem(String i, Item p) {
		item.put(i,p);
	}
	public void addItem(String i, Item p) {
		item.put(i, p);
		
	}
	public void removeItem(String i) {
		item.remove(i);
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
			return object;
		}
		
}
	
