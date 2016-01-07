package gui;


import java.util.Iterator;
import java.util.LinkedList;


import pizzeriadiddieffe.core.Order;//non puo essere inserito nel panel dei tavoli, altrimenti creo piu oggetti diversi

public class OrderManager {
	private LinkedList<Order> myOrderList=new LinkedList<Order>();
	
	public void checkOrder(String id) {
		
		if(!orderSearch(id).equals(null)){
			createOrder(id);
		}
		displayOrder(id);

	}

	private Order displayOrder(String id) {
		return orderSearch(id);
	}

	private void createOrder(String id) {
		Order newOrder=new Order();
		newOrder.setId(id);
		myOrderList.add(newOrder);
	}


	private Order orderSearch(String id){
		Iterator<Order> iteratore=getIterator();
		while(iteratore.hasNext()){
			Order order=new Order();
			order=iteratore.next();
			if(order.getId().equals(id)){
				return order;
			}
		}
		return null;
	}
	
	private Iterator<Order> getIterator(){
		return myOrderList.iterator();
	}
}
