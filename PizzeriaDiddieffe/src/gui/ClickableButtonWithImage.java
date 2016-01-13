package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ClickableButtonWithImage extends JButton {

	public ClickableButtonWithImage(int x, int y, int width, int height, int font, String image) {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Lucida Grande", Font.BOLD, font));
		this.setBorder(new LineBorder(Color.white, 3, true));	
		Image buttonImage = new ImageIcon("res/"+image + ".jpg").getImage().getScaledInstance(width, height,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon buttonIcon = new ImageIcon(buttonImage);
		this.setIcon(buttonIcon);
		this.setBounds(x, y, width, height);
		Image darkbuttonImage = new ImageIcon("res/"+image + "Dark.jpg").getImage().getScaledInstance(width, height,
				java.awt.Image.SCALE_SMOOTH);
		this.setRolloverIcon(new ImageIcon(darkbuttonImage));
		Image darkerbuttonImage = new ImageIcon("res/"+image + "DarkDark.jpg").getImage().getScaledInstance(width, height,
				java.awt.Image.SCALE_SMOOTH);
		this.setPressedIcon(new ImageIcon(darkerbuttonImage));
	}

	}


