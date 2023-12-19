package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

//1. Stock Account Management
//  a. Desc -> Write a program to read in Stock Names, Number of Share, Share Price.
//      Print a Stock Report with the total value of each Stock and the total value of Stock.
//  b. I/P -> N number of Stocks, for Each Stock Read In the Share Name, Number of
//      Share, and Share Price
//  c. Logic -> Calculate the value of each stock and the total value
//  d. O/P -> Print the Stock Report.
//  e. Hint -> Create Stock and Stock Portfolio Class holding the list of Stocks read
//      from the input file. Have functions in the Class to calculate the value of each
//      stock and the value of total stocks.
class Stock{
    String stock_name;
    int stock_quantity;
    double stock_price;
    double total_amount;
    Stock(String stock_name,int stock_quantity,double stock_price,double total_amount){
        this.stock_name = stock_name;
        this.stock_quantity = stock_quantity;
        this.stock_price = stock_price;
        this.total_amount = total_amount;
    }
    @Override
    public String toString() {
        return "Stock name : "+stock_name+", Stock Quantity : "+stock_quantity+
                ", Stock Price : "+stock_price+
                ", Stock total amount : "+total_amount;
    }
}
class Stock_Portfolio{
    ArrayList<Stock> Stock_list= new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String stock_name;
    int stock_quantity;
    double stock_price;
    double total_amount;
    int choice=1;
    void input(){
        do {
            System.out.println("1 - Add new stock");
            System.out.println("2 - Exit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();
            switch (choice){
                case 1 :
                    //Add new stock
                    System.out.println("Enter stock name : ");
                    stock_name = sc.next();
                    System.out.println("Enter stock quantity : ");
                    stock_quantity = sc.nextInt();
                    System.out.println("Enter stock price : ");
                    stock_price = sc.nextDouble();
                    //Calculating total value of that perticular stock
                    total_amount = calculate_value_of_each_stock(stock_quantity,stock_price);
                    Stock s = new Stock(stock_name,stock_quantity,stock_price,total_amount);
                    Stock_list.add(s);
                    for(Stock stock : Stock_list){
                        System.out.println(stock);
                    }
                    break;
                default:
                    if(choice == 2){
                        System.out.println("Exiting....");
                    }
                    else {
                        System.out.println("Invalid, please try again");
                    }
            }
        }while(choice != 2);
    }
    double calculate_value_of_each_stock(int stock_quantity, double stock_price){
        return stock_quantity * stock_price;
    }
    //Calculating value of total stocks
    void calculate_value_of_total_stocks(){
        double value_of_total_stocks=0;
        for(Stock stock : Stock_list){
            value_of_total_stocks += stock.total_amount;
        }
        System.out.println("Calculated value of total stocks is : Rs."+value_of_total_stocks);
    }
}
public class Stock_Account_Management {
    public static void main(String[] args) {
        Stock_Portfolio sp = new Stock_Portfolio();
        sp.input();
        sp.calculate_value_of_total_stocks();
    }
}
