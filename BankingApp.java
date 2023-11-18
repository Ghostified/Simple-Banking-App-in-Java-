import java.util.Scanner;
import java.lang.Math;

public class BankingApp {
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);

        //Create a Bank Account Objecte
        BankAccount  bank1 = new BankAccount(" Branson ", "1"); 
        bank1.showMenu();
    }
}
class BankAccount{
    int balance;
    int previousTransactions;
    String customerName;
    String customerId;

    //Constructor
    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    //Deposit method
    void deposit (int amount){
        if(amount != 0){
            balance = balance +  amount;
            previousTransactions = amount;
        }
    }

    //Withdraw method
    void withdraw ( int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransactions = -amount;
        }
    }

    //get Previous Transaction Method
    void getPreviousTransaction (){
        if (previousTransactions > 0){
            System.out.println("Deposited: " + previousTransactions);
        }
        else if (previousTransactions < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransactions));
        }
        else{
            System.out.println("No transactions has occured ");
        }
    }

    //show menu method
    void showMenu(){
         char option = '\0';
         Scanner sc = new Scanner(System.in);

         System.out.println("Welcome"+ customerName);
         System.out.println("Your ID is: " + customerId);
         System.out.println();
         System.out.println("A. Check Balance");
         System.out.println("B. Deposit");
         System.out.println("C. Withdraw");
         System.out.println("D. Previous Transaction");
         System.out.println("E. Exit");

         //loop through the menu options
         do{
            System.out.println("==================");
            System.out.println("Enter an option");
            System.out.println("===================");
            option = sc.next().charAt(0);

            //Convert lowercase input to upper case
            Character.toUpperCase(option);

            switch (option){
                case 'A':
                    System.out.println("==================");
                    System.out.println("Balance is: " + balance);
                    System.out.println("==================");
                    System.out.println();
                    break;
                
                case 'B':
                    System.out.println("==================");
                    System.out.println("Enter the amout to deposit");
                    System.out.println("==================");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("==================");
                    System.out.println("Enter the amout to withdraw");
                    System.out.println("==================");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                
                case 'D':
                    System.out.println("==================");
                    getPreviousTransaction();
                    System.out.println("==================");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("==================");
                    break;

                default:
                System.out.println("Invalid Option, try again");
                break;
            }
         }while (option != 'E');
    }
}
