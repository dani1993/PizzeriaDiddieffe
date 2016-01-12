package gui;

import java.awt.Font;

import javax.swing.JButton;

public class OrderItemJButton extends ClickableButtonWithImage{

	public OrderItemJButton(int x, int y, int width, int height,int font,String itemText) {
		super(x, y, width, height,font, itemText);
		System.out.println(itemText);
		this.setText(itemText);
		this.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}

	
}
