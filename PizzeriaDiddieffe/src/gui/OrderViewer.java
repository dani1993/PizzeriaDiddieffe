package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

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
	private Item currentItem;
		
	public OrderViewer(Image img,JFrame myFrame) {
		super(img);
		
//		JScrollPane scrollPane = new JScrollPane(currentJPanel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setBounds(60, 270, 450, 450);
//        scrollPane.setBorder(new LineBorder(Color.white,0));
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(500, 400));
//        contentPane.add(scrollPane);
//        scrollPane.setVisible(false);
//        myFrame.setContentPane(contentPane);
	
        
		Image payOrderImage=new ImageIcon(payOrderImagePath).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		myPayJPanel=new payOrderJPanel(payOrderImage,myFrame);
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
		
		while (iteratore.hasNext()){
			currentItem=iteratore.next();
			System.out.println(currentItem.getInfo());
		}
		
        for (int i = 0; i < 10; i++) {
            currentJPanel.add(new JButton("Hello-" + i));
        }
        
		
	}

	private Iterator<Item> getIterator() {
		return myItemslist.iterator();
	}
	
	

}
