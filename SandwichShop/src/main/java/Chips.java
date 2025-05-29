import java.util.List;
import java.util.Scanner;

public class Chips {

   private static Scanner scanner = new Scanner(System.in);
   private double price;
   private String name;
   public static List<String> chipsList = List.of(
           "Cheetos",
           "Doritos",
           "Lays"
   );

    public Chips(String name) {
        this.price = 1.50;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", name,price);
    }
}
