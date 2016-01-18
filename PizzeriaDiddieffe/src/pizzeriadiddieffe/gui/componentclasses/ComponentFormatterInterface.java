package pizzeriadiddieffe.gui.componentclasses;

import java.awt.Color;
import java.awt.Component;

public interface ComponentFormatterInterface {
	public void setComponentProp(int x, int y, int width, int height);
	public void setComponentTextProp(String text, String font, int fontSize, Color textColor);
	public void createNewComponent();
	public Component getFormattedComponent();
}