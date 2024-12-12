package lab3;

public class Note extends Item{
	public Note(String n, String d) {
		super(n,d);
	}
	
	@Override
	public void use() {
		System.out.println("The key unlocks the surgery room. There might be a surprise in there");
	}
}
