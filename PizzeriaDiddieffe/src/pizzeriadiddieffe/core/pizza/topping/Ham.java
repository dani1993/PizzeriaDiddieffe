package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class Ham extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.00;

	public Ham(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Ham";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}