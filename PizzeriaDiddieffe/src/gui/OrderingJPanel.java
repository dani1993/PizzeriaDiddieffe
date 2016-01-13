package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.pizza.Pizza;


public class OrderingJPanel extends JPanelWithBackgroundImg {

	private JButton AddToOrderButton;
	private JPanelWithBackgroundImg currentJPanel = this;
	private int addButtonWidth = 300;
	private int addButtonHeight = 500;
	private CreateBaseCaseByName myCreator=new CreateBaseCaseByName();
	private Object object;
	private Order currentOrder;
	private Item currentItem;
	private Object currentClass;
	
	
	public OrderingJPanel(Image img,String currentBasePackage, String[] pizzaItems, String[] pizzaToppingList,String currentClass) {
		super(img);
		
		
		String currentToppingPackage=currentBasePackage+".topping";
		createPizzaItems(pizzaItems,currentBasePackage);
		createPizzaToppingsItems(pizzaToppingList,currentToppingPackage);
		
		addOrderButton();
	}

	public void setOrder(Order currentOrder){
		this.currentOrder=currentOrder;
	}
	
	private void createPizzaItems(String[] pizzaItems,String currentPackage) {
		int x = 75;
		int y = 180;
		int width = 120;
		int height = 70;
		int fontSize = 15;
		final String fullPackagePath="pizzeriadiddieffe.core."+currentPackage+".";
		
		// create buttons for the 3 doughs
		for (int i = 0; i < pizzaItems.length; i++) {
			String currentItemText = pizzaItems[i];
			final OrderItemJButton currentItemButton = new OrderItemJButton(x, y, width, height, fontSize,
					currentItemText);
			currentItemButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					System.out.println(currentItemButton.getText() + " creato oggetto/inserito in List.");
					changeBorderColor(currentItemButton);
					
					//creo oggetto relativo alla classe con nome currentItemButton.getText()
					try{
					object=myCreator.createObjectByName(fullPackagePath+currentItemButton.getText());
					}catch(Exception exception){
						System.out.println(exception.getMessage());
					}
					
					
//					System.out.println(((Pizza) object).getInfo());
//					System.out.println(((currentClass.getClass()) object).getPrice());
//					
//				currentPizza=((currentClass.getClass()) object);
					
					
				}
			});
			currentJPanel.add(currentItemButton);
			x = x + 145;
		}
	}
	
	

	private void createPizzaToppingsItems(String[] pizzaToppingsItems,String currentPackage) {
		int x = 38, y = 290, width = 105, height = 60;
		int toppingsForColumn=4;
		int fontSize = 14;

	for (int i = 0; i < pizzaToppingsItems.length; i++) {
			//se ho già 4 toppings per colonna vado alla colonna dopo
			if (i % toppingsForColumn == 0 && i != 0) {
				x = x + 120;
				y = 290;
			}

		final String fullPackagePath="pizzeriadiddieffe.core."+currentPackage+".";
		// create buttons for the toppings
		
			String currentItemText = pizzaToppingsItems[i];
			final OrderItemJButton currentItemButton = new OrderItemJButton(x, y, width, height, fontSize,
					currentItemText);
//			currentItemButton.setEnabled(false);
			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeBorderColor(currentItemButton);
					System.out.println(currentItemButton.getText() + " creato oggetto/inserito in List.");
					
					try{
//						object=myCreator.createToppingByName(fullPackagePath+currentItemButton.getText(),myPizza);
						}catch(Exception exception){
							System.out.println(exception.getMessage());
						}
					
//				System.out.println(((currentClass) object).getInfo());
//				System.out.println(((currentClass) object).getPrice());
				
					
					
				}
			});
			
			currentJPanel.add(currentItemButton);
			y = y + 70;
		}
	}
	

	private void addOrderButton() {
		AddToOrderButton = new JButton("Add To Order");
		AddToOrderButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		AddToOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddToOrderButton.setBounds(400, 600, 140, 50);
		this.add(AddToOrderButton);

		AddToOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Aggiunti oggetti selezionati a ordine");
				
				if(currentItem!=null){
				try {
					currentOrder.add(currentItem);
					System.out.println(currentItem.getInfo());
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
			}
		});
	}
	
	
	private void changeBorderColor (OrderItemJButton currentItemButton) {
		Color currentBorder =  ((LineBorder)currentItemButton.getBorder()).getLineColor();
		if (currentBorder == Color.white) {
			currentItemButton.setBorder((new LineBorder(Color.green, 3, true)));
			currentItemButton.setForeground(Color.black);
		}
		else {
			currentItemButton.setBorder(new LineBorder(Color.white, 3, true));
			currentItemButton.setForeground(Color.white);
		}
	}
}
