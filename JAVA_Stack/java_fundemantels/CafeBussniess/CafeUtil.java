import java.util.ArrayList;
public class CafeUtil {
    public int getStreakGoal(){
        int count = 0;
        count ++;
        if (count == 10){
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

    }

}