//********* Cash withdrawal program using Java *********

import java.util.*;                                             //java.util.*; in the java program, it means we can use any class/interfaces which are part of the packages.
                                                                //So, we can all the classes which are part of util package easily without import statements.



public class Bank {                                                              //A class is a group of objects which have common properties. It is a logical entity. It can't be physical.

    public static void main(String[] args) {                                     //public is an Access modifier, which specifies from where and who can access the method.
                                                                                //static is a keyword that is when associated with a method, making it a class-related method.
                                                                                //void is a keyword and is used to specify that a method does not return anything.
                                                                                //main is the name of the Java main method.
                                                                                //String[] args stores Java command-line arguments
                                                                                //In short, public static void main(String[] args) to call the main function in Java.
                                                                                //The main method is called if its formal parameter matches that of an array of Strings.

//********** Taking Input from user **********
        Scanner sc=new Scanner(System.in);                                       //The Scanner class is used to get user input, and it is found in the java.util package.
        System.out.println("Enter Customer name: ");
        String name = sc.nextLine();
        while(!name.matches("[a-zA-Z[.] \s]+"))                                //Regular Expressions or Regex in Java is an API for defining String patterns that can be used
                                                                                // for searching, manipulating, and editing a string in Java.
                                                                                //we can fix from earlier, which type of input the program will take from user.
        {
            System.out.println("Please enter a valid Customer name!!!");
            name = sc.nextLine();
        }
        System.out.println("Enter your Account Number:");
        String AccountNo=sc.nextLine();
        while(!AccountNo.matches("^[0-9]{10}$"))
        {
            System.out.println("Please enter a valid Account Number!!!");
            AccountNo = sc.nextLine();
        }
        BankAccount obj1=new BankAccount(name,AccountNo);
        obj1.menu();
    }
}

class BankAccount{
    double bal;
    double prevTrans;
    String customerName;
    String AccountNo;

    BankAccount(String customerName,String AccountNo){                  //This keyword refers to the current object in a method or constructor. The most common use of
        this.customerName=customerName;                                 // this keyword is to eliminate the confusion between class attributes and parameters with the same name.
        this.AccountNo=AccountNo;                                       // Because a class attribute is shadowed by a method or constructor parameter.
    }

//************ Working Method to execute the code ************
    void deposit(double amount){
        if(amount!=0){
            bal+=amount;
            prevTrans=amount;
        }
    }

    void withdraw(double amt){
        if(amt!=0 && bal>=amt){
            bal-=amt;
            prevTrans=-amt;
        }
        else if(bal<amt){
            System.out.println("Bank balance insufficient!!!");
        }
    }

    void getPreviousTrans(){
        if(prevTrans>0){                                                               //Use * if *  to specify a block of code to be executed, if a specified condition is true.
        }
        else if(prevTrans<0){
            System.out.println("Withdrawn: "+Math.abs(prevTrans));                     //Use * else if *  to specify a new condition to test, if the first condition is false.
        }
        else{                                                                         //Use * else *  to specify a block of code to be executed, if the same condition is false.
            System.out.println("Deposited: "+prevTrans);
            System.out.println("No transaction occurred");
        }
    }

    void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println("\n");

        System.out.println("Welcome "+customerName);
        System.out.println("Your Bank Account No:"+AccountNo);
        System.out.println("\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Previous Transaction");
        System.out.println("5. Exit");

        do{                                                             //The do-while loop is a variant of the while loop.
                                                                        // This loop will execute the code block once, before checking if the condition is true,
                                                                        // then it will repeat the loop as long as the condition is true.
            System.out.println("\n");
            System.out.println("Choose an option");
            option=sc.next().charAt(0);
            //System.out.println("\n");

            switch (option){                                             //The switch case in java executes one statement from multiple ones. Thus, it is like an if-else-if ladder statement.
                                                                        // It works with a lot of data types. The switch statement is used to test the equality of a variable against several
                                                                        // values specified in the test cases.
                case '1':
                    System.out.println("......................");
                    System.out.println("Balance ="+bal);
                    System.out.println("......................");
                  //System.out.println("\n");
                    break;
                case '2':
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    double amt=sc.nextDouble();
                    deposit(amt);
                    System.out.println("......................");
                    //System.out.println("\n");
                    break;
                case '3':
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    double amtW=sc.nextDouble();
                    withdraw(amtW);
                    System.out.println("......................");
                    //System.out.println("\n");
                    break;
                case '4':
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    getPreviousTrans();
                    System.out.println("......................");
                    //System.out.println("\n");
                    break;

                case '5':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        }while(option!='5');

        System.out.println("Thank you for using our banking service");
        System.out.println("Have a good day");
        System.out.println("......................");
    }
}