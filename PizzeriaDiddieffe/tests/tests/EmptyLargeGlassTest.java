package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.beverage.EmptyLargeGlass;

public class EmptyLargeGlassTest {
	private String basicGlassInfo = "Empty large glass";
	private double basicGlassPrice = 1.00;
	private double deltaFactor = 0.00;

	private EmptyLargeGlass myLargeGlass; 
	private ItemTestClass fakeItem;

	@Before
	public void createLargeGlass() {
		myLargeGlass = new EmptyLargeGlass();
		fakeItem = new ItemTestClass();
	}

	@Test
	public void getInfo() {
		String glassInfo = myLargeGlass.getInfo();
		assertEquals(glassInfo, basicGlassInfo);
	}

	@Test 
	public void getPrice(){
		double glassPrice = myLargeGlass.getPrice();
		assertEquals(basicGlassPrice, glassPrice, deltaFactor);
	}

	@Test(expected = Exception.class)
	public void addItem() throws Exception {
		myLargeGlass.add(fakeItem);
	}

	@Test(expected = Exception.class)
	public void removeItem() throws Exception {
		myLargeGlass.remove(fakeItem);
	}
}