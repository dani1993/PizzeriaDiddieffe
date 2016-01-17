package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ComponentCreator<E> {

	 	private FormattedLabel myLabelformatter;
	 	private ComponentFormatterInterface componentFormatter;
		private FormattedButton myButtonformatter;
		private FormattedComboBox<E> myComboBoxFormatter;
		
		public ComponentCreator(){
			myButtonformatter=new FormattedButton();
			myLabelformatter=new FormattedLabel();
			myComboBoxFormatter=new FormattedComboBox<>();
		}
		
		private void setUpComponent(String text, String componentFont, int componentfontsize, Color componentcolor) {
			componentFormatter.createNewComponent();
			componentFormatter.setComponentTextProp(text, componentFont, componentfontsize, componentcolor);
		}
		
		public void createButton(String text, String componentFont, int componentfontsize, Color componentcolor){
			componentFormatter=myButtonformatter;
			setUpComponent(text, componentFont, componentfontsize, componentcolor);
		}

	
		public void createLabel(String text, String componentFont, int componentfontsize, Color componentcolor){
			componentFormatter=myLabelformatter;
			setUpComponent(text, componentFont, componentfontsize, componentcolor);
		}
		
		public void setUpComponentProp(int componentX,int componentY,int componentWidth,int componentHeight){
			componentFormatter.setComponentProp(componentX, componentY, componentWidth, componentHeight);
		}
		
		public JButton getButton(){
			return (JButton) componentFormatter.getFormattedComponent();
		}
		
		public JLabel getLabel(){
			return (JLabel) componentFormatter.getFormattedComponent();
		}
		
		public void createComboBox(String text, String componentFont, int componentfontsize, Color componentcolor){
			componentFormatter=myComboBoxFormatter;
			setUpComponent(text, componentFont, componentfontsize, componentcolor);
		}
		
		public JComboBox<E> getComboBox(){
			return (JComboBox<E>) componentFormatter.getFormattedComponent();
		}
	
}
