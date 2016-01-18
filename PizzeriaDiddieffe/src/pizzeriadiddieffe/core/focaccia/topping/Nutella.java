package pizzeriadiddieffe.core.focaccia.topping;

import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.focaccia.FocacciaDecorator;

public class Nutella extends FocacciaDecorator  {
	Focaccia tempFocaccia;
	private final static double PRICE = 1.00;

	public Nutella(Focaccia myFocaccia){
		tempFocaccia = myFocaccia; 
	}

	@Override
	public String getInfo() {
		return tempFocaccia.getInfo()+", Nutella";
	}

	@Override
	public double getPrice() {
		return tempFocaccia.getPrice()+PRICE;
	}
}