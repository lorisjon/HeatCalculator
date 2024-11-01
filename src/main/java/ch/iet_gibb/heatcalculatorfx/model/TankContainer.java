package ch.iet_gibb.heatcalculatorfx.model;

import ch.iet_gibb.heatcalculatorfx.property.Property;

import java.util.ArrayList;
import java.util.List;

/**
 * Superklasse für das Berechnen von Energie in Wasserspeicher (Tanks)
 * @author Loris Stahlberg
 * @version 1.0.0
 * @since 24.10.2024
 */
public abstract class TankContainer implements InterfaceTank  {
    /**der User gibt einen Namen für seinen Tank an */
    protected String name;

    /** maximale Temparatur die das Wasser erreichen darf (auch vom user als parameterwert angegeben)*/
    protected int maxTemp;

    /** Der User gibt an wie viel energie er pro tag benötigt*/
    protected int requiredEnergy;

    /**ID des Tanks*/
    private static int id;
    protected int tankId;

    /**
     *
     * @param name
     * @param maxTemp
     * @param requiredEnergy
     */
    public TankContainer(String name, int maxTemp, int requiredEnergy) {
        // der wert wird innerhalb der Methode übergeben und nur wenn die String variable nicht leer ist */
        checkName(name);

        // der wert wird innerhalb der Methode übergeben und nur wenn er grösser als 30 ist */
        checkTemp(maxTemp);

        this.requiredEnergy = checkValue(requiredEnergy);

        id++;
        tankId = id;
    }


    /**
     * Überprüft, ob die Parameter werte grösser als 0 sind und gibt eine Fehlermeldung zurück,
     * falls dies der Fall ist
     * @param value einer der werte für das Berechnen vom volumen
     * @return der gültige Wert (grösser als 0)
     */
    protected int checkValue (int value){
        if (value > 0)
        {
            return value;
        }

        else
        {
            throw new IllegalArgumentException("Die Parameterangaben müssen grösser als 0 sein");
        }
    }

    /**
     * Überprüft die maximale Temparatur die das Wasser erreichen darf,
     * sie muss grösser als 30 sein
     * @param temperatur die maximale Temparatur die das Wasser erreichen darf
     */
    protected void checkTemp (int temperatur) {
        if (temperatur > 30)
        {
            this.maxTemp = temperatur;
        }

        else
        {
            throw new IllegalArgumentException("Die Temperatur muss grösser als 30 sein.");
        }
    }

    /**
     * Überprüft den Namen des Tanks, er darf nicht leer sein
     * @param name Name des Tanks (vom User angegeben)
     */
    protected void checkName (String name)
    {
        if (name.isEmpty())
        {
            throw new IllegalArgumentException("Der Name des Tanks darf nicht leer sein");
        }

        else {
            this.name = name;
        }
    }


    /**
     * Methode für das Berechnen vom Volumen des Tanks, das Volumen wird dann in cm³ ausgegeben
     * berechnet das Volumen des Tanks (in Litern, da 1 cm³ = 1 ml und 1 Liter = 1000 ml)
     * @return volumen des Tanks
     */
    public abstract double volumeTank ();


    /**
     * Berechnet die im Tank gespeicherte Energie (in Kilojoule).
     * @return die Energie in Kilojoule
     */
    public final double calculateStoredEnergy() {
        double volumeInLiters = volumeTank() / 1000.0; // Volumen in Litern, da 1 Liter = 1000 cm³

        // Spezifische Wärmekapazität von Wasser in kJ/(kg·°C)
        final double specificHeatCapacity = 4.186;

        final double roomTemperature = 20.0; // Angenommene Raumtemperatur in °C

        // Temperaturdifferenz ΔT (Differenz zwischen Maximaltemperatur und Raumtemperatur)
        double deltaT = maxTemp - roomTemperature;


        // Berechnung der Energie: E = m * c * ΔT
        return volumeInLiters * specificHeatCapacity * deltaT;// Gespeicherte Energie in kJ
    }


    /**
     * Berechnet, wie viele Tage der Benutzer mit der gespeicherten Energie heizen kann.
     * @return Anzahl der Tage
     */
    public final double calculateHeatingDays() {
        double storedEnergy = calculateStoredEnergy(); // Energie in kJ
        // Umrechnung von kJ in kWh (1 kWh = 3600 kJ)
        double storedEnergyInKWh = storedEnergy / 3600.0;

        // Berechnet, wie viele Tage die Energie reicht
        //Jonas Raemy: Wenn man oben schaut, sieht man direkt, was die Funktion macht.(calculateHeatingDays)
        return storedEnergyInKWh / requiredEnergy;
    }



    /**
     * @return name des Tanks
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name des Tanks
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * @return maximal temparatur des Tanks, also die maximale Temparatur die das Wasser erreichen darf
     */
    public int getMaxTemp() {
        return maxTemp;
    }

    /**
     * @param maxTemp maximal temparatur des Tanks, also die maximale Temparatur die das Wasser erreichen darf
     */
    public void setMaxTemp(int maxTemp) {
        checkTemp(maxTemp);
    }


    /**
     * @return Energie die der User pro Tag benötigt
     */
    public int getRequiredEnergy() {
        return requiredEnergy;
    }

    /**
     * @param requiredEnergy Energie die der User pro Tag benötigt
     */
    public void setRequiredEnergy(int requiredEnergy) {
        this.requiredEnergy = checkValue(requiredEnergy);
    }

    @Override
    public List<Property> getProperties() {
        List<Property> properties = new ArrayList<>();

        Property name = new Property("Name:", getName());
        properties.add(name);

        Property maxTemp = new Property("maximale Temparatur für das Wasser:", Integer.toString(getMaxTemp()) + "");
        properties.add(maxTemp);

        Property requiredEnergy = new Property("benötigte Energie pro tag in kWh:", Integer.toString(getRequiredEnergy()) + "");
        properties.add(requiredEnergy);

        Property id = new Property("Tank ID:", Integer.toString(tankId)+ "");
        properties.add(id);

        return properties;
    }

}
