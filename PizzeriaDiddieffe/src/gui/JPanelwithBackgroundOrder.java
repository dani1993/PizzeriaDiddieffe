package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.OrderManager;

public class JPanelwithBackgroundOrder extends JPanelWithBackgroundImg{

	private JPanelWithBackgroundImg currentJPanel=this;
	private JButton pizzaButton;
	private JButton beverageButton;
	private JButton focacciaButton;
	private JButton orderButton;
	private String[] pizzalist={"pizzatrancio","tavolo2"};
	private String[] focaccialist={"",""};
	private String[] beveragelist={"",""};
	private static String  menuPizzaImagePath="pizzaMenutest.jpeg";
	private static String  menuBeverageImagePath="";
	private static String  menuFocacciaImagePath="";
	private Order currentOrder;
	private OrderingJPanel pizzaOrderingPanel;
	private OrderManager myOrderManager = new OrderManager();
	
	
	public JPanelwithBackgroundOrder(Image image,Frame frame) {
		super(image);
		drawChoiseButtons();
		createOrderingPanels(frame);
		
	}
	
	public void setTableId (String id) {
		currentOrder=myOrderManager.checkOrder(id);
	}
	
	public void createOrderingPanels(Frame myFrame) {
		Image menuPizzaImage=new ImageIcon(menuPizzaImagePath).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		pizzaOrderingPanel=new OrderingJPanel(menuPizzaImage,pizzalist);
		myFrame.add(pizzaOrderingPanel);
		pizzaOrderingPanel.setVisiblePanel(currentJPanel, myFrame);
		pizzaOrderingPanel.setVisible(false);
		
	}


	private void drawChoiseButtons(){// creo i quattro pulsanti per ordinare i cibi o visionare il conto ed eventualmente pagare
		pizzaButton = new JButton ("pizza");
		pizzaButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		pizzaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pizzaButton.setBounds(70, 500, 100, 50);
		this.add(pizzaButton);

		pizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPizzaMenuVisible();
			}

			private void setPizzaMenuVisible() {
				pizzaOrderingPanel.setOrder(currentOrder);
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
				
			}

			
		});
	}

	
	
}
