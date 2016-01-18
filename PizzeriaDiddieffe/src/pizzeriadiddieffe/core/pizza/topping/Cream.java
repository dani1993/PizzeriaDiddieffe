package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.*;

public class Cream extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 0.50;

	public Cream(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Cream";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}