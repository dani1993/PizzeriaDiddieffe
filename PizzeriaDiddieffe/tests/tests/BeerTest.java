package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.beverage.EmptyLargeGlass;
import pizzeriadiddieffe.core.beverage.topping.Beer;

public class BeerTest {
	private String beerInfo = "";
	private double baseBeerPrice = 3.00;
	private double deltaFactor = 0.00;
	private String actualBeverageInfo = "";

	private Beer myBeer;
	private Beverage myBaseBeverage;

	@Before
	public void beforetestBeer() {
		EmptyLargeGlass myEmptyLargeGlass = new EmptyLargeGlass();
		Beer myBeer = new Beer(myEmptyLargeGlass);

		this.myBeer = myBeer;
		this.myBaseBeverage = myEmptyLargeGlass;

		actualBeverageInfo = this.myBeer.getInfo();
		beerInfo = myBaseBeverage.getInfo()+", Beer";
	}

	@Test
	public void getInfoAfterDecoration() {
		assertEquals(beerInfo, actualBeverageInfo);
	}

	@Test
	public void getInfoBeforeDecoration(){
		String beverageInfo = myBaseBeverage.getInfo();
		assertNotEquals(beerInfo, beverageInfo);
	}

	@Test
	public void getPriceAfterDecoration(){
		double beerPrice = myBeer.getPrice();
		double priceExpected = baseBeerPrice+myBaseBeverage.getPrice();
		assertEquals(priceExpected, beerPrice, deltaFactor);
	}

	@Test
	public void getPriceBeforeDecoration(){
		double beerPrice = myBeer.getPrice();
		double beveratePrice = myBaseBeverage.getPrice();
		assertNotEquals(beerPrice, beveratePrice, deltaFactor);
	}
}