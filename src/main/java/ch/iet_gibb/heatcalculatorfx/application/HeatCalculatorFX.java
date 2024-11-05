package ch.iet_gibb.heatcalculatorfx.application;

import ch.iet_gibb.heatcalculatorfx.controller.TankController;
import ch.iet_gibb.heatcalculatorfx.model.LiterTank;
import ch.iet_gibb.heatcalculatorfx.model.QuadratischerTank;
import ch.iet_gibb.heatcalculatorfx.model.TankContainer;
import ch.iet_gibb.heatcalculatorfx.model.ZylindrischerTank;
import ch.iet_gibb.heatcalculatorfx.view.AlternativeTankView;
import ch.iet_gibb.heatcalculatorfx.view.TankView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class HeatCalculatorFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        List<TankContainer> models = createModels();
        
        TankController controller = new TankController(models);

        AlternativeTankView alternativeView = new AlternativeTankView(stage, controller);
        TankView view = new TankView(stage, controller); /* Views können nun hier ausgewechselt werden.  */

        controller.setView(alternativeView);
        controller.startView();
    }
    
    protected List<TankContainer> createModels() {
        ArrayList<TankContainer> tanks = new ArrayList<>();
        TankContainer tank = new QuadratischerTank(200, 200, 100, "Quadolin", 60, 50);
        tanks.add(tank);
        tank = new ZylindrischerTank(75, 200, "Zynanderix", 55, 45);
        tanks.add(tank);
        tank = new LiterTank(5820, "liliane", 55, 50);
        tanks.add(tank);
        return tanks;
    }

    public static void main(String[] args) {
        launch(args);
    }

}