package pizzeriadiddieffe.core.beverage.topping;

import pizzeriadiddieffe.core.beverage.*;

public  class CocaCola extends BeverageDecorator{
	Beverage tempBeverage;
	private final static double PRICE = 2.00;

	public CocaCola(Beverage myBeverage){
		tempBeverage = myBeverage;
	}

	@Override
	public String getInfo() {
		return tempBeverage.getInfo()+", CocaCola";
	}

	@Override
	public double getPrice() {
		return tempBeverage.getPrice()+PRICE;
	}
}