package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.*;

public class Anchovy extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.50;

	public Anchovy(Pizza myPizza) {
		tempPizza = myPizza;
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Anchovy";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}