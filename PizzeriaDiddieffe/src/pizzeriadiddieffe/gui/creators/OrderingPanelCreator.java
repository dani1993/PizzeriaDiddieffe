package pizzeriadiddieffe.gui.creators;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pizzeriadiddieffe.gui.jpanel.OrderingJPanel;

public class OrderingPanelCreator implements PanelCreator{
	private OrderingJPanel tempOrderingPanel;
	private Image tempOrderingImage;

	@Override
	public void setParameters(Image OrderingImagePath, int width, int height){
		tempOrderingImage = new ImageIcon(OrderingImagePath).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
	}

	@Override
	public void createPanel(String itemPackage, String[] itemBasicClasses, String[] itemToppingImages, String[] itemClassesName){
		tempOrderingPanel = new OrderingJPanel(tempOrderingImage, itemPackage, itemBasicClasses, itemToppingImages, itemClassesName);
	}

	@Override
	public void setOrderingBackButton(JPanel currentJPanel, JFrame myFrame){
		tempOrderingPanel.setVisiblePanel(currentJPanel, myFrame);
		tempOrderingPanel.setVisible(false);
		myFrame.add(tempOrderingPanel);
	}

	@Override
	public OrderingJPanel getOrderingPanel(){
		return tempOrderingPanel;
	}
}