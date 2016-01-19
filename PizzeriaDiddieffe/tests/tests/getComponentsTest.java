package tests;

import static org.junit.Assert.assertEquals;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import pizzeriadiddieffe.gui.componentclasses.ComponentsGetter;

public class getComponentsTest {
	private ComponentsGetter myComponentsGetter;
	private List<Component> myComponents;
	private JFrame myFrame;
	private JButton myButton;
	private JLabel myLabel;
	private boolean founded;

	@Before
	public void setUp(){
		myFrame = new JFrame("");
		myButton = new JButton("");
		myLabel = new JLabel("");
		myComponentsGetter = new ComponentsGetter();
		myComponents = new ArrayList<Component>();
		founded = false;
	}

	@Test
	public void getButtonElementFromFrameTest() {
		myFrame.add(myButton);
		myFrame.pack();
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponentPresence(myButton);
		assertEquals(true, founded);
	}

	@Test
	public void getLabelElementFromFrameTest() {
		myFrame.add(myLabel);
		myFrame.pack();
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponentPresence(myLabel);
		assertEquals(true, founded);
	}

	@Test
	public void getButtonFalseElementFromFrameTest() {
		myFrame.add(myLabel);
		myFrame.pack();
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponentPresence(myButton);
		assertEquals(false, founded);
	}

	@Test
	public void getLabelFalseElementFromFrameTest() {
		myFrame.add(myButton);
		myFrame.pack();
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponentPresence(myLabel);
		assertEquals(false, founded);
	}

	@Test
	public void getNullLabelComponent(){
		myFrame.pack();
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponentPresence(myLabel);
		assertEquals(false, founded);
	}

	@Test
	public void getNullButtonComponent(){
		myFrame.pack();
		myComponents = myComponentsGetter.getComponents(myFrame);
		checkComponentPresence(myButton);
		assertEquals(false, founded);
	}

	@Test
	public void getWrongComponent(){
		myComponents = myComponentsGetter.getComponents(myLabel);
		checkComponentPresence(myButton);
		assertEquals(false, founded);
	}

	private void checkComponentPresence(Component myComponent) {
		for(int i = 0; i<myComponents.size(); i++){
			if(myComponent.equals(myComponents.get(i))){
				founded = true;
			}
		}
	}
}