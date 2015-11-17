package dsb.consumptiondisplay;



public class ConsumptionDisplayController implements Runnable {

	ConsumptionDisplayModel model;
	ConsumptionDisplayView view;
	int size;

	public ConsumptionDisplayController(ConsumptionDisplayView view, ConsumptionDisplayModel model) {
		this.view = view;
		this.model = model;

		model.getTotalAmountOfConsumers();
		size = model.getTotalAmountOfConsumers();
	}

	
	public void run() {
		//long prev = 0;
		int n = 0;
		
		while (true) {
			switch(n){
			case 14:
				n = 0;
				break;
			default:
				view.updateConsumer(n);
				for (int i = 0; i < size; i++) {
					view.fastUpdateConsumer(i);
				}
				Main.getDisplay().refresh();
				
				n++;
				break;
			}
			
			view.orderByConsumption();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
}
