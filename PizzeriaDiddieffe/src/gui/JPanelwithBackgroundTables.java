package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.SynchronousQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JPanelwithBackgroundTables extends JPanelWithBackgroundImgAndBackBtn{

	
	private String tableCode;
	private JPanelwithBackgroundTables currentPanel;
	private JPanelwithBackgroundOrder currentOrderPanel;
	
	private int imgWidth;
	private int imgHeight;
	private int imgXToMove;
	private int imgYToMove;
	private int numberOfTablesInRow;
	
	private int[] coordinatesEight={30,3,150,170,60};
	private int[] coordinatesFour={60,2,200,220,60};
	private int [] coordinatesMax={60,2,200,220,160};
	
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
		int [] coordinates = getCoordinates(numbers);
		
		xToStart = coordinates[0];
		numberOfTablesInRow = coordinates[1];
		imgWidth = coordinates[2];
		imgXToMove = coordinates[3];
		y = coordinates[4];
		
		int i = 1;
		while (i <= numbers) {
			x = xToStart;
			for (int j = 0; j < numberOfTablesInRow && i <= numbers; j++) {
				if (where == "inside") {
				tableCode = Integer.toString(i) +"i";
				}
				else {
					tableCode = (Integer.toString(i) + "f");
				}
				final Table table = new Table(x, y, imgWidth, imgHeight, tableCode);
				this.add(table);
				table.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentOrderPanel.setTableId(table.getText());
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

	private int[] getCoordinates(int numbers) {
		int[] coordinates = new int[5];
		
			if (numbers > 8) {
				coordinates=coordinatesEight;
			} else {
				
				if (numbers > 4) {
					coordinates=coordinatesFour;

				} else {
					coordinates=coordinatesMax;
				}
			}
		return coordinates;
	}
	
	

}
