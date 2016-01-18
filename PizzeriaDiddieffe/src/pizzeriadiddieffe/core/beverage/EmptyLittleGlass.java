package pizzeriadiddieffe.core.beverage;

import pizzeriadiddieffe.core.Item;

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

	@Override
	public void add(Item obj) throws Exception {
		throw new Exception("It's a leaf");
	}

	@Override
	public void remove(Item obj) throws Exception{
		throw new Exception("It's a leaf");
	}
}