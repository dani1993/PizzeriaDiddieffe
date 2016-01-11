package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class ClickableButtonWithImage extends JButton{

	public ClickableButtonWithImage (int x, int y, int width, int height,int font,String image,String clickedImage,String mouseOnImage) {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Lucida Grande", Font.BOLD, font));
		this.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		Image buttonImage = new ImageIcon(image).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		ImageIcon buttonIcon = new ImageIcon(buttonImage);
		this.setIcon(buttonIcon);
		this.setBounds(x, y, width, height);
		Image darkbuttonImage = new ImageIcon(mouseOnImage).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		this.setRolloverIcon(new ImageIcon(darkbuttonImage));
		Image darkerbuttonImage = new ImageIcon(clickedImage).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		this.setPressedIcon(new ImageIcon(darkerbuttonImage));
	}
}
