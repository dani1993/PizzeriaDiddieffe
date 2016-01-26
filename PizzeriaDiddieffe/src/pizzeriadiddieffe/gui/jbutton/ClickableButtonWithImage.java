package pizzeriadiddieffe.gui.jbutton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class ClickableButtonWithImage extends JButton {
	private URL imageURL;
	public ClickableButtonWithImage(int x, int y, int width, int height, int font, String image) {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setFont(new Font("Lucida Grande", Font.BOLD, font));
		this.setBorder(new LineBorder(Color.white, 3, true));
		Image buttonImage;
		Image darkbuttonImage;
		Image darkerbuttonImage;
		if (image=="Back") {
			imageURL = ClickableButtonWithImage.class.getResource(image+".png");
			buttonImage = new ImageIcon(imageURL).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			imageURL = ClickableButtonWithImage.class.getResource(image+"Dark.png");
			darkbuttonImage = new ImageIcon(imageURL).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			imageURL = ClickableButtonWithImage.class.getResource(image+"DarkDark.png");
			darkerbuttonImage = new ImageIcon(imageURL).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		} else {
			imageURL = ClickableButtonWithImage.class.getResource(image+".jpg");
			buttonImage = new ImageIcon(imageURL).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			imageURL = ClickableButtonWithImage.class.getResource(image+"Dark.jpg");
			darkbuttonImage = new ImageIcon(imageURL).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
			imageURL = ClickableButtonWithImage.class.getResource(image+"DarkDark.jpg");
			darkerbuttonImage = new ImageIcon(imageURL).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		}
		ImageIcon buttonIcon = new ImageIcon(buttonImage);
		this.setIcon(buttonIcon);
		this.setBounds(x, y, width, height);
		this.setRolloverIcon(new ImageIcon(darkbuttonImage));
		this.setPressedIcon(new ImageIcon(darkerbuttonImage));
	}
}