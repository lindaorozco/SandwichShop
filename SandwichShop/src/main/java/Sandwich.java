import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    Scanner scanner = new Scanner(System.in);
    private boolean toasted;
    private double price;
    private Bread bread;
    private List<Toppings> toppings;
    private List<Sauces> sauces;
    private List<Sides> sides;



    public Sandwich(){}

    public Sandwich(Bread bread, boolean toasted,List<Toppings> toppings, List<Sides>sides, List<Sauces>sauces) {
        this.toasted = toasted;
        this.bread = bread;
        this.toppings = toppings;
        this.sauces = sauces;
        this.sides = sides;
        this.price = getPrice();

    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public double getPrice() {
        double sandwichPrice = 0.0;
        sandwichPrice += bread.getPrice(bread.getSize());

        if(toppings != null){
            for (Toppings topping : toppings){
                sandwichPrice += topping.getPrice();
            }
        }
        return sandwichPrice;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

    public Sandwich createSandwich (){
        Bread bread = createBread();
        List<Toppings> toppingsList = toppingsPrompt(bread);
        List<Sauces> saucesList = addSauces();
        List<Sides> sidesList = addSides();

        System.out.println("Would you like it toasted?");
        boolean toasted = scanner.nextLine().trim().equalsIgnoreCase("Y");

        return new Sandwich(bread,toasted,toppingsList, sidesList, saucesList);
    }
    public List<Toppings> toppingsPrompt(Bread bread){
        //Topping Prompts
        List<Toppings> toppingsList = new ArrayList<>();

        boolean selectionProcess = true;

        while (selectionProcess) {

            System.out.println("""
                    What topping you would like to add:
                    1. Meat Toppings.
                    2. Cheese Toppings.
                    3. Regular Toppings.
                    0. Done
                    """);
            try {
                int userToppingSelect = Integer.parseInt(scanner.nextLine().trim());
                switch (userToppingSelect) {
                    case 1 -> toppingsList.addAll(createMeatTopping(bread));
                    case 2 -> toppingsList.addAll(createCheeseTopping(bread));
                    case 3 -> toppingsList.addAll(regularTopping());
                    case 0 -> {
                        System.out.println("Done selecting Toppings");
                        selectionProcess = false;}
                    default -> System.out.println("Wrong input please try again");}
            }catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");}
        }
        return toppingsList;
    }
    public Bread createBread (){

        System.out.println("\nWhat kinda of bread would you like?\n");
        Bread.breadTypeList.forEach(System.out :: println);
        String userBreadType = scanner.nextLine().trim();
        System.out.println("What inch size of bread would you like? (4, 8, 12) ");
        String userBreadSize = scanner.nextLine().trim();

        return new Bread(userBreadType,userBreadSize);
    }

    public List<MeatToppings> createMeatTopping(Bread bread){
        List<MeatToppings> meatToppingsList = new ArrayList<>();
        while (true) {
            System.out.println("What kind of meat would you like? (type 'done' to go back)");
            MeatToppings.meatList.forEach(System.out :: println);
            String userMeat = scanner.nextLine().trim();

            if(userMeat.equalsIgnoreCase("done")) break;
            if (MeatToppings.meatList.contains(userMeat)){
                System.out.println("Would you like extra meat for an additional price? (Y/N)");
                boolean extraMeat = scanner.nextLine().trim().equalsIgnoreCase("Y");
                MeatToppings meatTopping = new MeatToppings(userMeat,bread, extraMeat);
                meatToppingsList.add(meatTopping);

                System.out.printf("Added: %s - $%.2f\n", userMeat, meatTopping.getPrice());
            }else {
                System.out.println("Sorry, we don't have this meat topping. Try again.");

            }
        }
        return meatToppingsList;
    }

    public List<CheeseToppings> createCheeseTopping(Bread bread){
        List<CheeseToppings> cheeseToppingsList = new ArrayList<>();
        while (true) {
            System.out.println("What kind of cheese would you like? (type 'done' to go back)");
            CheeseToppings.cheeseList.forEach(System.out :: println);
            String userCheese = scanner.nextLine().trim();

            if(userCheese.equalsIgnoreCase("done")) break;
            if (CheeseToppings.cheeseList.contains(userCheese)){
                System.out.println("Would you like extra cheese for an additional price? (Y/N)");
                boolean extraCheese = scanner.nextLine().trim().equalsIgnoreCase("Y");
                CheeseToppings cheeseTopping = new CheeseToppings(userCheese,bread, extraCheese);
                cheeseToppingsList.add(cheeseTopping);

                System.out.printf("Added: %s - $%.2f\n", userCheese, cheeseTopping.getPrice());
            } else {
                System.out.println("Sorry, we don't have this cheese topping. Try again.");
            }
        }
        return cheeseToppingsList;
    }
    public List<RegularToppings> regularTopping(){
        List<RegularToppings> regularToppingsList = new ArrayList<>();
        while (true) {
            System.out.println("Please select a Regular topping (type 'done' to go back):");
            RegularToppings.regularToppingList.forEach(System.out::println);

            String userRegularTopping = scanner.nextLine().trim();

            if(userRegularTopping.equalsIgnoreCase("done")) break;

            if(RegularToppings.regularToppingList.contains(userRegularTopping)){
                RegularToppings regularTopping = new RegularToppings(userRegularTopping);
                regularToppingsList.add(regularTopping);

                System.out.printf("Added: %s\n", userRegularTopping);
            }else {
                System.out.println("Sorry, we don't have this topping. Try again.");
            }
        }
        return regularToppingsList;
    }
    public List<Sauces> addSauces(){
        List<Sauces> saucesList = new ArrayList<>();
        while(true) {
            System.out.println("Please select a Sauce (type 'done' to go back):");
            Sauces.saucesList.forEach(System.out::println);

            String userSauce = scanner.nextLine().trim();

            if(userSauce.equalsIgnoreCase("done")) break;

            if(Sauces.saucesList.contains(userSauce)){
                Sauces sauce = new Sauces(userSauce);

                saucesList.add(sauce);

                System.out.printf("Added: %s\n", userSauce);
            } else {
                System.out.println("Sorry we don't have this sauce.");
            }
        }
        return saucesList;
    }
    public List<Sides> addSides(){
        List<Sides> sidesList = new ArrayList<>();
        while (true) {
            System.out.println("Please select a side (type 'done' to go back):");
            Sides.sidesList.forEach(System.out::println);

            String userSide = scanner.nextLine().trim();

            if(userSide.equalsIgnoreCase("done")) break;

            if(Sides.sidesList.contains(userSide)){
                Sides side = new Sides(userSide);
                sidesList.add(side);
                System.out.printf("Added: %s\n", userSide);
            } else {
                System.out.println("Sorry we don't have this sauce");
            }
        }
        return sidesList;
    }
    // fix this at the end

    @Override
    public String toString() {
        return
               "\nBread: " + bread.getType() + " (" + bread.getSize() + " inch)" +
               "\nToasted: " + toasted +
               "\nToppings: " + (toppings.isEmpty() ? "None" : toppings) +
               "\nSauces: " + (sauces.isEmpty() ? "None" : sauces) +
               "\nSides: " + (sides.isEmpty() ? "None" : sides) +
               "\nTotal Price: $" + String.format("%.2f", getPrice());
    }

}




