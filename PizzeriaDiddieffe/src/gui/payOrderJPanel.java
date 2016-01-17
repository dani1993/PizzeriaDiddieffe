package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import org.hamcrest.core.IsInstanceOf;

import pizzeriadiddieffe.core.Order;

public class payOrderJPanel extends JPanelWithBackgroundImgAndBackBtn{
	
	private int buttonsWidth=250;
	private int buttonsHeight=200;
	private int buttonsFont=30;
	private int space=20;
	private int singleButtonxSpace=10;
	private int buttonsXSpace=buttonsWidth+space;
	private int buttonsYSpace=buttonsHeight+space;
	private int singleButtonX=singleButtonxSpace+buttonsXSpace/2;
	private String buttonFontName="Lucida Grande";
	private Order myOrder;
	
	private JButton cashPay;
	private String cashImage="cashImage";
	private String cashText="Cash";
	
	private JButton BancomatPay;
	private String bancomatImage="bancomatImage";
	private String bancomatText="Bancomat";
	
	private JButton mobilePay;
	private String mobileImage="mobileImage";
	private String mobileText="Mobile Pay";
	
	private payMethodInterface payStrategy; 
	private payChooser myPayChooser; 
	private JPanelWithBackgroundImgAndBackBtn payPanel;
	private String payPanelImagePath="res/payPanel.jpg";
	private JPanelWithBackgroundImgAndBackBtn currentJPanel=this;
	private JFrame myFrame;
	
	
	public payOrderJPanel(Image img,JFrame myFrame) {
		super(img);
		int x=15;
		int y=200;
		createPayButton(cashPay,x,y,cashText,cashText,cashText);
		x=x+buttonsXSpace;
		y=200;
		createPayButton(BancomatPay,x,y,bancomatText,bancomatText,bancomatText);
		x=singleButtonX;
		y=y+buttonsYSpace;
		createPayButton(mobilePay, x, y, mobileText, mobileText, mobileText);
		this.myFrame=myFrame;
		
	}
	
	
	
	private void createPayPanel(JFrame myFrame) {
		Image payOrderImage=new ImageIcon(payPanelImagePath).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		payPanel=new JPanelWithBackgroundImgAndBackBtn(payOrderImage);
		payPanel.setVisiblePanel(currentJPanel, myFrame);
		payPanel.setVisible(false);
		myFrame.add(payPanel);	
	}

	
	public void setPrice(Order price){
		myOrder=price;
	}

	
	private void createPayButton(JButton payMode,int x,int y,String standardImage,String pressedImage, String mouseImage) {
		payMode = new JButtonTextImage(x, y, buttonsWidth, buttonsHeight, buttonsFont, standardImage);
		this.add(payMode);
		final String currentText=payMode.getText();
		payMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createPayPanel(myFrame);
				payStrategy=getStrategy(currentText);
				myPayChooser=new payChooser(payStrategy);
				myPayChooser.createPanel(myOrder, payPanel);
				currentJPanel.setVisible(false);
				payPanel.setVisible(true);
			}
		});
	}
	

	private payMethodInterface getStrategy(String text) {
		if(text.equals("Cash")){
			Image cashImageBG=new ImageIcon(cashImage).getImage().getScaledInstance(550, 750, java.awt.Image.SCALE_SMOOTH);
			return new CashPayment(cashImageBG);
		}
		else if(text.equals("Mobile Pay")){
			Image mobileImageBG=new ImageIcon(mobileImage).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
			return new MobilePayMethod(mobileImageBG);
		}
		Image bancomatImageBG=new ImageIcon(bancomatImage).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		return new BancomatPayMethod(bancomatImageBG);
		
	}

}
