import java.util.Scanner;

public class HomeScreen {
    private static Scanner scanner = new Scanner(System.in);
    public void display() {
        boolean running = true;
        while (running){
            System.out.println("\n*** Home Screen ***\n");

            System.out.println(""" 
            Welcome to DELI-cious Sandwich Shop!
            
            1. New Order
            2. Exit""");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        Order order = new Order();
                        order.orderMenu();
                        break;
                    case 2:
                        System.out.println("Thank you! Bye.");
                        running = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
