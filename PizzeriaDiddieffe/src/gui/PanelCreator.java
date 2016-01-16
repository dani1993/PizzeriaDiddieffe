package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public interface PanelCreator {
	public void setParameters(String OrderingImagePath,int width,int height);
	public void createPanel(String itemPackage, String[] itemBasicClasses, String[] itemToppingImages, String[] itemClassesName);
	public void setOrderingBackButton(JPanel currentJPanel, JFrame myFrame);
	public OrderingJPanel getOrderingPanel();
}
