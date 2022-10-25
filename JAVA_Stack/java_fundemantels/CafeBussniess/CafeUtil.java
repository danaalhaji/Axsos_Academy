import java.util.ArrayList;
public class CafeUtil {
    public int getStreakGoal(){
        int NumWeeks=10;
        int count = 0;
        count ++;
        if (count == NumWeeks){
            count = 0;
        }
        return count;
    }
    public double getOrderTotal(double[] prices){
        double sum = 0;
        for( double p : prices){
            sum += p;
        }
    return sum;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for(int i=0 ;i < menuItems.size();i++ ){
            System.out.println( i + " "+ menuItems.get(i));
        }
    }
    public void addCustomer(ArrayList<String> customer){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello," + userName);
        System.out.println("There are " + customer.size() +" people in front of you");
        customer.add(userName);
        for(String c : customer){
            System.out.println(c);
        }

    }

}