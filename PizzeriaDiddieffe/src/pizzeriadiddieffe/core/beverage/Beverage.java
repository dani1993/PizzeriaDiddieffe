package pizzeriadiddieffe.core.beverage;

import pizzeriadiddieffe.core.Item;

public abstract class Beverage implements Item {
	public abstract String getInfo();	
	public abstract double getPrice();
}