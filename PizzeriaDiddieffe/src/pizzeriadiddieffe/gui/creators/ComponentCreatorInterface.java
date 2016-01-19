package pizzeriadiddieffe.gui.creators;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public interface ComponentCreatorInterface<E> {
	public void createButton(String text, String componentFont, int componentFontSize, Color componentColor);
	public void createLabel(String text, String componentFont, int componentFontSize, Color componentColor);
	public void setUpComponentProp(int componentX, int componentY, int componentWidth, int componentHeight);
	public JButton getButton();
	public JLabel getLabel();
	public void createComboBox(String text, String componentFont, int componentFontSize, Color componentColor);
	public JComboBox<E> getComboBox();
}