package pizzeriadiddieffe.core.beverage.topping;

import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.beverage.BeverageDecorator;

public class Water extends BeverageDecorator{
	Beverage tempBeverage;
	private final static double PRICE = 1.00;

	public Water(Beverage myBeverage){
		tempBeverage = myBeverage;
	}

	@Override
	public String getInfo() {
		return tempBeverage.getInfo()+", Water";
	}

	@Override
	public double getPrice() {
		return tempBeverage.getPrice()+PRICE;
	}
}