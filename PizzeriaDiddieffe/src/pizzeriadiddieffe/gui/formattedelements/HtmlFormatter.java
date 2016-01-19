package pizzeriadiddieffe.gui.formattedelements;

public class HtmlFormatter implements HtmlFormatterInterface{
	private String bullet = "&#8226;&nbsp;";
	private String comma = ",";
	private String tabSpace = "</i> <br> <i> &nbsp;&nbsp;&nbsp;";
	private String endItalic = " </i> ";
	private String newLine = " <br> ";
	private String startBold = " <b> ";
	private String endBold = " </b> ";
	private String price = "&nbsp;&nbsp;Price: ";
	private String highligh = "<span style=\"background-color: #FFFF00\">";
	private String endhighligh = "</span>";

	@Override
	public String getBullet() {
		return bullet;
	}

	@Override
	public String getComma() {
		return comma;
	}

	@Override
	public String getTabSpace() {
		return tabSpace;
	}

	@Override
	public String getEndItalic() {
		return endItalic;
	}

	@Override
	public String getNewLine() {
		return newLine;
	}

	@Override
	public String getStartBold() {
		return startBold;
	}

	@Override
	public String getEndBold() {
		return endBold;
	}

	@Override
	public String getPrice() {
		return price;
	}

	@Override
	public String getHighligh() {
		return highligh;
	}

	@Override
	public String getEndhighligh() {
		return endhighligh;
	}
}