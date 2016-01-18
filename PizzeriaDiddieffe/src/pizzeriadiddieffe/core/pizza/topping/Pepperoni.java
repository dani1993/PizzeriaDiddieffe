package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class Pepperoni extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.00;

	public Pepperoni(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Pepperoni";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}