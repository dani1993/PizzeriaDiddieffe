package pizzeriadiddieffe.core;

import java.util.Iterator;
import java.util.LinkedList;

public class Order implements Item {
	private LinkedList<Item> myOrder;
	
	private Iterator<Item> getIterator(){
		Iterator<Item> myIterator = myOrder.iterator();
		return myIterator;
	}
	
	public LinkedList<Item> getOrderList(){
		return myOrder;
	}
	
	@Override
	public double getPrice() {
		double totPrice = 0;
		Iterator<Item> myIterator = getIterator();
		while(myIterator.hasNext()){
			totPrice = totPrice + myIterator.next().getPrice();
		}
		return totPrice;
	}

	@Override
	public String getInfo() {
		String totInfo = "";
		Iterator<Item> myIterator = getIterator();
		while(myIterator.hasNext()){
			totInfo = totInfo + myIterator.next().getInfo();
		}
		return totInfo;
	}

	@Override
	public void add(Item obj) throws Exception {
		myOrder.add(obj);
	}

	@Override
	public int remove(Item obj) throws Exception {
		try {
			myOrder.remove(obj);
		}
		catch(Exception e){
			System.out.println("Your order is empty");
			return -1;
		}
		return 0;
	}
}