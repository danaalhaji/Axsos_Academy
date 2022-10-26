public class BaristaTest{
    public static void main (String[] args){
        String newline = System.lineSeparator();
    // ---------- Set Our Menu Items ----------- 
        Item item1 = new Item();
        item1.setName("Cafe Late");
        item1.setPrice(10);

        Item item2 = new Item();
        item2.setName("Coffee");
        item2.setPrice(9);

        Item item3 = new Item();       
        item3.setName("Chai late");
        item3.setPrice(17);

        Item item4 = new Item("Iced Coffee",20);    
        
    //------------ Show all our items -----------
        System.out.print("------Our Items On The Menu-------"+ newline);
        item1.ShowDetails();
        item2.ShowDetails();
        item3.ShowDetails();
        item4.ShowDetails();

    // ----------- Add Orders --------------------

    Order order1 = new Order("Dana");
    order1.addItems(item1);
    order1.addItems(item2);
    order1.orderStatus(false);
    order1.getStatusMessage();
    order1.display();

    // Order 2 
    Order order2 = new Order();

    //3 Orders
    Order order3 = new Order("Order3");
    Order order4 = new Order("O2");
    Order order5 = new Order("O3");

    // Add items to order 3 and display it
    order3.addItems(item1);
    order3.addItems(item4);
    order3.display();
    // Test Ready method
    order2.orderStatus(true);
    order2.getStatusMessage();

    order5.orderStatus(false);
    order5.getStatusMessage();
    
    // **********************************************************************************************************//
    }
}