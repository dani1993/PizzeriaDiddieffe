package gui;

public class OrderItemJButton extends ClickableButtonWithImage{

	private static String image="res/pizzatest.jpg";
	private static String clickedImage=image;
	private static String mouseOnImage=image;
	
	public OrderItemJButton(int x, int y, int width, int height) {
		super(x, y, width, height, image, clickedImage, mouseOnImage);
		// TODO Auto-generated constructor stub
	}

}
