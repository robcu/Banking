import java.util.HashMap;

/**
 * Created by robculclasure on 2/2/17.
 */
public class Menu {

    String accountName;
    int menuChoice;
    double balance;
    HashMap hashmap = new HashMap();

    void chooseAccount() throws Exception{
        System.out.println("Welcome to Xbank ATM.");
        System.out.println("Enter your name: ");
        accountName = ATM.scanner.nextLine();
        if(hashmap.containsValue(accountName)){
            System.out.println("Greetings, " + accountName + ".");
        }
        else {
            System.out.println("Account not found.");
            System.out.println("Create a new account? [y/n]");
            String answer = ATM.scanner.nextLine().toLowerCase();
            if (answer.contentEquals("y")) {
                hashmap.put(accountName, balance = 0.00);
                System.out.println("New account created successfully.\n");
            } else if (answer.contentEquals("n")) {
                System.exit(0);
            } else {
                throw new Exception("Invalid input");
            }
        }
    }

    void menuOptions() throws Exception{
        System.out.println("Options:");
        System.out.println("[1] - Check my balance");
        System.out.println("[2] - Deposit funds");
        System.out.println("[3] - Withdraw funds");
        System.out.println("[4] - Close account");
        System.out.println("[5] - Cancel");

        menuChoice = ATM.scanner.nextInt();
        while(menuChoice != 5) {
            switch (menuChoice) {
                case 1:
                    System.out.println("Your balance is: $" + hashmap.get(accountName));
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double deposit = ATM.scanner.nextDouble();
                    hashmap.put(accountName, balance + deposit);
                    balance += deposit;
                    System.out.println(hashmap);
                    break;
                case 3:
                    System.out.println("Enter amount to withdraw:");
                    if (ATM.scanner.nextDouble() > balance) {
                        System.out.println("Insufficient funds.");
                        menuOptions();
                    } else {
                        System.out.println("Please take your money.");
                    }
                    break;
                case 4:
                    hashmap.remove(accountName);
                    System.out.println("Account closed.");
                    chooseAccount();
                    break;
                case 5:
                    System.out.println("Thank you and please come again.");
                    chooseAccount();
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        menuOptions();
        }

    }
}
