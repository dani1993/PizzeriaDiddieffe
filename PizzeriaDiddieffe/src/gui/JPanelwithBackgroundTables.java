package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelwithBackgroundTables extends JPanelWithBackgroundImgAndBackBtn{

	
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
				coordinates[0] = 30;  //xToStart
				coordinates[1] = 3; // tablesPerRow
				coordinates[2] = 150; // width
				coordinates[3] = 170; // xToMove
				coordinates[4] = 60; //y

			} else {
				if (numbers > 4) {
					coordinates[0] = 60; // xToStart
					coordinates[1] = 2; // tablesPerRow
					coordinates[2] = 200; // width
					coordinates[3] = 220; // xToMove
					coordinates[4] = 60; //y

				} else {
					coordinates[0] = 60; // xToStart
					coordinates[1] = 2; // tablesPerRow
					coordinates[2] = 200; // width
					coordinates[3] = 220; // xToMove
					coordinates[4] = 160; //y
				}
			}
		return coordinates;
	}

}
