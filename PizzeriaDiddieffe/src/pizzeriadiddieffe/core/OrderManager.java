package pizzeriadiddieffe.core;

import java.util.Iterator;
import java.util.LinkedList;

public class OrderManager implements OrderManagerInterface {
	private LinkedList<Order> myOrderList = new LinkedList<Order>();

	@Override
	public Order checkOrder(String id) {
		return orderSearch(id);
	}

	private Order createOrder(String id) {
		Order newOrder = new Order();
		newOrder.setId(id);
		myOrderList.add(newOrder);
		return newOrder;
	}

	private Order orderSearch(String id){
		Iterator<Order> iteratore = getIterator();
		Order order = new Order();
		while(iteratore.hasNext()){
			order=iteratore.next();
			if(order.getId().equals(id)){
				return order;
			}
		}
		return createOrder(id);
	}

	private Iterator<Order> getIterator(){
		return myOrderList.iterator();
	}
}