package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import pizzeriadiddieffe.core.Order;

public class BancomatPayMethod extends JPanelWithBackgroundImgAndBackBtn implements payMethodInterface {


	public BancomatPayMethod(Image img) {
		super(img);
		// TODO Auto-generated constructor stub
	}

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
	private int labelfont=25;

	private int buttonfont=20;
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

	@Override
	public void paymethod(Order totprice,JPanelWithBackgroundImgAndBackBtn myPanel) {
		this.totprice=totprice.getPrice();
		this.currentOrder=totprice;
		this.myPanel=myPanel;
		createTotalLabel();
		createButtons();
	}

	private void createTotalLabel() {
		final JLabel label=new JLabel("Totale Ordine "+totprice);
		label.setBounds(labelx,labely,labelWidth,labelheight);
		label.setFont((new Font("Lucida Grande", Font.BOLD, labelfont)));
		myPanel.add(label);
		labely=labely+labelSpace;

		payButton=new JButton("Pay");
		payButton.setBounds(buttonPayx, buttonPayy, buttonPayWidth, buttonPayHeight);
		payButton.setFont((new Font("Lucida Grande", Font.BOLD, buttonfont)));
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

		final JLabel label=new JLabel(totalString);
		label.setBounds(labelx,labely,labelWidth,labelheight);
		label.setFont((new Font("Lucida Grande", Font.BOLD, labelfont)));
		myPanel.add(label);

		for(int i=0;i<10;i++){
			final String buttonText=setCoordinates(i);

			final JButton currentButton=new JButton(buttonText);
			currentButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
			currentButton.setFont((new Font("Lucida Grande", Font.BOLD, buttonfont)));
			currentButton.addActionListener(new ActionListener() {


				@Override
				public void actionPerformed(ActionEvent e) {
					code = code+"*";
					String currentValue=label.getText()+"*";
					label.setText(currentValue);
					}
			});
			myPanel.add(currentButton);
		}

		JButton cancButton=new JButton("C");
		cancButton.setBounds(buttonX+xSpace, buttonY, buttonWidth, buttonHeight);
		cancButton.setFont((new Font("Lucida Grande", Font.BOLD, buttonfont)));
		cancButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(baseTotalString);	
			}
		});
		myPanel.add(cancButton);
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
