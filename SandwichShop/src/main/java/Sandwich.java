import java.util.ArrayList;

public class Sandwich {

    private String breadType;
    private String size;
    private boolean isToasted;
    private double price;
    ArrayList<Toppings> toppings;


    public Sandwich(String breadType, String size, boolean isToasted, double price, ArrayList<Toppings> toppings) {
        this.breadType = breadType;
        this.size = size;
        this.isToasted = isToasted;
        this.price = price;
        this.toppings = toppings;

    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Sandwich" + " | " +
                "price=" + price +
                ", isToasted=" + isToasted +
                ", size='" + size + '\'' +
                ", breadType='" + breadType + '\'' +
                '}';
    }

}
