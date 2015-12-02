package pizzeriadiddieffe.core.focaccia;

public class BasicBrownFocaccia extends Focaccia {
	private final static double PRICE = 3;
	private final static String INFO = "Brown focaccia";
	
	@Override
	public String getInfo(){
		return INFO;
		}
	
	@Override
	public double getPrice() {
		return PRICE;
	}
}
