package pizzeriadiddieffe.gui.paymethods;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.gui.creators.ComponentCreator;
import pizzeriadiddieffe.gui.jpanel.JPanelWithBackBtn;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundImgAndBackBtn;

@SuppressWarnings("serial")
public class MobilePayMethod extends JPanelWithBackBtn implements PayMethodInterface {
	private double totPrice;
	private JPanelWithBackgroundImgAndBackBtn myPanel;
	private JButton payButton;
	private Order currentOrder;
	private JComboBox<String> mobilePayOperator;
	private JComboBox<String> autenticationMethod;

	private int labelX = 30;
	private int labelY = 100;
	private int labelWidth = 500;
	private int labelHeight = 40;

	private int ySpace = 200;
	private int yBox = 35;
	private int xBox = 125;
	private int boxWidth = 300;
	private int boxHeight = 60;
	private int menuSpace = 100;

	private int buttonPayX = 120;
	private int buttonPayY = 580;
	private int buttonPayWidth = 300;
	private int buttonPayHeight = 100;

	private String[] operators = {"Apple Pay", "Android Pay", "Generic Operator"};
	private String [] autentications = {"Contact Less", "Code Insertion"};
	private ComponentCreator<String> myComponentCreator;

	private String buttonFont = "Lucida Grande";
	private int buttonFontSize = 20;
	private Color buttonColor = Color.black;
	private String labelFont = "Lucida Grande";
	private int labelFontSize = 20;
	private Color labelColor = Color.BLACK;
	private String comboFont = "Lucida Grande";
	private int comboFontSize = 20;
	private Color comboColor = Color.BLACK;

	public MobilePayMethod() {
		super();
		myComponentCreator = new ComponentCreator<String>();
	}

	@Override
	public void payMethod(Order totPrice, JPanelWithBackgroundImgAndBackBtn myPanel) {
		this.totPrice = totPrice.getPrice();
		this.currentOrder = totPrice;
		this.myPanel = myPanel;
		createTotalLabel();
		createBox();
	}

	private void createBox(){
		yBox = yBox+ySpace;
		autenticationMethod = createFormattedComboBox("", xBox, yBox, boxWidth, boxHeight);
		createMenuItems(autenticationMethod, autentications);

		yBox = yBox+ySpace;
		mobilePayOperator = createFormattedComboBox("", xBox, yBox, boxWidth, boxHeight);
		createMenuItems(mobilePayOperator, operators);
	}

	private void createMenuItems(JComboBox<String> currentMenu, String[] itemsName) {
		for(int i = 0; i<itemsName.length; i++){
			currentMenu.addItem(itemsName[i]);
		}
	}

	private void createTotalLabel(){		
		@SuppressWarnings("unused")
		final JLabel label = createFormattedLabel("Amount to Pay "+totPrice, labelX, labelY, labelWidth, labelHeight);
		labelY = labelY+menuSpace;

		@SuppressWarnings("unused")
		final JLabel labelMethod = createFormattedLabel("Choose Autentication Method", labelX, labelY, labelWidth, labelHeight);
		labelY = labelY+menuSpace*2;

		@SuppressWarnings("unused")
		final JLabel labelOperator = createFormattedLabel("Choose Operator ", labelX, labelY, labelWidth, labelHeight);

		payButton = createFormattedButton("Pay", buttonPayX, buttonPayY, buttonPayWidth, buttonPayHeight);
		payButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String currentText = payButton.getText();
				if(currentText.equals("Pay")){
					payButton.setText("Autentication");
					mobilePayOperator.setEnabled(false);
					autenticationMethod.setEnabled(false);
				}else if(currentText.equals("Autentication")){
					currentOrder.deleteAll();
					payButton.setEnabled(false);
					payButton.setText("Payed!");
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

	private JComboBox<String> createFormattedComboBox(String text, int comboBoxX, int comboBoxY, int comboBoxWidth, int comboBoxHeight){
		myComponentCreator.createComboBox(text, comboFont, comboFontSize, comboColor);
		myComponentCreator.setUpComponentProp(comboBoxX, comboBoxY, comboBoxWidth, comboBoxHeight);
		myPanel.add(myComponentCreator.getComboBox());
		return myComponentCreator.getComboBox();
	}
}