package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class Mushrooms extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.50;

	public Mushrooms(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Mushroms";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}