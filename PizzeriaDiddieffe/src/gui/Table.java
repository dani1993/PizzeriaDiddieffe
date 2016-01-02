package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Table extends JButton {
	
	public Table (int x, int y, int width, int height, int number) {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Lucida Grande", Font.BOLD, 60));
		this.setText(Integer.toString(number));
		this.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		Image tableImage = new ImageIcon("res/tavolo apparecchiato.jpg").getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon tableIcon = new ImageIcon(tableImage);
		this.setIcon(tableIcon);
		this.setBounds(x, y, width, height);
		Image darkTableImage = new ImageIcon("res/tavolo apparecchiato dark.jpg").getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		this.setRolloverIcon(new ImageIcon(darkTableImage));
		Image darkerTableImage = new ImageIcon("res/tavolo apparecchiato darker.jpg").getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		this.setPressedIcon(new ImageIcon(darkerTableImage));
	}
}
