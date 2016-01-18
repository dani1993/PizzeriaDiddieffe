package pizzeriadiddieffe.core.focaccia.topping;

import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.focaccia.FocacciaDecorator;

public class Sausage extends FocacciaDecorator  {
	Focaccia tempFocaccia;
	private final static double PRICE = 1.00;

	public Sausage(Focaccia myFocaccia){
		tempFocaccia = myFocaccia; 
	}

	@Override
	public String getInfo() {
		return tempFocaccia.getInfo()+", Sausage";
	}

	@Override
	public double getPrice() {
		return tempFocaccia.getPrice()+PRICE;
	}
}