package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.*;

public class Artichokes extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.00;

	public Artichokes(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Artichokes";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}