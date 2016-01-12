package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;

public class OrderViewer extends JPanelWithBackgroundImg{
 
	private  JPanelWithBackgroundImg currentJPanel=this;
	private payOrderJPanel myPayJPanel;
	private Order myOrder;
	private LinkedList<Item> myItemslist;
	private JButton payOrderButton;
	private int payButtonx=400;
	private int payButtony=500;
	private int payButtonHeight = 50;
	private int payButtonWight = 150;
	private String payOrderImagePath="res/payOrderBackground.jpg";
		
	public OrderViewer(Image img,Frame myFrame) {
		super(img);

		Image payOrderImage=new ImageIcon(payOrderImagePath).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		myPayJPanel=new payOrderJPanel(payOrderImage);
		myPayJPanel.setVisiblePanel(currentJPanel, myFrame);
		myPayJPanel.setVisible(false);
		myFrame.add(myPayJPanel);
		
		
		payOrderButton = new JButton ("pay Order");
		payOrderButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		payOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		payOrderButton.setBounds(payButtonx, payButtony, payButtonWight, payButtonHeight);
		this.add(payOrderButton);
		
		payOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myPayJPanel.setVisible(true);
				currentJPanel.setVisible(false);
			}
		});
	}
	
	public void setOrder(Order myOrder){
		this.myOrder=myOrder;
		drawOrder();
	}

	private void drawOrder() {
		myItemslist=myOrder.getOrderList();
		
	}

}
