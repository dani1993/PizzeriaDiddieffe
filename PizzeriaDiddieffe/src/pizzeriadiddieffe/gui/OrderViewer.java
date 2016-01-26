package pizzeriadiddieffe.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.gui.creators.ComponentCreator;
import pizzeriadiddieffe.gui.formattedelements.HtmlFormatter;
import pizzeriadiddieffe.gui.jpanel.OrderScrollPane;
import pizzeriadiddieffe.gui.jpanel.PayOrderJPanel;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundImgAndBackBtn;

@SuppressWarnings("serial")
public class OrderViewer extends JPanelWithBackgroundImgAndBackBtn implements OrderViewerInterface{
	private JPanelWithBackgroundImgAndBackBtn currentJPanel = this;
	private PayOrderJPanel myPayJPanel;
	private Order myOrder;
	private LinkedList<Item> myItemsList;
	private HtmlFormatter myHtmlFormatter;
	private OrderScrollPane scrollPane;

	private JButton editButton;
	private int editButtonX = 390;
	private int editButtonY = 140;
	private int editButtonHeight = 50;
	private int editButtonWight = 140;
	private int currentEditItem = 0;

	private JButton removeButton;
	private int removeButtonX = 20;
	private int removeButtonY = 650;
	private int removeButtonHeight = 50;
	private int removeButtonWight = 155;

	private JButton payOrderButton;
	private int payButtonX = 370;
	private int payButtonY = 650;
	private int payButtonHeight = 50;
	private int payButtonWight = 160;
	private String payOrderImagePath = "PaymentMethodBG.jpg";
	private Item currentItem;

	private Color scrollPaneColors = Color.white;
	private int scrollPaneX = 20;
	private int scrollPaneY = 200;
	private int scrollPaneWidth = 510;
	private int scrollPaneHeight = 420;

	private JLabel descriptionLabel;
	private String notEditingText;
	private boolean removingItem = false;
	@SuppressWarnings("rawtypes")
	private ComponentCreator myComponentCreator;
	private int labelX = -10;
	private int labelY = -5;
	private int labelHeight = 200;
	private int labelWidth = 200;
	private int labelFontSize = 22;
	private String font = "Lucida Grande";
	private int buttonFontSize = 22;
	private Color buttonTextColor = Color.BLACK;
	private LinkedList<String> itemsList;
	private URL imageURL;

	public OrderViewer(Image img, JFrame myFrame, JPanelWithBackgroundImgAndBackBtn payOrderVisiblePanel) {
		super(img);

		myComponentCreator = new ComponentCreator<>();

		JPanel panel = new JPanel();
		myHtmlFormatter = new HtmlFormatter();
		descriptionLabel = new JLabel();
		descriptionLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
		descriptionLabel.setFont(new Font(font, Font.PLAIN, labelFontSize));
		panel.add(descriptionLabel);

		scrollPane = new OrderScrollPane();
		scrollPane.setCurrentJPanel(panel);
		scrollPane.setParameters(scrollPaneX, scrollPaneY, scrollPaneWidth, scrollPaneHeight);
		scrollPane.setColors(scrollPaneColors, scrollPaneColors);
		currentJPanel.add(scrollPane.getScrollPane());

		imageURL = OrderViewer.class.getResource(payOrderImagePath);
		Image payOrderImage = new ImageIcon(imageURL).getImage();
		myPayJPanel = new PayOrderJPanel(payOrderImage, myFrame);
		myPayJPanel.setVisiblePanel(payOrderVisiblePanel, myFrame);
		myPayJPanel.setVisible(false);
		myFrame.add(myPayJPanel);

		payOrderButton = createFormattedButton("Pay Order", payButtonX, payButtonY, payButtonWight, payButtonHeight);
		payOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double price = myOrder.getPrice();
				if(price>0){
					myPayJPanel.setPrice(myOrder);
					myPayJPanel.setVisible(true);
					currentJPanel.setVisible(false);
				}
			}
		});

		editButton = createFormattedButton("Edit", editButtonX, editButtonY, editButtonWight, editButtonHeight);
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(itemsList.size()>0 && currentEditItem<itemsList.size()){
					removingItem = true;
					currentEditItem++;
					String currentItem = myHtmlFormatter.getHighligh()+itemsList.get(currentEditItem-1)+myHtmlFormatter.getEndhighligh();
					String currentText = "";
					for(int i = 0; i<itemsList.size(); i++){
						if(i==currentEditItem-1){
							editButton.setText("Next");
							currentText = currentText+currentItem;
						}else{
							currentText = currentText+itemsList.get(i);
						}
					}
					descriptionLabel.setText("<html>"+currentText+"<html>");
				}else{
					editButton.setText("Edit");

					currentEditItem = 0;
					removingItem = false;
					descriptionLabel.setText(notEditingText);
				}
			}
		});

		removeButton = createFormattedButton("Remove", removeButtonX, removeButtonY, removeButtonWight, removeButtonHeight);
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(removingItem==true && currentEditItem!=0){
					try {
						myOrder.deleteIndex(currentEditItem-1);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					currentEditItem = 0;
					drawOrder();
					editButton.setText("Edit");
				}
			}
		});
	}

	@Override
	public void setOrder(Order myOrder){
		this.myOrder = myOrder;
		drawOrder();
	}

	private void drawOrder() {
		itemsList = new LinkedList<String>();
		myItemsList = myOrder.getOrderList();
		Iterator<Item> iteratore = getIterator();
		String baseCase = "";
		int lastIndex = 0;
		while (iteratore.hasNext()) {
			currentItem = iteratore.next();
			baseCase = baseCase+myHtmlFormatter.getBullet()+currentItem.getInfo() ;
			baseCase = baseCase.replaceAll(myHtmlFormatter.getComma(), myHtmlFormatter.getTabSpace());
			baseCase = baseCase+myHtmlFormatter.getNewLine()+myHtmlFormatter.getEndItalic()+myHtmlFormatter.getStartBold()+ 
					myHtmlFormatter.getPrice()+currentItem.getPrice()+myHtmlFormatter.getEndBold()+myHtmlFormatter.getNewLine()+
					myHtmlFormatter.getNewLine();
			itemsList.add(baseCase.substring(lastIndex));
			lastIndex = baseCase.length();	
		}
		baseCase = baseCase+myHtmlFormatter.getBullet()+myHtmlFormatter.getStartBold()+"Total Price: "+myOrder.getPrice()+myHtmlFormatter.getEndBold();
		descriptionLabel.setText("<html>"+baseCase+"<html>");
		notEditingText = descriptionLabel.getText();
	}

	private Iterator<Item> getIterator() {
		return myItemsList.iterator();
	}

	private JButton createFormattedButton(String text, int buttonX, int buttonY, int buttonWidth, int buttonHeight){
		myComponentCreator.createButton(text, font, buttonFontSize, buttonTextColor);
		myComponentCreator.setUpComponentProp(buttonX, buttonY, buttonWidth, buttonHeight);
		this.add(myComponentCreator.getButton());
		return myComponentCreator.getButton();
	}
}