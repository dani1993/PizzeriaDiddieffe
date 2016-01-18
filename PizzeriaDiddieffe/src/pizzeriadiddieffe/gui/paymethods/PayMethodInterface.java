package pizzeriadiddieffe.gui.paymethods;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundImgAndBackBtn;

public interface PayMethodInterface {
	public void payMethod(Order totPrice, JPanelWithBackgroundImgAndBackBtn myPanel);
}