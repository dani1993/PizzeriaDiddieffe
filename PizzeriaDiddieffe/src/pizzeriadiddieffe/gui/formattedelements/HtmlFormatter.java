package pizzeriadiddieffe.gui.formattedelements;

public class HtmlFormatter {
	private String bullet = "&#8226;&nbsp;";
	private String comma = ",";
	private String tabSpace = "</i> <br> <i> &nbsp;&nbsp;&nbsp;";
	private String endItalic = " </i> ";
	private String newLine = " <br> ";
	private String startBold = " <b> ";
	private String endBold = " </b> ";
	private String price = "&nbsp;&nbsp;Price: ";
	
	public String getBullet() {
		return bullet;
	}
	
	public void setBullet(String bullet) {
		this.bullet = bullet;
	}
	
	public String getComma() {
		return comma;
	}
	
	public void setComma(String comma) {
		this.comma = comma;
	}
	
	public String getTabSpace() {
		return tabSpace;
	}
	
	public void setTabSpace(String tabSpace) {
		this.tabSpace = tabSpace;
	}
	
	public String getEndItalic() {
		return endItalic;
	}
	
	public void setEndItalic(String endItalic) {
		this.endItalic = endItalic;
	}
	
	public String getNewLine() {
		return newLine;
	}
	
	public void setNewLine(String newLine) {
		this.newLine = newLine;
	}
	
	public String getStartBold() {
		return startBold;
	}
	
	public void setStartBold(String startBold) {
		this.startBold = startBold;
	}
	
	public String getEndBold() {
		return endBold;
	}
	
	public void setEndBold(String endBold) {
		this.endBold = endBold;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
}