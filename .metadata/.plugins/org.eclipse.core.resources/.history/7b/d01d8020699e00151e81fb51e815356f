package pizzeriadiddieffe.core.beverage.topping;

import pizzeriadiddieffe.core.beverage.Beverage;

public class FizzyWater extends Beverage{
	Beverage tempBeverage;
	private final static double PRICE = 1.00;
	
	public FizzyWater(Beverage mybeverage){
		tempBeverage=mybeverage;
	}
	
	@Override
	public String getInfo() {
		return tempBeverage.getInfo() + ",Fizzy Water";
	}
	
	@Override
	public double getPrice() {
		return tempBeverage.getPrice()+PRICE;
	}
}
