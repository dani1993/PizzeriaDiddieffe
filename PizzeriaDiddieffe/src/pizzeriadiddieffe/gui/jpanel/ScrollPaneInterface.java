package pizzeriadiddieffe.gui.jpanel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public interface ScrollPaneInterface {
	public void setCurrentJPanel(JPanel panel);
	public void setParameters(int x, int y, int width, int height);
	public void setColors(Color borderColor, Color bgColor);
	public JScrollPane getScrollPane();
}