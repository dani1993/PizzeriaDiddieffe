package pizzeriadiddieffe.gui.creators;

import pizzeriadiddieffe.core.Item;

public interface ItemCreatorInterface {
	public void setItemsLists(String[] baseCasesNameList, String[] toppingNameList, String[] currentClassNames);
	public void setCurrentItem(Item currentItem);
	public void createChoseenBaseCase(String className);
	public Item getCurrentItem();
	public void createChoosenToppings(String currentPackage) ;
}