package pizzeriadiddieffe.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import pizzeriadiddieffe.core.Item;
import pizzeriadiddieffe.core.Order;
import pizzeriadiddieffe.gui.formattedelements.HtmlFormatter;
import pizzeriadiddieffe.gui.jpanel.OrderScrollPane;
import pizzeriadiddieffe.gui.jpanel.PayOrderJPanel;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundImgAndBackBtn;

public class OrderViewer extends JPanelWithBackgroundImgAndBackBtn {

	private JPanelWithBackgroundImgAndBackBtn currentJPanel = this;
	private PayOrderJPanel myPayJPanel;
	private Order myOrder;
	private LinkedList<Item> myItemsList;
	private HtmlFormatter myHtmlFormatter;
	private OrderScrollPane scrollPane;
	
	private JButton payOrderButton;
	private int payButtonX = 200;
	private int payButtonY = 650;
	private int payButtonHeight = 50;
	private int payButtonWight = 155;
	private String payOrderImagePath = "res/payOrderBackground.jpg";
	private Item currentItem;
	
	private Color scrollPaneColors=Color.white;
	private int scrollPaneX = 20;
	private int scrollPaneY = 200;
	private int scrollPaneWidth = 510;
	private int scrollPaneHeight = 420;

	private JLabel descriptionLabel;
	private int labelX = -10;
	private int labelY = -5;
	private int labelHeight = 200;
	private int labelWidth = 200;
	private int labelFont = 22;

	public OrderViewer(Image img, JFrame myFrame, JPanelWithBackgroundImgAndBackBtn payOrderVisiblePanel) {
		super(img);

		JPanel panel = new JPanel();
		myHtmlFormatter=new HtmlFormatter();
		descriptionLabel = new JLabel();
		descriptionLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
		descriptionLabel.setFont(new Font("Lucida Grande", Font.PLAIN, labelFont));
		panel.add(descriptionLabel);

		scrollPane=new OrderScrollPane();
		scrollPane.setCurrentJPanel(panel);
		scrollPane.setParameters(scrollPaneX, scrollPaneY, scrollPaneWidth, scrollPaneHeight);
		scrollPane.setColors(scrollPaneColors, scrollPaneColors);
		currentJPanel.add(scrollPane.getScrollPane());

		Image payOrderImage = new ImageIcon(payOrderImagePath).getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_SMOOTH);
		myPayJPanel = new PayOrderJPanel(payOrderImage, myFrame);
		myPayJPanel.setVisiblePanel(payOrderVisiblePanel, myFrame);
		myPayJPanel.setVisible(false);
		myFrame.add(myPayJPanel);

		payOrderButton = new JButton ("Pay Order");
		payOrderButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		payOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		payOrderButton.setBounds(payButtonX, payButtonY, payButtonWight, payButtonHeight);
		this.add(payOrderButton);
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
	}

	public void setOrder(Order myOrder){
		this.myOrder = myOrder;
		drawOrder();
	}

	private void drawOrder() {
		myItemsList = myOrder.getOrderList();
		Iterator<Item> iteratore = getIterator();
		String baseCase = "";

		while (iteratore.hasNext()) {
			currentItem = iteratore.next();
			baseCase = baseCase + myHtmlFormatter.getBullet() + currentItem.getInfo() ;
			baseCase = baseCase.replaceAll(myHtmlFormatter.getComma(), myHtmlFormatter.getTabSpace());
			baseCase = baseCase + myHtmlFormatter.getNewLine() + myHtmlFormatter.getEndItalic() + myHtmlFormatter.getStartBold() 
			+ myHtmlFormatter.getPrice() + currentItem.getPrice() + myHtmlFormatter.getEndBold() + myHtmlFormatter.getNewLine() + myHtmlFormatter.getNewLine();
		}

		descriptionLabel.setText("<html>"+baseCase+"<html>");
	}

	private Iterator<Item> getIterator() {
		return myItemsList.iterator();
	}
}