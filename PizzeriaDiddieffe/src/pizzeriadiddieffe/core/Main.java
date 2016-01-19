package pizzeriadiddieffe.core;

import pizzeriadiddieffe.gui.PizzeriaDiddieffeUI;

public class Main {
	public static void main(String[] args){
		run();
	}

	@SuppressWarnings("static-access")
	private static void run(){
		PizzeriaDiddieffeUI gui = new PizzeriaDiddieffeUI();
		gui.main(null);
	}
}