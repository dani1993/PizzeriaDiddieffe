package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class payOrderJPanel extends JPanelWithBackgroundImg{
	
	
	private int buttonsWidth=200;
	private int buttonsHeight=100;
	private int buttonsFont=30;
	
	private JButton cashPay;
	private String cashImage="res/cashImage.jpg";
	private String cashText="Cash";
	
	private JButton BancomatPay;
	private String bancomatImage="res/bancomatImage.jpg";
	private String bancomatText="Bancomat";
	
	private JButton ticketPay;
	private String ticketImage="res/ticketImage.jpg";
	private String ticketText="Ticket";
	
	public payOrderJPanel(Image img) {
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
		
	}

	private void createPayButton(JButton payMode,int x,int y,String standardImage,String pressedImage, String mouseImage,String text) {
		payMode = new ClickableButtonWithImage(x, y, buttonsWidth, buttonsHeight, buttonsFont, standardImage);
		payMode.setText(text);
		this.add(payMode);
		
	}

}
