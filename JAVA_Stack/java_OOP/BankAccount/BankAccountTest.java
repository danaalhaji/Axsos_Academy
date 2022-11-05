public class BankAccountTest{
    public static void main(String[] args){
        BankAccount account1 = new BankAccount(250000, 365021);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingBalance());
        account1.withdrawBalance(2541, "checking");
        account1.depositeBalance(1150000, "saving");
        account1.printSavingsBalance();
        account1.withdrawBalance(465021, "saving");
        System.out.println(account1.generateAccountID());
    } 
}