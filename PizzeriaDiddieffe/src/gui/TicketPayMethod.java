package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import pizzeriadiddieffe.core.Order;

public class TicketPayMethod extends JPanelWithBackgroundImg implements payMethodInterface {

	public TicketPayMethod(Image img) {
		super(img);
		// TODO Auto-generated constructor stub
	}

	private double totprice;
	private JPanelWithBackgroundImg myPanel;
	private JButton payButton;
	private Order currentOrder;
	private JComboBox<Integer> numberOfTickets;
	private JComboBox<Double> valueOfTickets;
	
	private int space=20;
	private int labelx=30;
	private int labely=100;
	private int labelWidth=500;
	private int labelheight=40;
	private int labelSpace=labelheight+space;
	private int labelfont=25;
	
	private int buttonfont=20;
	private int yBox = labely+labelSpace;
	private int yBoxSpace = yBox+labelSpace;
	private int xBox = 250;
	private int boxWidth = 75;
	private int boxHeight = 50;
	
	private double Totvalue=0;
	private int buttonPayx=300;
	private int buttonPayy=320;
	private int buttonPayWidth=220;
	private int buttonPayHeight=250;
	
	@Override
	public void paymethod(Order totprice,JPanelWithBackgroundImg myPanel) {
		this.totprice = totprice.getPrice();
		this.currentOrder=totprice;
		this.myPanel=myPanel;
		createTotalLabel();
		createBox();
	}
	
	public void createBox(){
		valueOfTickets = new JComboBox<Double>();
		valueOfTickets.addItem(2.5);
		valueOfTickets.addItem(5.0);
		valueOfTickets.addItem(7.5);
		valueOfTickets.setBounds(xBox, yBox, boxWidth, boxHeight);
		valueOfTickets.setFont(new Font("Lucida Grande", Font.BOLD, labelfont));
		myPanel.add(valueOfTickets);
		
		double value = (double)valueOfTickets.getSelectedItem();
		int ini = 0;
		int stop = (int)(totprice/value);
		numberOfTickets = new JComboBox<Integer>();
		int cont = 0;
		while(cont<=stop){
			numberOfTickets.addItem(cont);
			cont++;
		}
		numberOfTickets.setBounds(xBox, yBoxSpace, boxWidth, boxHeight);
		numberOfTickets.setFont(new Font("Lucida Grande", Font.BOLD, labelfont));
		myPanel.add(numberOfTickets);

		valueOfTickets.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				double value = (double)valueOfTickets.getSelectedItem();
				int bobo = (int)(totprice/value);
				numberOfTickets.removeAllItems();
				int cont = 0;
				while(cont<=bobo){
					numberOfTickets.addItem(cont);
					cont++;
				}
			}
		});
	}


	public void createTotalLabel(){
		final JLabel label=new JLabel("Totale Ordine "+totprice);
		label.setBounds(labelx,labely,labelWidth,labelheight);
		label.setFont((new Font("Lucida Grande", Font.BOLD, labelfont)));
		myPanel.add(label);
		
		final JLabel ticketsValue = new JLabel("Valore Tickets:");
		ticketsValue.setBounds(labelx, yBox, labelWidth, labelheight);
		ticketsValue.setFont((new Font("Lucida Grande", Font.BOLD, labelfont)));
		myPanel.add(ticketsValue);
		
		final JLabel ticketsNumber = new JLabel("Numero Tickets:");
		ticketsNumber.setBounds(labelx, yBoxSpace, labelWidth, labelSpace);
		ticketsNumber.setFont((new Font("Lucida Grande", Font.BOLD, labelfont)));
		myPanel.add(ticketsNumber);
		
		payButton=new JButton("Pay");
		payButton.setBounds(buttonPayx, buttonPayy, buttonPayWidth, buttonPayHeight);
		payButton.setFont((new Font("Lucida Grande", Font.BOLD, buttonfont)));
		payButton.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				String currentText=payButton.getText();
				Totvalue = (double)(valueOfTickets.getSelectedItem())*(int)(numberOfTickets.getSelectedItem());

				double resto=totprice-Totvalue;

				if(currentText=="Pay" && resto>0){
					payButton.setText("Da pagare: "+resto);
					numberOfTickets.setEnabled(false);
					valueOfTickets.setEnabled(false);
				}else if(resto==0){
					currentOrder.deleteAll();
					payButton.setText("Payed!");
				}else if(currentText!="Da pagare: "+resto){
					totprice=totprice-Totvalue;
				}
			}
		});
		myPanel.add(payButton);
	}

}