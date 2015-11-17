package dsb.consumptiondisplay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class ConsumptionDisplaySQLConnector {
	
	/**
	 * List for all dates to be taken in to account for the consumption.
	 */
	private final String[] DATES;
	private static final int BIER = 6829;
	private static final int PUL_BIER = 6827;
	private static final int PUL_BIER_KORTING = 6822;
	private static final int PITCHER = 6902;

	
	private Connection connection;

	public ConsumptionDisplaySQLConnector(String date1, String date2, String date3, String date4) {
		this.DATES = new String[4];
		this.DATES[0] = date1;
		this.DATES[1] = date2;
		this.DATES[2] = date3;
		this.DATES[3] = date4;
		

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://192.168.1.1:3306/barkas_1_0_prod", "barkasread", "lezen");
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public double getAmountOfLitersOfConsumer(int consumerid) {
		int bier = getAmountOfConsumption(consumerid, BIER);
		int pulbier = getAmountOfConsumption(consumerid, PUL_BIER);
		int pulbiermetkorting = getAmountOfConsumption(consumerid, PUL_BIER_KORTING);
		int pitcher = getAmountOfConsumption(consumerid, PITCHER);
		
		return (bier * 0.2) + (pulbier * 0.5) + (pulbiermetkorting * 0.5) + pitcher * 1.7;
	}
	
	public int getBlueMountain(int consumerid, int minutes){
		int bols = getConsumptionLastMinits(consumerid, 6871, minutes);
		int razz = getConsumptionLastMinits(consumerid, 7149, minutes);
		
		if( bols > razz ){
			return bols;
		}
		else{
			return razz;
		}
	}
	
	public int getCodeRood(int consumerid, int minutes){
		int Coolbergh = getConsumptionLastMinits(consumerid, 6840, minutes);
		int Bacardi = getConsumptionLastMinits(consumerid, 6908, minutes);
		return (Coolbergh+Bacardi);
	}
	
	
	public int getKetel1(int consumerid, int minutes){
		return getConsumptionLastMinits(consumerid, 6860, minutes);
	}
	
	
	public double getAmountOfLitersOfConsumerLastXMininutes(int consumerid, int minutes){
		int bier = getConsumptionLastMinits(consumerid, BIER, minutes);
		int pulbier = getConsumptionLastMinits(consumerid, PUL_BIER, minutes);
		int pulbiermetkorting = getConsumptionLastMinits(consumerid, PUL_BIER_KORTING, minutes);
		int pitcher = getConsumptionLastMinits(consumerid, PITCHER, minutes);
		
		return (bier * 0.2) + (pulbier * 0.5) + (pulbiermetkorting * 0.5) + pitcher * 1.7;
	}
	
	public BestellingMetNaam getRecentOrderMetNaam(int consumerid){
		String query = "SELECT * FROM Bestelling WHERE Bestelling_ID = (SELECT Bestelling_ID FROM Bestelling WHERE Bestelling_OpNaam IS NOT null AND Bestelling_Bon IN (SELECT Bon_ID FROM Bon WHERE Bon_Debiteur = '" + consumerid + "') ORDER BY Bestelling_Time DESC LIMIT 1)";
		ResultSet resultset = null;
		try {
			Statement statement = (Statement) connection.createStatement();
			resultset = (ResultSet) statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (resultset.next()) {
				String result = resultset.getString(11);
				int bonID = Integer.valueOf(resultset.getString(1));	
				int amount = Integer.valueOf(resultset.getString(4));
				int product = Integer.valueOf(resultset.getString(3));
				BestellingMetNaam Order = new BestellingMetNaam(result,bonID,product,amount);
				
				while (resultset.next()){
					Order.addOtherConsumption(Integer.valueOf(resultset.getString(3)), Integer.valueOf(resultset.getString(4)));
				}
				
				if (result != null)
					return Order;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return(null);
	}
	
	@SuppressWarnings("deprecation")
	private int getConsumptionLastMinits(int consumerid, int consumptiontype, int minutes) {
		Date d = new Date();
		
		d.setYear(114);
		d.setMonth(9);
		
		Date dOld = new Date(d.getTime() - (1000 * minutes * 60));
	    	
		String query = "SELECT SUM(Bestelling_AantalS)" + "FROM Bestelling WHERE Bestelling_Bon IN (SELECT Bon_ID FROM Bon WHERE Bon_datum = '" + DATES[0] + "' AND Bon_Time > '"+ dOld.getTime() +"' AND Bon_Debiteur = " + consumerid + ") AND Bestelling_Wat =" + consumptiontype;
	    ResultSet resultset = null;
		try {
			Statement statement = (Statement) connection.createStatement();
			resultset = (ResultSet) statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (resultset.next()) {
				String result = resultset.getString(1);
				if (result != null){
					return Integer.valueOf(resultset.getString(1));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	private int getAmountOfConsumption(int consumerid, int consumptiontype) {
		String query = "SELECT SUM(Bestelling_AantalS)" + "FROM Bestelling WHERE Bestelling_Bon IN (SELECT Bon_ID FROM Bon WHERE (Bon_datum = '" + DATES[0] + "' OR Bon_datum = '" +  DATES[1] + "' OR Bon_datum = '" +  DATES[2] + "' OR Bon_datum = '" + DATES[3] + "') AND Bon_Debiteur = " + consumerid + ") AND Bestelling_Wat =" + consumptiontype;
		ResultSet resultset = null;
		Statement statement = null;
		try {
			statement = (Statement) connection.createStatement();
			resultset = (ResultSet) statement.executeQuery(query);
			
			query = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (resultset.next()) {
				String result = resultset.getString(1);
				if (result != null)
				{
					return Integer.valueOf(resultset.getString(1));
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
