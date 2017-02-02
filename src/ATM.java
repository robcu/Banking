import java.util.Scanner;


public class ATM {

    static Scanner scanner = new Scanner(System.in);
    static Menu menu = new Menu();
    static User user = new User();


    public static void main(String[] args) throws Exception {


        menu.chooseAccount();
        menu.menuOptions();
    }
}
