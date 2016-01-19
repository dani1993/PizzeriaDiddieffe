
package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;

public class OrderTest {	
	private double deltaFactor = 0.0;
	private double baseOrderPrice = 0.0;
	private String baseOrderInfo = "";

	private Order myOrder;
	private ItemTestClass fakeItem;
	private double fakePrice = 1.00;
	private String fakeInfo = "fake info";

	@Before
	public void test() {
		myOrder = new Order();
		fakeItem = new ItemTestClass(fakePrice, fakeInfo);
	}

	@Test
	public void emptyOrderList() {
		LinkedList<Item> myList = myOrder.getOrderList();
		assertTrue(myList.isEmpty());
	}

	@Test(expected = Exception.class)
	public void removeItemFromList() throws Exception{
		removeItemToOrderList();
	}

	private void addItemToOrderList() throws Exception {
		myOrder.add(fakeItem);
	}

	private void removeItemToOrderList() throws Exception {
		myOrder.remove(fakeItem);
	}

	@Test
	public void addAndremoveItemFromList() throws Exception{
		addItemToOrderList();
		removeItemToOrderList();
		LinkedList<Item> myList=myOrder.getOrderList();
		assertTrue(myList.isEmpty());
	}

	@Test
	public void addItemToList() throws Exception{
		addItemToOrderList();
	}

	@Test
	public void getOrderBasePrice(){
		double basePrice = myOrder.getPrice();
		assertEquals(baseOrderPrice, basePrice, deltaFactor);
	}

	@Test
	public void getOrderCurrentPrice() throws Exception{
		addItemToOrderList();
		double currentOrderPrice = myOrder.getPrice();
		double fakeItemPrice = fakeItem.getPrice();
		assertEquals(fakeItemPrice, currentOrderPrice, deltaFactor);
	}

	@Test
	public void getBaseOrderInfo(){
		String myOrderInfo = myOrder.getInfo();
		assertEquals(baseOrderInfo, myOrderInfo);
	}

	@Test 
	public void getCurrentOrderInfo() throws Exception{
		addItemToOrderList();
		String fakeItemInfo = fakeItem.getInfo();
		String currentOrderInfo = myOrder.getInfo();
		assertEquals(fakeItemInfo, currentOrderInfo);
	}

	@Test
	public void checkPriceAfterRemove() throws Exception{
		double basePrice = myOrder.getPrice();
		addItemToOrderList();
		removeItemToOrderList();
		double currentPrice = myOrder.getPrice();
		assertEquals(basePrice, currentPrice, deltaFactor);
	}

	@Test
	public void checkInfoAfterRemove() throws Exception{
		String baseInfo = myOrder.getInfo();
		addItemToOrderList();
		removeItemToOrderList();
		String currentInfo = myOrder.getInfo();
		assertEquals(baseInfo, currentInfo);
	}

	@Test 
	public void removeItemFromOrder() throws Exception{
		myOrder.add(fakeItem);
		myOrder.deleteIndex(0);
		assertEquals(0, myOrder.getOrderList().size());
	}

	@Test (expected = Exception.class)
	public void removeItemFromEmptyOrder() throws Exception{
		myOrder.deleteIndex(1);
	}

	@Test 
	public void removeAllItemsFromOrder() throws Exception{
		myOrder.add(fakeItem);
		myOrder.add(fakeItem);
		myOrder.deleteAll();
		assertEquals(0, myOrder.getOrderList().size());
	}

	@Test 
	public void removeAllItemsFromEmptyOrder() throws Exception{
		myOrder.deleteAll();
		assertEquals(0, myOrder.getOrderList().size());
	}
}