package pizzeriadiddieffe.gui.creators;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import pizzeriadiddieffe.gui.componentclasses.ComponentFormatterInterface;
import pizzeriadiddieffe.gui.formattedelements.FormattedButton;
import pizzeriadiddieffe.gui.formattedelements.FormattedComboBox;
import pizzeriadiddieffe.gui.formattedelements.FormattedLabel;

public class ComponentCreator<E> {
	private FormattedLabel myLabelFormatter;
	private ComponentFormatterInterface componentFormatter;
	private FormattedButton myButtonFormatter;
	private FormattedComboBox<E> myComboBoxFormatter;

	public ComponentCreator(){
		myButtonFormatter = new FormattedButton();
		myLabelFormatter = new FormattedLabel();
		myComboBoxFormatter = new FormattedComboBox<>();
	}

	private void setUpComponent(String text, String componentFont, int componentFontSize, Color componentColor) {
		componentFormatter.createNewComponent();
		componentFormatter.setComponentTextProp(text, componentFont, componentFontSize, componentColor);
	}

	public void createButton(String text, String componentFont, int componentFontSize, Color componentColor){
		componentFormatter = myButtonFormatter;
		setUpComponent(text, componentFont, componentFontSize, componentColor);
	}

	public void createLabel(String text, String componentFont, int componentFontSize, Color componentColor){
		componentFormatter = myLabelFormatter;
		setUpComponent(text, componentFont, componentFontSize, componentColor);
	}

	public void setUpComponentProp(int componentX, int componentY, int componentWidth, int componentHeight){
		componentFormatter.setComponentProp(componentX, componentY, componentWidth, componentHeight);
	}

	public JButton getButton(){
		return (JButton) componentFormatter.getFormattedComponent();
	}

	public JLabel getLabel(){
		return (JLabel) componentFormatter.getFormattedComponent();
	}

	public void createComboBox(String text, String componentFont, int componentFontSize, Color componentColor){
		componentFormatter = myComboBoxFormatter;
		setUpComponent(text, componentFont, componentFontSize, componentColor);
	}

	public JComboBox<E> getComboBox(){
		return (JComboBox<E>)componentFormatter.getFormattedComponent();
	}
}