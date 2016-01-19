package pizzeriadiddieffe.core;

import java.lang.reflect.Constructor;

import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.pizza.Pizza;

public  class CreateObjectByName implements ItemsCreatorInterface{
	@Override
	public Object createObjectByName (String className) throws Exception{
		Class<?> clazz = Class.forName(className);
		Constructor<?> ctor = clazz.getConstructor();
		Object object = ctor.newInstance(new Object[] {});

		return object;
	}

	@Override
	public Object createToppingByName(String className, Item baseItem, String type) throws Exception {
		if (type.equals("pizza")) {
			baseItem = (Pizza) baseItem;
			Class<?> clazz = Class.forName(className);
			Constructor<?> ctor = clazz.getConstructor(Pizza.class);
			Object object = ctor.newInstance(new Object[] { baseItem });

			return object;
		} else if (type.equals("beverage")) {
			baseItem = (Beverage) baseItem;
			Class<?> clazz = Class.forName(className);
			Constructor<?> ctor = clazz.getConstructor(Beverage.class);
			Object object = ctor.newInstance(new Object[] { baseItem });

			return object;
		}

		baseItem = (Focaccia) baseItem;
		Class<?> clazz = Class.forName(className);
		Constructor<?> ctor = clazz.getConstructor(Focaccia.class);
		Object object = ctor.newInstance(new Object[] { baseItem });

		return object;
	}
}