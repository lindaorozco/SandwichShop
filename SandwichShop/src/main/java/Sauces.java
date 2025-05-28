import java.util.ArrayList;
import java.util.List;
public class Sauces {
    private String name;
    public static List<String> saucesList = List.of(
            "Mayo",
            "Mustard",
            "Ketchup",
            "Ranch",
            "Thousand island",
            "Vinaigrette");

    public Sauces(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

