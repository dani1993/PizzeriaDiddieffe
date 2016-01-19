package pizzeriadiddieffe.core.pizza;

import pizzeriadiddieffe.core.Item;

public abstract class Pizza implements Item{
	public abstract String getInfo();	
	public abstract double getPrice();
}