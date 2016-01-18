package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class Tuna extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.25;

	public Tuna(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Tuna";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}