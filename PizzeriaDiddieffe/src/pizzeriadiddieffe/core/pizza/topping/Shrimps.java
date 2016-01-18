package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.*;

public class Shrimps extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.50;

	public Shrimps(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Shrimps";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}