package Products;

public class CandyClass implements ProductsInterface {

    private double price;
    private int quantity;

    public CandyClass(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
