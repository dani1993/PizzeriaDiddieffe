package pizzeriadiddieffe.gui.jpanel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.Sound;
import pizzeriadiddieffe.gui.OrderViewerInterface;
import pizzeriadiddieffe.gui.creators.ComponentCreator;
import pizzeriadiddieffe.gui.creators.ItemCreator;
import pizzeriadiddieffe.gui.formattedelements.ButtonBorderManager;
import pizzeriadiddieffe.gui.jbutton.JButtonTextImage;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundImgAndBackBtn;

@SuppressWarnings("serial")
public class OrderingJPanel extends JPanelWithBackgroundImgAndBackBtn implements OrderViewerInterface{
	private JButton AddToOrderButton;
	private JButton ClearButton;
	private JPanelWithBackgroundImgAndBackBtn currentJPanel = this;

	private int addButtonHeight = 60;
	private int addButtonWidth = 200;
	private int addButtonx = 325;
	private int addButtony = 640;

	private int clearButtonHeight = 60;
	private int clearButtonWidth = 200;
	private int clearButtonx = 30;
	private int clearButtony = 640;

	private ButtonBorderManager myBorderManager;
	private Color defaultColor = Color.white;
	private Color selectedColor = Color.green;

	private ItemCreator myItemCreator;
	private Order currentOrder;
	private Item currentItem;
	private Sound buttonSound;
	@SuppressWarnings("rawtypes")
	private ComponentCreator myComponentCreator;

	private LinkedList<JButton> baseCasesButtonList;
	private LinkedList<JButton> toppingButtonList;
	private LinkedList<String> currentTopping;
	private String currentCaseBase;

	private int baseFontSize = 15;
	private int baseCasesX = 50; 
	private int baseCasesY = 190; 
	private int baseCasesWidth = 140;
	private int baseCasesHeight = 70;
	private int baseCaseXToMove = 155;

	private int toppingX = 38;
	private int toppingYToStart = 290;
	private int toppingY = toppingYToStart;
	private int toppingWidth = 110;
	private int toppingHeight = 60;
	private int toppingsForColumn = 4;
	private int toppingFontSize = 13;
	private int toppingYToMove = 80;
	private int toppingXToMove = 125;

	private String addToOrderSound = "res/addToOrderSound.wav";
	private String clearSound = "res/clearCurrentOrderSound.wav";

	private String buttonFont = "Lucida Grande";
	private int buttonFontSize = 16;
	private Color buttonTextColor = Color.black;

	public OrderingJPanel(Image img, String currentBasePackage, String[] baseCasesNameList, String[] toppingNameList, String[] classNameList) {
		super(img);

		myItemCreator = new ItemCreator(currentBasePackage);
		myItemCreator.setItemsLists(baseCasesNameList, toppingNameList, classNameList);

		myComponentCreator = new ComponentCreator<>();

		baseCasesButtonList = new LinkedList<JButton>();
		toppingButtonList = new LinkedList<JButton>();
		currentTopping = new LinkedList<String>();
		buttonSound = new Sound();
		myBorderManager = new ButtonBorderManager(defaultColor, selectedColor);

		createToppingsItems(toppingNameList);
		createBaseItems(baseCasesNameList);
		addOrderButton();
	}

	@Override
	public void setOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	private void createBaseItems(String[] pizzaItems) {
		for (int i = 0; i<pizzaItems.length; i++) {
			String currentItemText = pizzaItems[i];
			final JButtonTextImage currentItemButton = new JButtonTextImage(baseCasesX, baseCasesY, baseCasesWidth,
					baseCasesHeight, baseFontSize, currentItemText);
			baseCasesButtonList.add(currentItemButton);
			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeBorderColor(currentItemButton);
					if(getBorderColor(currentItemButton).equals(selectedColor)){
						baseCasesButtonList.add(currentItemButton);
						currentCaseBase = currentItemButton.getText();
						setOthersButtons(false, baseCasesButtonList, currentItemButton);
						setOthersButtons(true, toppingButtonList, currentItemButton);
					}else{
						currentCaseBase = null;
						baseCasesButtonList.remove(currentItemButton);
						setOthersButtons(true, baseCasesButtonList, currentItemButton);
						setOthersButtons(false, toppingButtonList, currentItemButton);
					}
				}
			});
			currentJPanel.add(currentItemButton);
			baseCasesX = baseCasesX+baseCaseXToMove;
		}
	}

	private void createToppingsItems(String[] toppingsItems) {
		for (int i = 0; i<toppingsItems.length; i++) {
			if (i%toppingsForColumn==0 && i!=0) {
				toppingX = toppingX+toppingXToMove;
				toppingY = toppingYToStart;
			}
			final String currentItemText = toppingsItems[i];
			final JButtonTextImage currentItemButton = new JButtonTextImage(toppingX, toppingY, toppingWidth,
					toppingHeight, toppingFontSize, currentItemText);
			toppingButtonList.add(currentItemButton);
			currentItemButton.setEnabled(false);

			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeBorderColor(currentItemButton);
					if (getBorderColor(currentItemButton).equals(selectedColor)) {
						currentTopping.add(currentItemButton.getText());
						toppingButtonList.add(currentItemButton);
					} else {
						currentTopping.remove(currentItemButton.getText());
						toppingButtonList.remove(currentItemButton);
					}
				}
			});

			currentJPanel.add(currentItemButton);
			toppingY = toppingY+toppingYToMove;
		}
	}

	private void addOrderButton() {
		AddToOrderButton = createFormattedButton("Add To Order", addButtonx, addButtony, addButtonWidth, addButtonHeight);
		AddToOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonSound.setSound(clearSound);
				
				if (currentCaseBase!=null) {
					try {
						createChoseenBaseCase(currentCaseBase);
						Iterator<String> iteratore = getListIterator(currentTopping);
						while(iteratore.hasNext()){
							String currentToppingName = (String)iteratore.next();
							createChoosenToppings(currentToppingName);
						}

						currentOrder.add(currentItem);
						buttonSound.setSound(addToOrderSound);
					} catch (Exception e1) {
						System.out.println(e1);
					}
				}

				try {
					buttonSound.playSound();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				resetSelection();
			}
		});

		ClearButton=createFormattedButton("Clear Selection", clearButtonx, clearButtony, clearButtonWidth, clearButtonHeight);
		ClearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonSound.setSound(clearSound);

				try {
					buttonSound.playSound();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				resetSelection();
			}
		});
	}


	private void resetSelection(){
		resetAllButtons();
		currentTopping = new LinkedList<>();
		currentCaseBase = null;
		currentItem = null;
	}

	private void setOthersButtons(boolean enable, LinkedList<JButton> list, JButton mybutton) {
		myBorderManager.setOthersButtons(enable, list, mybutton);
	}

	private void resetAllButtons(){
		myBorderManager.resetButtons(baseCasesButtonList, toppingButtonList);
		myBorderManager.setOthersButtons(false, toppingButtonList, new JButton());
		myBorderManager.setOthersButtons(true, baseCasesButtonList, new JButton());
	}

	private Iterator<String> getListIterator(LinkedList<String> list) {
		return list.iterator();
	}

	private void changeBorderColor(JButtonTextImage currentItemButton) {
		myBorderManager.changeBorderColor(currentItemButton);
	}

	private Color getBorderColor(JButtonTextImage currentItemButton) {
		return myBorderManager.getBorderColor(currentItemButton);
	}

	private void createChoseenBaseCase(String className) {
		myItemCreator.createChoseenBaseCase(className);
		currentItem = myItemCreator.getCurrentItem();
	}

	private void createChoosenToppings( String currentPackage) {
		myItemCreator.createChoosenToppings(currentPackage);
		currentItem = myItemCreator.getCurrentItem();
	}

	private JButton createFormattedButton(String text, int buttonX, int buttonY, int buttonWidth, int buttonHeight){
		myComponentCreator.createButton(text, buttonFont, buttonFontSize, buttonTextColor);
		myComponentCreator.setUpComponentProp(buttonX, buttonY, buttonWidth, buttonHeight);
		this.add(myComponentCreator.getButton());
		return myComponentCreator.getButton();
	}	
}