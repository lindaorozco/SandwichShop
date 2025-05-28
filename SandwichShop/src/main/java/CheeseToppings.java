import java.util.List;
import java.util.Scanner;

public class CheeseToppings extends Toppings {

    public static List<String> cheeseList = List.of(
            "American",
            "Swiss",
            "Provolone",
            "Pepper Jack"

    );
    public CheeseToppings(String name, Bread bread, boolean extra) {
        super(name, extra, getPrice(bread, extra));

    }
   private static double getPrice(Bread bread, boolean isExtra){
       return switch (bread.getSize()){
           case "4" -> isExtra ? 1.05 : 0.75;
           case "8" -> isExtra ? 2.10 : 1.50;
           case "12" -> isExtra ? 3.15 : 2.25;
           default -> 0.75;
       };
   }
}
