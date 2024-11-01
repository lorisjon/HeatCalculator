package ch.iet_gibb.heatcalculatorfx.model;
/**
 * Klasse für das Berechnen von zylindrischen Tanks
 * @author Loris Stahlberg
 * @version 1.0.0
 * @since 24.10.2024
 */
public class ZylindrischerTank extends TankContainer {

    /** der User kann Parameterwerte zur grösse angeben also
     * höhe ← in cm angegeben
     * radius ← in cm angegeben
     */
    protected int radius;
    protected int  height;




    /**
     *
     * @param radius
     * @param height
     * @param name
     * @param maxTemp
     * @param requiredEnergy
     */
    public ZylindrischerTank(int radius, int height, String name, int maxTemp, int requiredEnergy) {
        //Diese Attribute werden der Superklasse überwiesen und hier im Konstruktor wird nur radius und höhe zugewiesen

        super (name, maxTemp, requiredEnergy);

        this.radius = checkValue(radius);
        this.height = checkValue(height);
    }



    /**
     * Berechnet das Volumen des Zylindertanks.
     * @return das Volumen des Tanks in cm³
     */
    @Override
    public double volumeTank() {
        // Konstante für Pi
        final double PI = Math.PI;

        // Berechnung des Volumens
        return PI * Math.pow(radius, 2) * height;
    }




    /**
     * @return radius des Tanks
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @param radius radius des Tanks
     */
    public void setRadius(int radius) {
        this.radius = checkValue(radius);
    }


    /**
     * @return Höhe des Tanks
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height Höhe des Tanks
     */
    public void setHeight(int height) {
        this.height = checkValue(height);
    }

    /**
     * Gibt die werte der Variablen eines ZylindrischerTank objekts aus
     * @return die werte des Tanks
     */
    @Override
    public String toString() {
        return "ZylindrischerTank{" +
                "\n" + "Tank id: " + tankId + "\n" +
                "Radius des Tanks=" + radius + " cm" + ", " + "\n"
                + "Höhe des Tanks=" + height + " cm"  + "\n" +
                ", Name des Tanks='" + name + '\'' + ", " + "\n" +
                "maximale Temperatur die das Wasser erreichen darf=" + maxTemp + "°C Grad Celsius" + ", " + "\n" +
                "Energie die der User pro tag benötigt in kwh angegeben=" + requiredEnergy + " kWh" + "\n" +
                '}';
    }
}
