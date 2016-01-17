package gui;

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


class JPanelWithBackgroundImg extends JPanel {
	
	private Image img;
	private JButton btnBackToInOutScreen;
	private JPanel visible_panel;
	private JFrame myFrame;
	private ComponentsGetter myComponentGetter;
	
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
		paintBackButton();
		myComponentGetter=new ComponentsGetter();
		
	}
	
	
	private void paintBackButton() {
//		btnBackToInOutScreen = new JButton ("Back");
//		btnBackToInOutScreen.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
//		btnBackToInOutScreen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnBackToInOutScreen.setBounds(10, 10, 100, 50);
		btnBackToInOutScreen = new ClickableButtonWithImage(10, 10, 100, 50, 0, "Back");
		this.add(btnBackToInOutScreen);
		btnBackToInOutScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsVisibility();
			}
		});
	}
	
	
	private void setPanelsVisibility() {
		List<Component> myComponents=new ArrayList<Component>();
		myComponents=myComponentGetter.getComponents(myFrame);
		for(Component comp : myComponents){
			if(comp.getClass().equals(visible_panel) && !comp.equals(visible_panel)){
				comp.setVisible(false);
			}
		}
		this.setVisible(false); 
		visible_panel.setVisible(true);
	}
	
	
//	private List<Component> getComponents( Container currentComponent){
//		 Component[] allComponents = currentComponent.getComponents();
//		 List<Component> componentsList = new ArrayList<Component>();
//		 for (Component comp : allComponents) {
//		        componentsList.add(comp);
//		        if (comp instanceof Container)
//		            componentsList.addAll(getComponents((Container) comp));
//		    }
//		    return componentsList;
//	}
	
	
	public void setVisiblePanel(JPanel visible_panel,JFrame frame){
		this.visible_panel=visible_panel;  
		this.myFrame=frame;
	}
	
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(img, 0, 0, null);
	        
	}
	
	public JFrame getFrame(){
		return myFrame;
	}	
}
