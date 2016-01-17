package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class OrderItemJButton extends ClickableButtonWithImage{

	public OrderItemJButton(int x, int y, int width, int height,int font,String itemText) {
		super(x, y, width, height,font, itemText);
		this.setText(itemText);
		this.setFont(new Font("Lucida Grande", Font.BOLD, font));
//		if (itemText == "Small" || itemText == "Medium" || itemText == "Large") 
//			this.setForeground(Color.black);
//		else
			this.setForeground(Color.black);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}

	
}
