package pizzeriadiddieffe.gui.formattedelements;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComboBox;

import pizzeriadiddieffe.gui.componentclasses.ComponentFormatterInterface;

public class FormattedComboBox<E> implements ComponentFormatterInterface{
	private JComboBox<E> tempComboBox;

	@Override
	public void setComponentProp(int x, int y, int width, int height) {
		tempComboBox.setBounds(x, y, width, height);
	}

	@Override
	public void setComponentTextProp(String text, String font, int fontSize, Color textColor) {
		tempComboBox.setFont(new Font(font, Font.PLAIN, fontSize));
		tempComboBox.setForeground(textColor);
	}

	@Override
	public void createNewComponent() {
		tempComboBox = new JComboBox<E>();
	}

	@Override
	public Component getFormattedComponent() {
		return tempComboBox;
	}
}