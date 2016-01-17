package gui;

import javax.swing.JButton;

public class Table extends ClickableButtonWithImage {
	private static String tableImg="tavolo apparecchiato";
	private static int tableFont=60;
	
	public Table (int x, int y, int width, int height,String tableCode) {
		super(x,y,width,height,tableFont,tableImg);
		this.setText(tableCode);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}
}
