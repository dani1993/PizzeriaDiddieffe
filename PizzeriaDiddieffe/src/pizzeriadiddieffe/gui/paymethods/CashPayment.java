package pizzeriadiddieffe.gui.paymethods;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.gui.creators.ComponentCreator;
import pizzeriadiddieffe.gui.jpanel.JPanelWithBackBtn;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundImgAndBackBtn;

@SuppressWarnings("serial")
public class CashPayment extends JPanelWithBackBtn implements PayMethodInterface   {
	private double totPrice;
	private JPanelWithBackgroundImgAndBackBtn myPanel;
	private JButton payButton;
	private Order currentOrder;
	private String baseTotalString = "Amount Paid ";
	private String totalString = baseTotalString;
	@SuppressWarnings("rawtypes")
	private ComponentCreator myComponentCreator;

	private Color labelColor = Color.black;
	private String labelFont = "Lucida Grande";
	private Color buttonColor = Color.black;
	private String buttonFont = "Lucida Grande";

	private int space = 20;
	private int labelX = 30;
	private int labelY = 100;
	private int labelWidth = 500;
	private int labelHeight = 40;
	private int labelSpace = labelHeight+space;
	private int labelFontSize = 25;

	private int buttonFontSize = 20;
	private int startX = 20;
	private int startY = 320;
	private int buttonX = startX;
	private int buttonY = startY;
	private int buttonWidth = 70;
	private int buttonHeight = 70;
	private int xSpace = buttonWidth+space;
	private int ySpace = buttonHeight+space;

	private double totValue = 0;
	private int buttonPayX = 300;
	private int buttonPayY = 320;
	private int buttonPayWidth = 220;
	private int buttonPayHeight = 250;
	private String amountToPayString = "Amount to Pay ";
	
	@SuppressWarnings("rawtypes")
	public CashPayment() {
		super();
		myComponentCreator = new ComponentCreator();
	}

	@Override
	public void payMethod(Order totPrice, JPanelWithBackgroundImgAndBackBtn myPanel) {
		this.totPrice = totPrice.getPrice();
		this.currentOrder = totPrice;
		this.myPanel = myPanel;
		createTotalLabel();
		createButtons();
	}

	private void createTotalLabel() {	
		@SuppressWarnings("unused")
		final JLabel label = (JLabel) createFormattedLabel(amountToPayString+totPrice, labelX,labelY, labelWidth, labelHeight);
		labelY = labelY+labelSpace;

		payButton = createFormattedButton("Pay", buttonPayX, buttonPayY, buttonPayWidth, buttonPayHeight);
		payButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentText = payButton.getText();

				if(totalString!=baseTotalString){
					totValue = Double.parseDouble(totalString);
					double resto = totValue-totPrice;

					if(currentText=="Pay" && resto>0){
						payButton.setText("Change : "+(float)resto);
					}else if(currentText!="Pay" || resto==0){
						currentOrder.deleteAll();
						payButton.setText("Payed!");
						payButton.setEnabled(false);
					}
				}
			}
		});	
	}

	private JButton createFormattedButton(String text, int buttonX, int buttonY, int buttonWidth, int buttonHeight){
		myComponentCreator.createButton(text, buttonFont, buttonFontSize, buttonColor);
		myComponentCreator.setUpComponentProp(buttonX, buttonY, buttonWidth, buttonHeight);
		myPanel.add(myComponentCreator.getButton());
		return myComponentCreator.getButton();
	}

	private JLabel createFormattedLabel(String text, int labelX, int labelY, int labelWidth, int labelHeight){
		myComponentCreator.createLabel(text, labelFont, labelFontSize, labelColor);
		myComponentCreator.setUpComponentProp(labelX, labelY, labelWidth, labelHeight);
		myPanel.add(myComponentCreator.getLabel());
		return myComponentCreator.getLabel();
	}

	private void createButtons() {		
		final JLabel label = createFormattedLabel(totalString, labelX, labelY, labelWidth, labelHeight);

		for(int i = 0; i<10; i++){
			final String buttonText = setCoordinates(i);
			final JButton currentButton = createFormattedButton(buttonText, buttonX, buttonY, buttonWidth, buttonHeight);
			currentButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int value = Integer.parseInt(currentButton.getText());
					String currentValue = label.getText()+value;
					label.setText(currentValue);
					totalString = currentValue.substring(baseTotalString.length());		
				}
			});
		}

		JButton cancButton = createFormattedButton("C", buttonX+xSpace, buttonY, buttonWidth, buttonHeight);
		cancButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(baseTotalString);	
			}
		});

		JButton dotButton = createFormattedButton(".", buttonX-xSpace, buttonY, buttonWidth, buttonHeight);
		dotButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(label.getText()+".");	
			}
		});
	}

	private String setCoordinates(int i) {
		if(i==9){
			buttonX = startX;
			buttonY = buttonY+ySpace;
			buttonX = buttonX+xSpace;
			return Integer.toString(i-9);
		}else{
			if(i%3==0 && i!=0){
				buttonX = startX;
				startY = startY+ySpace;
				buttonY = buttonY+ySpace;
				return Integer.toString(i+1);
			}else if(i%3!=0 && i!=0){
				buttonY = startY;
				buttonX = buttonX+xSpace;
				return Integer.toString(i+1);
			}
		}
		return Integer.toString(i+1);
	}
}