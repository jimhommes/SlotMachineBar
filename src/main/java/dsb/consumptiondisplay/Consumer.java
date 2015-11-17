package dsb.consumptiondisplay;

import java.text.DecimalFormat;

public class Consumer implements Comparable<Consumer> {

	private static DecimalFormat df = new DecimalFormat("#.#");

	private String name;
	private int id;
	private Double amountConsumed;
	private EventHandler eventHandeler;

	public Consumer(String name, int id, double amountConsumed,ConsumptionDisplayModel model) {
		this.name = name;
		this.id = id;
		this.amountConsumed = amountConsumed;
		this.eventHandeler = new EventHandler(id, model, this.amountConsumed);
	}
	
	public Submarine getSubmarine(){
		return this.eventHandeler.getSubmarine();
	}
	
	public EventHandler getEventHandler(){
		return this.eventHandeler;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmountConsumed() {
		return amountConsumed;
	}

	public void setAmountConsumed(double amountConsumed) {
		this.amountConsumed = amountConsumed;
	}

	@Override
	public String toString() {
		Submarine submarine = this.getSubmarine();
		if (amountConsumed < 1000)
		{
			return name + ": " + df.format(submarine.getDistance()) + " m";
		}
		else return name + ": " + df.format(submarine.getDistance()/1000) + " Km";
	}

	public int compareTo(Consumer o) {
		double other = o.getAmountConsumed();
		if (amountConsumed > other)
			return 1;
		if (amountConsumed == other)
			return 0;
		return -1;
	}
}
