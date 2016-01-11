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
		//ritorna un array con "[x dove partire] [numero di tavoli per riga] [width] [x da muovere a destra]"
		int [] coordinates = getCoordinates(numbers, where);
		
		xToStart = coordinates[0];
		numberOfTablesInRow = coordinates[1];
		imgWidth = coordinates[2];
		imgXToMove = coordinates[3];
		
		int i = 1;
		while (i <= numbers) {
			x = xToStart;
			for (int j = 0; j < numberOfTablesInRow && i <= numbers; j++) {
				tableCode = where + Integer.toString(i);
				Table table = new Table(x, y, imgWidth, imgHeight, i);
				this.add(table);
				table.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPanel.setVisible(false);
						currentOrderPanel.setVisiblePanel(currentPanel, getFrame());
						currentOrderPanel.setVisible(true);
					}
				});
				x = x + imgXToMove;
				i++;
			}
			y = y + imgYToMove;
		}
	}

	private int[] getCoordinates(int numbers, String where) {
		int[] coordinates = new int[4];
		if (where == "inside") {
			if (numbers > 8) {
				coordinates[0] = 30;  //xToStart
				coordinates[1] = 3;   //tablesPerRow
				coordinates[2] = 150;  //width
				coordinates[3] = 170;  //xToMove
			} else {
				if (numbers > 4) {
					coordinates[0] = 60;  //xToStart
					coordinates[1] = 2;  //tablesPerRow
					coordinates[2] = 200;  //width
					coordinates[3] = 220;  //xToMove
				} else {
					coordinates[0] = 140;  //xToStart
					coordinates[1] = 1;    //tablesPerRow
					coordinates[2] = 280;   //xToMove
				}
			}
		} else {
			// TODO parametri per tavoli fuori
		}
		return coordinates;
	}

}
