import java.util.Scanner;


public class ATM {

    static Menu menu = new Menu();

    public static void main(String[] args) throws Exception {

        menu.loggedIn = false;

        while(true){
            while(!menu.loggedIn){
                menu.greetUser();
            }
            while(menu.loggedIn){
                menu.processAccountMenu();
            }
        }
    }
}
