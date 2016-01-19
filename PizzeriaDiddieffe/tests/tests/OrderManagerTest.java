package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.OrderManager;

public class OrderManagerTest {
	private Order fakeOrder;
	private OrderManager fakeOrderManager;

	@Before
	public void setUp(){
		fakeOrder = new Order();
		fakeOrderManager = new OrderManager();
	}

	@Test
	public void CheckOrderTrueIdTest() {
		String fakeId = "fakeid";
		fakeOrder = fakeOrderManager.checkOrder(fakeId);
		assertEquals(fakeId, fakeOrder.getId());
	}

	@Test
	public void CheckOrderFalseIdTest() {
		String fakeId = "fakeid";
		String wrongId = "wrongid";
		fakeOrder = fakeOrderManager.checkOrder(fakeId);
		assertNotEquals(wrongId, fakeOrder.getId());
	}

	@Test
	public void CheckOrderSameObjectTest() {
		String fakeId = "fakeid";
		Order myOrder = fakeOrderManager.checkOrder(fakeId);
		fakeOrder = fakeOrderManager.checkOrder(fakeId);
		assertSame(myOrder, fakeOrder);
	}
}