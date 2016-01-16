package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.hamcrest.core.IsInstanceOf;

import pizzeriadiddieffe.core.Order;

public class payOrderJPanel extends JPanelWithBackgroundImgAndBackBtn{
	
	private int buttonsWidth=200;
	private int buttonsHeight=100;
	private int buttonsFont=30;
	private Order myOrder;
	
	private JButton cashPay;
	private String cashImage="res/cashImage.jpg";
	private String cashText="Cash";
	
	private JButton BancomatPay;
	private String bancomatImage="res/bancomatImage.jpg";
	private String bancomatText="Bancomat";
	
	private JButton ticketPay;
	private String ticketImage="res/ticketImage.jpg";
	private String ticketText="Mobile Pay";
	
	private payMethodInterface payStrategy; 
	private payChooser myPayChooser; 
	private JPanelWithBackgroundImgAndBackBtn payPanel;
	private String payPanelImagePath="res/payPanel.jpg";
	private JPanelWithBackgroundImgAndBackBtn currentJPanel=this;
	private JFrame myFrame;
	
	
	public payOrderJPanel(Image img,JFrame myFrame) {
		super(img);
		int x=150;
		int y=150;
		createPayButton(cashPay,x,y,cashImage,cashImage,cashImage,cashText);
		x=350;
		y=150;
		createPayButton(BancomatPay,x,y,bancomatImage,bancomatImage,bancomatImage,bancomatText);
		x=150;
		y=350;
		createPayButton(ticketPay, x, y, ticketImage, ticketImage, ticketImage,ticketText);
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

	
	private void createPayButton(JButton payMode,int x,int y,String standardImage,String pressedImage, String mouseImage,String text) {
		payMode = new ClickableButtonWithImage(x, y, buttonsWidth, buttonsHeight, buttonsFont, standardImage);
		payMode.setText(text);
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
			Image cashImageBG=new ImageIcon(cashImage).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
			return new CashPayment(cashImageBG);
		}
		else if(text.equals("Mobile Pay")){
			Image ticketImageBG=new ImageIcon(ticketImage).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
			return new MobilePayMethod(ticketImageBG);
		}
		Image bancomatImageBG=new ImageIcon(bancomatImage).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		return new BancomatPayMethod(bancomatImageBG);
		
	}

}
