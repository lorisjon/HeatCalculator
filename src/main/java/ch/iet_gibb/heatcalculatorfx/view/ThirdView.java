package ch.iet_gibb.heatcalculatorfx.view;

import ch.iet_gibb.heatcalculatorfx.controller.ControllerViewInterface;
import ch.iet_gibb.heatcalculatorfx.controller.TankController;
import ch.iet_gibb.heatcalculatorfx.model.InterfaceTank;
import ch.iet_gibb.heatcalculatorfx.property.Property;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ThirdView implements ControllerViewInterface {

    protected Stage stage;
    protected TankController controller;

    public ThirdView(Stage stage, TankController controller) {
        this.stage = stage;
        this.controller = controller;
        stage.setTitle("Dritte (eigene) View");
    }


    /*
    @param data für die daten der einzelnen Speicher
     */
    @Override
    public void startView(InterfaceTank data) {
        /* Layout erstellen (https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
        um mehr Informationen über die Layout typen in JavaFX zu erhalten) */
        VBox layout3 = new VBox();
        layout3.setPadding(new Insets(10));
        layout3.setSpacing(10);
        layout3.setStyle("-fx-background-color: #005340");

        /* Textfeld, für den Titel der Klassen, erstellen und dem Layout anfügen */
        Text tankText = getTankNode(data.getTitel());
        layout3.getChildren().add(tankText);

        /* Eigenschaften untereinander in einer VBox darstellen und dem Layout anfügen */
        VBox propertiesLayout = new VBox();
        for(Property property : data.getProperties()){
            // Label mit der Beschriftung erstellen und dem Layout anfügen
            addPropertyToPane(property, propertiesLayout);
        }
        layout3.getChildren().add(propertiesLayout);



        /* Button erstellen und dem Layout anfügen, um zwischen den verschiedenen Tanks navigieren zu können*/
        Button btnNext;
        btnNext = new Button("→");
        btnNext.setOnAction( controller );
        layout3.getChildren().add(btnNext);

        /* Scene erstellen und die View darstellen */
        Scene scene = new Scene(layout3,450,600);
        stage.setScene(scene);
        stage.show();
    }


    protected Text getTankNode(String title) {
        Text tankText = new Text();
        tankText.setText(title);
        tankText.setFont(Font.font ("Trebuchet MS", FontWeight.EXTRA_BOLD, 30));
        tankText.setStyle("-fx-fill: white;");
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
        keyText.setFont(Font.font ("Comic Sans MS", FontWeight.BOLD, 20));
        propertiesLayout.getChildren().add(keyText);

        // Label/Textfeld für die Werte passend zu den einzelnen Beschreibungen
        Text valueText = new Text();
        valueText.setText(property.getValue());
        valueText.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 16));
        propertiesLayout.getChildren().add(valueText);
    }

}
