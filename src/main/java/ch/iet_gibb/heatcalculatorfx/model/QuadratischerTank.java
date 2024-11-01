package ch.iet_gibb.heatcalculatorfx.model;


import ch.iet_gibb.heatcalculatorfx.property.Property;

import java.util.List;

/**
 * Klasse für das Berechnen von quadratischen Tanks
 * @author Loris Stahlberg
 * @version 1.0.0
 * @since 24.10.2024
 */
public class QuadratischerTank extends TankContainer {

    /** der User kann Parameterwerte zur grösse angeben also
     * höhe ←in cm angegeben
     * breite ←in cm angegeben
     * länge ←in cm angegeben
     */
    /** Höhe die der User als Parameter wert angibt*/
    protected int height;

    /** Breite die der User als Parameter wert angibt*/
    protected int width;

    /** Länge die der User als Parameter wert angibt*/
    protected int length;


    /**
     *
     * @param width
     * @param height
     * @param length
     * @param name
     * @param maxTemp
     * @param requiredEnergy
     */
    public QuadratischerTank(int width, int height, int length, String name, int maxTemp, int requiredEnergy) {
        //Diese Attribute werden der Superklasse überwiesen und hier im Konstruktor wird nur breite, höhe und länge zugewiesen
        super (name, maxTemp, requiredEnergy);

        this.width = checkValue(width);
        this.height = checkValue(height);
        this.length = checkValue(length);
    }





    /**
     * Methode für das Berechnen vom Volumen des Tanks, das Volumen wird dann in cm³ ausgegeben
     * @return volumen des Tanks
     */
    @Override
    public double volumeTank() {
        return width * height * length; // Volumen in cm³
    }




    /**
     *
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
     * @return Breite des Tanks
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width Breite des Tanks
     */
    public void setWidth(int width) {
        this.width = checkValue(width);
    }


    /**
     * @return länge des Tanks, also länge nach hinten quasi
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length länge des Tanks
     */
    public void setLength(int length) {
        this.length = checkValue(length);
    }


    @Override
    public String getTitel() {
        return "Quadratischer Tank";
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = super.getProperties();

        Property height = new Property("Höhe in cm:", Integer.toString(getHeight()));
        properties.add(height);

        Property width = new Property("Width in cm:", Integer.toString(getWidth()));
        properties.add(width);

        Property length = new Property("Length in cm:", Integer.toString(getLength()));
        properties.add(length);

        return properties;
    }

    /**
     * Gibt die werte der Variablen eines QuadratischerTank objekts aus
     * @return die werte des Tanks
     */
    @Override
    public String toString() {
        return "QuadratischerTank{" +
                "\n" + "Tank id: " + tankId + "\n" +
                "Höhe des Tanks=" + height + " cm" + "\n" +
                ", Breite des Tanks=" + width + " cm" + ", " + "\n"
                + "länge des Tanks=" + length + " cm" + "\n" +
                ", name des Tanks='" + name + '\'' + ", " + "\n" +
                "maximale Temperatur die das Wasser erreichen darf=" + maxTemp + "°C Grad Celsius" + ", " + "\n" +
                "Energie die der User pro tag benötigt in kwh angegeben=" + requiredEnergy + " kWh" + "\n" +
                '}';
    }
}
