import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to DELI-cious Sandwich Shop \n " +
                "Please select from the following options: \n" +
                "1. New Order \n2. Exit" );

        Scanner scanner = new Scanner(System.in);

        //calling the order class
        Order order = new Order();

        int userInput = Integer.parseInt(scanner.nextLine().trim());

        boolean homeMenuRunning = true;

            while (homeMenuRunning) {
                switch (userInput){
                    case 1 :
                        System.out.println("Opening menu :");
                        order.orderMenu();
                        break;
                    case 2 :
                        System.out.println("Exit: ");
                        homeMenuRunning = false;
                        break;
                    default:
                        System.out.println("Try again");
                }

            }


    }
}
