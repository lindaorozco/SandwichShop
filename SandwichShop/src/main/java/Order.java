import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private List<Sandwich> sandwichList = new ArrayList<>();
    private List<Drink> drinkList = new ArrayList<>();
    private List<Chips> chipsList = new ArrayList<>();
    private double totalPrice;

    public Order() {
    }

    public Order(String name, List<Sandwich> sandwichList, List<Drink> drinkList, List<Chips> chipsList) {
        this.name = name;
        this.sandwichList = sandwichList;
        this.drinkList = drinkList;
        this.chipsList = chipsList;
        this.totalPrice = getTotalPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sandwich> getSandwichList() {
        return sandwichList;
    }

    public void setSandwichList(List<Sandwich> sandwichList) {
        this.sandwichList = sandwichList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public List<Chips> getChipsList() {
        return chipsList;
    }

    public void setChipsList(List<Chips> chipsList) {
        this.chipsList = chipsList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void orderMenu() {


        boolean orderMenuRunning = true;

        while (orderMenuRunning) {
            System.out.println(""" 
                     What would you like to add to your order?
                     1. Add Sandwich
                     2. Add Drink
                     3. Add Chips
                     4. Checkout
                     0. Cancel
                    """);
            try {
                int userChoice = Integer.parseInt(scanner.nextLine().trim());

                switch (userChoice) {
                    case 1 -> addSandwich();

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

    public void addSandwich() {
        System.out.println("How many sandwiches would you like to add?");

        try {
            int sandwichCount = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < sandwichCount; i++) {
                System.out.println("\n=== Creating sandwich order # " + (i + 1) + " ===");

                Sandwich sandwich = new Sandwich().createSandwich();
                sandwichList.add(sandwich);

                System.out.println("Sandwich # " + (i + 1) + " has been added to your order\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Please enter a valid number");
        }
    }

    public void addDrink() {
        System.out.println("How many drinks would you like to add to your order?");
        int userCount = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 1; i <= userCount; i++) {

            System.out.println("What drink would you like?");
            Drink.drinkList.forEach(System.out::println);

            String userDrink = scanner.nextLine().trim();
            System.out.println("What size?: S, M, L");

            String userDrinkSize = scanner.nextLine().trim().toUpperCase();
            Drink drink = new Drink(userDrinkSize, userDrink);

            drinkList.add(drink);
            System.out.println("Your drink has been added to your order!\n");
        }
    }

    public void addChips() {

        System.out.println("How many chips would you like to add to your order?");
        String chipCount = scanner.nextLine().trim();

        int chipInput = Integer.parseInt(chipCount);
        for (int i = 0; i < chipInput; i++) {

            System.out.println("Available chips:");
            Chips.chipsList.forEach(System.out::println);
            String userChips = scanner.nextLine().trim().toLowerCase();

            Chips chips = new Chips(userChips);
            chipsList.add(chips);
            System.out.println("Chips have been added to your order\n");
        }

    }


    public double getPrice() {
        double totalCost = 0.0;

        if (sandwichList != null) {
            for (Sandwich sandwich : sandwichList) {
                totalCost += sandwich.getPrice();
            }
        }
        if (drinkList != null) {
            for (Drink drink : drinkList) {
                totalCost += drink.getPrice();
            }
        }
        if (chipsList != null) {
            for (Chips chips : chipsList) {
                totalCost += chips.getPrice();
            }
        }
        return totalCost;
    }

    public void checkout() {
        System.out.println("Please enter the name for the order:");
        String userOrderName = scanner.nextLine().trim();
        Order order = new Order(userOrderName, sandwichList, drinkList, chipsList);

        System.out.println(order);

        System.out.println("Please verify order is correct (Y/N)");
        boolean userConfirmation = scanner.nextLine().trim().equalsIgnoreCase("Y");
        if (userConfirmation) {
            System.out.println("Your order has been confirmed!");
            ReceiptFileManager.writeToFile(order);
        }else {
            System.out.println("Your order will be cancelled or modified\n");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ORDER SUMMARY ===\n");
        sb.append("Name: ").append(name).append("\n");

        sb.append(" Sandwiches:");
        if (sandwichList != null && !sandwichList.isEmpty()) {
            for (Sandwich sandwich : sandwichList) {
                sb.append(sandwich).append("\n");
            }
        } else {
            sb.append(" - None\n");
        }

        sb.append("\nDrinks:\n");
        if (drinkList != null && !drinkList.isEmpty()) {
            for (Drink drink : drinkList) {
                sb.append(" - ").append(drink).append("\n");
            }
        } else {
            sb.append(" - None\n");
        }

        sb.append("\nChips:\n");
        if (chipsList != null && !chipsList.isEmpty()) {
            for (Chips chip : chipsList) {
                sb.append(" - ").append(chip).append("\n");
            }
        } else {
            sb.append(" - None\n");
        }

        sb.append("\nTotal Price: $").append(String.format("%.2f", getPrice())).append("\n");
        sb.append("======================");

        return sb.toString();
    }
}
