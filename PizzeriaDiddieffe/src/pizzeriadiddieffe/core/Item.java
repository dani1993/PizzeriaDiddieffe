package pizzeriadiddieffe.core;

public interface Item {
	public double getPrice();
	public String getInfo();
	public void add(Item obj) throws Exception;
	public int remove(Item obj) throws Exception;
}
