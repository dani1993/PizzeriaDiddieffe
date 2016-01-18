package pizzeriadiddieffe.gui.jpanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import pizzeriadiddieffe.core.CreateBaseCaseByName;
import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.core.Sound;
import pizzeriadiddieffe.core.beverage.Beverage;
import pizzeriadiddieffe.core.focaccia.Focaccia;
import pizzeriadiddieffe.core.pizza.Pizza;
import pizzeriadiddieffe.gui.jbutton.JButtonTextImage;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundImgAndBackBtn;

public class OrderingJPanel extends JPanelWithBackgroundImgAndBackBtn {
	private JButton AddToOrderButton;
	private JPanelWithBackgroundImgAndBackBtn currentJPanel = this;
	private int addButtonWidth = 60;
	private int addButtonHeight = 250;
	private int addButtonx = 130;
	private int addButtony = 640;
	private CreateBaseCaseByName myCreator;
	private Object object;
	private Order currentOrder;
	private Item currentItem;
	private String currentClass;
	private String[] currentClassName;
	private Sound buttonSound;

	private LinkedList<JButton> baseCasesButtonList;
	private LinkedList<JButton> toppingButtonList;
	private LinkedList<String> currentTopping;
	private String currentCaseBase;

	private int baseFontSize = 15;
	private int baseCasesX = 75; // 75
	private int baseCasesY = 190; // 180
	private int baseCasesWidth = 120;
	private int baseCasesHeight = 70;
	private int baseCaseXToMove = 140;

	private int toppingX = 38;// 35
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

	private String[] baseCasesNameList;
	private String[] toppingNameList;

	public OrderingJPanel(Image img, String currentBasePackage, String[] baseCasesNameList, String[] toppingNameList, String[] classNameList) {
		super(img);
		myCreator = new CreateBaseCaseByName();
		baseCasesButtonList = new LinkedList<JButton>();
		toppingButtonList = new LinkedList<JButton>();
		currentTopping = new LinkedList<String>();
		buttonSound = new Sound();
		currentClassName = classNameList;
		this.baseCasesNameList = baseCasesNameList;
		this.currentClass = currentBasePackage;
		this.toppingNameList = toppingNameList;

		createPizzaToppingsItems(toppingNameList);
		createPizzaItems(baseCasesNameList);
		addOrderButton();
	}

	public void setOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	private void createPizzaItems(String[] pizzaItems) {
		for (int i = 0; i<pizzaItems.length; i++) {
			String currentItemText = pizzaItems[i];
			final JButtonTextImage currentItemButton = new JButtonTextImage(baseCasesX, baseCasesY, baseCasesWidth,
					baseCasesHeight, baseFontSize, currentItemText);
			baseCasesButtonList.add(currentItemButton);
			currentItemButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changeBorderColor(currentItemButton);
					if(getBorderColor(currentItemButton).equals(Color.green)){
						baseCasesButtonList.add(currentItemButton);
						currentCaseBase = currentItemButton.getText();
						setOthersButtons(false,baseCasesButtonList,currentItemButton);
						setOthersButtons(true,toppingButtonList,currentItemButton);
					}else{
						currentCaseBase = null;
						baseCasesButtonList.remove(currentItemButton);
						setOthersButtons(true,baseCasesButtonList,currentItemButton);
						setOthersButtons(false, toppingButtonList, currentItemButton);
					}
				}
			});
			currentJPanel.add(currentItemButton);
			baseCasesX = baseCasesX + baseCaseXToMove;
		}
	}

	private void createPizzaToppingsItems(String[] toppingsItems) {
		for (int i = 0; i<toppingsItems.length; i++) {
			if (i%toppingsForColumn==0 && i!=0) {
				toppingX = toppingX + toppingXToMove;
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
					if (getBorderColor(currentItemButton).equals(Color.green)) {
						currentTopping.add(currentItemButton.getText());
						toppingButtonList.add(currentItemButton);
					} else {
						currentTopping.remove(currentItemButton.getText());
						toppingButtonList.remove(currentItemButton);
					}
				}
			});

			currentJPanel.add(currentItemButton);

			toppingY = toppingY + toppingYToMove;
		}
	}

	private void addOrderButton() {
		AddToOrderButton = new JButton("Add To Order/Clear");
		AddToOrderButton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		AddToOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddToOrderButton.setBounds(addButtonx, addButtony, addButtonHeight, addButtonWidth);
		this.add(AddToOrderButton);

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
				resetAllButtons();
				currentTopping = new LinkedList<>();
				currentCaseBase = null;
				currentItem = null;
			}
		});
	}

	
	private void setOthersButtons(boolean enable,LinkedList<JButton> list,JButton mybutton) {
		Iterator<JButton> iteratore = getButtonListIterator(list);
		while(iteratore.hasNext()){
			JButton currentButton = iteratore.next();
			currentButton.setEnabled(enable);
			if(enable==false && mybutton.equals(currentButton)){
				currentButton.setEnabled(true);
			}
		}
	}
	
	
	
	private void resetAllButtons(){
		resetButtons();
		setOthersButtons(false, toppingButtonList, new JButton());
		setOthersButtons(true, baseCasesButtonList, new JButton());
	}

	private Iterator<JButton> getButtonListIterator(LinkedList<JButton> list) {
		return list.iterator();
	}

	private Iterator<String> getListIterator(LinkedList<String> list) {
		return list.iterator();
	}

	private void resetButtons() {
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

	private void resetBorderColor(JButton currentButton) {
		currentButton.setBorder(new LineBorder(Color.white, 3, true));
	}

	private void changeBorderColor(JButtonTextImage currentItemButton) {
		Color currentBorder = getBorderColor(currentItemButton);
		if(currentItemButton.isEnabled()){
			if (currentBorder==Color.white) {
				currentItemButton.setBorder((new LineBorder(Color.green, 3, true)));
			} else {
				currentItemButton.setBorder(new LineBorder(Color.white, 3, true));
			}
		}
	}

	private Color getBorderColor(JButtonTextImage currentItemButton) {
		Color currentBorder = ((LineBorder) currentItemButton.getBorder()).getLineColor();
		return currentBorder;
	}

	private void createChoseenBaseCase(String className) {
		String currentclassName=getClassName(className,baseCasesNameList);

		final String fullPackagePath = "pizzeriadiddieffe.core." + currentClass + ".";
		try {
			object = myCreator.createObjectByName(fullPackagePath + currentclassName);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
		currentItem = ((Item) object);
	}

	private String getClassName(String className,String[] nameList) {
		for(int i=0; i<currentClassName.length; i++){
			if(nameList[i].equals(className)){
				if(nameList.equals(toppingNameList)){
					return currentClassName[i+baseCasesNameList.length];
				}
				return currentClassName[i];
			}
		}
		return null;
	}

	private void createChoosenToppings( String currentPackage) {
		currentPackage=getClassName(currentPackage,toppingNameList);

		String fullPackagePath = "pizzeriadiddieffe.core." +currentClass+ ".topping." + currentPackage;

		try {
			object = myCreator.createToppingByName(fullPackagePath,
					currentItem, currentClass);
		} catch (Exception exception) {
			System.out.println(currentItem.getPrice());
			System.out.println("errore");
		}
		castToCurrentClass(currentClass);
	}

	private void castToCurrentClass(String currentClass) {
		if (currentClass.equals("pizza")) {
			currentItem = (Pizza) object;
			return;
		} else if (currentClass.equals("beverage")) {
			currentItem = (Beverage) object;
			return;
		}
		currentItem = (Focaccia) object;
		return;
	}
}