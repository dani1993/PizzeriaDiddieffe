package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.OrderManager;

public class JPanelwithBackgroundOrder extends JPanelWithBackgroundImg{

	private JPanelWithBackgroundImg currentJPanel=this;
	private JButton pizzaButton;
	private JButton beverageButton;
	private JButton focacciaButton;
	private JButton orderButton;
	private String[] pizzalist={"Basic Pizza", "Double Dough", "Brown Dough"};
	private String[] pizzaToppingList = {"Anchovy","Bufala","Ham"};
	private String[] focaccialist={"",""};
	private String[] beveragelist={"",""};
	private static String  menuPizzaImagePath="res/pizzaOrdering.jpg";
	private static String  menuBeverageImagePath="";
	private static String  menuFocacciaImagePath="";
	private Order currentOrder;
	private OrderViewer orderViewer;
	private OrderManager myOrderManager = new OrderManager();
	private OrderingJPanel pizzaOrderingPanel;
	
	public JPanelwithBackgroundOrder(Image image,Frame frame) {
		super(image);
		drawChoiseButtons();
		createOrderingPanels(frame);
		
	}

	
	public void createOrderingPanels(Frame myFrame) {
		int width = 550, height = 750;
		Image menuPizzaImage=new ImageIcon(menuPizzaImagePath).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		pizzaOrderingPanel=new OrderingJPanel(menuPizzaImage,currentOrder, pizzalist, pizzaToppingList);
		myFrame.add(pizzaOrderingPanel);
		pizzaOrderingPanel.setVisiblePanel(currentJPanel, myFrame);
		pizzaOrderingPanel.setVisible(false);
		myFrame.add(pizzaOrderingPanel);
		
		orderViewer=new OrderViewer(menuPizzaImage,myFrame);
		orderViewer.setVisiblePanel(currentJPanel, myFrame);
		orderViewer.setVisible(false);
		myFrame.add(orderViewer);
		
		
		
	}
	
	public void setTableId (String id) {
		currentOrder=myOrderManager.checkOrder(id);
	}


	private void drawChoiseButtons(){// creo i quattro pulsanti per ordinare i cibi o visionare il conto ed eventualmente pagare
		pizzaButton = new OrderItemJButton(70, 500, 100, 50, 16, "pizzatest");
		
		this.add(pizzaButton);

		pizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPizzaMenuVisible();
			}

			private void setPizzaMenuVisible() {
				currentJPanel.setVisible(false);
				pizzaOrderingPanel.setVisible(true);
				
			}

			
		});
		
		beverageButton = new JButton ("beverage");
		beverageButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		beverageButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		beverageButton.setBounds(150, 40, 100, 50);
		this.add(beverageButton);

		beverageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBeverageMenuVisible();
			}

			private void setBeverageMenuVisible() {
				// TODO Auto-generated method stub
				
			}

			
		});
		
		focacciaButton = new JButton ("focaccia");
		focacciaButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		focacciaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		focacciaButton.setBounds(70, 100, 100, 50);
		this.add(focacciaButton);

		focacciaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFocacciaMenuVisible();
			}

			private void setFocacciaMenuVisible() {
				// TODO Auto-generated method stub
				
			}

			
		});
		
		orderButton = new JButton ("order");
		orderButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		orderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		orderButton.setBounds(350, 100, 100, 50);
		this.add(orderButton);

		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOrderMenuVisible();
			}

			private void setOrderMenuVisible() {
				orderViewer.setVisible(true);
				currentJPanel.setVisible(false);
			}

			
		});
	}

	
	
}
