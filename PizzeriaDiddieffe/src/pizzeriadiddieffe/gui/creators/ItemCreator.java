package pizzeriadiddieffe.gui.creators;

import pizzeriadiddieffe.core.CreateObjectByName;
import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.pizza.Pizza;

public class ItemCreator implements ItemCreatorInterface{
	private Item currentItem;
	private Object object;
	private CreateObjectByName myCreator;
	private String[] baseCasesNameList;
	private String[] toppingNameList;
	private String[] currentClassNames;
	private String currentClass;

	public ItemCreator(String currentClass){
		this.currentClass = currentClass;
		myCreator = new CreateObjectByName();
	}

	@Override
	public void setItemsLists(String[] baseCasesNameList, String[] toppingNameList, String[] currentClassNames){
		this.toppingNameList = toppingNameList;
		this.currentClassNames = currentClassNames;
		this.baseCasesNameList = baseCasesNameList;
	}

	@Override
	public void setCurrentItem(Item currentItem){
		this.currentItem = currentItem;
	}

	@Override
	public void createChoseenBaseCase(String className) {
		String currentclassName = getClassName(className, baseCasesNameList);
		final String fullPackagePath = "pizzeriadiddieffe.core."+currentClass+"."+currentclassName;

		try {
			object = myCreator.createObjectByName(fullPackagePath);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		currentItem = ((Item) object);
	}

	@Override
	public Item getCurrentItem(){
		return currentItem;
	}

	private String getClassName(String className, String[] nameList) {
		for(int i = 0; i<currentClassNames.length; i++){
			if(nameList[i].equals(className)){
				if(nameList.equals(toppingNameList)){
					return currentClassNames[i+baseCasesNameList.length];
				}
				return currentClassNames[i];
			}
		}
		return null;
	}

	@Override
	public void createChoosenToppings(String currentPackage) {
		currentPackage = getClassName(currentPackage, toppingNameList);
		String fullPackagePath = "pizzeriadiddieffe.core."+currentClass+".topping."+currentPackage;

		try {
			object = myCreator.createToppingByName(fullPackagePath, currentItem, currentClass);
		} catch (Exception exception) {
			System.out.println(currentItem.getPrice());
			System.out.println("errore");
		}
		castToCurrentClass(currentClass);
	}

	private void castToCurrentClass(String currentClass) {
		if (currentClass.equals("pizza")) {
			currentItem = (Pizza) object;
			return;
		} else if (currentClass.equals("beverage")) {
			currentItem = (Beverage) object;
			return;
		}
		currentItem = (Focaccia) object;
		return;
	}
}