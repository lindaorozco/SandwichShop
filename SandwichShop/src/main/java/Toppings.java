public abstract class Toppings {

    private String name;
    boolean extra;
    private double price;

    public Toppings(String name, boolean extra, double price) {
        this.name = name;
        this.extra = extra;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        extra = extra;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        if(this instanceof RegularToppings){
            return name;
        }
        if (extra) {
            return String.format("%s (extra) - $%.2f", name, price);
        } else {
            return String.format("%s - $%.2f", name, price);
        }
    }

}
