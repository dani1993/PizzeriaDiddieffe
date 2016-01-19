package pizzeriadiddieffe.gui.formattedelements;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import pizzeriadiddieffe.gui.componentclasses.ComponentFormatterInterface;

public class FormattedButton implements ComponentFormatterInterface{
	private JButton tempButton;

	@Override
	public void setComponentProp(int x, int y, int width, int height){
		tempButton.setBounds(x, y, width, height);
		tempButton.setHorizontalAlignment(SwingConstants.CENTER);
		tempButton.setVerticalAlignment(SwingConstants.CENTER);
		tempButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tempButton.setBackground(new Color(255, 255, 255));
	}

	@Override
	public void setComponentTextProp(String text, String font, int fontSize, Color textColor){
		tempButton.setText(text);
		tempButton.setFont(new Font(font, Font.PLAIN, fontSize));
		tempButton.setForeground(textColor);
	}

	@Override
	public void createNewComponent(){
		tempButton = new JButton();	
	}

	@Override
	public JButton getFormattedComponent(){
		return tempButton;
	}
}