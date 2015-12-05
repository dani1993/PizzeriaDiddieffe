package pizzeriadiddieffe.core.beverage.topping;

import pizzeriadiddieffe.core.beverage.Beverage;

public class Fanta extends Beverage {
	Beverage tempBeverage;
	private final static double PRICE = 2.00;
	
	public Fanta(Beverage mybeverage){
		tempBeverage=mybeverage;
	}
	
	@Override
	public String getInfo() {
		return tempBeverage.getInfo() + ", Fanta";
	}
	
	@Override
	public double getPrice() {
		return tempBeverage.getPrice()+PRICE;
	}
}
