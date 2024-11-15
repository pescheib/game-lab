package lab3;

public class Key extends Item{
	public Key(String n, String o) {
		super(n, o);
		
	}
	public void use() {
		Room surgery = game.currentRoom.getExit('w');
		if((surgery != null)) {
			surgery.setlock(false);
			game.print("Unlocked");
			
		}
		else {
			game.print("use key on operating door");
		}
		
		//if (currentRoom.getExit('n') == null) {
		//	game.print( "use key on operating door");
		//}
		//else if(currentRoom.getExit('n').getname().equals( "surgery")) {
		//	game.print( "use key on operating door");
		//	game.currentRoom.getExit('w').setlock(false);
		//	
		//}
		//else {
		//	game.print( "use key on operating door");
		//}
		
	}
	
}



//&& surgery.getname().equals("surgery")