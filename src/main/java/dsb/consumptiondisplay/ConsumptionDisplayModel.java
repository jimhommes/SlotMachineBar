package dsb.consumptiondisplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ConsumptionDisplayModel {

	private ConsumptionDisplaySQLConnector connector;

	public ArrayList<Consumer> consumers;

	public ConsumptionDisplayModel(ConsumptionDisplaySQLConnector connector) {
		consumers = new ArrayList<Consumer>();
		this.connector = connector; 

		consumers.add(new Consumer("Bestuur", 863, 874, this));
		consumers.add(new Consumer("Dies 117", 260, 676,this));
		consumers.add(new Consumer("Octopus", 243, 1452,this));
		consumers.add(new Consumer("Kurk", 242, 1153,this));
		consumers.add(new Consumer("QUAST", 244, 1123,this));
		consumers.add(new Consumer("Schranz", 245, 809,this));
		consumers.add(new Consumer("Spetter", 246, 1085,this));
		consumers.add(new Consumer("Asene", 240, 1066,this));
		consumers.add(new Consumer("Apollo", 239, 874,this));
		consumers.add(new Consumer("Chaos", 278, 1017,this));
		consumers.add(new Consumer("Krat", 327, 1218,this));
		consumers.add(new Consumer("McClan", 494, 1466,this));
		consumers.add(new Consumer("Kielzog", 558, 1508,this));
		consumers.add(new Consumer("Nobel", 621, 1224,this));
		consumers.add(new Consumer("UMTC", 787, 217,this));
	}

	public int getTotalAmountOfConsumers() {
		return consumers.size();
	}
	
	public ConsumptionDisplaySQLConnector getConnector(){
		return this.connector;
	}

	public Consumer getConsumer(int i) {
		return consumers.get(i);
	}
	
	public Consumer getConsumerByName(String string){
		for (int i = 0; i < consumers.size(); i++) {
			if(consumers.get(i).getName() == string)
			{
				return consumers.get(i);
			}
		}
		return(null);
	}

	public void updateConsumer(int indexOfConsumer) {
		Consumer consumer = consumers.get(indexOfConsumer);
		Submarine sub = consumer.getSubmarine();
		//double amountOfLiters = connector.getAmountOfLitersOfConsumer(consumer.getId());
		double amountOfLitersLast30Minutes = connector.getAmountOfLitersOfConsumerLastXMininutes(consumer.getId(), 30);
		
		sub.setSnelheid(amountOfLitersLast30Minutes);
		BestellingMetNaam Event = connector.getRecentOrderMetNaam(consumer.getId());
		//BestellingMetNaam Event = new BestellingMetNaam("Spetter", 1000, 200, 5);
		
		consumer.getEventHandler().HandleEvents(Event);
		
		consumer.setAmountConsumed(amountOfLitersLast30Minutes); /*was amount of litters*/
	}
	
	public void fastupdateConsumer(int indexOfConsumer) {
		Consumer consumer = consumers.get(indexOfConsumer);
		Submarine sub = consumer.getSubmarine();
		sub.updateDistance();
	}

	public void orderByConsumption() {
		Comparator<Consumer> comperator = Collections.reverseOrder();
		Collections.sort(consumers, comperator);
	}
}
