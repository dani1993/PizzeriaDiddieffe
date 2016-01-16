package gui;

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
	private int labelfont=20;
	
	private int buttonfont=20;
	private int ySpace=200;
	private int yBox= 30;
	private int xBox = labelx;
	private int boxWidth = 300;
	private int boxHeight = 60;
	private int menuSpace=100;
	
	private int buttonPayx=120;
	private int buttonPayy=580;
	private int buttonPayWidth=300;
	private int buttonPayHeight=100;
	
	private String[] operators={"Apple Pay","Android Pay","Generic Operator"};
	private String [] autentications={"Contact Less","Code Insertion"};
	
	
	public MobilePayMethod(Image img) {
		super(img);
		// TODO Auto-generated constructor stub
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
		autenticationMethod = new JComboBox<String>();
		createMenuItems(autenticationMethod,autentications);
		setMenuLayout(autenticationMethod,yBox);
	
		yBox=yBox+ySpace;
		mobilepayOperator = new JComboBox<String>();
		createMenuItems(mobilepayOperator,operators);
		setMenuLayout(mobilepayOperator,yBox);
		
	}

	private void setMenuLayout(JComboBox<String> currentMenu,int y) {
		currentMenu.setBounds(xBox, y, boxWidth, boxHeight);
		currentMenu.setFont(new Font("Lucida Grande", Font.BOLD, labelfont));
		myPanel.add(currentMenu);
	}

	private void createMenuItems(JComboBox<String> currentMenu,String[] itemsName) {
		for(int i=0;i<itemsName.length;i++){
			currentMenu.addItem(itemsName[i]);
			
		}
	}

	
	private void setUpLabel(JLabel currentLabel,int y){
		currentLabel.setBounds(labelx,y,labelWidth,labelheight);
		currentLabel.setFont((new Font("Lucida Grande", Font.BOLD, labelfont)));
		myPanel.add(currentLabel);
	}
	

	private void createTotalLabel(){
		
		final JLabel label=new JLabel("Totale Ordine "+totprice);
		setUpLabel(label, labely);
		
		
		labely=labely+menuSpace;
		final JLabel labelMethod = new JLabel("Choose Autentication Method ");
		setUpLabel(labelMethod, labely);
		
		labely=labely+menuSpace*2;
		final JLabel labelOperator = new JLabel("Choose Operator ");
		setUpLabel(labelOperator, labely);
		
		
		payButton=new JButton("Pay");
		payButton.setBounds(buttonPayx, buttonPayy, buttonPayWidth, buttonPayHeight);
		payButton.setFont((new Font("Lucida Grande", Font.BOLD, buttonfont)));
		
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
		
		myPanel.add(payButton);
	}

}