package pizzeriadiddieffe.gui.formattedelements;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import pizzeriadiddieffe.gui.componentclasses.ComponentFormatterInterface;

public class FormattedLabel implements ComponentFormatterInterface{
	private JLabel tempLabel;

	@Override
	public void setComponentProp(int x, int y, int width, int height){
		tempLabel.setBounds(x, y, width, height);
		tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tempLabel.setVerticalAlignment(SwingConstants.CENTER);
	}

	@Override
	public void setComponentTextProp(String text, String font, int fontSize, Color textColor){
		tempLabel.setText(text);
		tempLabel.setFont(new Font(font, Font.PLAIN, fontSize));
		tempLabel.setForeground(textColor);
	}

	@Override
	public void createNewComponent(){
		tempLabel = new JLabel();
	}

	@Override
	public JLabel getFormattedComponent(){
		return tempLabel;
	}
}