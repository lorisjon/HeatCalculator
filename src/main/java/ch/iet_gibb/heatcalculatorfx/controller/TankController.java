package ch.iet_gibb.heatcalculatorfx.controller;

import ch.iet_gibb.heatcalculatorfx.model.TankContainer;
import ch.iet_gibb.heatcalculatorfx.view.TankView;
import javafx.event.ActionEvent;

import java.util.List;

public class TankController implements javafx.event.EventHandler<ActionEvent> {

    protected List<TankContainer> models;

    protected TankView view;

    //index mit dem aktuell angezeigtem model im View
    protected int currentTank = 0;

    public TankController(List<TankContainer> models) {
        this.models = models;
    }

    public void setView(TankView view) {
        this.view = view;
    }

    public void startView() {
        view.startView();
    }

    public void showNextTank() {
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

    @Override
    public void handle(ActionEvent actionEvent) {
        showNextTank();
    }
}
