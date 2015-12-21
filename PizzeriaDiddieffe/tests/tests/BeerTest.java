package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.beverage.EmptyLargeGlass;
import pizzeriadiddieffe.core.beverage.topping.Beer;

public class BeerTest {
	
	private String beer_info="Empty large glass, Beer";
	private double base_beer_price=3.00;
	private double delta_factor=0.0;
	private String actual_beverage_info="";
	
	private Beer my_beer;
	private Beverage my_base_beverage;
	
	@Before
	public void beforetestBeer() {
		EmptyLargeGlass my_empty_large_glass=new EmptyLargeGlass();
		Beer my_beer=new Beer(my_empty_large_glass);
		
		this.my_beer=my_beer;
		this.my_base_beverage=my_empty_large_glass;
		
		actual_beverage_info=this.my_beer.getInfo();
	}
	
	
	@Test
	public void getInfoAfterDecoration() {
		assertEquals(beer_info, actual_beverage_info);
	}
	
	@Test
	public void getInfoBeforeDecoration(){
		String beverage_info=my_base_beverage.getInfo();
		assertNotEquals(beer_info,beverage_info);
	}
	
	
	@Test
	public void getPriceAfterDecoration(){
		double beer_price=my_beer.getPrice();
		double price_expected=base_beer_price+my_base_beverage.getPrice();
		assertEquals(price_expected, beer_price,delta_factor);
	}
	
	@Test
	public void getPriceBeforeDecoration(){
		double beer_price=my_beer.getPrice();
		double beverate_price=my_base_beverage.getPrice();
		assertNotEquals(beer_price,beverate_price,delta_factor);
	}
	
	


}
