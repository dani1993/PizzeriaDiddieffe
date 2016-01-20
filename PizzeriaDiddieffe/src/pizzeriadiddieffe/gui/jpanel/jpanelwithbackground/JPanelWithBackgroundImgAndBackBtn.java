package pizzeriadiddieffe.gui.jpanel.jpanelwithbackground;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pizzeriadiddieffe.gui.componentclasses.ComponentsGetter;
import pizzeriadiddieffe.gui.jbutton.ClickableButtonWithImage;

@SuppressWarnings("serial")
public class JPanelWithBackgroundImgAndBackBtn extends JPanel{
	private Image img;
	private ClickableButtonWithImage btnBackToInOutScreen;
	private JPanel visiblePanel;// pannello visibile
	private JFrame myFrame;
	private ComponentsGetter myComponentGetter;
	
	//back button bounds
	private int xBackButton = 10;
	private int yBackButton = 10;
	private int widthBackButton = 100;
	private int heightBackButton = 50;

	public JPanelWithBackgroundImgAndBackBtn(String img) {
		this(new ImageIcon(img).getImage());
	}

	public JPanelWithBackgroundImgAndBackBtn(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		myComponentGetter = new ComponentsGetter();
		paintBackButton();
	}

	private void paintBackButton() {
		btnBackToInOutScreen = new ClickableButtonWithImage(xBackButton, yBackButton, widthBackButton, heightBackButton, 0, "Back");
		btnBackToInOutScreen.setBorderPainted(false);
		this.add(btnBackToInOutScreen);
		btnBackToInOutScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsVisibility();
			}
		});
	}

	private void setPanelsVisibility() {// setto tutti i componenti del frame
		// invisibili,tranne il pannello
		// visible_panel
		List<Component> myComponents = new ArrayList<Component>();
		myComponents = myComponentGetter.getComponents(myFrame);
		for (Component comp : myComponents) {
			if (comp.getClass().equals(visiblePanel) && !comp.equals(visiblePanel)) {
				comp.setVisible(false);
			}
		}
		this.setVisible(false);// senza questa problema di visibilita nel
		// jpanel...order
		visiblePanel.setVisible(true);
	}

	public void setVisiblePanel(JPanel visiblePanel, JFrame frame) {
		this.visiblePanel = visiblePanel;
		this.myFrame = frame;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw background image
		g.drawImage(img, 0, 0, null);
	}

	public JFrame getFrame() {
		return myFrame;
	}
}