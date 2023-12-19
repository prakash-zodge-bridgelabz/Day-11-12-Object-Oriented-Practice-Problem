package com.bridgelabz;
//3. Commercial data processing - StockAccount.java implements a data type that
//might be used by a financial institution to keep track of customer information. The
//StockAccount class implements following methods

// --------Picture--------

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//The StockAccount class also maintains a list of CompanyShares objects
//which have Stock Symbol and Number of Shares as well as DateTime of the
//transaction. When buy or sell is initiated StockAccount checks if
//CompanyShares are available and accordingly update or create an Object.
class Stock_Account{        // Company profile
    String stock_symbol;
    double stock_amount;
    int number_of_shares = 5; //Total available company shares
    LocalDateTime date_time_of_transaction;
    String file_name;
    Stock_Account(String file_name){
        this.file_name = file_name;
    }
    double valueOf(){ //Returning total stock value of account Rupees
        return stock_amount;
    }
    void buy(String stock_symbol, double stock_amount){
        this.stock_symbol = stock_symbol;
        this.stock_amount += stock_amount;
        number_of_shares -= 1;
        System.out.println("Stock purchase successfully");
    }
    void sell(String stock_symbol, double stock_amount){
        this.stock_symbol = stock_symbol;
        this.stock_amount -= stock_amount;
        number_of_shares += 1;
        System.out.println("Stock sell successfully");
    }
    void save(String file_name){
        this.file_name = file_name;
        System.out.println("Account has been saved to file");
    }
    // print detail record of stocks and values
    void printReport(){
        System.out.println("Stock symbol : "+stock_symbol+
                "\nStock amount : Rs."+valueOf()+
                "\nNumber of shares : "+number_of_shares);
    }
}
public class Commercial_data_processing {
    public static void main(String[] args) {
        LocalDateTime date_time = LocalDateTime.now();
        ArrayList<Stock_Account> stock_account = new ArrayList<>();



        Stock_Account Infosys = new Stock_Account("Infosys");
        Infosys.buy("INFY",20);
        Infosys.save("Infosys");
        Infosys.printReport();

    }
}
