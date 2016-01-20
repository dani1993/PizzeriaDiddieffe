package pizzeriadiddieffe.gui.jbutton;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class JButtonTextImage extends ClickableButtonWithImage{
	public JButtonTextImage(int x, int y, int width, int height, int font, String itemText) {
		super(x, y, width, height,font, itemText);
		this.setText(itemText);
		this.setFont(new Font("Lucida Grande", Font.BOLD, font));
		if(this.getText()=="Inside" || this.getText()=="Outside"){
			this.setForeground(Color.WHITE);
		} else if(this.getText()=="Cash" || this.getText()=="Mobile Pay" || this.getText()=="Bancomat"){
			this.setForeground(Color.RED);
		} else{
			this.setForeground(Color.black);
		}
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}
}