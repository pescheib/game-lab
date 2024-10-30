package lab3;

public class Item {
	private String object;
	private String name;

	public Item(String o, String n) {
		object = o;
		name = n;
		getname();
		getobject();
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
		return object  ;
	}
	
}
