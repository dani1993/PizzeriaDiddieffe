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
public class BancomatPayMethod extends JPanelWithBackBtn implements PayMethodInterface {
	private double totPrice;
	private JPanelWithBackgroundImgAndBackBtn myPanel;
	private JButton payButton;
	private Order currentOrder;
	private String baseTotalString = "Insert Code ";
	private String totalString = baseTotalString;
	private String code = "";
	private static final String STAR = "*";

	private int space = 20;
	private int labelX = 30;
	private int labelY = 100;
	private int labelWidth = 500;
	private int labelHeight = 40;
	private int labelSpace = labelHeight+space;

	private int startX = 20;
	private int startY = 320;
	private int buttonX = startX;
	private int buttonY = startY;
	private int buttonWidth = 70;
	private int buttonHeight = 70;
	private int xSpace = buttonWidth+space;
	private int ySpace = buttonHeight+space;

	private int buttonPayX = 300;
	private int buttonPayY = 320;
	private int buttonPayWidth = 220;
	private int buttonPayHeight = 250;

	@SuppressWarnings("rawtypes")
	private ComponentCreator myComponentCreator;
	private int buttonFontSize = 20;
	private Color buttonColor = Color.black;
	private Color labelColor = Color.BLACK;
	private int labelFontSize = 25;
	private String buttonFontName = "Lucida Grande";
	private String labelFontName = "Lucida Grande";

	@SuppressWarnings("rawtypes")
	public BancomatPayMethod() {
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
		final JLabel label = createFormattedLabel("Amount to Pay "+totPrice, labelX, labelY, labelWidth, labelHeight);
		labelY = labelY+labelSpace;

		payButton = createFormattedButton("Pay", buttonPayX, buttonPayY, buttonPayWidth, buttonPayHeight);
		payButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(code.length()<5){
					payButton.setText("Insert Code");
				} else{
					currentOrder.deleteAll();
					payButton.setText("Payed");
					payButton.setEnabled(false);
				}
			}
		});
		myPanel.add(payButton);		
	}

	private void createButtons() {
		final JLabel label = createFormattedLabel(totalString, labelX, labelY, labelWidth, labelHeight);

		for(int i = 0; i<10; i++){
			final String buttonText = setCoordinates(i);
			final JButton currentButton = createFormattedButton(buttonText, buttonX, buttonY, buttonWidth, buttonHeight);
			currentButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					code = code+STAR;
					String currentValue = label.getText()+STAR;
					label.setText(currentValue);
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

	private JButton createFormattedButton(String text, int buttonX, int buttonY, int buttonWidth, int buttonHeight){
		myComponentCreator.createButton(text, buttonFontName, buttonFontSize, buttonColor);
		myComponentCreator.setUpComponentProp(buttonX, buttonY, buttonWidth, buttonHeight);
		myPanel.add(myComponentCreator.getButton());
		return myComponentCreator.getButton();
	}

	private JLabel createFormattedLabel(String text, int labelX, int labelY, int labelWidth, int labelHeight){
		myComponentCreator.createLabel(text, labelFontName, labelFontSize, labelColor);
		myComponentCreator.setUpComponentProp(labelX, labelY, labelWidth, labelHeight);
		myPanel.add(myComponentCreator.getLabel());
		return myComponentCreator.getLabel();
	}
}