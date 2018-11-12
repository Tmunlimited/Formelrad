package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */


	public double calculateUFromRAndI(float r, float i) {
		return r*i;
	}

	public double calculateUFromPAndI(float p, float i) {
		return p/i;
	}


	public double calculateUFromPAndR(float p, float r) {
		return Math.sqrt(p*r);
	}

	
	// Leistungsformeln f�r P Start
	
	public double getPfromUandI(int u, int i) {
		return u*i;
	}
	
	public double getPfromRandI(int r, int i) {
		return r*i*i;
	}
	
	public double getPfromUandR(int u, int r) {
		return (u*u)/r;
	}
	
	// Leistungsformlen f�r P Ende

	
	// Current Formulas for I Start
	


	// Current Formulas for I End
}
