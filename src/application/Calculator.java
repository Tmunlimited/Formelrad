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
