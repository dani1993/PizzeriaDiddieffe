package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.plaf.ColorUIResource;

public class OrderItemJButton extends ClickableButtonWithImage{

	public OrderItemJButton(int x, int y, int width, int height,int font,String itemText) {
		super(x, y, width, height,font, itemText);
		System.out.println(itemText);
		this.setText(itemText);
		this.setFont(new Font("Lucida Grande", Font.PLAIN, font));
		this.setForeground(Color.white);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}

	
}
