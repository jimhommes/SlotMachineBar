package dsb.consumptiondisplay;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
	private List<BestellingMetNaam> eventList = new ArrayList<BestellingMetNaam>();
	private int eventHanderID;
	private ConsumptionDisplayModel model;
	
	public EventHandler(int ConsumerID, ConsumptionDisplayModel m){
		eventHanderID = ConsumerID;
		eventList.add(new BestellingMetNaam("Start Borrel",0,0,0));
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


		} else if (happening.equals("KURK") || happening.equals("SMN") || happening.equals("SMNKURK")) {


		} else if (happening.equals("QUAST")) {


		} else if (happening.equals("SCHRANZ")) {


		} else if (happening.equals("SPETTER")) {


		} else if (happening.equals("ASENE")) {


		} else if (happening.equals("APOLLO")) {


		} else if (happening.equals("CHAOS")) {


		} else if (happening.equals("KRAT")) {


		} else if (happening.equals("MCCLAN")) {


		} else if (happening.equals("KIELZOG")) {


		} else if (happening.equals("NOBEL")) {


		} else if (happening.equals("DIES") || happening.equals("117")) {


		} else if (happening.equals("BESTUUR") || happening.equals("118")) {


		} else if (happening.equals("UMTC")) {


		}
	}
}
