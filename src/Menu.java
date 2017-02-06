import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by robculclasure on 2/2/17.
 */
public class Menu {

    String accountName;
    int menuChoice; // right now my program loops because each method calls another method. WHILE LOOP
    double balance;
    boolean loggedIn;
    HashMap registry = new HashMap();
    Scanner greetScanner = new Scanner(System.in);
    int intGreetChoice;
    Scanner loginScanner = new Scanner(System.in);
    Scanner createAccountScanner = new Scanner(System.in);
    Scanner depositScanner = new Scanner(System.in);
    Scanner withdrawalScanner = new Scanner(System.in);
    Scanner accountMenuScanner = new Scanner(System.in);

    void greetUser() throws Exception {
        System.out.println("Welcome to javaBank ATM.");
        System.out.println("[1] - Login");
        System.out.println("[2] - Create a new account");
        intGreetChoice = greetScanner.nextInt();
        if(intGreetChoice == 1){
            login();
        }
        else if(intGreetChoice == 2){
            createAccount();
        }
    }

    void login() throws Exception{
        System.out.println("Enter your name:");
        accountName = loginScanner.nextLine();
        if(registry.containsKey(accountName)){
            System.out.println("Welcome " + accountName + ".");
            loggedIn = true;
        }
        else{
            System.out.println("Account not found. If you believe there is an error please visit your local branch.");
        }
    }

    void createAccount() throws Exception {
        System.out.println("Enter your name:");
        accountName = createAccountScanner.nextLine();
        registry.put(accountName, balance = 0.00);
        System.out.println("New account created successfully.\n");
        loggedIn = true;
    }

    void processAccountMenu() throws Exception{
        System.out.println("Account Options:");
        System.out.println("[1] - Check my balance");
        System.out.println("[2] - Deposit funds");
        System.out.println("[3] - Withdraw funds");
        System.out.println("[4] - Close account");
        System.out.println("[5] - Log out");

        menuChoice = accountMenuScanner.nextInt();

        switch (menuChoice) {
            case 1:
                checkBalance();
                break;
            case 2:
                makeDeposit();
                break;
            case 3:
                makeWithdrawal();
                break;
            case 4:
                deleteAccount();
                break;
            case 5:
                logOut();
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    void checkBalance() throws Exception {
        System.out.println("Your balance is: $" + registry.get(accountName));
    }

    void makeDeposit() throws Exception {
        System.out.println("Enter amount to deposit:");
        double deposit = depositScanner.nextDouble();
        balance += deposit;
        registry.put(accountName, balance);
        System.out.println("Deposit successful.");

    }

    void makeWithdrawal() throws Exception {
        System.out.println("Enter amount to withdraw:");
        double withdrawal = withdrawalScanner.nextDouble();
        if (withdrawal > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= withdrawal;
            registry.put(accountName, balance);
            System.out.println("Dispensing $" + withdrawal + ". Please take your money.");
        }
    }

    void deleteAccount() throws Exception {
        registry.remove(accountName);
        System.out.println("Dispensing balance and closing account. Please take your money.");
        loggedIn = false;
    }

    void logOut() throws Exception {
        System.out.println("Thank you and please come again.");
        loggedIn = false;
    }
}
