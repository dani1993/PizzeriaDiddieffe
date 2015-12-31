package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelwithBackgroundTables extends JPanelWithBackgroundImg{

	
	private String tableCode;
	private JPanelwithBackgroundTables currentPanel;
	private JPanelwithBackgroundOrder currentOrderPanel;
	
	public JPanelwithBackgroundTables(Image image) {
		super(image);
		// TODO Auto-generated constructor stub
	}
	
	public JPanelwithBackgroundTables(Image img, int numbers, String where,JPanelwithBackgroundOrder currentOrderPanel) {
		super(img);
		currentPanel=this;
		this.currentOrderPanel=currentOrderPanel;
		drawTables(numbers, where);
	}
	
	
	private void drawTables(int numbers, final String where) {
		for(int  i=1;i<=numbers;i++) {
			tableCode=where + Integer.toString(i);   //problema sempre uguale a fine ciclo
			JButton table = new JButton();
			table.setForeground(new Color(0, 0, 0));
			table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			table.setIcon(new ImageIcon("res/tavolo apparecchiato.jpg"));
			table.setBounds(60*i, 60*i, 150, 150);
			this.add(table);
			table.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					currentPanel.setVisible(false);
					currentOrderPanel.setVisible(true);
				}
			});
		}
	}

	
	
	

}
