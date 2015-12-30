package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JPanelwithBackgroundTables extends JPanelWithBackgroundImg{

	
	private String tableCode;
	private JPanelwithBackgroundTables currentPanel;
	private JPanelwithBackgroundOrder currentOrderPanel;
	
	private int imgWidth;
	private int imgHeight;
	private int imgXToMove;
	private int imgYToMove;
	private int numberOfTablesInRow;
	
	public JPanelwithBackgroundTables(Image image) {
		super(image);
		// TODO Auto-generated constructor stub
	}
	
	public JPanelwithBackgroundTables(Image img, int numbers, String where,JPanelwithBackgroundOrder currentOrderPanel) {
		super(img);
		currentPanel=this;
		this.currentOrderPanel=currentOrderPanel;
		drawTables(numbers, where);
		this.setLayout(null);
	}
	
	
	private void drawTables(int numbers, final String where) {
		int x, xToStart = 0;
		int y = 60;
		imgHeight = 140;
		imgYToMove = 170;
		System.out.println(numbers);
		if (where == "inside") {
			if (numbers > 8) {
				imgWidth = 150;
				imgXToMove = 170;
				numberOfTablesInRow = 3;
				xToStart = 30;
			}
			else {
				if (numbers > 4) {
					imgWidth = 200;
					imgXToMove = 220;
					numberOfTablesInRow = 2;
					xToStart = 60;
				}
				else {
					xToStart = 140;
					imgWidth = 280;
					numberOfTablesInRow = 1;
				}
			}
		}
 else {
	 // TODO  parametri per tavoli fuori
		}
		for (int i = 1; i <= numbers;) {
			x = xToStart;
			for (int j = 0; j < numberOfTablesInRow && i <= numbers; j++) {
				// problema sempre uguale a fine ciclo
				tableCode = where + Integer.toString(i);
				JButton table = new JButton();
				table.setLayout(null);
				table.setForeground(new Color(0, 0, 0));
				table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				table.setFont(new Font("Lucida Grande", Font.BOLD, 60));
				table.setText(Integer.toString(i));
				table.setHorizontalTextPosition(JButton.CENTER);
				table.setVerticalTextPosition(JButton.CENTER);
				Image tableImage = new ImageIcon("res/tavolo apparecchiato.jpg").getImage().getScaledInstance(imgWidth, imgHeight, java.awt.Image.SCALE_SMOOTH);
				ImageIcon tableIcon = new ImageIcon(tableImage);
				table.setIcon(tableIcon);
				table.setBounds(x, y, imgWidth, imgHeight);
				this.add(table);
				table.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPanel.setVisible(false);
						currentOrderPanel.setVisible(true);
					}
				});
				x = x + imgXToMove;
				i++;
			}
			y = y + imgYToMove;
		}
	}

	
	
	

}
