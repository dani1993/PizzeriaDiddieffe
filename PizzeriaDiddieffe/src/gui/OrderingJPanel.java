package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import pizzeriadiddieffe.core.Order;

public class OrderingJPanel extends JPanelWithBackgroundImg {

	private JButton AddToOrderButton;
	private JPanelWithBackgroundImg currentJPanel = this;
	private int addButtonWidth = 300;
	private int addButtonHeight = 500;

	public OrderingJPanel(Image img, Order currentOrder, String[] pizzaItems, String[] pizzaToppingList) {
		super(img);
		createPizzaToppingsItems(pizzaToppingList);
		createPizzaItems(pizzaItems);
		addOrderButton();
	}

	private void createPizzaItems(String[] pizzaItems) {
		int x = 75;
		int y = 180;
		int width = 120;
		int height = 70;
		int fontSize = 15;
		
		// create buttons for the 3 doughs
		for (int i = 0; i < pizzaItems.length; i++) {
			String currentItemText = pizzaItems[i];
			final OrderItemJButton currentItemButton = new OrderItemJButton(x, y, width, height, fontSize,
					currentItemText);
			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					System.out.println(currentItemButton.getText() + " creato oggetto/inserito in List.");
					changeBorderColor(currentItemButton);
				}
			});
			currentJPanel.add(currentItemButton);
			x = x + 140;
		}
	}

	private void createPizzaToppingsItems(String[] pizzaToppingsItems) {
		int x = 35, y = 260, width = 90, height = 60;
		int fontSize = 14;

		// create buttons for the toppings
		for (int i = 0; i < pizzaToppingsItems.length; i++) {
			String currentItemText = pizzaToppingsItems[i];
			final OrderItemJButton currentItemButton = new OrderItemJButton(x, y, width, height, fontSize,
					currentItemText);
//			currentItemButton.setEnabled(false);
			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeBorderColor(currentItemButton);
					System.out.println(currentItemButton.getText() + " creato oggetto/inserito in List.");

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
		AddToOrderButton.setBounds(addButtonWidth, addButtonHeight, 100, 50);
		this.add(AddToOrderButton);

		AddToOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Aggiunti oggetti selezionati a ordine");
			}
		});
	}
	private void changeBorderColor (OrderItemJButton currentItemButton) {
		Color currentBorder =  ((LineBorder)currentItemButton.getBorder()).getLineColor();
		if (currentBorder == Color.white) {
			currentItemButton.setBorder((new LineBorder(Color.green, 3, true)));
		}
		else {
			currentItemButton.setBorder(new LineBorder(Color.white, 3, true));
		}
	}
}
