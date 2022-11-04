public class OrderKioskTest{
    public static void main(String[] args){
        TestK test = new TestK();
        // ---------Add Items to the menu-----------------
        test.addMenuItem("Coffee" , 10 , 0);
        test.addMenuItem("Latte" , 12 , 1);
        test.addMenuItem("Nesacfe" , 15 , 2);
        test.addMenuItem("Hot Chocolate" , 17 , 3);

        // ---------Display Items in the menu ---------------
        test.displayMenu();
    }
}