package ch.iet_gibb.heatcalculatorfx.controller;

import ch.iet_gibb.heatcalculatorfx.model.TankSuper;
import ch.iet_gibb.heatcalculatorfx.view.TankView;

import java.util.List;

public class TankController {

    protected List<TankSuper> models;

    protected TankView view;

    protected int currentTank = 0;

    public TankController(List<TankSuper> models) {
        this.models = models;
    }

    public void setView(TankView view) {
        this.view = view;
    }

    public void startView() {
        view.startView();
    }

    public void showNextLabel() {
        //inkrementiert die Zahl von currentTank um eins, falls man nicht am Ende der Liste ist
        if (currentTank < models.size()-1)
        {
            currentTank++;
        }

        else
        {
            currentTank = 0;
        }

        view.startView();
    }

    public String getTank() {
        //greift auf die Liste zu, spricht das Element currentTank an
        // und ruft auf diesem Objekt die toString Methode auf
        return models.get(currentTank).toString();
    }
}
