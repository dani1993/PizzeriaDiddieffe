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
	private PizzeriaDiddieffeUI chooseNumberOfTables;
	private JLabel labelNumberOfTablesOutside;
	
	private JPanel chooseInsideOutside;
	
	private JPanelwithBackgroundTables insidePanel;
	private JPanelwithBackgroundTables outsidePanel;
	
	private JPanelwithBackgroundOrder orderPanel;
	
	private JButton btnPlusOutisde;
	private JButton btnPlusInside;
	
	private Image img;
	private FormattedLabel myLabelSetter=new FormattedLabel();
	private String currentFont="Lucida Grande";
	private int fontSize=18;
	private Color labelTextColor=Color.white;
	private Color buttonTextColor=Color.black;
	
	private SignFormattedButton myButtonSetter=new SignFormattedButton();

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
		
		chooseNumberOfTables = new PizzeriaDiddieffeUI("res/mainBG.jpg");
//		chooseNumberOfTables.setBackground(new Color(139, 69, 19));
		frame.getContentPane().add(chooseNumberOfTables, "name_1230783104452");
		chooseNumberOfTables.setLayout(null);
	
		JLabel lblNumberOfTableInside=createLabel(155, 162, 240, 20,"Number of tables inside:");
		final JLabel labelNumberOfTablesInside=createLabel(255, 226, 40, 20,"0");
	
		btnMinusInside=createButtons(165, 212, 50, 50,"-",false);
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
		
	
		btnPlusInside=createButtons(335, 212, 50, 50,"+",true);
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
		
		
		JLabel lblNumberOfTableOutside=createLabel(155, 358, 240, 20,"Number of tables outside:");
		
		btnMinusOutside=createButtons(165, 398, 50, 50,"-",false);
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
		
		
		
		labelNumberOfTablesOutside=createLabel(255, 412, 40, 20,"0");
		
		btnPlusOutisde=createButtons(335, 398, 50, 50,"+",true);
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
		
	
		
		chooseInsideOutside = new JPanel();// potrebbe essere una classe 
		frame.getContentPane().add(chooseInsideOutside, "name_1233757414457");
		chooseInsideOutside.setLayout(new GridLayout(2, 0, 0, 0));
		
	
		final OrderItemJButton btnInside = new OrderItemJButton(0,0,550,375,60,"Inside");
		btnInside.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnInside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseInsideOutside.setVisible(false);
				insidePanel.setVisible(true);
			}
		});
		chooseInsideOutside.add(btnInside);
		
		
		
		final OrderItemJButton btnOutside = new OrderItemJButton(0,0,550,375,60,"Outside");
		btnOutside.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnOutside.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseInsideOutside.setVisible(false);
				outsidePanel.setVisible(true);
			}
		});
		chooseInsideOutside.add(btnOutside);
		
		
		JButton btnDone=createButtons(175, 617, 200, 60,"Done",true);
		btnDone.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(numberOfTablesInside>0 || numberOfTablesOutside>0){
			chooseNumberOfTables.setVisible(false);
			createPlacesPanels(numberOfTablesInside, numberOfTablesOutside,btnInside,btnOutside);
		}
			}
	});
		
		
		
	}

	
	private JButton createButtons(int x, int y,int width,int height,String text,boolean enable) {
		myButtonSetter.createNewComponent();
		myButtonSetter.setComponentTextProp(text, currentFont, fontSize, buttonTextColor);
		myButtonSetter.setComponentProp(x, y, width, height);
		myButtonSetter.setButtonEnabled(enable);
		JButton button = myButtonSetter.getFormattedComponent();
		chooseNumberOfTables.add(button);
		return button;
	}

	
	private JLabel createLabel(int x, int y,int width,int height,String text) {
		myLabelSetter.createNewComponent();
		myLabelSetter.setComponentTextProp(text, currentFont, fontSize,labelTextColor);
		myLabelSetter.setComponentProp(x, y, width, height);
		JLabel label = myLabelSetter.getFormattedComponent();
		chooseNumberOfTables.add(label);
		return label;
	}
	
	
	private void createPlacesPanels(int insideTables,int outsideTables,JButton btn_inside,JButton btn_outside){
		
		if(insideTables<1){
			btn_inside.setEnabled(false);
		}
		if(outsideTables<1){
			btn_outside.setEnabled(false);
		}
			chooseInsideOutside.setVisible(true);
			
			Image orderOutside_bg=new ImageIcon("res/OrderManager.jpg").getImage();//creo pannello per ordini interni 
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
