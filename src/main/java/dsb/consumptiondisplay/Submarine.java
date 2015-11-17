package dsb.consumptiondisplay;


public class Submarine {
	private boolean routeKetel5;
	private boolean routeSmirnoffIce;
	private boolean routeBlueMountain;
	private boolean CODE_ROOD;
	
	private double snelheid;
	private double distance;
	private int torpedos;
	private boolean subBroken;
	private int disabledTimer;
	private int specialEffectTimer;
	private static double speedModefier;
	
	private int codeRoodSpeed;
	
	private int mostRecentTopedo;
	
	Submarine(){
		this.routeKetel5 = false;
		this.routeSmirnoffIce = false;
		this.routeBlueMountain = true;
		this.CODE_ROOD = true;
		this.snelheid = 0;
		this.distance = 0.7;
		this.torpedos = 1;
		this.subBroken = false;
		this.disabledTimer = 0;
		this.specialEffectTimer = 0;
		Submarine.speedModefier = 1;
		this.codeRoodSpeed = 0;
		this.mostRecentTopedo = 0;
	}
	
	public void setCodeRoodSpeed(int amount){
		this.codeRoodSpeed = amount;
	}
	
	public void setRouteKetel5(){
		System.out.println("Iemand selecteerd nu Ketel 5");
		this.routeKetel5 = true;
	}
	
	public void setRouteSmirnoffIce(){
		System.out.println("Iemand selecteerd nu Smirnoff Ice");
		this.routeSmirnoffIce = true;
	}
	
	public void setBlueMountain(){
		System.out.println("Iemand selecteerd nu Blue Mountain");
		this.routeBlueMountain = true;
	}
	
	public boolean getCODE_ROOD(){
		return this.CODE_ROOD;
	}
	
	public void setMaltBier(){
		System.out.println("maltbier selection motherfucker, dit werkt gewoon :)");
	}
			
	public boolean Splitsing(String splitsing){
		if (splitsing.equals("ketel5")) {
			return this.routeKetel5;
		} else if (splitsing.equals("smirnoff")) {
			return this.routeSmirnoffIce;
		} else
			return splitsing.equals("bluemountain") && this.routeBlueMountain;
	}
	
	void setSnelheid(double LitersBier){
		if(CODE_ROOD){
			this.snelheid = 1 + (codeRoodSpeed)/2;
			System.out.println(this.snelheid);
		}
		else{
			this.snelheid = 1 + Math.log10(LitersBier * 2 + 1)/Math.log10(1.9);
		}
	}
	
	void updateDistance(){
		this.distance = this.distance + this.getSnelheid();
		
		if(this.subBroken){			
			this.disabledTimer--;  		
			if(this.disabledTimer == 0){ 
				this.subBroken = false;  
				System.out.println("uitgeschakelde sub gerepareerd :)");
			}					
		}
		
		if(specialEffectTimer >0 ){
			specialEffectTimer--;
			if(specialEffectTimer == 0){
				try {
					Process proc = Runtime.getRuntime().exec(new String[]{"C:\\Users\\Hajo\\workspace\\SubJava\\Send_b.exe" });
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setDistance(double newDistance){
		this.distance = newDistance * 10;
	}
	
	public double getDistance(){
		if(this.distance > 30950){
			CODE_ROOD = true;
		}
		return this.distance /10;		
	}
	
	private double getSnelheid(){
		if(this.subBroken){
			return 0;
		}
		else{
			return (Math.max(1, this.snelheid)) * Submarine.speedModefier;
		}
	}
	
	public static void setSpeedModefier(double newmodifier){
		Submarine.speedModefier = newmodifier;
	}
	
	public void AddTorpedo(int index){
		this.mostRecentTopedo = index;
		this.torpedos++;
	}
	
	public int getTorpedoIndex(){
		return this.mostRecentTopedo;
	}
	
	public int getTorpedo(){
		return this.torpedos;
	}
	
	public boolean FireTorpedo(){
		if(this.torpedos > 0)
		{
			this.torpedos--;
			System.out.println("torpedo geschoten, " + this.torpedos + " over");
			return(true);
		}
		System.out.println("geen torpedos beschikbaar.....");
		return (false);
	}
	
	public boolean getSubBroken(){
		return this.subBroken;
	}
	
	public void SubHit(){
		this.subBroken = true;
		this.disabledTimer = 5*60;
		this.specialEffectTimer = 11;
		try {
			Process proc = Runtime.getRuntime().exec(new String[]{"C:\\Users\\Hajo\\workspace\\SubJava\\Send_a+audio.exe" });
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("submarine geraakt en uitgeschakeld");
	}
}
