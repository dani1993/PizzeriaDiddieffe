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
	
	public Table (int x, int y, int width, int height,int number) {
		super(x,y,width,height,tableImg,tableClickImg,tableMouseOnImg);
		this.setText(Integer.toString(number));
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
	}
}
