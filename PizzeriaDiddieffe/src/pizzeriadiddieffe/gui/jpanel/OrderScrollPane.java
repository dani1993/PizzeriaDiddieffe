package pizzeriadiddieffe.gui.jpanel;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class OrderScrollPane extends JScrollPane implements ScrollPaneInterface{
	private JScrollPane scrollPane;

	@Override
	public void setCurrentJPanel(JPanel panel){
		scrollPane = new JScrollPane(panel);
	}

	@Override
	public void setParameters(int x, int y, int width, int height){
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setBounds(x, y, width, height);
	}

	@Override
	public void setColors(Color borderColor, Color bgColor){
		scrollPane.setBorder(new LineBorder(borderColor, 2));
		scrollPane.setBackground(bgColor);
		scrollPane.getViewport().setBackground(bgColor);
	}

	@Override
	public JScrollPane getScrollPane(){
		return scrollPane;
	}
}