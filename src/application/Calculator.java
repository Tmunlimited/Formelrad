package application;

/**
 * Berechnet das Formelrad
 *
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
                ", widerstand=" + widerstand + "]";
    }

    public void calculate() {
        /* Hier auf Grund der vorhanden Werte entscheiden
         * welche Methode unten aufgerufen werden muss.
         */

        //Decide which U-Formula
        if (spannung == 0) {
            if (widerstand != 0 && strom != 0) {
                this.spannung = calculateUFromRAndI(widerstand, strom);
                this.leistung = getPfromRandI(widerstand, strom);
            } else if (leistung != 0 && strom != 0) {
                this.spannung = calculateUFromPAndI(leistung, strom);
                this.widerstand = calculateRFromPAndI(leistung, strom);
            } else if (leistung != 0 && widerstand != 0) {
                this.spannung = calculateUFromPAndR(leistung, widerstand);
                this.strom = 0;
            }
        }

        //Decide which R-Formula
        if (widerstand == 0) {
            if (spannung != 0 && strom != 0) {
                this.widerstand = calculateRFromUAndI(spannung, strom);
                this.leistung = 0;
            } else if (leistung != 0 && strom != 0) {
                this.widerstand = calculateRFromPAndI(leistung, strom);
                this.spannung = 0;
            } else if (spannung != 0 && leistung != 0) {
                this.widerstand = calculateRFromUAndP(spannung, leistung);
                this.strom = 0;
            }

        }
    }

        /* Hier die Methoden mit den Formlen hinzuf�gen
         */

    //calculate U
    public double calculateUFromRAndI(double r, double i) {
        return r * i;
    }

    public double calculateUFromPAndI(double p, double i) {
        return p / i;
    }

    public double calculateUFromPAndR(double p, double r) {
        return Math.sqrt(p * r);
    }


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


    // Leistungsformeln f�r P Start

    public double getPfromUandI(double u, double i) {
        return u * i;
    }

    public double getPfromRandI(double r, double i) {
        return r * Math.pow(2, i);
    }

    public double getPfromUandR(double u, double r) {
        return (u * u) / r;
    }

    // Leistungsformlen f�r P Ende


}
