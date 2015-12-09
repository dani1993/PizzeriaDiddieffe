package pizzeriadiddieffe.core.beverage.topping;

import pizzeriadiddieffe.core.beverage.Beverage;

public class Water extends Beverage{
	Beverage tempBeverage;
	private final static double PRICE = 1.00;
	
	public Water(Beverage mybeverage){
		tempBeverage=mybeverage;
	}
	
	@Override
	public String getInfo() {
		return tempBeverage.getInfo() + ", Water";
	}
	
	@Override
	public double getPrice() {
		return tempBeverage.getPrice()+PRICE;
	}

}
