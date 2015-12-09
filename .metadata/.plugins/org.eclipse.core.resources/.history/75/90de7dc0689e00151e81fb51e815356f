package pizzeriadiddieffe.core.beverage.topping;

import pizzeriadiddieffe.core.beverage.Beverage;

public class Beer extends Beverage{
	Beverage tempBeverage;
	private final static double PRICE = 3.00;
	
	public Beer(Beverage mybeverage){
		tempBeverage=mybeverage;
	}
	
	@Override
	public String getInfo() {
		return tempBeverage.getInfo() + ", Beer";
	}
	
	@Override
	public double getPrice() {
		return tempBeverage.getPrice()+PRICE;
	}

}
