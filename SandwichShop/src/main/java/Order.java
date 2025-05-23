import java.util.Scanner;

public class Order {

    boolean orderMenuRunning = true;

        public void orderMenu(){

            Scanner scanner = new Scanner(System.in);

            System.out.println(""" 
            What would you like to add to your order?
            1. Add Sandwich\s
            2. Add Drink
            3. Add Chips
            4. Checkout
            5. Cancel
          
           \s""");

            while (orderMenuRunning){

                try {
                  int userChoice =Integer.parseInt(scanner.nextLine().trim());

                  switch (userChoice){
                      case 1 -> addSandwich();

                      case 2 -> addDrink();

                      case 3 -> addChips();

                      case 4 -> checkout();

                      case 5 -> orderMenu();

                      default:
                          System.out.println("Invalid entry. Try again");
                  }

                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }

            }

            void addSandwich(){
                System.out.println("Would you like it toasted? (Y/N)");

                boolean userChoice = scanner.nextLine().trim().replaceAll("\\s+", "").equalsIgnoreCase("Yes");

            }

        }// +addSandwich(Sandwich)
    //        +addDrink(Drink)
    //        +addChips(Chips)
    //        +cancelOrder()
    //        +checkout()
    //        +getTotalPrice()
    //        +getOrderSummary()


}
