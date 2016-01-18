package pizzeriadiddieffe.core.focaccia.topping;

import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.focaccia.FocacciaDecorator;

public class FreshTomato extends FocacciaDecorator  {
	Focaccia tempFocaccia;
	private final static double PRICE = 0.25;

	public FreshTomato(Focaccia myFocaccia){
		tempFocaccia = myFocaccia; 
	}

	@Override
	public String getInfo() {
		return tempFocaccia.getInfo()+", Slices of tomatoes";
	}

	@Override
	public double getPrice() {
		return tempFocaccia.getPrice()+PRICE;
	}
}