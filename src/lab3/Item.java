package lab3;
import java.io.Serializable;


public class Item extends game implements Serializable {
	private String object;
	private String name;

	public Item(String n, String o) {
		object = o;
		name = n;
		}
	public String getobject() {
		return object; 
			
		}
	public void setobject(String o) {
		object = o; 
			
		}
	
	public String getname() {
		return name; 
			
		}
	public void setname(String n) {
		 name = n; 
			
		}
	public String toString() {
		return name;
	}
	public void open() {
		game.print("you cannot open that");
	}
	public void use() {
		game.print("you cannot use that");
	}
}
