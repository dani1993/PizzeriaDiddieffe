package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.*;

public class BufalaMozzarella extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 1.00;

	public BufalaMozzarella(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Bufala mozzarella";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}