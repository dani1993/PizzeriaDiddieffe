package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.CardLayout;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;


public class PizzeriaDiddieffeUI {
	
	private int numberOfTablesInside = 0;
	private int numberOfTablesOutside = 0;
	
	private JButton btnMinusInside;
	private JButton btnMinusOutside;
	
	private JFrame frame;
	private JLabel labelNumberOfTablesOutside;
	
	private JPanel chooseInsideOutside;
	
	private Inside insidePanel;
	private Inside outsidePanel;

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
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseNumberOfTables.setVisible(false);
				chooseInsideOutside.setVisible(true);
			}
		});
		btnDone.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnDone.setBounds(170, 617, 200, 60);
		chooseNumberOfTables.add(btnDone);
		
		chooseInsideOutside = new JPanel();
		frame.getContentPane().add(chooseInsideOutside, "name_1233757414457");
		chooseInsideOutside.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton btnInside = new JButton("Inside");
		btnInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseInsideOutside.setVisible(false);
				insidePanel.setVisible(true);
			}
		});
		chooseInsideOutside.add(btnInside);
		
		JButton btnOutside = new JButton("Outside");
		chooseInsideOutside.add(btnOutside);
		btnOutside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseInsideOutside.setVisible(false);
				outsidePanel.setVisible(true);
			}
		});
		
		
		Image inside_bg = new ImageIcon ("res/parquetBG.jpg").getImage();
		insidePanel = new Inside(inside_bg);
		frame.getContentPane().add(insidePanel);

		Image outside_bg = new ImageIcon ("res/outsideBG.jpg").getImage();
		outsidePanel = new Inside(outside_bg);
		frame.getContentPane().add(outsidePanel);
	}
	class Inside extends JPanel {
		private Image img;
		public Inside(String img) {
			this(new ImageIcon(img).getImage());
		}
		public Inside(Image img) {
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
		        g.drawImage(img, 0, 0, null);
		}
		
		
		
	}
}
