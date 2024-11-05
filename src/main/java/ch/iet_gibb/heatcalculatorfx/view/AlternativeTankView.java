package ch.iet_gibb.heatcalculatorfx.view;

import ch.iet_gibb.heatcalculatorfx.controller.ControllerViewInterface;
import ch.iet_gibb.heatcalculatorfx.controller.TankController;
import ch.iet_gibb.heatcalculatorfx.model.InterfaceTank;
import ch.iet_gibb.heatcalculatorfx.property.Property;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class AlternativeTankView implements ControllerViewInterface {

    protected Stage stage;
    protected TankController controller;

    public AlternativeTankView(Stage stage, TankController controller) {
        this.stage = stage;
        this.controller = controller;
        stage.setTitle("Heat Calculator");
    }


    /*
    @param data für die daten der einzelnen Speicher
     */
    @Override
    public void startView(InterfaceTank data) {
        /* Layout erstellen (https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
        um mehr Informationen über die Layout typen in JavaFX zu erhalten) */
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);

        /* Textfeld, für den Titel der Klassen, erstellen und dem Layout anfügen */
        Text tankText = getTankNode(data.getTitel());
        layout.getChildren().add(tankText);

        /* Eigenschaften untereinander in einer VBox darstellen und dem Layout anfügen */
        VBox propertiesLayout = new VBox();
        for(Property property : data.getProperties()){
            // Label mit der Beschriftung erstellen und dem Layout anfügen
            addPropertyToPane(property, propertiesLayout);
        }
        layout.getChildren().add(propertiesLayout);



        /* Button erstellen und dem Layout anfügen, um zwischen den verschiedenen Tanks navigieren zu können*/
        Button btnNext;
        btnNext = new Button("→");
        btnNext.setOnAction( controller );
        layout.getChildren().add(btnNext);

        /* Scene erstellen und die View darstellen */
        Scene scene = new Scene(layout,450,600);
        stage.setScene(scene);
        stage.show();
    }


    protected Text getTankNode(String title) {
        Text tankText = new Text();
        tankText.setText(title);
        tankText.setFont(Font.font ("Helvetica", FontWeight.EXTRA_BOLD, 30));
        tankText.setStyle("-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, darkblue 0%, black 50%);");
        return tankText;
    }


    /* Fügt die Angaben der Tanks
    also die einzelnen Properties in das Pane
     */
    protected void addPropertyToPane(Property property, Pane propertiesLayout) {
        // Label oder eher Textfeld für die Beschreibung erstellen
        // also, das, was dann links stehen soll, dinge wie: "Breite in Cm:", oder ähnlich
        Text keyText = new Text();
        keyText.setText(property.getKey());
        keyText.setFont(Font.font ("Helvetica", FontWeight.BOLD, 20));
        propertiesLayout.getChildren().add(keyText);

        // Label/Textfeld für die Werte passend zu den einzelnen Beschreibungen
        Text valueText = new Text();
        valueText.setText(property.getValue());
        valueText.setFont(Font.font("Helvetica", FontWeight.NORMAL, 16));
        propertiesLayout.getChildren().add(valueText);
    }

}
