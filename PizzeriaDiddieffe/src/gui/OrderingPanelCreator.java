package gui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderingPanelCreator {
	
	private OrderingJPanel tempOrderingPanel;
	private Image tempOrderingImage;
	
	public void setParameters(String OrderingImagePath,int width,int height){
		tempOrderingImage=new ImageIcon(OrderingImagePath).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	}
	
	public void createPanel(String itemPackage, String[] itemBasicClasses, String[] itemToppingImages, String[] itemClassesName){
		tempOrderingPanel=new OrderingJPanel(tempOrderingImage,itemPackage,itemBasicClasses, itemToppingImages, itemClassesName);
	}
	
	
	public void setOrderingBackButton(JPanel currentJPanel, JFrame myFrame){
		tempOrderingPanel.setVisiblePanel(currentJPanel, myFrame);
		tempOrderingPanel.setVisible(false);
		myFrame.add(tempOrderingPanel);
	}
	
	
	
	public OrderingJPanel getOrderingPanel(){
		return tempOrderingPanel;
	}
}
