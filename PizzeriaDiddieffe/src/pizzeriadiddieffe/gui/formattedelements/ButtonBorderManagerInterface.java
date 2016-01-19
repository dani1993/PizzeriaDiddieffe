package pizzeriadiddieffe.gui.formattedelements;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JButton;

import pizzeriadiddieffe.gui.jbutton.JButtonTextImage;

public interface ButtonBorderManagerInterface {
	public  Color getBorderColor(JButtonTextImage currentItemButton);
	public  void changeBorderColor(JButtonTextImage currentItemButton) ;
	public void setOthersButtons(boolean enable, LinkedList<JButton> list, JButton mybutton);
	public void resetButtons(LinkedList<JButton> baseCasesButtonList, LinkedList<JButton> toppingButtonList);	
}