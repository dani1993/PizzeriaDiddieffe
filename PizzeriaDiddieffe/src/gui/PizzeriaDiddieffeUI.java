package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class PizzeriaDiddieffeUI extends JPanel {
	
	private  int numberOfTablesInside = 0;
	private  int numberOfTablesOutside = 0;
	private final int maxNumberOfTablesInside = 12;
	private final int maxNumberOfTablesOutside = 8;
	
	private JButton btnMinusInside;
	private JButton btnMinusOutside;
	
	private JFrame frame;
	private JLabel labelNumberOfTablesOutside;
	
	private JPanel chooseInsideOutside;
	
	private JPanelwithBackgroundTables insidePanel;
	private JPanelwithBackgroundTables outsidePanel;
	
	private JPanelwithBackgroundOrder orderPanel;
	
	private JButton btnPlusOutisde;
	private JButton btnPlusInside;
	
	public static JProgressBar progressBar = new JProgressBar();

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
	
	private Image img;
	
	
	
	public PizzeriaDiddieffeUI(String img) {
		this(new ImageIcon(img).getImage());
	}
	
	public PizzeriaDiddieffeUI(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	    	//draw background image
	        g.drawImage(img, 0, 0, null);
	}
	
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
		
		final PizzeriaDiddieffeUI chooseNumberOfTables = new PizzeriaDiddieffeUI("res/mainBG.jpg");
//		chooseNumberOfTables.setBackground(new Color(139, 69, 19));
		frame.getContentPane().add(chooseNumberOfTables, "name_1230783104452");
		chooseNumberOfTables.setLayout(null);
		//my progress bar
		progressBar.setBounds(150, 500, 300, 50);
		chooseNumberOfTables.add(progressBar);
	    progressBar.setStringPainted(true);

		
		JLabel lblNumberOfTables = new JLabel("Number of tables inside:");
		lblNumberOfTables.setForeground(Color.white);
		lblNumberOfTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfTables.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNumberOfTables.setBounds(155, 162, 240, 20);
		lblNumberOfTables.setHorizontalTextPosition(SwingConstants.CENTER);
		chooseNumberOfTables.add(lblNumberOfTables);
		
		final JLabel labelNumberOfTablesInside = new JLabel("0");
		labelNumberOfTablesInside.setForeground(Color.white);
		labelNumberOfTablesInside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		labelNumberOfTablesInside.setBounds(255, 226, 40, 20);
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
		btnMinusInside.setBounds(165, 212, 50, 50);
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
		btnPlusInside.setBounds(335, 212, 50, 50);
		chooseNumberOfTables.add(btnPlusInside);
		
		JLabel lblNumberOfTable = new JLabel("Number of table outside:");
		lblNumberOfTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfTable.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNumberOfTable.setForeground(Color.white);
		lblNumberOfTable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNumberOfTable.setBounds(155, 358, 240, 20);
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
		btnMinusOutside.setBounds(165, 398, 50, 50);
		chooseNumberOfTables.add(btnMinusOutside);
		
		labelNumberOfTablesOutside = new JLabel("0");
		labelNumberOfTablesOutside.setForeground(Color.white);
		labelNumberOfTablesOutside.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumberOfTablesOutside.setHorizontalTextPosition(SwingConstants.CENTER);
		labelNumberOfTablesOutside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		labelNumberOfTablesOutside.setBounds(255, 412, 40, 20);
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
		btnPlusOutisde.setBounds(335, 398, 50, 50);
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
				if(numberOfTablesInside>0 || numberOfTablesOutside>0){
				chooseNumberOfTables.setVisible(false);
				createPlacesPanels(numberOfTablesInside, numberOfTablesOutside,btnInside,btnOutside);
			}
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
			
			Image orderOutside_bg=new ImageIcon("").getImage();//creo pannello per ordini interni 
			orderPanel=new JPanelwithBackgroundOrder(orderOutside_bg,frame);
			frame.getContentPane().add(orderPanel);
			Image inside_bg = new ImageIcon ("res/parquetBG.jpg").getImage();
			insidePanel = new JPanelwithBackgroundTables(inside_bg, insideTables, "inside",orderPanel);
			insidePanel.setLayout(null);
			frame.getContentPane().add(insidePanel);
			
			
			Image outside_bg = new ImageIcon ("res/outsideBG.jpg").getImage();
			outsidePanel = new JPanelwithBackgroundTables(outside_bg, outsideTables, "outside",orderPanel);
			frame.getContentPane().add(outsidePanel);
			setBackButtons();
		
	}
	
	private void setBackButtons(){
		
		insidePanel.setVisiblePanel(chooseInsideOutside,frame);
		outsidePanel.setVisiblePanel(chooseInsideOutside,frame);
	
	}
	
	
}
