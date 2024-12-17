package lab3;

import javax.swing.JOptionPane;

public class NPC {
	private String name; // NPC's name
	private String description; // NPC's description
	
	public NPC(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public void say(String dialog) {
		game.print(name+": "+dialog);
	}
	
	public void talk() {
		game.print("You can't talk to "+name+".");
	}
	
	public void response(int option) {
		// This method intentionally left blank.
	}

	public void getResponse(String[] options) {
			String s = "";
				for (int i = 0; i < options.length; i++) {
					s += "Option " + (i + 1) + ": " + options[i] + "\n";
	}
					s += "Enter an option (1-" + options.length + "):";
					int option = Integer.parseInt(JOptionPane.showInputDialog(s));
						response(option);
	
		}		
	}

