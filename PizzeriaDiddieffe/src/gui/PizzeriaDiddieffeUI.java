package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class PizzeriaDiddieffeUI {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(0, 0));
		mainPanel.setMinimumSize(new Dimension(0, 0));
		mainPanel.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		JPanel chooseNumberOfTables = new JPanel();
		chooseNumberOfTables.setVisible(false);
		chooseNumberOfTables.setAlignmentY(Component.TOP_ALIGNMENT);
		chooseNumberOfTables.setAlignmentX(Component.LEFT_ALIGNMENT);
		chooseNumberOfTables.setPreferredSize(new Dimension(550, 750));
		chooseNumberOfTables.setMinimumSize(new Dimension(550, 750));
		mainPanel.add(chooseNumberOfTables);
		chooseNumberOfTables.setBackground(new Color(160, 82, 45));
		chooseNumberOfTables.setLayout(null);
		
		JLabel labelOutsideNumberOfTables = new JLabel("Number of tables outside:");
		labelOutsideNumberOfTables.setBounds(173, 102, 180, 16);
		labelOutsideNumberOfTables.setHorizontalAlignment(SwingConstants.CENTER);
		chooseNumberOfTables.add(labelOutsideNumberOfTables);
		
		JLabel labelOutSideNumber = new JLabel("0");
		labelOutSideNumber.setHorizontalAlignment(SwingConstants.CENTER);
		labelOutSideNumber.setBounds(242, 144, 61, 16);
		chooseNumberOfTables.add(labelOutSideNumber);
		
		JButton buttonMinusOutside = new JButton("-");
		buttonMinusOutside.setBounds(132, 139, 117, 29);
		chooseNumberOfTables.add(buttonMinusOutside);
		
		JButton buttonPlusOutside = new JButton("+");
		buttonPlusOutside.setBounds(299, 139, 117, 29);
		chooseNumberOfTables.add(buttonPlusOutside);
		
		JLabel labelInsideNumberOfTables = new JLabel("Number of tables inside:");
		labelInsideNumberOfTables.setBounds(173, 228, 180, 16);
		chooseNumberOfTables.add(labelInsideNumberOfTables);
		
		JLabel labelInsideNumber = new JLabel("0");
		labelInsideNumber.setHorizontalAlignment(SwingConstants.CENTER);
		labelInsideNumber.setBounds(242, 269, 61, 16);
		chooseNumberOfTables.add(labelInsideNumber);
		
		JButton buttonMinusInside = new JButton("-");
		buttonMinusInside.setBounds(112, 264, 117, 29);
		chooseNumberOfTables.add(buttonMinusInside);
		
		JButton buttonPlusInside = new JButton("+");
		buttonPlusInside.setBounds(299, 264, 117, 29);
		chooseNumberOfTables.add(buttonPlusInside);
		
		JButton buttonDone = new JButton("Done");
		buttonDone.setBounds(212, 614, 117, 29);
		chooseNumberOfTables.add(buttonDone);
		
		JPanel chooseInsideOutside = new JPanel();
		chooseInsideOutside.setPreferredSize(new Dimension(550, 750));
		chooseInsideOutside.setBackground(new Color(0, 0, 205));
		mainPanel.add(chooseInsideOutside);
		chooseInsideOutside.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 61, 16);
		chooseInsideOutside.add(lblNewLabel);
	}
}
