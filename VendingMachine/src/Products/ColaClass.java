package Products;

public class ColaClass implements ProductsInterface {
	 private double price;
	    private int quantity;

	    public ColaClass(double price, int quantity) {
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


