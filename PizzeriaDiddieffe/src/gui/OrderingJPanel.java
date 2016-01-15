package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.BoxLayout;
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
	private int addButtonx = 150;
	private int addButtony = 640;
	private CreateBaseCaseByName myCreator;
	private Object object;
	private Order currentOrder;
	private Item currentItem;
	private String currentClass;
	private String[] currentClassName;
	private ItemRemoverFromOrder myRemover;
	private LinkedList<JButton> buttonList;
	private int scrollPanex = 10;
	private int scrollPaney = 180;
	private int scrollPaneWidth = 530;
	private int scrollPaneHeight = 420;
	

	private JPanel panel;

	private int baseFontSize = 15;
	private int baseCasesx = 75; // 75
	private int baseCasesy = 190; // 180
	private int baseCasesWidth = 120;
	private int baseCasesHeight = 70;
	private int baseCaseXToMove = 140;

	private int toppingX = 38;// 35
	private int toppingYToStart = 290;
	private int toppingY = toppingYToStart;
	private int toppingWidth = 110;
	private int toppingHeight = 60;
	private int toppingsForColumn = 4;
	private int toppingFontSize = 13;
	private int toppingYToMove = 80;
	private int toppingXToMove = 125;

	private GridBagConstraints gdc;

	public OrderingJPanel(Image img, String currentBasePackage, String[] pizzaItems, String[] pizzaToppingList, String[] classNameList) {
		super(img);
		myCreator = new CreateBaseCaseByName();
		myRemover = new ItemRemoverFromOrder();
		buttonList = new LinkedList<JButton>();
		
		panel = new JPanel();

		currentClassName = classNameList;
		// panel.setLayout(new GridLayout(6,6));
		// gdc = new GridBagConstraints(
		// panel.setLayout(currentJPanel.getLayout());
		//
		// JScrollPane scrollPane = new JScrollPane(panel);
		// scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		// scrollPane.setBounds(scrollPanex, scrollPaney, scrollPaneWidth,
		// scrollPaneHeight);
		// scrollPane.setBorder(new LineBorder(Color.white,0));
		// scrollPane.setWheelScrollingEnabled(true);
		// currentJPanel.add(scrollPane);
		System.out.println(currentBasePackage);
		this.currentClass = currentBasePackage;
		String currentToppingPackage = currentBasePackage + ".topping";
		createPizzaItems(pizzaItems, currentBasePackage);
		createPizzaToppingsItems(pizzaToppingList, currentToppingPackage, (pizzaItems.length));
		
		
		addOrderButton();

	}

	public void setOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	private void createPizzaItems(String[] pizzaItems, String currentPackage) {
		final String fullPackagePath = "pizzeriadiddieffe.core." + currentPackage + ".";
		
		// create buttons for the 3 doughs
		for (int i = 0; i < pizzaItems.length; i++) {
			String className = currentClassName[i];
			String currentItemText = pizzaItems[i];
			final OrderItemJButton currentItemButton = new OrderItemJButton(baseCasesx, baseCasesy, baseCasesWidth,
					baseCasesHeight, baseFontSize, currentItemText);
			currentItemButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					System.out.println(currentItemButton.getText() + " creato oggetto/inserito in List.");
					changeBorderColor(currentItemButton);
					buttonList.add(currentItemButton);
					try {
						object = myCreator.createObjectByName(fullPackagePath + className);
					} catch (Exception exception) {
						System.out.println(exception.getMessage());
					}

					currentItem = ((Item) object);
				}
			});
			// gdc.gridx=baseCasesx;
			// gdc.gridy=baseCasesy;
			//
			// gdc.anchor = GridBagConstraints.FIRST_LINE_START;
			// panel.add(currentItemButton,gdc);
			currentJPanel.add(currentItemButton);

			baseCasesx = baseCasesx + baseCaseXToMove;
		}

	}

	private void createPizzaToppingsItems(String[] toppingsItems, String currentPackage, int pizzaBasicItems) {
		for (int i = 0; i < toppingsItems.length; i++) {
			String className = currentClassName[i+pizzaBasicItems];

			// se ho già 4 toppings per colonna vado alla colonna dopo
			if (i % toppingsForColumn == 0 && i != 0) {
				toppingX = toppingX + toppingXToMove;
				toppingY = toppingYToStart;
			}

			final String fullPackagePath = "pizzeriadiddieffe.core." + currentPackage + ".";
			// create buttons for the toppings

			final String currentItemText = toppingsItems[i];
			
			final OrderItemJButton currentItemButton = new OrderItemJButton(toppingX, toppingY, toppingWidth,
					toppingHeight, toppingFontSize, currentItemText);
			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeBorderColor(currentItemButton);

					if (getBorderColor(currentItemButton).equals(Color.green)) {
						buttonList.add(currentItemButton);
						try {
							System.out.println(fullPackagePath + currentItemButton.getText() + currentItem + currentClass);

							object = myCreator.createToppingByName(fullPackagePath + className,
									currentItem, currentClass);
						} catch (Exception exception) {
//							System.out.println(exception.getMessage());
							System.out.println(currentItem.getPrice());
							System.out.println("errore");
						}

						System.out.println("Id ordine " + currentOrder.getId());
						castToCurrentClass(currentClass);
					} else {
//						(Pizza)object.remove
//						myRemover.removeItem(currentItem, currentItemText, currentClass);
					}
				}

			});

			currentJPanel.add(currentItemButton);
			toppingY = toppingY + toppingYToMove;
		}
	}

	private void addOrderButton() {
		AddToOrderButton = new JButton("Add To Order");
		AddToOrderButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		AddToOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddToOrderButton.setBounds(addButtonx, addButtony, addButtonHeight, addButtonWidth);
		this.add(AddToOrderButton);

		AddToOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentItem != null) {
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

	private Iterator getIterator() {
		return buttonList.iterator();
	}

	private void resetButtons() {
		Iterator<JButton> iteratore = getIterator();
		while (iteratore.hasNext()) {
			JButton currentButton = iteratore.next();
			resetBorderColor(currentButton);
		}
	}

	private void resetBorderColor(JButton currentButton) {
		currentButton.setBorder(new LineBorder(Color.white, 3, true));

	}

	private void changeBorderColor(OrderItemJButton currentItemButton) {
		Color currentBorder = getBorderColor(currentItemButton);
		if (currentBorder == Color.white) {
			currentItemButton.setBorder((new LineBorder(Color.green, 3, true)));
		} else {
			currentItemButton.setBorder(new LineBorder(Color.white, 3, true));
		}
	}

	private Color getBorderColor(OrderItemJButton currentItemButton) {
		Color currentBorder = ((LineBorder) currentItemButton.getBorder()).getLineColor();
		return currentBorder;
	}

	private void castToCurrentClass(String currentClass) {
		if (currentClass.equals("pizza")) {
			currentItem = (Pizza) object;
			return;
		} else if (currentClass.equals("beverage")) {
			currentItem = (Beverage) object;
			return;
		}
		currentItem = (Focaccia) object;
		return;
	}
}
