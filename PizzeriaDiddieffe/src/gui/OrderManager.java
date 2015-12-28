package gui;

import java.util.Iterator;
import java.util.LinkedList;

import pizzeriadiddieffe.core.Order;

public class OrderManager {
	private LinkedList<Order> myOrderList=new LinkedList();
	
	public void checkOrder(String id) {
		
		if(!checkOrderList(id)){
			createOrder();
		}
		else {
		displayOrder();

		}
	}

	private boolean checkOrderList(String id) {
		Iterator<Order> iteratore=getIterator();
		while(iteratore.hasNext()){
			Order order=new Order();
			order=iteratore.next();
			if(order.getId().equals(id)){
				return true;
			}
		}
		return false;
		
	}
	
	private Iterator<Order> getIterator(){
		return myOrderList.iterator();
	}
}
