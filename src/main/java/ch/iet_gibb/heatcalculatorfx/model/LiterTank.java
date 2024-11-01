package ch.iet_gibb.heatcalculatorfx.model;
/**
 * Klasse für das Berechnen von jeglichen Tanks
 * Mithilfe des Fassungsvermögens in Liter
 * @author Loris Stahlberg
 * @version 1.0.0
 * @since 24.10.2024
 */
public class LiterTank extends TankContainer {
    /** anstatt parameter werte wie höhe, länge, etc. anzugeben kann der User hier
     * einfach das Fassungsvermögen in Liter angeben, so können auch tanks mit komplizierten Fromen
     * berechnet werden. Also:
     * Liter ← natürlich in Liter angegeben
     */

    protected int liter;


    /**
     *
     * @param liter
     * @param name
     * @param maxTemp
     * @param requiredEnergy
     */
    public LiterTank(int liter, String name, int maxTemp, int requiredEnergy) {
        //Diese Attribute werden der Superklasse überwiesen und hier im Konstruktor wird nur breite, höhe und länge zugewiesen
        //Jonas Raemy: Kommentar stimmt nicht, Linter wird übergeben. Dazu, wenn man Ahnung von Code hat, weiss man was Super bedeutet.
        super (name, maxTemp, requiredEnergy);


        this.liter = checkValue(liter);
    }

    @Override
    public double volumeTank() {
        return liter * 1000; //volumen in cm³
    }



    /**
     * @return das Fassungsvermögen des Tanks in Liter
     */
    public int getLiter() {
        return liter;
    }

    /**
     * @param liter das Fassungsvermögen des Tanks in Liter
     */
    public void setLiter(int liter) {
        this.liter = checkValue(liter);
    }


    /**
     * Gibt die werte der Variablen eines LiterTank objekts aus
     * @return die werte des Tanks
     */
    @Override
    public String toString() {
        return "LiterTank{" +
                "\n" + "Tank id: " + tankId + "\n" +
                "Fassungsvermögen des Tanks in Liter=" + liter + " Liter" + ", " + "\n" +
                "Name des Tanks='" + name + '\'' + ", " + "\n" +
                "maximale Temperatur die das Wasser erreichen darf=" + maxTemp + "°C Grad Celsius" + ", " + "\n" +
                "Energie die der User pro tag benötigt in kwh angegeben=" + requiredEnergy + " kWh" + "\n" +
                '}';
    }
}
