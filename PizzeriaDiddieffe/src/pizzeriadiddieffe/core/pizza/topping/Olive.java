package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class Olive extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 0.25;

	public Olive(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Olives";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}