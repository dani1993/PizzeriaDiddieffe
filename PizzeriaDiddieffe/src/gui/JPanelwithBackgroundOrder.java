package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.OrderManager;

public class JPanelwithBackgroundOrder extends JPanelWithBackgroundImg{

	private JPanelWithBackgroundImg currentJPanel=this;
	private JButton pizzaButton;
	private JButton beverageButton;
	private JButton focacciaButton;
	private JButton orderButton;
	private int buttonHeight=230;
	private int buttonWidth=230;
	private int startX=35;
	private int startY=150;
	private int space=20;
	private int spacex=(buttonWidth)+space;
	private int spacey=(buttonHeight)+space;
	private int fontButtons=24;
	
	private String[] pizzaBasicClasses={"Basic Pizza", "Double Dough", "Brown Dough"};
	private String[] pizzaToppingImages = {"Tomato Sauce","Mozzarella", "Anchovy","Bufala","Ham","Onions","Olives","Mushrooms","Pepperoni","Porcini","Tuna","Sausages","Cream","Artichokes","Shrimps"};
	
	private static String  menuPizzaImagePath="res/pizzaOrdering.jpg";
	private String pizzaPackage="pizza";
	private String currentDecorator;
	
	private String[] focaccialist={"Basic Focaccia","Brown Focaccia","Five Cereals"};
	private String[] focacciaToppingList = {"Mortadella","Cooked Ham","Bufala","Mozzarella","Tomatoes","Lettuce","Nutella","Olives","Pecorino","Raw Ham","Rosemary","Sausages","Stracchino"};
	private static String  menuFocacciaImagePath="res/FocacciaOrdering.jpg";
	private String focacciaPackage="focaccia";
	
	private String[] beveragelist={"Small","Medium","Large"};
	private String[] beverageToppingList = {"Water","Fizzy Water","Coke","Fanta","Beer"};
	private static String  menuBeverageImagePath="res/drinksOrdering.jpg";
	private String beveragePackage="beverage";
	
	private static String orderViewerImagePath="res/bill.jpg";
	private Order currentOrder;
	private OrderViewer orderViewer;
	private OrderManager myOrderManager = new OrderManager();
	private OrderingJPanel pizzaOrderingPanel;
	private OrderingJPanel beverageOrderingPanel;
	private OrderingJPanel focacciaOrderingPanel;
	
	public JPanelwithBackgroundOrder(Image image,JFrame frame) {
		super(image);
		drawChoiseButtons();
		createOrderingPanels(frame);
	}

	
	public void createOrderingPanels(JFrame myFrame) {
		int width = 550, height = 750;
		Image menuPizzaImage=new ImageIcon(menuPizzaImagePath).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		pizzaOrderingPanel=new OrderingJPanel(menuPizzaImage,pizzaPackage,pizzaBasicClasses, pizzaToppingImages,currentDecorator);
		myFrame.add(pizzaOrderingPanel);
		pizzaOrderingPanel.setVisiblePanel(currentJPanel, myFrame);
		pizzaOrderingPanel.setVisible(false);
		myFrame.add(pizzaOrderingPanel);
		
		Image menuBeverageImage=new ImageIcon(menuBeverageImagePath).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		beverageOrderingPanel=new OrderingJPanel(menuBeverageImage,beveragePackage,beveragelist, beverageToppingList,currentDecorator);
		myFrame.add(beverageOrderingPanel);
		beverageOrderingPanel.setVisiblePanel(currentJPanel, myFrame);
		beverageOrderingPanel.setVisible(false);
		myFrame.add(beverageOrderingPanel);
		
		Image menuFocacciaImage=new ImageIcon(menuFocacciaImagePath).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		focacciaOrderingPanel=new OrderingJPanel(menuFocacciaImage, focacciaPackage,focaccialist, focacciaToppingList,currentDecorator);
		myFrame.add(focacciaOrderingPanel);
		focacciaOrderingPanel.setVisiblePanel(currentJPanel, myFrame);
		focacciaOrderingPanel.setVisible(false);
		myFrame.add(focacciaOrderingPanel);
		
		orderViewer=new OrderViewer(menuPizzaImage,myFrame,currentJPanel);
		orderViewer.setVisiblePanel(currentJPanel, myFrame);
		orderViewer.setVisible(false);
		myFrame.add(orderViewer);
	}
	
	public void setTableId (String id) {
		currentOrder=myOrderManager.checkOrder(id);
	}


	private void drawChoiseButtons(){// creo i quattro pulsanti per ordinare i cibi o visionare il conto ed eventualmente pagare
		pizzaButton = new OrderItemJButton(startX, startY,buttonWidth, buttonHeight, fontButtons, "pizzatest");
		
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
		
		beverageButton = new OrderItemJButton(startX+spacex, startY, buttonWidth, buttonHeight, fontButtons, "beveragetest");
		
		this.add(beverageButton);

		beverageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBeverageMenuVisible();
			}

			private void setBeverageMenuVisible() {
				beverageOrderingPanel.setOrder(currentOrder);
				currentJPanel.setVisible(false);
				beverageOrderingPanel.setVisible(true);
			}

			
		});
		
		focacciaButton = new OrderItemJButton(startX, startY+spacey, buttonWidth, buttonHeight, fontButtons, "focacciatest");
	
		this.add(focacciaButton);

		focacciaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFocacciaMenuVisible();
			}

			private void setFocacciaMenuVisible() {
				focacciaOrderingPanel.setOrder(currentOrder);
				currentJPanel.setVisible(false);
				focacciaOrderingPanel.setVisible(true);
			}

			
		});
		
		orderButton=new OrderItemJButton(startX+spacex, startY+spacey, buttonWidth, buttonHeight,fontButtons,"Order");
		this.add(orderButton);

		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOrderMenuVisible();
			}

			private void setOrderMenuVisible() {
				orderViewer.setOrder(currentOrder);
				orderViewer.setVisible(true);
				currentJPanel.setVisible(false);
			}

			
		});
	}

	
	
}
