package tests;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.gui.componentclasses.ComponentFormatterInterface;
import pizzeriadiddieffe.gui.componentclasses.ComponentSetter;
import pizzeriadiddieffe.gui.formattedelements.FormattedButton;
import pizzeriadiddieffe.gui.formattedelements.FormattedLabel;

public class ComponentSetterButtonTextPropTest {
	private ComponentSetter myComponentSetter;
	private ComponentFormatterInterface myComponentFormatter;
	private FormattedButton myButtonFormatter;
	private FormattedLabel myLabelFormatter;
	private JButton myButton;

	private String text = "text";
	private String font = "Lucida Grande";
	private int fontSize = 20;
	private Color textColor = Color.red;

	private Color newColor = Color.blue;
	private int newFontSize = 30;
	private String newText = "new text";
	private String newFont = "Lucida Grande Bold";

	@Before
	public void setUp() {
		myButton = new JButton("");
		myComponentSetter = new ComponentSetter();
		myButtonFormatter = new FormattedButton();
	}

	@Test
	public void assignButtonFormatter() {
		setCurrentComponent(myButtonFormatter);
	}

	@Test
	public void formatButtonTextProp() {
		setCurrentComponent(myButtonFormatter);
		formatComponentText(text, font, fontSize, textColor);
	}	

	@Test
	public void formatButtonString(){
		myButton = (JButton) changeComponentText(myButtonFormatter);
		assertEquals(newText, myButton.getText());
	}

	@Test
	public void formatButtonColor(){
		myButton = (JButton) changeComponentColor(myButtonFormatter);
		assertEquals(newColor, myButton.getForeground());
	}

	@Test
	public void formatButtonFont(){
		myButton = (JButton) changeComponentFont(myButtonFormatter);
		assertEquals(newFont, myButton.getFont().getName());
	}

	@Test
	public void formatButtonFontSize(){
		myButton = (JButton) changeComponentFontSize(myButtonFormatter);
		assertEquals(newFontSize, myButton.getFont().getSize());
	}

	private Component changeComponentText(ComponentFormatterInterface currentFormatter){
		String currentText = newText;
		setCurrentComponent(currentFormatter);
		formatComponentText(currentText, font, fontSize, textColor);
		return myComponentSetter.getFormattedComponent();
	}

	private Component changeComponentFontSize(ComponentFormatterInterface currentFormatter){
		int currentFontSize = newFontSize;
		setCurrentComponent(currentFormatter);
		formatComponentText(text, font, currentFontSize, textColor);
		return myComponentSetter.getFormattedComponent();
	}

	private Component changeComponentColor(ComponentFormatterInterface currentFormatter){
		Color currentColor = newColor;
		setCurrentComponent(currentFormatter);
		formatComponentText(text, font, fontSize, currentColor);
		return myComponentSetter.getFormattedComponent();
	}

	private Component changeComponentFont(ComponentFormatterInterface currentFormatter){
		String currentFont = newFont;
		setCurrentComponent(currentFormatter);
		formatComponentText(text, currentFont, fontSize, textColor);
		return myComponentSetter.getFormattedComponent();
	}

	private void setCurrentComponent(ComponentFormatterInterface myCurrentFormatter) {
		myComponentFormatter = myCurrentFormatter;
		myComponentSetter.setCurrentComponent(myComponentFormatter);
	}

	private void formatComponentText(String text, String font, int fontSize, Color textColor) {
		myComponentSetter.setComponentTextProp(text, font, fontSize, textColor);
	}
}