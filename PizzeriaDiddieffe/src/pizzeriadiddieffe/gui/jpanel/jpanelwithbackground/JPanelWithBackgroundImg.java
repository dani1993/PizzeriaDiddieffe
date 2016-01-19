package pizzeriadiddieffe.gui.jpanel.jpanelwithbackground;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pizzeriadiddieffe.gui.componentclasses.ComponentsGetter;
import pizzeriadiddieffe.gui.creators.ComponentCreator;

class JPanelWithBackgroundImg extends JPanel implements JPanelWithImageInterface{
	private Image img;
	private JButton btnBackToInOutScreen;
	private JPanel visiblePanel;
	private JFrame myFrame;
	private ComponentsGetter myComponentGetter;
	private ComponentCreator myComponentCreator;
	private String buttonFontName = "Lucida Grande";
	private int buttonFontSize = 16;
	private Color buttonColor = Color.black;

	public JPanelWithBackgroundImg(String img) {
		this(new ImageIcon(img).getImage());
	}

	public JPanelWithBackgroundImg(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		myComponentCreator = new ComponentCreator<>();
		paintBackButton();
		myComponentGetter = new ComponentsGetter();
	}

	private void paintBackButton() {
		btnBackToInOutScreen = createFormattedButton("Back", 10, 10, 100, 50);
		btnBackToInOutScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsVisibility();
			}
		});
	}

	private void setPanelsVisibility() {
		List<Component> myComponents = new ArrayList<Component>();
		myComponents = myComponentGetter.getComponents(myFrame);
		for(Component comp : myComponents){
			if(comp.getClass().equals(visiblePanel) && !comp.equals(visiblePanel)){
				comp.setVisible(false);
			}
		}
		this.setVisible(false); 
		visiblePanel.setVisible(true);
	}

	@Override
	public void setVisiblePanel(JPanel visiblePanel, JFrame frame){
		this.visiblePanel = visiblePanel;  
		this.myFrame = frame;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
	}

	@Override
	public JFrame getFrame(){
		return myFrame;
	}	

	private JButton createFormattedButton(String text, int buttonX, int buttonY, int buttonWidth, int buttonHeight){
		myComponentCreator.createButton(text, buttonFontName, buttonFontSize, buttonColor);
		myComponentCreator.setUpComponentProp(buttonX, buttonY, buttonWidth, buttonHeight);
		this.add(myComponentCreator.getButton());
		return myComponentCreator.getButton();
	}
}