package pizzeriadiddieffe.core.beverage;

public class EmptyLittleGlass extends Beverage{
	private final static double PRICE = 0.00;
	private final static String INFO = "Empty little glass";
	
	@Override
	public String getInfo() {
		return INFO;
	}

	@Override
	public double getPrice() {
		return PRICE;
	}

}
