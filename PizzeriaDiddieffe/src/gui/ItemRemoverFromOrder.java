package gui;

import pizzeriadiddieffe.core.Item;

public class ItemRemoverFromOrder {
	
	private CreateBaseCaseByName myCopingItem=new CreateBaseCaseByName();
	
	public Item removeItem(Item currentItem,String itemName,String itemType){
		String itemInfo=currentItem.getInfo();
		String currentString=itemInfo.replaceAll(", "+itemType, " ");
		System.out.println("classe da rimuovere"+ itemName);
		System.out.println("classi da creare "+currentString);
		
		
		
		return currentItem;
	}

}
