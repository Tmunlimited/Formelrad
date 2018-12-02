package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann, modified by Samuel Dubler & Josua Koglin
 * @version 1.0 - 25.11.18
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
				spannung = calculateUFromPAndR(leistung,widerstand);
				strom= calculateIFromPAndR(leistung,widerstand);
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

	// Formulas for U Start
	public double calculateUFromRAndI(double r, double i) {
		System.out.println("Berechne U mit R: "+r+" und I: "+i+". Ergibt U= "+r*i);
		return r*i;
	}

	public double calculateUFromPAndI(double p, double i) {
		System.out.println("Berechne U mit P: "+p+" und I: "+i+". Ergibt U= "+p/i);
		return p/i;
	}


	public double calculateUFromPAndR(double p, double r) {
		System.out.println("Berechne U mit P: "+p+" und R: "+r+". Ergibt U= "+p*r);
		return Math.sqrt(p*r);
	}
	// Formulas for U End
	
	// Leistungsformeln for P Start
	
	public double calculatePFromUAndI(double u, double i) {
		System.out.println("Berechne P mit U: "+u+" und I: "+i+". Ergibt P= "+u*i);
		return u*i;
	}
	
	public double calculatePFromRAndI(double r, double i) {
		System.out.println("Berechne P mit R: "+r+" und I: "+i+". Ergibt P= "+r*i*i);
		return r*i*i;
	}
	
	public double calculatePFromUAndR(double u, double r) {
		System.out.println("Berechne P mit U: "+u+" und R: "+r+". Ergibt P= "+(u*u)/r);
		return (u*u)/r;
	}
	
	// Leistungsformlen for P End

	
	// Formulas for I Start
	
	public double calculateIFromPAndR(double P, double R) {
		System.out.println("Berechne I mit P: "+P+" und R: "+R+". Ergibt I= "+Math.sqrt(P/R));
		return Math.sqrt(P/R);
	}

	public double calculateIFromPAndU(double P, double U) {
		System.out.println("Berechne I mit P: "+P+" und U: "+U+". Ergibt I= "+P/U);
		return P/U;
	}
	
	public double calcuclateIFromUAndR(double U, double R) {
		System.out.println("Berechne I mit U: "+U+" und R: "+R+". Ergibt I= "+U/R);
		return U/R;
	}
	
	// Formulas for I End
	
	// Formulas for R Start
    public double calculateRFromUAndI(double u, double i) {
		System.out.println("Berechne R mit U: "+u+" und I: "+i+". Ergibt R= "+u/i);
        return u / i;
    }

    public double calculateRFromPAndI(double p, double i) {
    	System.out.println("Berechne R mit P: "+p+" und I: "+i+". Ergibt R= "+p/Math.pow(2, i));
        return p / Math.pow(2, i);
    }

    public double calculateRFromUAndP(double u, double p) {
    	System.out.println("Berechne R mit U: "+u+" und P: "+p+". Ergibt R= "+Math.pow(2, u) / p);
        return Math.pow(2, u) / p;
    }
    // Formulas for R End
}