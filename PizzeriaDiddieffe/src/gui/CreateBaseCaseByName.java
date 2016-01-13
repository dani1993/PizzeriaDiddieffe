package gui;

import java.lang.reflect.Constructor;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.pizza.Pizza;

public class CreateBaseCaseByName{
	private Class myclass;
	
	public Object createObjectByName (String className) throws Exception{
		Class<?> clazz = Class.forName(className);
		Constructor<?> ctor = clazz.getConstructor();
		Object object = ctor.newInstance(new Object[] {  });
		
		return object;
	}
	
	public Object createToppingByName (String className,Item baseItem,Class consClass) throws Exception{
		Class<?> clazz = Class.forName(className);
		Constructor<?> ctor = clazz.getConstructor(consClass.getClass());
		Object object = ctor.newInstance(new Object[] { baseItem });
	return object;
}
	
}
