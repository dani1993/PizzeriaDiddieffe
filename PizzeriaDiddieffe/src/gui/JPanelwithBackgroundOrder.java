package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.OrderManager;

public class JPanelwithBackgroundOrder extends JPanelWithBackgroundImgAndBackBtn {

	private JPanelWithBackgroundImgAndBackBtn currentJPanel = this;
	private OrderItemJButton pizzaButton;
	private OrderItemJButton beverageButton;
	private OrderItemJButton focacciaButton;
	private OrderItemJButton orderButton;
	private int buttonHeight = 230;
	private int buttonWidth = 230;
	private int startX = 35;
	private int startY = 165;
	private int space = 20;
	private int spacex = (buttonWidth) + space;
	private int spacey = (buttonHeight) + space;
	private int fontButtons = 24;
	
	private int width=550;
	private int height=750;

	private String[] pizzaClasses = {"BasicWhitePizza","BasicDoubleWhitePizza","BasicBrownPizza","TomatoSauce","Mozzarella","Anchovy"
			,"BufalaMozzarella","Ham","Onion","Olive","Mushrooms","Pepperoni","Porcini","Tuna","Sausage","Cream","Artichokes","Shrimps"};
	
	private String[] pizzaBasicClasses={"Basic Pizza", "Double Dough", "Brown Dough"};
	private String[] pizzaToppingImages = {"Tomato Sauce","Mozzarella", "Anchovy","Bufala","Ham","Onions","Olives","Mushrooms","Pepperoni"
			,"Porcini","Tuna","Sausages","Cream","Artichokes","Shrimps"};
	
	private static String  menuPizzaImagePath="res/pizzaOrdering.jpg";
	private String pizzaPackage="pizza";
	
	private String[] focacciaClasses = {"BasicWhiteFocaccia", "BasicBrownFocaccia", "Basic5CerealsFocaccia", "Mortadella","CookedHam"
			,"FreshBufalaMozzarella","FreshMozzarella","FreshTomato","Lettuce","Nutella","Olive","Pecorino","RawHam","Rosemary","Sausage"
			,"Stracchino"};
	private String[] focaccialist={"Basic Focaccia","Brown Focaccia","Five Cereals"};
	private String[] focacciaToppingList = {"Mortadella","Cooked Ham","Bufala","Mozzarella","Tomatoes","Lettuce","Nutella","Olives","Pecorino"
			,"Raw Ham","Rosemary","Sausages","Stracchino"};
	private static String  menuFocacciaImagePath="res/FocacciaOrdering.jpg";
	private String focacciaPackage="focaccia";
	
	private String[] beverageClasses = {"EmptyLittleGlass","EmptyMediumGlass","EmptyLargeGlass", "Water","FizzyWater","CocaCola","Fanta","Beer"};
	private String[] beveragelist={"Small","Medium","Large"};
	private String[] beverageToppingList = {"Water","Fizzy Water","Coke","Fanta","Beer"};
	private static String  menuBeverageImagePath="res/DrinksOrdering.jpg";
	private String beveragePackage="beverage";
	
	private Order currentOrder;
	private OrderViewer orderViewer;
	private Image orderViewerImage=new ImageIcon(menuBeverageImagePath).getImage().getScaledInstance(550, 750, java.awt.Image.SCALE_SMOOTH);;
	private OrderManager myOrderManager ;
	private OrderingJPanel pizzaOrderingPanel;
	private OrderingJPanel beverageOrderingPanel;
	private OrderingJPanel focacciaOrderingPanel;
	private OrderingPanelCreator myOrderingPanelCreator;
	
	private JFrame myFrame;
	
	public JPanelwithBackgroundOrder(Image image,JFrame frame) {
		super(image);
		myFrame=frame;
		myOrderManager = new OrderManager();
		myOrderingPanelCreator=new OrderingPanelCreator();
		createOrderingPanels();
		createOrderViewerPanel();
		drawChoiseButtons();
	}

	private void createOrderViewerPanel() {
//		Image menuBeverageImage=new ImageIcon(menuBeverageImagePath).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		orderViewer=new OrderViewer(orderViewerImage,myFrame,currentJPanel);
		orderViewer.setVisiblePanel(currentJPanel, myFrame);
		orderViewer.setVisible(false);
		myFrame.add(orderViewer);
		
	}

	
	private void createOrderingPanels() {
//		PizzeriaDiddieffeUI.progressBar.setValue(20);
		
		pizzaOrderingPanel=createOrderingPanel(menuPizzaImagePath, pizzaPackage, pizzaBasicClasses, pizzaToppingImages, pizzaClasses);
		beverageOrderingPanel=createOrderingPanel(menuBeverageImagePath, beveragePackage, beveragelist, beverageToppingList, beverageClasses);
		focacciaOrderingPanel=createOrderingPanel(menuFocacciaImagePath, focacciaPackage, focaccialist, focacciaToppingList, focacciaClasses);
		
	}

	
	private OrderingJPanel createOrderingPanel(String ImagePath,String basePackage,String[] baseCases,String[] toppings,String[] classes){
		myOrderingPanelCreator.setParameters(ImagePath, width, height);
		myOrderingPanelCreator.createPanel(basePackage, baseCases, toppings, classes);
		myOrderingPanelCreator.setOrderingBackButton(currentJPanel, myFrame);
		return myOrderingPanelCreator.getOrderingPanel();
	}
	
	
	public void setTableId (String id) {
		currentOrder=myOrderManager.checkOrder(id);
	}

	private void drawChoiseButtons(){
		
		pizzaButton=drawSelectedButton(pizzaButton, startX, startY,"Pizza");
		setActionListener(pizzaButton, pizzaOrderingPanel);
		
		beverageButton=drawSelectedButton(beverageButton, startX+spacex, startY, "Beverage");
		setActionListener(beverageButton, beverageOrderingPanel);
		
		focacciaButton=drawSelectedButton(focacciaButton, startX, startY+spacey, "Focaccia");
		setActionListener(focacciaButton, focacciaOrderingPanel);
		
		orderButton=drawSelectedButton(orderButton, startX+spacex,  startY+spacey, "Order");
		setOrderViewerListner(orderButton, orderViewer);

	}
	
	private void setOrderViewerListner(OrderItemJButton currentItemJButton,final OrderViewer currentOrderViewer){
		currentItemJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrderViewer.setOrder(currentOrder);
				currentJPanel.setVisible(false);
				currentOrderViewer.setVisible(true);
			}
		});
	}


	private OrderItemJButton drawSelectedButton(OrderItemJButton currentItemJButton,int startX,int startY,String text) {
		currentItemJButton = new OrderItemJButton(startX, startY,buttonWidth, buttonHeight, fontButtons, text);
		this.add(currentItemJButton);
		return currentItemJButton;
	}
	
	
	private void setActionListener(OrderItemJButton currentItemJButton,final OrderingJPanel currentOrderingPanel){
		currentItemJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrderingPanel.setOrder(currentOrder);
				currentJPanel.setVisible(false);
				currentOrderingPanel.setVisible(true);
			}
		});
	}
	
}
