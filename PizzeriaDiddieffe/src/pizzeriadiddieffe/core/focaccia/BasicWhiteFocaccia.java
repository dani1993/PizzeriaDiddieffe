package pizzeriadiddieffe.core.focaccia;

public class BasicWhiteFocaccia extends Focaccia {
	private final static double PRICE = 2.5;
	private final static String INFO = "White focaccia";
	
	@Override
	public String getInfo(){
		return INFO;
		}
	
	@Override
	public double getPrice() {
		return PRICE;
	}
}
