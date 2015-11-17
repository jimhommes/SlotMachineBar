package dsb.consumptiondisplay;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
	private List<BestellingMetNaam> eventList = new ArrayList<BestellingMetNaam>();
	private int eventHanderID;
	private Submarine submarine;
	private ConsumptionDisplayModel model;
	
	public EventHandler(int ConsumerID, ConsumptionDisplayModel m, double distance){
		eventHanderID = ConsumerID;
		eventList.add(new BestellingMetNaam("Start Borrel",0,0,0));
		this.submarine = new Submarine();
		this.getSubmarine().setDistance(distance);
		model = m;
	}
	
	public int getEventHandlerID (){
		return this.eventHanderID;
	}
	
	public void HandleEvents(BestellingMetNaam newEvent){
		if(newEvent != null)
		{
			if(newEvent.getBestellingID() != eventList.get(eventList.size() - 1).getBestellingID() ){
				HandleNewEvent(newEvent);
			}

		}
	}
	
	public Submarine getSubmarine(){
		return this.submarine;
	}
	
	private int SearchConsumption(int consumption_ID){
		int amountConsumed = 0;
		for (int i = 0; i < eventList.size(); i++) {
			BestellingMetNaam Bestelling = eventList.get(i);
			amountConsumed += Bestelling.getConsumptieAmount(consumption_ID);
		}	
		return amountConsumed;
	}

	private void HandleNewEvent(BestellingMetNaam Event){
		eventList.add(Event);
		System.out.println(this.eventHanderID + "\t" + Event.getmetNaam() + "\t@index "  + eventList.size() + "\t\t");
		
		String happening = Event.getmetNaam().toUpperCase().replaceAll("\\s","");

		if (happening.equals("OCTO") || happening.equals("OCTOPUS") || happening.equals("HICOCTOPUS")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Octopus").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("KURK") || happening.equals("SMN") || happening.equals("SMNKURK")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Kurk").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("QUAST")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("QUAST").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("SCHRANZ")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Schranz").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("SPETTER")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Spetter").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("ASENE")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Asene").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("APOLLO")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Apollo").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("CHAOS")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Chaos").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("KRAT")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Krat").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("MCCLAN")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("McClan").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("KIELZOG")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Kielzog").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("NOBEL")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Nobel").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("DIES") || happening.equals("117")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Dies 117").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("BESTUUR") || happening.equals("118")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("Bestuur").getEventHandler().getSubmarine().SubHit();
			}

		} else if (happening.equals("UMTC")) {
			if (this.getSubmarine().FireTorpedo()) {
				model.getConsumerByName("UMTC").getEventHandler().getSubmarine().SubHit();
			}


		}
		
		//System.out.println("Totaal Bier = " + SearchConsumption(6829) + "\t\t Totaal Fris = " + SearchConsumption(6853));
		
		if(model.getConnector().getBlueMountain(this.eventHanderID, 180) > 0){{
				this.getSubmarine().setBlueMountain();
			}
		}
		
		if( SearchConsumption(7075) > 0){
			this.getSubmarine().setRouteSmirnoffIce();
		}
		
		
		if(model.getConnector().getKetel1(this.eventHanderID, 180) > 4){
			this.getSubmarine().setRouteKetel5();
		}
		
		if(model.getConnector().getKetel1(this.eventHanderID, 180) > 4){
			this.getSubmarine().setRouteKetel5();
		}
		
		this.getSubmarine().setCodeRoodSpeed(model.getConnector().getCodeRood(this.eventHanderID, 30));
	}
}
