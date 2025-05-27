import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    Scanner scanner = new Scanner(System.in);
    List<Sandwich> sandwichList = new ArrayList<>();
    List<Drink> drinkList = new ArrayList<>();
    List<Chips> chipsList = new ArrayList<>();

    boolean orderMenuRunning = true;

        public void orderMenu(){

            System.out.println(""" 
            What would you like to add to your order?
            1. Add Sandwich
            2. Add Drink
            3. Add Chips
            4. Checkout
            5. Cancel
          
           """);

            while (orderMenuRunning){

                try {
                  int userChoice =Integer.parseInt(scanner.nextLine().trim());

                  switch (userChoice){
                      case 1 -> addSandwich(); // for loop how many sandwiches // count variable (takes user input) // for iterations

                      case 2 -> addDrink();

                      case 3 -> addChips();

                      case 4 -> checkout();

                      case 0 -> {
                          System.out.println("Order cancelled. Returning back to Home Screen...");
                              orderMenuRunning = false;
                      }
                      default -> System.out.println("Invalid entry. Please try again");
                  }

                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }

            }

        }
    public void addSandwich (){
        System.out.println("How many sandwiches would you like to add?");

        try {
            int sandwichCount = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < sandwichCount; i++) {
                System.out.println("Creating sandwich order # " + (i + 1));

                Sandwich sandwich = new Sandwich().createSandwich();
                sandwichList.add(sandwich);

                System.out.println("Sandwich # "+ (i + 1) + "has been added to your order");
            }
        } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid number");
            }
    }
    public void addDrink(){
        System.out.println("How many drinks would you like to add to your order?");

        try{
            int drinkCount = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < drinkCount; i++){
                System.out.println("Adding drinks to your order " + (i +1));

                Drink drink = new Drink().createDrink();
                drinkList.add(drink);

                System.out.println("Your drink " + (i +1) + "has been added to your order!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please try again");
        }
    }

        public void addChips(){}
    public void checkout(){
            // sout name for order
        // order order = new order()
        // scanner pls verify order
        // if y then return order ? :: go back to order menu
    }



}
