package pizzeriadiddieffe.core;

public interface Item {
	double getPrice();
	String getInfo();
	void add(Item obj) throws Exception;
	void remove() throws Exception;
}
