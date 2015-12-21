package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.beverage.EmptyLargeGlass;

public class EmptyLargeGlassTest {
	
	private EmptyLargeGlass my_large_glass; 
	private String basic_glass_info="Empty large glass";
	private double basic_glass_price=1.00;
	private double delta_factor=0.0;
	
	private ItemTestClass fake_item;

	@Before
	public void createLargeGlass() {
		my_large_glass=new EmptyLargeGlass();
		fake_item=new ItemTestClass();
	}
	
	@Test
	public void getInfo() {
		String glass_info=my_large_glass.getInfo();
		assertEquals(glass_info,basic_glass_info);
	}

	@Test 
	public void getPrice(){
		double glass_price=my_large_glass.getPrice();
		assertEquals(basic_glass_price,glass_price,delta_factor);
	}
	
	@Test(expected=Exception.class)
	public void addItem() throws Exception {
		my_large_glass.add(fake_item);
	}
	
//	@Test(expected=Exception.class)
//	public void removeItem() throws Exception {
//		my_large_glass.remove(fake_item);
//	}
	
}
