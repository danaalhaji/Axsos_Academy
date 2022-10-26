import java.util.ArrayList;

public class OrdersAndItemsTest{
    public static void main (String[] args){
// ------------------Add Items -----------------------------
        Item items1 = new Item();
        items1.name ="Coffee";
        items1.price = 12;
        Item items2 = new Item();
        items2.name="Chai Latte";
        items2.price = 20;
        Item items3 = new Item();
        items3.name = "Cafe Latte";
        items3.price = 17;
        Item items4 = new Item();
        items4.name ="Americano";
        items4.price = 10;
        // --Print All Items ---
        System.out.println("-----Our Menu------");
        System.out.println(items3.name + " " + items3.price);
        System.out.println(items2.name + " " + items1.price);
        System.out.println(items1.name + " " + items1.price);
        System.out.println(items4.name + " " + items4.price);
        System.out.println("------------------");
// ------------------Add Orders--------------------------------
        Orders order1 = new Orders();
        order1.name= "Cindhuri";
        order1.items.add(items1);
        order1.total = items1.price;
        order1.ready = true;
        String newline = System.lineSeparator();
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        Orders order2 = new Orders();
        order2.name= "Jimmy";
        order2.items.add(items3);
        order2.items.add(items2);
        order2.total = items3.price + items2.price;
        order2.ready = true;
        Orders order3 = new Orders();
        order3.name= "Sam";
        order3.items.add(items2);
        order3.items.add(items1);
        order3.total = items2.price + items1.price;
        System.out.printf("the old Total: %s\n", order3.total);
        order3.ready = true;
        order3.items.add(items3);
        order3.items.add(items3);
        order3.total =  order3.total + (2*items3.price);
        Orders order4 = new Orders();
        order4.name= "Noah";
        order4.items.add(items4);
        order4.total = items4.price ;
        order4.ready = true;
        // ----Print Second Order------
        System.out.printf("-----------------------------------"+ newline);
        System.out.printf("Order Number2 :"+ newline);
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);
        // ----Print Third Order------
        System.out.printf("-----------------------------------"+ newline);
        System.out.printf("Order Number3 :"+ newline);
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
        // ----Print Third Order------
        System.out.printf("-----------------------------------"+ newline);
        System.out.printf("Order Number3 :"+ newline);
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}