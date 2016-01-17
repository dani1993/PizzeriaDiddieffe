package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import pizzeriadiddieffe.core.Order;


public class CashPayment extends JPanelWithBackgroundImgAndBackBtn implements payMethodInterface   {

	private double totprice;
	private JPanelWithBackgroundImgAndBackBtn myPanel;
	private JButton payButton;
	private Order currentOrder;
	private String baseTotalString="Importo Consegnato ";
	private String totalString=baseTotalString;
    private ComponentCreator myComponentCreator;
	
	private Color labelcolor=Color.black;
	private String labelFont="Lucida Grande";
	private Color buttoncolor=Color.black;
	private String buttonFont="Lucida Grande";
	
	private int space=20;
	private int labelx=30;
	private int labely=100;
	private int labelWidth=500;
	private int labelheight=40;
	private int labelSpace=labelheight+space;
	private int labelfontsize=25;
	
	private int buttonfontsize=20;
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

	

	public CashPayment(Image img) {
		super(img);
		myComponentCreator=new ComponentCreator();
	}
	
	
	@Override
	public void paymethod(Order totprice,JPanelWithBackgroundImgAndBackBtn myPanel) {
		this.totprice=totprice.getPrice();
		this.currentOrder=totprice;
		this.myPanel=myPanel;
		createTotalLabel();
		createButtons();
	}


	private void createTotalLabel() {
		
		final JLabel label=(JLabel) createFormattedLabel("Totale importo "+totprice,labelx,labely,labelWidth,labelheight);
		
		labely=labely+labelSpace;
		
		payButton=createFormattedButton("Pay",buttonPayx, buttonPayy,buttonPayWidth,buttonPayHeight);
		payButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentText=payButton.getText();
				
				if(totalString!=baseTotalString){
				Totvalue=Double.parseDouble(totalString);
				double resto=Totvalue-totprice;
				
				if(currentText=="Pay" && resto>0){
					payButton.setText("Resto : "+resto);
				}else if(currentText!="Pay"){
					currentOrder.deleteAll();
					payButton.setText("Payed!");
				}
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

	
	private void createButtons() {
		
		final JLabel label=createFormattedLabel(totalString,labelx, labely,labelWidth,labelheight);

		for(int i=0;i<10;i++){
			
			final String buttonText=setCoordinates(i);
			final JButton currentButton=createFormattedButton(buttonText, buttonX, buttonY, buttonWidth, buttonHeight);
			currentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int value=Integer.parseInt(currentButton.getText());
					String currentValue=label.getText()+value;
					label.setText(currentValue);
					totalString=currentValue.substring(18);		
				}
			});
		}
		
		JButton cancButton=createFormattedButton("C", buttonX+xSpace, buttonY, buttonWidth, buttonHeight);
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



}
