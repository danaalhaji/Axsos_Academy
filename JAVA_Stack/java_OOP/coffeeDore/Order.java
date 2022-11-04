import java.util.ArrayList;
public class Order{
    private String name;
    private double total = 0;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();
    public Order(){
        this.name ="Guest";
    } 
    public Order(String name){
    this.name =name;
    } 
    public void setName(String name){
        this.name = name;
    }
    public void addItems(Item i){
        double price = i.getPrice();
        this.items.add(i);
        this.total += price;
    }
    public boolean orderStatus(boolean status){
        this.ready = status;
        return this.ready;
    }
    public void getStatusMessage(){
        if (this.ready == true){
            System.out.println("Your Order Is Ready!");
        }
        else{
            System.out.println("Thank you for waiting. Your order will be ready soon.");
        }
    }
    public void display(){
        System.out.println("Order Name " + this.name);
        for (Item i : this.items){
            System.out.println( i.getName() +" --  "+i.getPrice()+" $");
        }
        System.out.println("Total: " + this.total + " $");
    }
    }