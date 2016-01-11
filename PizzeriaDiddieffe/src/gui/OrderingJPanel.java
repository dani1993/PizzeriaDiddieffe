package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import pizzeriadiddieffe.core.Order;


public class OrderingJPanel extends JPanelWithBackgroundImg{

	private JButton AddToOrderButton;
	private JPanelWithBackgroundImg currentJPanel=this;
	private int addButtonWidth=300;
	private int addButtonHeight=500;
	
	public OrderingJPanel(Image img,Order currentOrder,String[] items) {
		super(img);
		createOrderItems(items);
		addOrderButton();
	}
	
	
	private void createOrderItems(String[] items){

		int x=100;
		int y=100;
		int width=100;
		int height=70;
		int font=15;
		
		for(int i=0;i<items.length;i++){
			String currentItemText=items[i];
			currentItemText="res/"+currentItemText+".jpg";
			System.out.println(currentItemText);
			final OrderItemJButton currentItemButton=new OrderItemJButton(x, y, width, height,font,currentItemText);
			
			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.out.println(currentItemButton.getText()+" creato oggetto/inserito in List.");
					
				
				}
			});
			
			currentJPanel.add(currentItemButton);
			
		}
	}
	
	
	private void addOrderButton() {
		AddToOrderButton = new JButton ("Add To Order");
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
		
}
