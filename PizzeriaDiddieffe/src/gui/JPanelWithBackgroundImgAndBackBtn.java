package gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
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


class JPanelWithBackgroundImgAndBackBtn extends JPanel {
	
	private Image img;
	private JButton btnBackToInOutScreen;
	private JPanel visible_panel;//pannello visibile
	private JFrame myFrame;
	
	
	
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
		
		paintBackButton();
		
	}
	
	
	private void paintBackButton() {
		btnBackToInOutScreen = new JButton ("Back");
		btnBackToInOutScreen.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBackToInOutScreen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBackToInOutScreen.setBounds(10, 10, 100, 50);
		this.add(btnBackToInOutScreen);

		btnBackToInOutScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelsVisibility();
			}
		});
	}
	
	private void setPanelsVisibility() {//setto tutti i componenti del frame invisibili,tranne il pannello visible_panel
		List<Component> myComponents=new ArrayList<Component>();
		myComponents=getComponents(myFrame);
		for(Component comp : myComponents){
			if(comp.getClass().equals(visible_panel) && !comp.equals(visible_panel)){
				comp.setVisible(false);
			}
		}
		this.setVisible(false);//senza questa problema di visibilita nel jpanel...order 
		visible_panel.setVisible(true);
	}
	
	private List<Component> getComponents( Container currentComponent){//restituisce la lista dei componenti presenti nel frame
		 Component[] allComponents = currentComponent.getComponents();
		 List<Component> componentsList = new ArrayList<Component>();
		 for (Component comp : allComponents) {
		        componentsList.add(comp);
		        if (comp instanceof Container)
		            componentsList.addAll(getComponents((Container) comp));
		    }
		    return componentsList;
	}
	
	public void setVisiblePanel(JPanel visible_panel,JFrame frame){
		this.visible_panel=visible_panel;  
		this.myFrame=frame;
	}
	
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	    	//draw background image
	        g.drawImage(img, 0, 0, null);
	        
	}
	
	public JFrame getFrame(){
		return myFrame;
	}	
}
