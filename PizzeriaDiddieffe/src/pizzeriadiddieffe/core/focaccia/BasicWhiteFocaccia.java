package pizzeriadiddieffe.core.focaccia;

import pizzeriadiddieffe.core.focaccia.Focaccia;

public class BasicWhiteFocaccia extends Focaccia {
	private final static double PRICE = 4;
	private final static String INFO = "White dough focaccia";
	
	@Override
	public String getInfo(){
		return INFO;
	}
	
	@Override
	public double getPrice() {
		return PRICE;
	}
}