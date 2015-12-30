package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class JPanelwithBackgroundOrder extends JPanelWithBackgroundImg{

	
	private JButton pizzaButton;
	private JButton beverageButton;
	private JButton focacciaButton;
	private JButton orderButton;
	
	
	
	public JPanelwithBackgroundOrder(Image image) {
		super(image);
		drawChoiseButtons();
		// TODO Auto-generated constructor stub
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
				// TODO Auto-generated method stub
				
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
