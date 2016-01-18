package pizzeriadiddieffe.core.focaccia;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.focaccia.Focaccia;

public class BasicWhiteFocaccia extends Focaccia {
	private final static double PRICE = 4.00;
	private final static String INFO = "White dough focaccia";

	@Override
	public String getInfo(){
		return INFO;
	}

	@Override
	public double getPrice() {
		return PRICE;
	}

	@Override
	public void add(Item obj) throws Exception {
		throw new Exception("It's a leaf");
	}

	@Override
	public void remove(Item obj) throws Exception{
		throw new Exception("It's a leaf");
	}
}