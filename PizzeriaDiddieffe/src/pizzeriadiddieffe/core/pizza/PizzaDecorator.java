package pizzeriadiddieffe.core.pizza;

import pizzeriadiddieffe.core.Item;

public abstract class PizzaDecorator extends Pizza {
	public abstract double getPrice();
	public abstract String getInfo();

	@Override
	public void add(Item obj) throws Exception {
		throw new Exception("It's a leaf");
	}

	@Override
	public void remove(Item obj) throws Exception {
		throw new Exception("It's a leaf");
	}
}