public class BankAccountTest{
    public static void main(String[] args){
        BankAccount account1 = new BankAccount(250000, 365021);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingBalance());
        account1.withdrawCheckingBalance(2541);
        account1.depositeSavingBalance(1150000);
        account1.printSavingsBalance();
        account1.withdrawCheckingBalance(465021);
        System.out.println(account1.generateAccountID());
    } 
}