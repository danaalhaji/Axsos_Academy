public class Item{
    private String name;
    private double price;
    private int index ;
    public Item(){
        this.name = " ";
        this.price = 0;
    }
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public double getPrice(){
        // System.out.println(this.price);
        return this.price;
    }
    public void setIndex(int q){
        this.index = q;
    }

    public int getIndex(){
        return this.index ;
    }
    
    public void ShowDetails(){
        System.out.println("This is item is:" + this.name + ", And it's price is :" + this.price + "you can find this item in the menu at index" + this.index);
    }

}