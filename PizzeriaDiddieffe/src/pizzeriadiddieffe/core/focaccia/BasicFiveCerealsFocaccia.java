package pizzeriadiddieffe.core.focaccia;

public class BasicFiveCerealsFocaccia extends Focaccia {
	private final static double PRICE = 3.5;
	private final static String INFO = "Five cereals focaccia";
	
	@Override
	public String getInfo(){
		return INFO;
		}
	
	@Override
	public double getPrice() {
		return PRICE;
	}
}