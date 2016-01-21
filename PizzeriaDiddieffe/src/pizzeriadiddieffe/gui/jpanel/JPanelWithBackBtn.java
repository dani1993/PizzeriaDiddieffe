package pizzeriadiddieffe.gui.jpanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pizzeriadiddieffe.gui.componentclasses.ComponentsGetter;
import pizzeriadiddieffe.gui.jbutton.ClickableButtonWithImage;

@SuppressWarnings("serial")
public class JPanelWithBackBtn extends JPanel{	
	private ClickableButtonWithImage btnBackToInOutScreen;
	private JPanel visiblePanel;
	private JFrame myFrame;
	private ComponentsGetter myComponentGetter;
	private static int width = 550;
	private static int heigh = 750;
	private int xBackBtn = 10;
	private int yBackBtn = 10;
	private int widthBackBtn = 100;
	private int heightBackBtn = 50;

	public JPanelWithBackBtn() {
		Dimension size = new Dimension(width, heigh);
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		myComponentGetter = new ComponentsGetter();
		paintBackButton();
	}

	private void paintBackButton() {
		btnBackToInOutScreen = new ClickableButtonWithImage(xBackBtn, yBackBtn, widthBackBtn, heightBackBtn, 0, "Back");
		btnBackToInOutScreen.setBorderPainted(false);
		this.add(btnBackToInOutScreen);
		btnBackToInOutScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsVisibility();
			}
		});
	}

	private void setPanelsVisibility() {
		List<Component> myComponents = new ArrayList<Component>();
		myComponents = myComponentGetter.getComponents(myFrame);
		for (Component comp : myComponents) {
			if (comp.getClass().equals(visiblePanel) && !comp.equals(visiblePanel)) {
				comp.setVisible(false);
			}
		}
		this.setVisible(false);
		visiblePanel.setVisible(true);
	}

	public void setVisiblePanel(JPanel visiblePanel, JFrame frame) {
		this.visiblePanel = visiblePanel;
		this.myFrame = frame;
	}

	public JFrame getFrame() {
		return myFrame;
	}	
}