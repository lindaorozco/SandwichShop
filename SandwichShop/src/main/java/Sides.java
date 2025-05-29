import java.util.List;

public class Sides {
    private String name;

    public static List<String>sidesList = List.of(
            "Au jus",
            "Sauce"
    );

    public Sides(String name) {
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
