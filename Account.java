import java.util.Scanner;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }

    void deposit(int new_deposit){
        if (new_deposit > 0){
            balance = balance + new_deposit;
            previousTransaction = new_deposit;
        }
    }

    void withdraw(int new_withdraw){
        if (new_withdraw > 0){
            balance = balance - new_withdraw;
            previousTransaction = - new_withdraw;
        }
    }

    void getPreviousTransaction(){
        if (previousTransaction > 0){
            System.out.println("Deposit: " + previousTransaction);
        } else if (previousTransaction < 0){
            System.out.println("Withdraw: " + previousTransaction);
        } else {
            System.out.println("No Transaction Occurred");
        }
    }

    void calculateInterests(int years){
        double interestsRate = 0.0185;
        double interests = balance * interestsRate * years;
        double newBalance = interests + balance;
        System.out.println("Your current interests are: " + interests);
        System.out.println("Your current balance with interests is: " + newBalance);
    }

    void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer ID: " + customerID);
        System.out.println("What would you like to do?");
        System.out.println("a. Check Balance");
        System.out.println("b. Make a Deposit");
        System.out.println("c. Make a Withdraw");
        System.out.println("d. View Previous Transaction");
        System.out.println("e. Calculate Interests");
        System.out.println("f. Exit");
        do {
            System.out.println();
            System.out.println("Enter An Option: ");
            char input = sc.next().charAt(0);
            option = Character.toLowerCase(input);
            System.out.println();

            switch(option){
                case 'a':
                    System.out.println("Your balance is: " + balance);
                    break;
                case 'b':
                    System.out.println("Enter an Amount to Deposit: ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("Deposit: " + amount);
                    break;
                case 'c':
                    System.out.println("Enter an Amount to Withdraw: ");
                    amount = sc.nextInt();
                    withdraw(amount);
                    System.out.println("Withdraw: " + amount);
                    break;
                case 'd':
                    getPreviousTransaction();
                    break;
                case 'e':
                    System.out.println("Enter How Many Years of Accured Interests: ");
                    int years = sc.nextInt();
                    calculateInterests(years);
                    break;
                case 'f':
                    System.out.println("============================================");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while(option != 'f');
        System.out.println("Thank you for banking with us!");
    }
}
