package pizzeriadiddieffe.gui.creators;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pizzeriadiddieffe.gui.jpanel.OrderingJPanel;

public interface PanelCreator {
	public void setParameters(Image OrderingImagePath, int width, int height);
	public void createPanel(String itemPackage, String[] itemBasicClasses, String[] itemToppingImages, String[] itemClassesName);
	public void setOrderingBackButton(JPanel currentJPanel, JFrame myFrame);
	public OrderingJPanel getOrderingPanel();
}