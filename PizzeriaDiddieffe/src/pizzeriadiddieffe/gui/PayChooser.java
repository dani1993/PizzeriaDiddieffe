package pizzeriadiddieffe.gui;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundImgAndBackBtn;
import pizzeriadiddieffe.gui.paymethods.PayMethodInterface;

public class PayChooser {
	private PayMethodInterface myPaymentStrategy;

	public PayChooser(PayMethodInterface choosenStrategy){
		this.myPaymentStrategy = choosenStrategy;
	}

	public void createPanel(Order totPrice, JPanelWithBackgroundImgAndBackBtn myPanel){
		myPaymentStrategy.payMethod(totPrice, myPanel);
	}
}