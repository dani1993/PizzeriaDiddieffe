package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.pizza.Pizza;


public class OrderingJPanel extends JPanelWithBackgroundImg {

	private JButton AddToOrderButton;
	private JPanelWithBackgroundImg currentJPanel = this;
	private int addButtonWidth = 60;
	private int addButtonHeight = 200;
	private int addButtonx=150;
	private int addButtony=640;
	private CreateBaseCaseByName myCreator;
	private Object object;
	private Order currentOrder;
	private Item currentItem;
	private String currentClass;
	private ItemRemoverFromOrder myRemover;
	private LinkedList<JButton> buttonList;
	private int scrollPanex=20;
	private int scrollPaney=180;
	private int scrollPaneWidth=500;
	private int scrollPaneHeight=420;
	
	private JPanel panel;
	
	
	public OrderingJPanel(Image img,String currentBasePackage, String[] pizzaItems, String[] pizzaToppingList,String currentClass) {
		super(img);
		myCreator=new CreateBaseCaseByName();
		myRemover=new ItemRemoverFromOrder(); 
		buttonList=new LinkedList<JButton>();
		
		
		
		panel = new JPanel();
//		panel.setLayout(new GridLayout(4,4));
		
        JScrollPane scrollPane = new JScrollPane(panel);
       
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(scrollPanex, scrollPaney, scrollPaneWidth, scrollPaneHeight);
        scrollPane.setBorder(new LineBorder(Color.white,0));
        currentJPanel.add(scrollPane);
       
        
        
		
		this.currentClass=currentBasePackage;
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
					buttonList.add(currentItemButton);
					try{
					object=myCreator.createObjectByName(fullPackagePath+currentItemButton.getText());
					}catch(Exception exception){
						System.out.println(exception.getMessage());
					}
					
					currentItem=((Item) object);
				}
			});
			panel.add(currentItemButton);
			x = x + 140;
		}
		
			
	}
	
	

	
	private void createPizzaToppingsItems(String[] pizzaToppingsItems,String currentPackage) {
		int x = 35, y = 270, width = 90, height = 60;
		int toppingsForColumn=4;
		int fontSize = 14;

	for (int i = 0; i < pizzaToppingsItems.length; i++) {
			//se ho già 4 toppings per colonna vado alla colonna dopo
			if (i % toppingsForColumn == 0 && i != 0) {
				x = x + 110;
				y = 270;
			}

		final String fullPackagePath="pizzeriadiddieffe.core."+currentPackage+".";
		// create buttons for the toppings
		
			final String currentItemText = pizzaToppingsItems[i];
			final OrderItemJButton currentItemButton = new OrderItemJButton(x, y, width, height, fontSize,
					currentItemText);
//			currentItemButton.setEnabled(false);
			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeBorderColor(currentItemButton);
					buttonList.add(currentItemButton);
					if(getBorderColor(currentItemButton).equals(Color.green)){
					
					try{
						object=myCreator.createToppingByName(fullPackagePath+currentItemButton.getText(),currentItem,currentClass);
						}catch(Exception exception){
							System.out.println(exception.getMessage());
							System.out.println(currentItem.getPrice());
							System.out.println("errore");
						}
					
					System.out.println("Id ordine "+currentOrder.getId());
					castToCurrentClass(currentClass);
				}
					else{
						myRemover.removeItem(currentItem,currentItemText,currentClass);
					}
				}

				
				
			});
			
			panel.add(currentItemButton);
			y = y + 70;
		}
	}
	

	
	private void addOrderButton() {
		AddToOrderButton = new JButton("Add To Order");
		AddToOrderButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		AddToOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddToOrderButton.setBounds(addButtonx, addButtony,addButtonHeight, addButtonWidth);
		this.add(AddToOrderButton);

		AddToOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentItem!=null){
				try {
					currentOrder.add(currentItem);
					resetButtons();
					System.out.println(currentItem.getInfo());
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
			}

			
		});
	}
	
	private Iterator getIterator(){
		return buttonList.iterator();
	}
	
	private void resetButtons() {
		Iterator<JButton> iteratore=getIterator();
		while(iteratore.hasNext()){
		JButton currentButton=iteratore.next();
		resetBorderColor(currentButton);
		}
	}
	
	
	private void resetBorderColor(JButton currentButton) {
		currentButton.setBorder(new LineBorder(Color.white, 3, true));
		
	}

	private void changeBorderColor (OrderItemJButton currentItemButton) {
		Color currentBorder=getBorderColor(currentItemButton);
		if (currentBorder == Color.white) {
			currentItemButton.setBorder((new LineBorder(Color.green, 3, true)));
		}
		else {
			currentItemButton.setBorder(new LineBorder(Color.white, 3, true));
		}
	}
	
	private Color getBorderColor(OrderItemJButton currentItemButton) {
		Color currentBorder =  ((LineBorder)currentItemButton.getBorder()).getLineColor();
		return currentBorder;
	}
	
	
	
	private void castToCurrentClass(String currentClass) {
		if(currentClass.equals("pizza")){
			currentItem=(Pizza)object;
			return;
		}
		else if(currentClass.equals("beverage")){
			 currentItem=(Beverage)object;
			 return;
		}
		
		 currentItem=(Focaccia)object;
		 return;
	}
}
