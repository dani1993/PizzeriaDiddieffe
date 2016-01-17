package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import pizzeriadiddieffe.core.Order;

public class BancomatPayMethod extends JPanelWithBackgroundImgAndBackBtn implements payMethodInterface {

	private double totprice;
	private JPanelWithBackgroundImgAndBackBtn myPanel;
	private JButton payButton;
	private Order currentOrder;
	private String baseTotalString="Inserire Codice ";
	private String totalString=baseTotalString;
	private String code = "";

	private int space=20;
	private int labelx=30;
	private int labely=100;
	private int labelWidth=500;
	private int labelheight=40;
	private int labelSpace=labelheight+space;
	
	private int startX=20;
	private int startY=320;
	private int buttonX=startX;
	private int buttonY=startY;
	private int buttonWidth=70;
	private int buttonHeight=70;
	private int xSpace=buttonWidth+space;
	private int ySpace=buttonHeight+space;

	private double Totvalue=0;
	private int buttonPayx=300;
	private int buttonPayy=320;
	private int buttonPayWidth=220;
	private int buttonPayHeight=250;
	
	private ComponentCreator myComponentCreator;
	private int buttonfontsize=20;
	private Color buttoncolor=Color.black;
	private Color labelcolor=Color.BLACK;
	private int labelfontsize=25;
	private String buttonfontname="Lucida Grande";
	private String labelfontname="Lucida Grande";

	
	public BancomatPayMethod(Image img) {
		super(img);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void paymethod(Order totprice,JPanelWithBackgroundImgAndBackBtn myPanel) {
		this.totprice=totprice.getPrice();
		this.currentOrder=totprice;
		this.myPanel=myPanel;
		myComponentCreator=new ComponentCreator();
		createTotalLabel();
		createButtons();
	}

	private void createTotalLabel() {
		
		final JLabel label=createFormattedLabel("Totale Ordine "+totprice, labelx, labely, labelWidth, labelheight);
	
		labely=labely+labelSpace;

		payButton=createFormattedButton("Pay", buttonPayx, buttonPayy, buttonPayWidth, buttonPayHeight);
		payButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(code.length()<5){
					payButton.setText("Insert");
				} else{
					currentOrder.deleteAll();
					payButton.setText("Payed");
					payButton.setEnabled(false);
				}
			}
		});
		myPanel.add(payButton);		
	}

	private void createButtons() {

		final JLabel label=createFormattedLabel(totalString, labelx, labely, labelWidth, labelheight);

		for(int i=0;i<10;i++){
			final String buttonText=setCoordinates(i);
			final JButton currentButton=createFormattedButton(buttonText, buttonX, buttonY, buttonWidth, buttonHeight);
			currentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					code = code+"*";
					String currentValue=label.getText()+"*";
					label.setText(currentValue);
					}
			});
		}

		JButton cancButton=createFormattedButton("C",buttonX+xSpace, buttonY, buttonWidth, buttonHeight);
		cancButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(baseTotalString);	
			}
		});
	}

	
	private String setCoordinates(int i) {
		if(i==9){
			buttonX=startX;
			buttonY=buttonY+ySpace;
			buttonX=buttonX+xSpace;
			return Integer.toString(i-9);
		}else{
			if(i%3==0 && i!=0){
				buttonX=startX;
				startY=startY+ySpace;
				buttonY=buttonY+ySpace;
				return Integer.toString(i+1);
			}else if(i%3!=0 && i!=0){
				buttonY=startY;
				buttonX=buttonX+xSpace;
				return Integer.toString(i+1);
			}
		}
		return Integer.toString(i+1);
	}
	
	
	private JButton createFormattedButton(String text,int buttonx,int buttony,int buttonwidth,int buttonheight){
		myComponentCreator.createButton(text, buttonfontname,buttonfontsize, buttoncolor);
		myComponentCreator.setUpComponentProp(buttonx, buttony, buttonwidth, buttonheight);
		myPanel.add(myComponentCreator.getButton());
		return myComponentCreator.getButton();
	}
	
	
	private JLabel createFormattedLabel(String text,int labelx,int labely,int labelwidth,int labelheight){
		myComponentCreator.createLabel(text, labelfontname, labelfontsize, labelcolor);
		myComponentCreator.setUpComponentProp(labelx, labely, labelwidth, labelheight);
		myPanel.add(myComponentCreator.getLabel());
		return myComponentCreator.getLabel();
	}

}
