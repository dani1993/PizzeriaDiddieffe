package pizzeriadiddieffe.core.focaccia.topping;

import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.focaccia.FocacciaDecorator;

public class FreshMozzarella extends FocacciaDecorator  {
	Focaccia tempFocaccia;
	private final static double PRICE = 0.50;

	public FreshMozzarella(Focaccia myFocaccia){
		tempFocaccia = myFocaccia; 
	}

	@Override
	public String getInfo() {
		return tempFocaccia.getInfo()+", Slices of Mozzarella";
	}

	@Override
	public double getPrice() {
		return tempFocaccia.getPrice()+PRICE;
	}
}