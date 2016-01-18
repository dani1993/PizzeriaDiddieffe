package pizzeriadiddieffe.gui.jbutton;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class JButtonTextImage extends ClickableButtonWithImage{
	public JButtonTextImage(int x, int y, int width, int height,int font,String itemText) {
		super(x, y, width, height,font, itemText);
		this.setText(itemText);
		this.setFont(new Font("Lucida Grande", Font.BOLD, font));
		this.setForeground(Color.black);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}
}