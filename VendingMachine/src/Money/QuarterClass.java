package Money;

public class QuarterClass implements CoinInterface{
	

	    private double weight;
	    private double size;

	    public QuarterClass(double weight, double size) {
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


