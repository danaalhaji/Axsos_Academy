public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is ";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee = 2.5;
        double cafeLatte = 4.5;
        double cappuccino = 3.8;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrde4r = false;

    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        System.out.println(customer1 + pendingMessage );
        System.out.println(generalGreeting + customer2 + readyMessage + "You Ordered CafeLatte and," +displayTotalMessage + cafeLatte +"$" );
        System.out.println(generalGreeting + customer3 + readyMessage + "You Ordered CafeLatte and," +displayTotalMessage + cappuccino +"$" );
        System.out.println(generalGreeting + customer4 + pendingMessage + "Notice that the price for you order is" + cappuccino + "$"); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
    }
}