package pizzeriadiddieffe.core.focaccia;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.focaccia.Focaccia;

public class Basic5CerealsFocaccia extends Focaccia {
	private final static double PRICE = 4.50;
	private final static String INFO = "Double white dough focaccia";

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