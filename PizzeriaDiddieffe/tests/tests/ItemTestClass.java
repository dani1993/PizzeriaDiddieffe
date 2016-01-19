package tests;

import pizzeriadiddieffe.core.Item;

public class ItemTestClass implements Item{
	private double price=-100.00;
	private String info ="fake item, fake info";

	public ItemTestClass(){
	}

	public ItemTestClass(double price, String info){
		this.price = price;
		this.info = info;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getInfo() {
		return info;
	}

	@Override
	public void add(Item obj) throws Exception {
	}

	@Override
	public void remove(Item obj) throws Exception {
	}
}