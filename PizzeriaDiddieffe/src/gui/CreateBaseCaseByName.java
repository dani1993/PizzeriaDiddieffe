package gui;

import java.lang.reflect.Constructor;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.pizza.Pizza;

public  class CreateBaseCaseByName{
	
	public Object createObjectByName (String className) throws Exception{
		Class<?> clazz = Class.forName(className);
		Constructor<?> ctor = clazz.getConstructor();
		Object object = ctor.newInstance(new Object[] {  });
		
		return object;
	}
	
	public  Object createToppingByName (String className,Item baseItem,String type)throws Exception{
		baseItem=getType(type,baseItem);
		baseItem=(Pizza)baseItem;
		Class<?> clazz = Class.forName(className);
		Constructor<?> ctor = clazz.getConstructor(Pizza.class);
		Object object = ctor.newInstance(new Object[] { baseItem });
		
		return object;
	}

	private Item getType(String type,Item myItem) {
		if(type.equals("pizza")){
			return myItem=(Pizza)myItem;
		}
		else if(type.equals("beverage")){
			return myItem=(Beverage)myItem;
		}
		
		return myItem=(Focaccia)myItem;
	}
		
	
}
