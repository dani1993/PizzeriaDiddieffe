package pizzeriadiddieffe.core.pizza;

import pizzeriadiddieffe.core.Item;

public class BasicWhitePizza extends Pizza {
	private final static double PRICE = 3.50;
	private final static String INFO = "White dough pizza";

	@Override
	public String getInfo(){
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