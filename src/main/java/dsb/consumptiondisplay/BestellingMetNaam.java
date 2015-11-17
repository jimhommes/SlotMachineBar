package dsb.consumptiondisplay;

import java.util.ArrayList;
import java.util.List;

public class BestellingMetNaam {
	private String metNaam;
	private List<Integer> consumptionList = new ArrayList<Integer>();
	private int BestellingID;
	private List<Integer> AmountList = new ArrayList<Integer>();
	
	BestellingMetNaam(String naam, int ID, int ConsumptieID, int Amount){
		this.metNaam = naam;
		this.BestellingID = ID;
		this.consumptionList.add(ConsumptieID);
		this.AmountList.add(Amount);
	}
	
	void addOtherConsumption(int ConsumptieID, int Amount){
		this.consumptionList.add(ConsumptieID);
		this.AmountList.add(Amount);
	}
	
	int getConsumptieAmount(int ID){
		int amount = 0;
		
		for (int i = 0; i < consumptionList.size(); i++){
			if(ID == consumptionList.get(i)){
				amount = amount + AmountList.get(i);
			}
		}
		
		return amount;
	}
	
	public int getBestellingID (){
		return this.BestellingID;
	}
	
	public String getmetNaam(){
		return this.metNaam;
	}
}
