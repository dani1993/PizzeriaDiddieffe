package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class Mushroms extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.5;

	public Mushroms(Pizza myPizza){
		tempPizza = myPizza; 
		}

	@Override
	public String getInfo() {
		return tempPizza.getInfo() + ", Mushroms";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}
