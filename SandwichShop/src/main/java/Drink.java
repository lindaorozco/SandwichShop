import java.util.Scanner;

public class Drink {

    static Scanner scanner = new Scanner(System.in);

    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor, double price) {
        this.size = size;
        this.flavor = flavor;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String drinkFlavor(){
        System.out.println("What drink would you like?");
        System.out.println("(1.) Cola \n (2.) Lemonade \n (3.) Orange\n (4.) Sprite");
        String userFlavor = scanner.nextLine();

        switch (userFlavor){
            case "1" -> {
                return "Cola"; }
            case "2" -> {
                return "Lemonade";}
            case "3" -> {
                return "Orange";}
            case "4" -> {
                return "Sprite";}
            default -> System.out.println("Invalid entry. Please try again");
        }
        return userFlavor;
    }
    
    public static void drinkSize(){
        System.out.println();
    }
}
