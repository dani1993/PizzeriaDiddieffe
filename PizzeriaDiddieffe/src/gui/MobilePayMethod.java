package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import pizzeriadiddieffe.core.Order;

public class MobilePayMethod extends JPanelWithBackgroundImgAndBackBtn implements payMethodInterface {

	private double totprice;
	private JPanelWithBackgroundImgAndBackBtn myPanel;
	private JButton payButton;
	private Order currentOrder;
	private JComboBox<String> mobilepayOperator;
	private JComboBox<String> autenticationMethod;
	
	private int labelx=30;
	private int labely=100;
	private int labelWidth=500;
	private int labelheight=40;
	
	private int ySpace=200;
	private int yBox= 35;
	private int xBox = 125;
	private int boxWidth = 300;
	private int boxHeight = 60;
	private int menuSpace=100;
	
	private int buttonPayx=120;
	private int buttonPayy=580;
	private int buttonPayWidth=300;
	private int buttonPayHeight=100;
	
	private String[] operators={"Apple Pay","Android Pay","Generic Operator"};
	private String [] autentications={"Contact Less","Code Insertion"};
	private ComponentCreator<String> myComponentCreator;
	
	private String buttonFont="Lucida Grande";
	private int buttonfontsize=20;
	private Color buttoncolor=Color.black;
	private String labelFont="Lucida Grande";
	private int labelfontsize=20;
	private Color labelcolor=Color.BLACK;
	private String comboFont="Lucida Grande";
	private int combofontsize=20;
	private Color combocolor=Color.BLACK;
	
	
	public MobilePayMethod(Image img) {
		super(img);
		myComponentCreator=new ComponentCreator();
	}
	
	@Override
	public void paymethod(Order totprice,JPanelWithBackgroundImgAndBackBtn myPanel) {
		this.totprice = totprice.getPrice();
		this.currentOrder=totprice;
		this.myPanel=myPanel;
		createTotalLabel();
		createBox();
	}
	
	private void createBox(){
		yBox=yBox+ySpace;
		autenticationMethod = createFormattedComboBox("", xBox, yBox, boxWidth, boxHeight);
		createMenuItems(autenticationMethod, autentications);
	
		yBox=yBox+ySpace;
		mobilepayOperator = createFormattedComboBox("", xBox, yBox, boxWidth, boxHeight);
		createMenuItems(mobilepayOperator, operators);
		
		
	}



	private void createMenuItems(JComboBox<String> currentMenu,String[] itemsName) {
		for(int i=0;i<itemsName.length;i++){
			currentMenu.addItem(itemsName[i]);
			
		}
	}

	

	private void createTotalLabel(){
		
		final JLabel label=createFormattedLabel("Totale Ordine "+totprice, labelx, labely, labelWidth, labelheight);
		
		labely=labely+menuSpace;
		final JLabel labelMethod =createFormattedLabel("Choose Autentication Method", labelx, labely, labelWidth, labelheight);
		
		labely=labely+menuSpace*2;
		final JLabel labelOperator = createFormattedLabel("Choose Operator ", labelx, labely, labelWidth, labelheight);
		
		
		payButton=createFormattedButton("Pay", buttonPayx, buttonPayy, buttonPayWidth, buttonPayHeight);
		payButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentText=payButton.getText();
				
				if(currentText.equals("Pay")){
					payButton.setText("Autentication");
					mobilepayOperator.setEnabled(false);
					autenticationMethod.setEnabled(false);
					
				}else if(currentText.equals("Autentication")){
					currentOrder.deleteAll();
					payButton.setText("Payed!");
				
			}
			}
		});
	}
	
	private JButton createFormattedButton(String text,int buttonx,int buttony,int buttonwidth,int buttonheight){
		myComponentCreator.createButton(text, buttonFont, buttonfontsize, buttoncolor);
		myComponentCreator.setUpComponentProp(buttonx, buttony, buttonwidth, buttonheight);
		myPanel.add(myComponentCreator.getButton());
		return myComponentCreator.getButton();
	}
	
	
	private JLabel createFormattedLabel(String text,int labelx,int labely,int labelwidth,int labelheight){
		myComponentCreator.createLabel(text, labelFont, labelfontsize, labelcolor);
		myComponentCreator.setUpComponentProp(labelx, labely, labelwidth, labelheight);
		myPanel.add(myComponentCreator.getLabel());
		return myComponentCreator.getLabel();
	}

	private JComboBox<String> createFormattedComboBox(String text,int comboBoxX,int comboBoxY,int comboBoxWidth,int comboBoxHeight){
		myComponentCreator.createComboBox(text, comboFont, combofontsize, combocolor);
		myComponentCreator.setUpComponentProp(comboBoxX, comboBoxY, comboBoxWidth, comboBoxHeight);
		myPanel.add(myComponentCreator.getComboBox());
		return myComponentCreator.getComboBox();
	}
	
}