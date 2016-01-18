package pizzeriadiddieffe.core.focaccia.topping;

import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.focaccia.FocacciaDecorator;

public class Rosemary extends FocacciaDecorator  {
	Focaccia tempFocaccia;
	private final static double PRICE = 0.00;

	public Rosemary(Focaccia myFocaccia){
		tempFocaccia = myFocaccia; 
	}

	@Override
	public String getInfo() {
		return tempFocaccia.getInfo()+", Rosemary";
	}

	@Override
	public double getPrice() {
		return tempFocaccia.getPrice()+PRICE;
	}
}