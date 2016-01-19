package pizzeriadiddieffe.core;

import java.util.Iterator;
import java.util.LinkedList;

public class Order implements Item {
	private LinkedList<Item> myOrder = new LinkedList<Item>();
	private String id;

	private Iterator<Item> getIterator(){
		Iterator<Item> myIterator = myOrder.iterator();
		return myIterator;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public LinkedList<Item> getOrderList(){
		return myOrder;
	}

	@Override
	public double getPrice() {
		double totPrice = 0;
		Iterator<Item> myIterator = getIterator();
		while(myIterator.hasNext()){
			totPrice = totPrice+myIterator.next().getPrice();
		}
		return totPrice;
	}

	@Override
	public String getInfo() {
		String totInfo = "";
		Iterator<Item> myIterator = getIterator();
		while(myIterator.hasNext()){
			totInfo = totInfo+myIterator.next().getInfo();
		}
		return totInfo;
	}

	@Override
	public void add(Item obj) throws Exception {
		myOrder.add(obj);
	}

	@Override
	public void remove(Item obj) throws Exception {
		if(!myOrder.contains(obj)){
			throw new Exception ("Order is empty!");
		}
		myOrder.remove(obj);
	}

	public void deleteAll() {
		myOrder.removeAll(getOrderList());	
	}

	public void deleteIndex(int i) throws Exception{
		if(i>myOrder.size()){
			throw new Exception("Can't remove that!");
		}else{
			myOrder.remove(i);
		}
	}
}