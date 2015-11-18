package dsb.consumptiondisplay;

public class Main {

	public static DisplayRttN display;
	
	public static void main(String[] args) {
		display = new DisplayRttN(null);
//		ConsumptionDisplaySQLConnector connector = new ConsumptionDisplaySQLConnector("2014-11-12", "2014-11-13", "2014-11-14","2014-11-15");
//		ConsumptionDisplayModel model = new ConsumptionDisplayModel(connector);
//		ConsumptionDisplayView view = new ConsumptionDisplayView(model);
//		ConsumptionDisplayController controller = new ConsumptionDisplayController(view, model);

		
//		Thread thread = new Thread(controller);
//		thread.run();
	}
	
	public static DisplayRttN getDisplay() {
		return display;
	}
}
