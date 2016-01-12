package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Table extends ClickableButtonWithImage {
	private static String tableImg="res/tavolo apparecchiato.jpg";
	private static String tableMouseOnImg="res/tavolo apparecchiato dark.jpg";
	private static String tableClickImg="res/tavolo apparecchiato darker.jpg";
	private static int tableFont=60;
	
	public Table (int x, int y, int width, int height,String tableCode) {
		super(x,y,width,height,tableFont,tableImg,tableClickImg,tableMouseOnImg);
		this.setText(tableCode);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}
}
