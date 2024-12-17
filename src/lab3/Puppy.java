package lab3;

public class Puppy extends NPC {
		public Puppy(String name, String description) {
			super("puppy", "A hideous puppy wags his tail.");
		}
			int count = 0;
	    

	    @Override
	    public void talk() {
	        if(count == 0){
	            say("Hi! I'm an adorable puppy!\n");
	            String[] options = {
	                "Yes you are! Who's a good boy?",
	                "Ew, no. You're actually kinda hideous."
	            };
	            getResponse(options); 
	            count++; 
	        }
	        else if(count == 1){
	            say("Hey! Wanna play fetch? Say yes! Say yes!\n");
	            String[] options = {
	                "Yes! I love fetch!",
	                "No. I am a horrible person and don't like playing with puppies."
	            };
	            getResponse(options);
	            count++;
	        }

	        else{
	            say("Yip!\n");
	            count++;
	        }
	    }


	    @Override
	    public void response(int option) {
	        if(count == 0){ 
	            switch(option) {
	                case 1:
	                    say("I am! I'm a good boy!\n");
	    
	                    break;
	    
	                case 2:
	                    say("I am adorable! Why are you so mean?");
	                    game.print("The puppy bites you. You deserve it.\n");
	    
	                break;
	            }   
	        }

	        else if (count == 1){
	            switch(option) {
	                case 1:
	                    say("Yay! Fetch!");
	                    game.print("The puppy runs off and returns with a ball. You now have a ball\n");
	                    Item ball = new Item("ball", "a small slimey ball");
	                    game.inventory.add(ball);
	    
	                    break;
	    
	                case 2:
	                    say("You're a bad person! I don't like you!");
	                    game.print("The puppy runs away and doesn't come back\n");
	                    
	                break;
	            }
	        }
	    }

	    public void give(Item i){
	        if(game.getIteminventory(i.getname()) == null){
	            game.print("You dont have such item");
	        }
	        else if(i.getname() == "toy"){
	            game.print("You gave the " + i.getname() + " to the puppy");
	            game.inventory.remove(i);
	        }
	        else{
	            game.print("You can't give the " + i.getname() + " to the puppy");
	        }
	    }


}
					
		
