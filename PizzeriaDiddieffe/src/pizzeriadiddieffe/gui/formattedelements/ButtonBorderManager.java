package pizzeriadiddieffe.gui.formattedelements;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import pizzeriadiddieffe.gui.jbutton.JButtonTextImage;

public class ButtonBorderManager {
	private Color defaultColor;
	private Color selectedColor;

	public ButtonBorderManager(Color defaultColor, Color selectedColor){
		this.defaultColor = defaultColor;
		this.selectedColor = selectedColor;
	}

	public  Color getBorderColor(JButtonTextImage currentItemButton) {
		Color currentBorder = ((LineBorder) currentItemButton.getBorder()).getLineColor();
		return currentBorder;
	}

	public  void changeBorderColor(JButtonTextImage currentItemButton) {
		Color currentBorder = getBorderColor(currentItemButton);
		if(currentItemButton.isEnabled()){
			if (currentBorder==defaultColor) {
				currentItemButton.setBorder((new LineBorder(selectedColor, 3, true)));
			} else {
				currentItemButton.setBorder(new LineBorder(defaultColor, 3, true));
			}
		}
	}

	private void resetBorderColor(JButton currentButton) {
		currentButton.setBorder(new LineBorder(defaultColor, 3, true));
	}

	public void setOthersButtons(boolean enable, LinkedList<JButton> list, JButton mybutton) {
		Iterator<JButton> iterator = getButtonListIterator(list);
		while(iterator.hasNext()){
			JButton currentButton = iterator.next();
			currentButton.setEnabled(enable);
			if(enable==false && mybutton.equals(currentButton)){
				currentButton.setEnabled(true);
			}
		}
	}

	private Iterator<JButton> getButtonListIterator(LinkedList<JButton> list) {
		return list.iterator();
	}

	public void resetButtons(LinkedList<JButton> baseCasesButtonList, LinkedList<JButton> toppingButtonList) {
		Iterator<JButton> iteratorBasecases = getButtonListIterator(baseCasesButtonList);
		Iterator<JButton> iteratortopping = getButtonListIterator(toppingButtonList);

		resetListButtons(iteratorBasecases);
		resetListButtons(iteratortopping);
	}

	private void resetListButtons(Iterator<JButton> iterator){
		while (iterator.hasNext()) {
			JButton currentButton = iterator.next();
			resetBorderColor(currentButton);
		}
	}
}