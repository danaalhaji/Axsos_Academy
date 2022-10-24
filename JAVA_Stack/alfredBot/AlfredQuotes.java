import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello" + name + ", lovely to see you. How are you?";
    }
    public String dateAnnouncement() {
        Date d = new Date();  
        // YOUR CODE HERE
        return "It is currently"+ d;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        String newline = System.lineSeparator();
        int alfred = conversation.indexOf("Alfred");
        int alexis = conversation.indexOf("Alexis");
        if (alexis > -1){
            return conversation + newline + "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if (alfred > -1){
            return conversation + newline + "At your service. As you wish, naturally.";
        }
        else{
            return conversation + newline + "Right. And with that I shall retire.";
        }
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

