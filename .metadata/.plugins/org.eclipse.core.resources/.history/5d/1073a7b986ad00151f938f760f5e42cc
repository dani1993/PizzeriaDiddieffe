package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;

public class OrderTest {
	
	private double delta_factor=0.0;
	private double base_order_price=0.0;
	private String base_order_info="";
	
	private Order my_order;
	private ItemTestClass fake_item;
	private double fake_price=1.00;
	private String fake_info="fake info";
	
	@Before
	public void test() {
		my_order = new Order();
		fake_item=new ItemTestClass(fake_price,fake_info);
	}

	
	@Test
	public void emptyOrderList() {
		LinkedList<Item> my_list=my_order.getOrderList();
		assertTrue(my_list.isEmpty());
	}
	
	@Test(expected=Exception.class)
	public void removeItemFromList() throws Exception{
		removeItemToOrderList();
	}

	
	private void addItemToOrderList() throws Exception {
		my_order.add(fake_item);
	}
	
	
	private void removeItemToOrderList() throws Exception {
		my_order.remove(fake_item);
	}
	
	
	@Test
	public void addAndremoveItemFromList() throws Exception{
		addItemToOrderList();
		removeItemToOrderList();
		LinkedList<Item> my_list=my_order.getOrderList();
		assertTrue(my_list.isEmpty());
	}
	
	
	@Test
	public void addItemToList() throws Exception{
		addItemToOrderList();
	}
	
	@Test
	public void getOrderBasePrice(){
		double base_price=my_order.getPrice();
		assertEquals(base_order_price, base_price,delta_factor);
	}
	
	@Test
	public void getOrderCurrentPrice() throws Exception{
		addItemToOrderList();
		double current_order_price=my_order.getPrice();
		double fake_item_price=fake_item.getPrice();
		assertEquals(fake_item_price,current_order_price,delta_factor);
	}
	
	@Test
	public void getBaseOrderInfo(){
		String my_order_info=my_order.getInfo();
		assertEquals(base_order_info, my_order_info);
	}
	
	@Test 
	public void getCurrentOrderInfo() throws Exception{
		addItemToOrderList();
		String fake_item_info=fake_item.getInfo();
		String current_order_info=my_order.getInfo();
		assertEquals(fake_item_info, current_order_info);
	}
	
	@Test
	public void checkPriceAfterRemove() throws Exception{
		double base_price=my_order.getPrice();
		addItemToOrderList();
		removeItemToOrderList();
		double current_price=my_order.getPrice();
		assertEquals(base_price,current_price,delta_factor);
	}
	
	@Test
	public void checkInfoAfterRemove() throws Exception{
		String base_info=my_order.getInfo();
		addItemToOrderList();
		removeItemToOrderList();
		String current_info=my_order.getInfo();
		assertEquals(base_info,current_info);
	}
	
	

}
