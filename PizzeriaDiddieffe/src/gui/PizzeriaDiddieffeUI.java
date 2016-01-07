package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.border.LineBorder;


public class PizzeriaDiddieffeUI {
	
	private int numberOfTablesInside = 0;
	private int numberOfTablesOutside = 0;
	private int maxNumberOfTablesInside = 12;
	private int maxNumberOfTablesOutside = 8;
	
	private JButton btnMinusInside;
	private JButton btnMinusOutside;
	
	private JFrame frame;
	private JLabel labelNumberOfTablesOutside;
	
	private JPanel chooseInsideOutside;
	
	private JPanelwithBackgroundTables insidePanel;
	private JPanelwithBackgroundTables outsidePanel;
	
	private JPanelwithBackgroundOrder orderPanelOutside;
	private JPanelwithBackgroundOrder orderPanelInside;
	
	private JButton btnPlusOutisde;
	private JButton btnPlusInside;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PizzeriaDiddieffeUI window = new PizzeriaDiddieffeUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PizzeriaDiddieffeUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMaximumSize(new Dimension(550, 750));
		frame.setMinimumSize(new Dimension(550, 750));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		final JPanel chooseNumberOfTables = new JPanel();
		chooseNumberOfTables.setBackground(new Color(139, 69, 19));
		frame.getContentPane().add(chooseNumberOfTables, "name_1230783104452");
		chooseNumberOfTables.setLayout(null);
		
		JLabel lblNumberOfTables = new JLabel("Number of tables inside:");
		lblNumberOfTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfTables.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNumberOfTables.setBounds(155, 112, 240, 20);
		lblNumberOfTables.setHorizontalTextPosition(SwingConstants.CENTER);
		chooseNumberOfTables.add(lblNumberOfTables);
		
		final JLabel labelNumberOfTablesInside = new JLabel("0");
		labelNumberOfTablesInside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		labelNumberOfTablesInside.setBounds(255, 166, 40, 20);
		labelNumberOfTablesInside.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumberOfTablesInside.setHorizontalTextPosition(SwingConstants.CENTER);
		chooseNumberOfTables.add(labelNumberOfTablesInside);
		
		btnMinusInside = new JButton("-");
		btnMinusInside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinusInside.setEnabled(false);
		btnMinusInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesInside--;
				labelNumberOfTablesInside.setText(String.valueOf(numberOfTablesInside));
				if (numberOfTablesInside == 0) {
					btnMinusInside.setEnabled(false);
				}
				btnPlusInside.setEnabled(true);
			}
		});
		btnMinusInside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnMinusInside.setBounds(165, 152, 50, 50);
		chooseNumberOfTables.add(btnMinusInside);
		
		
		
		btnPlusInside = new JButton("+");
		btnPlusInside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPlusInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesInside++;
				labelNumberOfTablesInside.setText(String.valueOf(numberOfTablesInside));
				if (numberOfTablesInside == maxNumberOfTablesInside) {
					btnPlusInside.setEnabled(false);
				}
				btnMinusInside.setEnabled(true);
			}
		});
		btnPlusInside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnPlusInside.setBounds(335, 152, 50, 50);
		chooseNumberOfTables.add(btnPlusInside);
		
		JLabel lblNumberOfTable = new JLabel("Number of table outside:");
		lblNumberOfTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfTable.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNumberOfTable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNumberOfTable.setBounds(155, 298, 240, 20);
		chooseNumberOfTables.add(lblNumberOfTable);
		
		btnMinusOutside = new JButton("-");
		btnMinusOutside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinusOutside.setEnabled(false);
		btnMinusOutside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesOutside--;
				labelNumberOfTablesOutside.setText(String.valueOf(numberOfTablesOutside));
				if (numberOfTablesOutside == 0) {
					btnMinusOutside.setEnabled(false);
				}
				btnPlusOutisde.setEnabled(true);
			}
		});
		btnMinusOutside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnMinusOutside.setBounds(165, 338, 50, 50);
		chooseNumberOfTables.add(btnMinusOutside);
		
		labelNumberOfTablesOutside = new JLabel("0");
		labelNumberOfTablesOutside.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumberOfTablesOutside.setHorizontalTextPosition(SwingConstants.CENTER);
		labelNumberOfTablesOutside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		labelNumberOfTablesOutside.setBounds(255, 352, 40, 20);
		chooseNumberOfTables.add(labelNumberOfTablesOutside);
		
		btnPlusOutisde = new JButton("+");
		btnPlusOutisde.setFocusPainted(false);
		btnPlusOutisde.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPlusOutisde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesOutside++;
				labelNumberOfTablesOutside.setText(String.valueOf(numberOfTablesOutside));
				if (numberOfTablesOutside == maxNumberOfTablesOutside) {
					btnPlusOutisde.setEnabled(false);
				}
				btnMinusOutside.setEnabled(true);
			}
		});
		btnPlusOutisde.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnPlusOutisde.setBounds(335, 338, 50, 50);
		chooseNumberOfTables.add(btnPlusOutisde);
		
		chooseInsideOutside = new JPanel();// potrebbe essere una classe 
		frame.getContentPane().add(chooseInsideOutside, "name_1233757414457");
		chooseInsideOutside.setLayout(new GridLayout(2, 0, 0, 0));

		
		final JButton btnInside = new JButton("Inside");
		btnInside.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnInside.setForeground(new Color(0, 0, 0));
		btnInside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInside.setIcon(new ImageIcon("res/insideButton.jpg"));
		btnInside.setFont(new Font("Lucida Grande", Font.BOLD, 60));
		btnInside.setText("Inside");
		btnInside.setHorizontalTextPosition(JButton.CENTER);
		btnInside.setVerticalTextPosition(JButton.CENTER);
		btnInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseInsideOutside.setVisible(false);
				insidePanel.setVisible(true);
			}
		});
		chooseInsideOutside.add(btnInside);
		
		
		final JButton btnOutside = new JButton("Outside");
		btnOutside.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnOutside.setForeground(new Color(0, 0, 0));
		btnOutside.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOutside.setIcon(new ImageIcon("res/outsideButton.jpg"));
		chooseInsideOutside.add(btnOutside);
		btnOutside.setFont(new Font("Lucida Grande", Font.BOLD, 60));
		btnOutside.setText("Outside");
		btnOutside.setHorizontalTextPosition(JButton.CENTER);
		btnOutside.setVerticalTextPosition(JButton.CENTER);
		btnOutside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseInsideOutside.setVisible(false);
				outsidePanel.setVisible(true);
			}
		});
		
		JButton btnDone = new JButton("Done");
		btnDone.setBackground(new Color(255, 255, 255));
		btnDone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseNumberOfTables.setVisible(false);
				createPlacesPanels(numberOfTablesInside, numberOfTablesOutside,btnInside,btnOutside);
			}
		});
		btnDone.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnDone.setBounds(175, 617, 200, 60);
		chooseNumberOfTables.add(btnDone);
		
		
		
	}
	
	
	
	private void createPlacesPanels(int insideTables,int outsideTables,JButton btn_inside,JButton btn_outside){
		
		if(insideTables<1){
			btn_inside.setEnabled(false);
		}
		if(outsideTables<1){
			btn_outside.setEnabled(false);
		}
		
			chooseInsideOutside.setVisible(true);
			
		
			Image orderOutside_bg=new ImageIcon("res/orderBG.jpg").getImage();//creo pannello per ordini interni 
			orderPanelOutside=new JPanelwithBackgroundOrder(orderOutside_bg);
			
			frame.getContentPane().add(orderPanelOutside);
			
			Image orderInside_bg=new ImageIcon("res/orderBG.jpg").getImage();//creo pannello per ordini esterni
			orderPanelInside=new JPanelwithBackgroundOrder(orderInside_bg);
			
			frame.getContentPane().add(orderPanelInside);
			
			
			Image inside_bg = new ImageIcon ("res/parquetBG.jpg").getImage();
			insidePanel = new JPanelwithBackgroundTables(inside_bg, insideTables, "inside",orderPanelInside);
			insidePanel.setLayout(null);
			frame.getContentPane().add(insidePanel);
				
			Image outside_bg = new ImageIcon ("res/outsideBG.jpg").getImage();
			outsidePanel = new JPanelwithBackgroundTables(outside_bg, outsideTables, "outside",orderPanelOutside);
			frame.getContentPane().add(outsidePanel);
			
			setBackButtons();
		
	}
	
	private void setBackButtons(){
		insidePanel.setVisiblePanel(chooseInsideOutside,frame);
		outsidePanel.setVisiblePanel(chooseInsideOutside,frame);
		orderPanelOutside.setVisiblePanel(outsidePanel, frame);//setto il pannello che dovra essere lasciato visibile alla pressione del pulsante "back"
		orderPanelInside.setVisiblePanel(insidePanel, frame); //setto il pannello che dovra essere lasciato visibile alla pressione del pulsante "back"
	
		orderPanelInside.createOrderingPanels();
		orderPanelOutside.createOrderingPanels();
	
	}
	
	
}
