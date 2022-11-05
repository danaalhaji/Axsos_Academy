import java.util.ArrayList;
import java.util.Random;
public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private double total ;
    private static Random random = new Random();
    private static int numberAccounts = 0;
    public BankAccount(double savings , double checking ){
        this.generateAccountID();
        this.savingsBalance = savings;
        this.checkingBalance = checking;
        this.total = this.savingsBalance+this.checkingBalance;
        numberAccounts ++;
    }
    public double getSavingBalance(){
        return this.savingsBalance;
    }
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public void depositeBalance(double money , String type){
        if (type == "checking"){
        this.checkingBalance+=money;
        }
        if (type == "saving"){
            this.savingsBalance+=money;
            }
    }
    public void withdrawBalance(double money , String type){
        if (type == "checking"){
            if (money >= this.checkingBalance){
            System.out.println("Not enough balance!");
        }
            else{
                this.checkingBalance -= money;
                System.out.println(this.checkingBalance);
            }
    }
    if (type == "saving"){
        if (money >= this.savingsBalance){
            System.out.println("Not enough balance!");
        }
        else{
            this.savingsBalance -= money;
        }
        }
    }
    public void printCheckingBalance(){
        System.out.println(getCheckingBalance());
    }
    public void printSavingsBalance(){
        System.out.println(getSavingBalance());
    }
    public int generateAccountID(){
    int accountNumber = 1000000000 + (int)(random.nextDouble() * 999999999);
    return accountNumber;
}
    }
    

