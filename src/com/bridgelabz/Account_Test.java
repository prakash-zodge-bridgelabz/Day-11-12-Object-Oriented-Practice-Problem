package com.bridgelabz;
//2. Modify class Account to provide a method called debit that withdraws money
//from an Account. Ensure that the debit amount does not exceed the Account’s
//balance. If it does, the balance should be left unchanged and the method
//should print a message indicating ―Debit amount exceeded account balance.
//Modify class AccountTest to test method debit.
class Account{
    int account_number;
    String account_name;
    double account_balance;
    Account(int account_number, String account_name,double account_balance){
        this.account_number = account_number;
        this.account_name = account_name;
        this.account_balance = account_balance;
    }
    //debit function that withdraws money from an Account.
    boolean debit(double amount){
        if(amount < account_balance){
            account_balance -= amount;
            System.out.println("Amount debited successfully....\nBalance is : "+account_balance);
            return true;
        }
        else{
            System.out.println("Debited amount is exceeding the Account’s balance");
            return false;
        }
    }
}
public class Account_Test {
    public static void main(String[] args) {
        Account a = new Account(123,"Prakash",5000);

        if(a.debit(3000) == true){
            System.out.println("Method debit is working fine after providing Rs.3000 for debit");
        }
        else if(a.debit(3000) == false){
            System.out.println("Faulty transaction");
        }
        if(a.debit(6000) == false){
            System.out.println("Method debit is working fine after providing Rs.6000 for debit");
        }
        else if(a.debit(6000) == true){
            System.out.println("Faulty transaction");
        }
    }
}
