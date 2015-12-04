package pizzeriadiddieffe.core.focaccia;

import pizzeriadiddieffe.core.focaccia.Focaccia;

public class BasicBrownFocaccia extends Focaccia {
	private final static double PRICE = 4;
	private final static String INFO = "Brown dough focaccia";
	
	@Override
	public String getInfo(){
		return INFO;
	}
	
	@Override
	public double getPrice() {
		return PRICE;
	}
}
