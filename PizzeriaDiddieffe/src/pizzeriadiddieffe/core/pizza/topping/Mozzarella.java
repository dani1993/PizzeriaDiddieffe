package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class Mozzarella extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 0.50;

	public Mozzarella(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Mozzarella";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}