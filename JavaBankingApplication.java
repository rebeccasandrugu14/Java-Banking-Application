
import java.util.Scanner;  

/*
This Java application replicates a banking system. In this program, you will be able to do the following below:

	Create an account(s)
	Display all account details
    Search by account number
	Withdraw money
	Deposit money
	
*/

class BankDetails {
	private String name;  
    private String accNum;  
    private String accType; 
	private String address;
	private String ssn;
	private String email;
	private long number;
    private long balance;  
    Scanner sc = new Scanner(System.in);
	
    //method to open new account  
    public void openAccount() {  
		System.out.print("Enter Name: ");  
        name = sc.nextLine();  
        System.out.print("Enter Account Number: ");  
        accNum = sc.nextLine();  
        System.out.print("Enter Account type: ");  
        accType = sc.nextLine();  
		System.out.print("Enter SSN: ");  
        ssn = sc.nextLine();
		System.out.print("Enter Address: ");  
        address = sc.nextLine();
		System.out.print("Enter Email: ");
		email = sc.nextLine();
		System.out.print("Enter phone number: ");
		number = sc.nextLong();
        System.out.print("Enter Balance: $");  
        balance = sc.nextLong(); 
    }  

	//method to display account details  
    public void showAccount() {  
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account number: " + accNum); 
        System.out.println("Account type: " +accType); 
		System.out.println("SSN: " + ssn);
        System.out.println("Address: " + address);
		System.out.println("Email: " + email);
		System.out.println("Phone number: " + number);
        System.out.println("Balance: $" + balance);  
	}
	
	//method to show balance  
    public void balance() {  
          
        System.out.println("Balance is: $" + balance);
    }
	
    //method to deposit money  
    public void deposit() {  
        long amount;  
        System.out.println("Enter the amount you want to deposit: $");  
        amount = sc.nextLong();  
        balance = balance + amount;  
        System.out.println("Balance after deposit: $" + balance);
    }
	
    //method to withdraw money  
    public void withdrawal() {  
        long amount;  
        System.out.println("Enter the amount you want to withdraw: $");  
        amount = sc.nextLong();  
        if (balance >= amount) {  
            balance = balance - amount;  
            System.out.println("Balance after withdrawal: $" + balance);  
        } else {  
            System.out.println("Your balance is less than $" + amount + "\tTransaction failed...!!" );  
        }  
    } 
	
    //method to search an account number  
    public boolean search(String accNumber) {  
        if (accNum.equals(accNumber)) {  
            showAccount();  
            return (true);  
        }  
        return (false);  
    }  
}  

public class JavaBankingApplication {  
    public static void main(String arg[]) {  
        Scanner sc = new Scanner(System.in);  
        //create initial accounts  
        System.out.print("How many number of customers do you want to input? ");  
        int numberOfCustomers = sc.nextInt();  
        BankDetails customers[] = new BankDetails[numberOfCustomers];  
        for (int i = 0; i < customers.length; i++) {  
            customers[i] = new BankDetails();  
            customers[i].openAccount();  
        }  
		
        // loop runs until number 5 is not pressed to exit  
        int choice;  
        do {  
            System.out.println("\n ***Banking System Application***");  
            System.out.println("1. Display all account details \n 2. Search by Account number\n 3. Deposit the amount \n 4. Withdraw the amount \n 5.Exit ");  
            System.out.println("Enter your choice: ");  
            choice = sc.nextInt();  
                switch (choice) {  
                    case 1:  
                        for (int i = 0; i < customers.length; i++) {  
                            customers[i].showAccount();  
                        }  
                        break;  
                    case 2:  
                        System.out.print("Enter account no. you want to search: ");  
                        String accNumber = sc.next();  
                        boolean found = false;  
						
                        for (int i = 0; i < customers.length; i++) {  
                            found = customers[i].search(accNumber);  
                            if (found) {  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;  
                    case 3:  
                        System.out.print("Enter Account no. : ");  
                        accNumber = sc.next();  
                        found = false;  
                        for (int i = 0; i < customers.length; i++) {  
                            found = customers[i].search(accNumber);  
                            if (found) {  
                                customers[i].deposit();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;  
                    case 4:  
                        System.out.print("Enter Account No : ");  
                        accNumber = sc.next();  
                        found = false;  
                        for (int i = 0; i < customers.length; i++) {  
                            found = customers[i].search(accNumber);  
                            if (found) {  
                                customers[i].withdrawal();  
                                break;  
                            }  
                        }  
                        if (!found) {  
                            System.out.println("Search failed! Account doesn't exist..!!");  
                        }  
                        break;  
                    case 5:  
                        System.out.println("See you soon...");  
                        break;  
                }  
            }  
            while (choice != 5);  
        }  
    }  