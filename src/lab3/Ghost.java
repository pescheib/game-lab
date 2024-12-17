package lab3;

public class Ghost extends NPC{
	public Ghost(String name, String description) {
		super("Ghost", "frightening, hideous, and partially see-through");
	}
	@Override
	public void talk() {
		say("boo! WHY ARE YOU HERE!");
		String[] options = {
				"I need care!",
	"I'm looking for a diamond."
	};
	getResponse(options);
	}
	@Override
	public void response(int option) {
		switch(option) {
		case 1:
			say("i cannot assist you with that");
			break;
		case 2:
			say("hmmmmm have you found the combination or safe?");
			game.print("The ghost floats away through you, you fall over the bed, hurt your leg, and he goes into the abyss");
			break;
		}
	}
}