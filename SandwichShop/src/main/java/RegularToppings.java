import java.util.List;

public class RegularToppings extends Toppings{

    public static List<String> regularToppingList = List.of(
            "Lettuce",
            "Peppers",
            "Onions",
            "Tomatoes",
            "Jalapenos",
            "Cucumbers",
            "Pickles",
            "Guacamole",
            "Mushrooms");

    public RegularToppings(String name) {
        super(name, false, 0.0);
    }
}
