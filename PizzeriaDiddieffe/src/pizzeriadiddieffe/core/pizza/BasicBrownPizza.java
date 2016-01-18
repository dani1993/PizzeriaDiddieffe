package pizzeriadiddieffe.core.pizza;

import pizzeriadiddieffe.core.Item;

public class BasicBrownPizza extends Pizza {
	private final static double PRICE = 3.75;
	private final static String INFO = "Brown dough pizza";

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