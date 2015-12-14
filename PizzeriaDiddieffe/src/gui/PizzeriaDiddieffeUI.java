package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.CardLayout;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;


public class PizzeriaDiddieffeUI {
	
	private int numberOfTablesInside = 0;
	private int numberOfTablesOutside = 0;
	
	private JButton btnMinusInside;
	private JButton btnMinusOutside;
	
	private JFrame frame;
	private JLabel labelNumberOfTablesOutside;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel chooseNumberOfTables = new JPanel();
		chooseNumberOfTables.setBackground(new Color(139, 69, 19));
		frame.getContentPane().add(chooseNumberOfTables, "name_1230783104452");
		chooseNumberOfTables.setLayout(null);
		
		JLabel lblNumberOfTables = new JLabel("Number of tables inside:");
		lblNumberOfTables.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfTables.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNumberOfTables.setBounds(155, 112, 240, 20);
		lblNumberOfTables.setHorizontalTextPosition(SwingConstants.CENTER);
		chooseNumberOfTables.add(lblNumberOfTables);
		
		JLabel labelNumberOfTablesInside = new JLabel("0");
		labelNumberOfTablesInside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		labelNumberOfTablesInside.setBounds(255, 166, 40, 20);
		labelNumberOfTablesInside.setHorizontalAlignment(SwingConstants.CENTER);
		labelNumberOfTablesInside.setHorizontalTextPosition(SwingConstants.CENTER);
		chooseNumberOfTables.add(labelNumberOfTablesInside);
		
		btnMinusInside = new JButton("-");
		btnMinusInside.setEnabled(false);
		btnMinusInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesInside--;
				labelNumberOfTablesInside.setText(String.valueOf(numberOfTablesInside));
				if (numberOfTablesInside == 0) {
					btnMinusInside.setEnabled(false);
				}
			}
		});
		btnMinusInside.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnMinusInside.setBounds(165, 152, 50, 50);
		chooseNumberOfTables.add(btnMinusInside);
		
		
		
		JButton btnPlusInside = new JButton("+");
		btnPlusInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesInside++;
				labelNumberOfTablesInside.setText(String.valueOf(numberOfTablesInside));
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
		
		JButton btnMinusOutside = new JButton("-");
		btnMinusOutside.setEnabled(false);
		btnMinusOutside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesOutside--;
				labelNumberOfTablesOutside.setText(String.valueOf(numberOfTablesOutside));
				if (numberOfTablesOutside == 0) {
					btnMinusOutside.setEnabled(false);
				}			}
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
		
		JButton btnPlusOutisde = new JButton("+");
		btnPlusOutisde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesOutside++;
				labelNumberOfTablesOutside.setText(String.valueOf(numberOfTablesOutside));
				btnMinusOutside.setEnabled(true);
			}
		});
		btnPlusOutisde.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnPlusOutisde.setBounds(335, 338, 50, 50);
		chooseNumberOfTables.add(btnPlusOutisde);
		
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnDone.setBounds(170, 617, 200, 60);
		chooseNumberOfTables.add(btnDone);
		
		JPanel chooseInsideOutside = new JPanel();
		frame.getContentPane().add(chooseInsideOutside, "name_1233757414457");
		chooseInsideOutside.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton btnInside = new JButton("Inside");
		chooseInsideOutside.add(btnInside);
		
		JButton btnOutside = new JButton("Outside");
		chooseInsideOutside.add(btnOutside);
		
		JPanel inside = new JPanel();
		frame.getContentPane().add(inside, "name_6455395976526");
		
		JPanel outside = new JPanel();
		frame.getContentPane().add(outside, "name_6466496075840");
		
		
		
		
		
		
	}
}
