package pizzeriadiddieffe.gui.componentclasses;

import java.awt.Color;
import java.awt.Component;

public class ComponentSetter {
	private ComponentFormatterInterface componentFormatter;

	public void setCurrentComponent(ComponentFormatterInterface componentFormatter){
		this.componentFormatter = componentFormatter;
		this.componentFormatter.createNewComponent();
	}

	public void setComponentTextProp(String text, String font, int fontSize, Color textColor){
		componentFormatter.setComponentTextProp(text, font, fontSize, textColor);
	}

	public void setComponentProp(int x, int y, int width, int height){
		componentFormatter.setComponentProp(x, y, width, height);
	}

	public Component getFormattedComponent(){
		return componentFormatter.getFormattedComponent();
	}
}