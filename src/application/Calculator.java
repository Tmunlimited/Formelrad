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
		if(leistung!=0) {
			if(spannung!=0) {
				strom = calculateIFromPAndU(leistung,spannung);
				widerstand = calculateRFromUAndP(spannung,leistung);
			} else if(strom!=0){
				spannung= calculateUFromPAndI(leistung, strom);
				widerstand = calculateRFromPAndI(leistung,strom);
			} else if(widerstand !=0) {
				spannung = calculateUFromPAndR(leistung,spannung);
				strom= calculateIFromPAndR(leistung,spannung);
			}
		} else if(spannung!=0) {
			if(strom!=0) {
				leistung = calculatePFromUAndI(spannung,strom);
				widerstand = calculateRFromUAndI(spannung,strom);
			} else if(widerstand!=0) {
				leistung= calculatePFromUAndR(spannung,widerstand);
				strom = calcuclateIFromUAndR(spannung,widerstand);
			}
		} else if (strom!=0) {
			if(widerstand!=0) {
				leistung=calculatePFromRAndI(widerstand,strom);
				spannung=calculateUFromRAndI(widerstand,strom);
			}
		}
		
	}
	
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */


	public double calculateUFromRAndI(double r, double i) {
		return r*i;
	}

	public double calculateUFromPAndI(double p, double i) {
		return p/i;
	}


	public double calculateUFromPAndR(double p, double r) {
		return Math.sqrt(p*r);
	}

	
	// Leistungsformeln f�r P Start
	
	public double calculatePFromUAndI(double u, double i) {
		return u*i;
	}
	
	public double calculatePFromRAndI(double r, double i) {
		return r*i*i;
	}
	
	public double calculatePFromUAndR(double u, double r) {
		return (u*u)/r;
	}
	
	// Leistungsformlen f�r P Ende

	
	// Current Formulas for I Start
	
	public double calculateIFromPAndR(double P, double R) {
		return Math.sqrt(P/R);
	}

	public double calculateIFromPAndU(double P, double U) {
		return P/U;
	}
	
	public double calcuclateIFromUAndR(double U, double R) {
		return U/R;
	}
	
	// Current Formulas for I End
	
    //calculate R
    public double calculateRFromUAndI(double u, double i) {
        return u / i;
    }

    public double calculateRFromPAndI(double p, double i) {
        return p / Math.pow(2, i);
    }

    public double calculateRFromUAndP(double u, double p) {
        return Math.pow(2, u) / p;
    }
	
}