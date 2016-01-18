package pizzeriadiddieffe.core.beverage.topping;

import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.beverage.BeverageDecorator;

public class Beer extends BeverageDecorator{
	Beverage tempBeverage;
	private final static double PRICE = 3.00;

	public Beer(Beverage myBeverage){
		tempBeverage = myBeverage;
	}

	@Override
	public String getInfo() {
		return tempBeverage.getInfo()+", Beer";
	}

	@Override
	public double getPrice() {
		return tempBeverage.getPrice()+PRICE;
	}
}