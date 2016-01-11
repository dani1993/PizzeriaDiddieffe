package gui;

import javax.swing.JButton;

public class OrderItemJButton extends ClickableButtonWithImage{

	public OrderItemJButton(int x, int y, int width, int height,int font,String itemText) {
		super(x, y, width, height,font, itemText, itemText, itemText);
		String text=itemText.substring(4,itemText.length()-4);
		this.setText(text);
		System.out.println(text);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}

	
}
