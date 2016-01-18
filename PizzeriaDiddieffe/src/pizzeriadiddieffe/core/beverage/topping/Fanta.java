package pizzeriadiddieffe.core.beverage.topping;

import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.beverage.BeverageDecorator;

public class Fanta extends BeverageDecorator {
	Beverage tempBeverage;
	private final static double PRICE = 2.00;

	public Fanta(Beverage myBeverage){
		tempBeverage = myBeverage;
	}

	@Override
	public String getInfo() {
		return tempBeverage.getInfo()+", Fanta";
	}

	@Override
	public double getPrice() {
		return tempBeverage.getPrice()+PRICE;
	}
}