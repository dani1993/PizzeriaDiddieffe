package gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

class JPanelWithBackgroundImg extends JPanel {
	
	private Image img;
	private JButton btnBackToInOutScreen;
	private JPanel visible_panel;//pannello visibile
	
	private JPanel other_panel1; //pannelli invisibili
	private JPanel other_panel2;
	
	
	
	public JPanelWithBackgroundImg(String img) {
		this(new ImageIcon(img).getImage());
	}
	public JPanelWithBackgroundImg(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		
		//BACK BUTTON 
		btnBackToInOutScreen = new JButton ("Back");
		btnBackToInOutScreen.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnBackToInOutScreen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBackToInOutScreen.setBounds(10, 10, 100, 50);
		this.add(btnBackToInOutScreen);

		btnBackToInOutScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				visible_panel.setVisible(true);
				other_panel1.setVisible(false);		//setto le rispettive visibilita
				other_panel2.setVisible(false);
			}
		});
	}
	
	 //uso il metodo per settare, a seconda del pannello, se dovra essere visibile o meno
	public void setVisiblePanel(JPanel visible_panel,JPanel other_panel1,JPanel other_panel2){
		this.visible_panel=visible_panel;  
		this.other_panel1=other_panel1;
		this.other_panel2=other_panel2;
		
	}
	
	
	
	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        g.drawImage(img, 0, 0, null);
	}
	
	
	
}
