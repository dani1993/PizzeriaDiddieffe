package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;

public class OrderViewer extends JPanelWithBackgroundImg {

	private JPanelWithBackgroundImg currentJPanel = this;
	private payOrderJPanel myPayJPanel;
	private Order myOrder;
	private LinkedList<Item> myItemslist;
	private JButton payOrderButton;
	private int payButtonx = 200;
	private int payButtony = 650;
	private int payButtonHeight = 50;
	private int payButtonWight = 155;
	private String payOrderImagePath = "res/payOrderBackground.jpg";
	private Item currentItem;
	private int scrollPanex = 15;
	private int scrollPaney = 200;
	private int scrollPaneWidth = 510;
	private int scrollPaneHeight = 420;

	private JLabel descriptionLabel;
	private int labelx = -10;
	private int labely = -5;
	private int labelHeight = 200;
	private int labelWidth = 200;
	private int labelFont = 25;

	public OrderViewer(Image img, JFrame myFrame, JPanelWithBackgroundImg payOrderVisiblePanel) {
		super(img);

		JPanel panel = new JPanel();
        
       
        
	
		
        descriptionLabel=new JLabel();
        descriptionLabel.setBounds(labelx, labely, labelWidth, labelHeight);
        descriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, labelFont));
		
		
        panel.add(descriptionLabel);
		
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBounds(scrollPanex, scrollPaney, scrollPaneWidth, scrollPaneHeight);
        scrollPane.setBorder(new LineBorder(Color.white,0));
        currentJPanel.add(scrollPane);
        
        
        
        
		Image payOrderImage=new ImageIcon(payOrderImagePath).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		myPayJPanel=new payOrderJPanel(payOrderImage,myFrame);
		myPayJPanel.setVisiblePanel(payOrderVisiblePanel, myFrame);
		myPayJPanel.setVisible(false);
		myFrame.add(myPayJPanel);
	     
		
		payOrderButton = new JButton ("pay Order");
		payOrderButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		payOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		payOrderButton.setBounds(payButtonx, payButtony, payButtonWight, payButtonHeight);
		this.add(payOrderButton);
		
		payOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price=myOrder.getPrice();
				if(price>0){
				myPayJPanel.setPrice(myOrder);
				myPayJPanel.setVisible(true);
				currentJPanel.setVisible(false);
				}
			}
		});
	}
	
	public void setOrder(Order myOrder){
		this.myOrder=myOrder;
		drawOrder();
	}

	private void drawOrder() {
		myItemslist=myOrder.getOrderList();
		Iterator <Item> iteratore=getIterator();
		String baseCase="";
		String comma =",";
		String tabSpace="<br> &nbsp;&nbsp;&nbsp;";
		String newLine=" <br> ";
		String startBold = " <b> ";
		String endBold = " <\b ";
		String price="Price : ";
		
		
		while (iteratore.hasNext()){
			currentItem=iteratore.next();
			System.out.println(currentItem.getInfo());
			baseCase=baseCase+newLine+currentItem.getInfo();
			baseCase=baseCase.replaceAll(comma, tabSpace);
			baseCase=baseCase+newLine+startBold+price+currentItem.getPrice()+endBold+newLine;
			
		}
		
		descriptionLabel.setText("<html>"+baseCase+"<html>");
		
        
		
	}

	private Iterator<Item> getIterator() {
		return myItemslist.iterator();
	}
	
	

}
