package pizzeriadiddieffe.gui.jpanel.jpanelwithbackground;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.OrderManager;
import pizzeriadiddieffe.gui.OrderViewer;
import pizzeriadiddieffe.gui.creators.OrderingPanelCreator;
import pizzeriadiddieffe.gui.jbutton.JButtonTextImage;
import pizzeriadiddieffe.gui.jpanel.OrderingJPanel;

@SuppressWarnings("serial")
public class JPanelWithBackgroundOrder extends JPanelWithBackgroundImgAndBackBtn implements JPanelWithImageOrderInterface{
	private JPanelWithBackgroundImgAndBackBtn currentJPanel = this;
	private JButtonTextImage pizzaButton;
	private JButtonTextImage beverageButton;
	private JButtonTextImage focacciaButton;
	private JButtonTextImage orderButton;
	private int buttonHeight = 230;
	private int buttonWidth = 230;
	private int startX = 35;
	private int startY = 165;
	private int space = 20;
	private int spaceX = buttonWidth+space;
	private int spaceY = buttonHeight+space;
	private int fontButtons = 24;

	private int width = 550;
	private int height = 750;

	private String[] pizzaClasses = {"BasicWhitePizza", "BasicDoubleWhitePizza", "BasicBrownPizza", "TomatoSauce", "Mozzarella", "Anchovy",
			"BufalaMozzarella", "Ham", "Onion", "Olive", "Mushrooms", "Pepperoni", "Porcini", "Tuna", "Sausage",
			"Cream", "Artichokes", "Shrimps"};

	private String[] pizzaBasicClasses = {"Basic Pizza", "Double Dough", "Brown Dough"};
	private String[] pizzaToppingImages = {"Tomato Sauce", "Mozzarella", "Anchovy", "Bufala", "Ham", "Onions", "Olives", "Mushrooms", "Pepperoni",
			"Porcini", "Tuna", "Sausages", "Cream", "Artichokes", "Shrimps"};

	private static String menuPizzaImagePath = "res/pizzaOrdering.jpg";
	private String pizzaPackage = "pizza";

	private String[] focacciaClasses = {"BasicWhiteFocaccia", "BasicBrownFocaccia", "Basic5CerealsFocaccia", "Mortadella", "CookedHam", "FreshBufalaMozzarella",
			"FreshMozzarella", "FreshTomato", "Lettuce", "Nutella", "Olive", "Pecorino", "RawHam", "Rosemary", "Sausage", "Stracchino"};

	private String[] focacciaList = {"Basic Focaccia", "Brown Focaccia", "Five Cereals"};
	private String[] focacciaToppingList = {"Mortadella", "Cooked Ham", "Bufala", "Mozzarella", "Tomatoes", "Lettuce", "Nutella", "Olives",
			"Pecorino", "Raw Ham", "Rosemary", "Sausages", "Stracchino"};

	private static String menuFocacciaImagePath = "res/FocacciaOrdering.jpg";
	private String focacciaPackage = "focaccia";

	private String[] beverageClasses = {"EmptyLittleGlass", "EmptyMediumGlass", "EmptyLargeGlass", "Water", "FizzyWater", "CocaCola", "Fanta", "Beer"};

	private String[] beverageList = {"Small", "Medium", "Large"};
	private String[] beverageToppingList = {"Water", "Fizzy Water", "Coke", "Fanta", "Beer"};

	private static String menuBeverageImagePath = "res/DrinksOrdering.jpg";
	private String beveragePackage = "beverage";
	
	private static String orderViewerBGImagePath = "res/OrderViewerBG.jpg";

	private Order currentOrder;
	private OrderViewer orderViewer;
	private Image orderViewerImage = new ImageIcon(orderViewerBGImagePath).getImage().getScaledInstance(550, 750, java.awt.Image.SCALE_SMOOTH);;
	private OrderManager myOrderManager ;
	private OrderingJPanel pizzaOrderingPanel;
	private OrderingJPanel beverageOrderingPanel;
	private OrderingJPanel focacciaOrderingPanel;
	private OrderingPanelCreator myOrderingPanelCreator;

	private JFrame myFrame;

	public JPanelWithBackgroundOrder(Image image, JFrame frame) {
		super(image);
		myFrame = frame;
		myOrderManager = new OrderManager();
		myOrderingPanelCreator = new OrderingPanelCreator();
		createOrderingPanels();
		createOrderViewerPanel();
		drawChoiceButtons();
	}

	private void createOrderViewerPanel() {
		//		Image menuBeverageImage = new ImageIcon(menuBeverageImagePath).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		orderViewer = new OrderViewer(orderViewerImage, myFrame, currentJPanel);
		orderViewer.setVisiblePanel(currentJPanel, myFrame);
		orderViewer.setVisible(false);
		myFrame.add(orderViewer);
	}

	private void createOrderingPanels() {
		pizzaOrderingPanel = createOrderingPanel(menuPizzaImagePath, pizzaPackage, pizzaBasicClasses, pizzaToppingImages, pizzaClasses);
		beverageOrderingPanel = createOrderingPanel(menuBeverageImagePath, beveragePackage, beverageList, beverageToppingList, beverageClasses);
		focacciaOrderingPanel = createOrderingPanel(menuFocacciaImagePath, focacciaPackage, focacciaList, focacciaToppingList, focacciaClasses);
	}

	private OrderingJPanel createOrderingPanel(String ImagePath, String basePackage, String[] baseCases, String[] toppings, String[] classes){
		myOrderingPanelCreator.setParameters(ImagePath, width, height);
		myOrderingPanelCreator.createPanel(basePackage, baseCases, toppings, classes);
		myOrderingPanelCreator.setOrderingBackButton(currentJPanel, myFrame);
		return myOrderingPanelCreator.getOrderingPanel();
	}

	@Override
	public void setTableId (String id) {
		currentOrder = myOrderManager.checkOrder(id);
	}

	private void drawChoiceButtons(){
		pizzaButton = drawSelectedButton(pizzaButton, startX, startY, "Pizza");
		setActionListener(pizzaButton, pizzaOrderingPanel);

		beverageButton = drawSelectedButton(beverageButton, startX+spaceX, startY, "Beverage");
		setActionListener(beverageButton, beverageOrderingPanel);

		focacciaButton = drawSelectedButton(focacciaButton, startX, startY+spaceY, "Focaccia");
		setActionListener(focacciaButton, focacciaOrderingPanel);

		orderButton = drawSelectedButton(orderButton, startX+spaceX,  startY+spaceY, "Order");
		setOrderViewerListner(orderButton, orderViewer);
	}

	private void setOrderViewerListner(JButtonTextImage currentItemJButton, final OrderViewer currentOrderViewer){
		currentItemJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrderViewer.setOrder(currentOrder);
				currentJPanel.setVisible(false);
				currentOrderViewer.setVisible(true);
			}
		});
	}

	private JButtonTextImage drawSelectedButton(JButtonTextImage currentItemJButton, int startX, int startY, String text) {
		currentItemJButton = new JButtonTextImage(startX, startY, buttonWidth, buttonHeight, fontButtons, text);
		this.add(currentItemJButton);
		return currentItemJButton;
	}

	private void setActionListener(JButtonTextImage currentItemJButton, final OrderingJPanel currentOrderingPanel){
		currentItemJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentOrderingPanel.setOrder(currentOrder);
				currentJPanel.setVisible(false);
				currentOrderingPanel.setVisible(true);
			}
		});
	}
}