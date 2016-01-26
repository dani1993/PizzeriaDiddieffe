package pizzeriadiddieffe.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.border.LineBorder;

import pizzeriadiddieffe.gui.creators.ComponentCreator;
import pizzeriadiddieffe.gui.jbutton.JButtonTextImage;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundOrder;
import pizzeriadiddieffe.gui.jpanel.jpanelwithbackground.JPanelWithBackgroundTables;

@SuppressWarnings("serial")
public class PizzeriaDiddieffeUI extends JPanel {
	private  int numberOfTablesInside = 0;
	private  int numberOfTablesOutside = 0;
	private final int maxNumberOfTablesInside = 12;
	private final int maxNumberOfTablesOutside = 8;

	private JButton btnMinusInside;
	private JButton btnMinusOutside;

	private JFrame frame;
	private PizzeriaDiddieffeUI chooseNumberOfTables;
	private JLabel labelNumberOfTablesOutside;

	private JPanel chooseInsideOutside;

	private JPanelWithBackgroundTables insidePanel;
	private JPanelWithBackgroundTables outsidePanel;

	private JPanelWithBackgroundOrder orderPanel;

	private JButton btnPlusOutisde;
	private JButton btnPlusInside;

	private Image img;

	private String labelFont = "Lucida Grande";
	private int labelFontSize = 18;
	private String buttonFont = "Lucida Grande";
	private int buttonFontSize = 18;
	private Color labelTextColor = Color.white;
	private Color buttonTextColor = Color.black;
	private URL imageURL;

	@SuppressWarnings("rawtypes")
	private ComponentCreator myComponentCreator = new ComponentCreator<>();

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

		imageURL = PizzeriaDiddieffeUI.class.getResource("mainBG.jpg");
		chooseNumberOfTables = new PizzeriaDiddieffeUI(new ImageIcon(imageURL).getImage());
		frame.getContentPane().add(chooseNumberOfTables, "name_1230783104452");
		chooseNumberOfTables.setLayout(null);

		@SuppressWarnings("unused")
		JLabel lblNumberOfTableInside = createFormattedLabel("Number of tables inside:", 155, 162, 240, 20);
		final JLabel labelNumberOfTablesInside=createFormattedLabel("0", 255, 226, 40, 20);

		btnMinusInside = createFormattedButton("-", 165, 212, 50, 50);
		btnMinusInside.setEnabled(false);
		btnMinusInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesInside--;
				labelNumberOfTablesInside.setText(String.valueOf(numberOfTablesInside));
				if (numberOfTablesInside==0) {
					btnMinusInside.setEnabled(false);
				}
				btnPlusInside.setEnabled(true);
			}
		});

		btnPlusInside = createFormattedButton("+", 335, 212, 50, 50);
		btnPlusInside.setEnabled(true);
		btnPlusInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesInside++;
				labelNumberOfTablesInside.setText(String.valueOf(numberOfTablesInside));
				if (numberOfTablesInside==maxNumberOfTablesInside) {
					btnPlusInside.setEnabled(false);
				}
				btnMinusInside.setEnabled(true);
			}
		});

		@SuppressWarnings("unused")
		JLabel lblNumberOfTableOutside = createFormattedLabel("Number of tables outside:", 155, 358, 240, 20);

		btnMinusOutside = createFormattedButton("-", 165, 398, 50, 50);
		btnMinusOutside.setEnabled(false);
		btnMinusOutside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesOutside--;
				labelNumberOfTablesOutside.setText(String.valueOf(numberOfTablesOutside));
				if (numberOfTablesOutside==0) {
					btnMinusOutside.setEnabled(false);
				}
				btnPlusOutisde.setEnabled(true);
			}
		});

		labelNumberOfTablesOutside = createFormattedLabel("0", 255, 412, 40, 20);

		btnPlusOutisde = createFormattedButton("+", 335, 398, 50, 50);
		btnPlusOutisde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfTablesOutside++;
				labelNumberOfTablesOutside.setText(String.valueOf(numberOfTablesOutside));
				if (numberOfTablesOutside==maxNumberOfTablesOutside) {
					btnPlusOutisde.setEnabled(false);
				}
				btnMinusOutside.setEnabled(true);
			}
		});

		chooseInsideOutside = new JPanel();// potrebbe essere una classe 
		frame.getContentPane().add(chooseInsideOutside, "name_1233757414457");
		chooseInsideOutside.setLayout(new GridLayout(2, 0, 0, 0));

		final JButtonTextImage btnInside = new JButtonTextImage(0, 0, 550, 375, 60, "Inside");
		btnInside.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseInsideOutside.setVisible(false);
				insidePanel.setVisible(true);
			}
		});
		chooseInsideOutside.add(btnInside);

		final JButtonTextImage btnOutside = new JButtonTextImage(0, 0, 550, 375, 60, "Outside");
		btnOutside.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnOutside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseInsideOutside.setVisible(false);
				outsidePanel.setVisible(true);
			}
		});
		chooseInsideOutside.add(btnOutside);

		JButton btnDone = createFormattedButton("Done", 175, 617, 200, 60);
		btnDone.setEnabled(true);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numberOfTablesInside>0 || numberOfTablesOutside>0){
					chooseNumberOfTables.setVisible(false);
					createPlacesPanels(numberOfTablesInside, numberOfTablesOutside, btnInside, btnOutside);
				}
			}
		});
	}

	private void createPlacesPanels(int insideTables, int outsideTables, JButton btnInside, JButton btnOutside){		
		if(insideTables<1){
			btnInside.setEnabled(false);
		}
		if(outsideTables<1){
			btnOutside.setEnabled(false);
		}
		chooseInsideOutside.setVisible(true);

		imageURL = PizzeriaDiddieffeUI.class.getResource("OrderManager.jpg");
		Image orderOutsideBg = new ImageIcon(imageURL).getImage();//creo pannello per ordini interni 
		orderPanel = new JPanelWithBackgroundOrder(orderOutsideBg, frame);
		frame.getContentPane().add(orderPanel);

		imageURL = PizzeriaDiddieffeUI.class.getResource("parquetBG.jpg");
		Image insideBg = new ImageIcon (imageURL).getImage();
		insidePanel = new JPanelWithBackgroundTables(insideBg, insideTables, "inside", orderPanel);
		insidePanel.setLayout(null);
		frame.getContentPane().add(insidePanel);

		imageURL = PizzeriaDiddieffeUI.class.getResource("outsideBG.jpg");
		Image outsideBg = new ImageIcon (imageURL).getImage();
		outsidePanel = new JPanelWithBackgroundTables(outsideBg, outsideTables, "outside", orderPanel);
		frame.getContentPane().add(outsidePanel);
		setBackButtons();
	}

	private void setBackButtons(){
		insidePanel.setVisiblePanel(chooseInsideOutside, frame);
		outsidePanel.setVisiblePanel(chooseInsideOutside, frame);
	}

	private JButton createFormattedButton(String text, int buttonX, int buttonY, int buttonWidth, int buttonHeight){
		myComponentCreator.createButton(text, buttonFont, buttonFontSize, buttonTextColor);
		myComponentCreator.setUpComponentProp(buttonX, buttonY, buttonWidth, buttonHeight);
		chooseNumberOfTables.add(myComponentCreator.getButton());
		return myComponentCreator.getButton();
	}

	private JLabel createFormattedLabel(String text, int labelX, int labelY, int labelWidth, int labelHeight){
		myComponentCreator.createLabel(text, labelFont, labelFontSize, labelTextColor);
		myComponentCreator.setUpComponentProp(labelX, labelY, labelWidth, labelHeight);
		chooseNumberOfTables.add(myComponentCreator.getLabel());
		return myComponentCreator.getLabel();
	}
}