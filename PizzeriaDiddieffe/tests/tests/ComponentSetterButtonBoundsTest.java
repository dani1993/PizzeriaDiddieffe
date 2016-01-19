package tests;

import static org.junit.Assert.assertEquals;

import java.awt.Component;

import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.gui.componentclasses.ComponentFormatterInterface;
import pizzeriadiddieffe.gui.componentclasses.ComponentSetter;
import pizzeriadiddieffe.gui.formattedelements.FormattedButton;

public class ComponentSetterButtonBoundsTest {
	private ComponentSetter myComponentSetter;
	private ComponentFormatterInterface myComponentFormatter;
	private FormattedButton myButtonFormatter;
	private JButton myButton;

	private int defaultX = 0;
	private int defaultY = 0;
	private int defaultWidth = 0;
	private int defautlHeight = 0;
	private int currentIntFormatter = 100;

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
	public void formatButtonBounds() {
		setCurrentComponent(myButtonFormatter);
		formatComponentBounds(defaultX, defaultY ,defaultWidth, defautlHeight);
	}	

	@Test
	public void formatButtonX(){
		myButton = (JButton) changeComponentX(myButtonFormatter);
		assertEquals(myButton.getX(), currentIntFormatter);
	}

	@Test
	public void formatButtonY(){
		myButton = (JButton) changeComponentY(myButtonFormatter);
		assertEquals(myButton.getY(), currentIntFormatter);
	}

	@Test
	public void formatButtonWidth(){
		myButton = (JButton) changeComponentWidth(myButtonFormatter);
		assertEquals(myButton.getWidth(), currentIntFormatter);
	}

	@Test
	public void formatButtonHeight(){
		myButton = (JButton) changeComponentHeight(myButtonFormatter);
		assertEquals(myButton.getHeight(), currentIntFormatter);
	}

	private Component changeComponentX(ComponentFormatterInterface currentFormatter){
		int currentX = currentIntFormatter;
		setCurrentComponent(currentFormatter);
		formatComponentBounds(currentX, defaultY, defaultWidth, defautlHeight);
		return myComponentSetter.getFormattedComponent();
	}

	private Component changeComponentY(ComponentFormatterInterface currentFormatter){
		int currentY = currentIntFormatter;
		setCurrentComponent(currentFormatter);
		formatComponentBounds(defaultX, currentY, defaultWidth, defautlHeight);
		return myComponentSetter.getFormattedComponent();
	}

	private Component changeComponentHeight(ComponentFormatterInterface currentFormatter){
		int currentHeight = currentIntFormatter;
		setCurrentComponent(currentFormatter);
		formatComponentBounds(defaultX, defaultY, defaultWidth, currentHeight);
		return myComponentSetter.getFormattedComponent();
	}

	private Component changeComponentWidth(ComponentFormatterInterface currentFormatter){
		int currentWidth = currentIntFormatter;
		setCurrentComponent(currentFormatter);
		formatComponentBounds(defaultX, defaultY, currentWidth, defautlHeight);
		return myComponentSetter.getFormattedComponent();
	}

	private void setCurrentComponent(ComponentFormatterInterface myCurrentFormatter) {
		myComponentFormatter = myCurrentFormatter;
		myComponentSetter.setCurrentComponent(myComponentFormatter);
	}

	private void formatComponentBounds(int x, int y, int width, int height) {
		myComponentSetter.setComponentProp(x, y, width, height);
	}
}