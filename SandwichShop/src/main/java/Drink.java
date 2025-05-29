import java.util.List;

public class Drink {

    private String size;
    private String flavor;
    private double price;
    public static List<String> drinkList = List.of(
            "Cola",
            "Pepsi",
            "Sprite",
            "Orange"

    );

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = getPrice();
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
        if (size.equalsIgnoreCase("M")) {
            return 2.50;
        } else if (size.equalsIgnoreCase("L")) {
            return 3.00;
        } else {
            return 2.00;
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", flavor,size,getPrice());
    }
}