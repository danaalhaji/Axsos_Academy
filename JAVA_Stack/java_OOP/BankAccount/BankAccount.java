import java.util.ArrayList;
import java.util.Random;
public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private static Random random = new Random();
    private static int numberAccounts = 0;
    private static ArrayList<BankAccount> allAccounts = new ArrayList<BankAccount>();
    public BankAccount(double savings , double checking ){
        this.generateAccountID();
        this.savingsBalance = savings;
        this.checkingBalance = checking;
        numberAccounts ++;
    }
    public double getSavingBalance(){
        return this.savingsBalance;
    }
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public void depositeCheckingBalance(double money){
        this.checkingBalance+=money;
    }
    public void depositeSavingBalance(double money){
        this.savingsBalance+=money;
    }
    public void withdrawCheckingBalance(double money){
        if (money >= this.checkingBalance){
            System.out.println("Not enough balance!");
        }
        else{
            this.checkingBalance -= money;
            System.out.println(this.checkingBalance);
        }
    }
    public void withdrawSavingBalance(double money){
        if (money >= this.savingsBalance){
            System.out.println("Not enough balance!");
        }
        else{
            this.savingsBalance -= money;
        }
    }
    public void printCheckingBalance(){
        System.out.println(getCheckingBalance());
    }
    public void printSavingsBalance(){
        System.out.println(getSavingBalance());
    }
    public int generateAccountID(){

    Random r = new Random();
    int accountNumber = 1000000000 + (int)(r.nextDouble() * 999999999);
    return accountNumber;
}
    }
    

