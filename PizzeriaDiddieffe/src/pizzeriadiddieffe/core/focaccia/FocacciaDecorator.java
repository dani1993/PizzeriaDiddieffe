package pizzeriadiddieffe.core.focaccia;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.focaccia.Focaccia;

public abstract class FocacciaDecorator extends Focaccia {
	public abstract double getPrice();
	public abstract String getInfo();

	@Override
	public void add(Item obj) throws Exception {
		throw new Exception("It's a leaf");
	}

	@Override
	public void remove(Item obj) throws Exception{
		throw new Exception("It's a leaf");
	}
}