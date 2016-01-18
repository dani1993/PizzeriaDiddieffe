package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class Porcini extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.50;

	public Porcini(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Porcini";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}