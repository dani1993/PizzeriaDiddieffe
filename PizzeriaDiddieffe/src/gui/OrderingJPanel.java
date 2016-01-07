package gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import pizzeriadiddieffe.core.Order;


public class OrderingJPanel extends JPanelWithBackgroundImg{

	private JButton AddToOrderButton;
	private int addButtonWidth=300;
	private int addButtonHeight=500;
	
	public OrderingJPanel(Image img,Order currentOrder,String[] items) {
		super(img);
		createOrderItems(items);
		addOrderButton();
		// TODO Auto-generated constructor stub
	}
	private void createOrderItems(String[] items){

		int x=0;
		int y=0;
		int width=100;
		int height=100;
		// potrebbero essere posizionati come i tavoli
		
		for(int i=0;i<items.length;i++){
			OrderItemJButton currentItemButton=new OrderItemJButton(x, y, width, height);
			
			
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
				
			}
		});
	}
		
}
