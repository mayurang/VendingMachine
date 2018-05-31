package Money;

public class NickelClass implements CoinInterface{
	
	    private double weight;
	    private double size;

	    public NickelClass(double weight, double size) {
	        this.weight = weight;
	        this.size = size;
	    }

	    public double getWeight() {
	        return weight;
	    }

	    public double getSize() {
	        return size;
	    }
	}


