package gui;

import pizzeriadiddieffe.core.Order;

public class payChooser {
	
	private payMethodInterface myPaymentStrategy;
	
	public payChooser(payMethodInterface choosenStrategy){
		this.myPaymentStrategy=choosenStrategy;
	}
	
	public void createPanel(Order totPrice,JPanelWithBackgroundImgAndBackBtn myPanel){
	      myPaymentStrategy.paymethod(totPrice, myPanel);
	   }

}
