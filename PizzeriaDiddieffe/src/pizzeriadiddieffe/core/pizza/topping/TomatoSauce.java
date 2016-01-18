package pizzeriadiddieffe.core.pizza.topping;

import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.core.pizza.PizzaDecorator;

public class TomatoSauce extends PizzaDecorator {
	Pizza tempPizza;
	private final static double PRICE = 0.50;

	public TomatoSauce(Pizza myPizza){
		tempPizza = myPizza; 
	}

	@Override
	public String getInfo() {
		return tempPizza.getInfo()+", Tomato sauce";
	}

	@Override
	public double getPrice() {
		return tempPizza.getPrice()+PRICE;
	}
}