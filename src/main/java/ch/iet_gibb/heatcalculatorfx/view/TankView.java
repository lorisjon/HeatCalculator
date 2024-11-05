package ch.iet_gibb.heatcalculatorfx.view;

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

public class TankView {

    protected Stage stage;
    protected TankController controller;

    public TankView(Stage stage, TankController controller) {
        this.stage = stage;
        this.controller = controller;
    }


    /*
    @param data für die daten der einzelnen Speicher
     */
    public void startView( InterfaceTank data ) {
        /* Layout erstellen (https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
        um mehr Informationen über die Layout typen in JavaFX zu erhalten) */
        VBox layout = new VBox();
        // Padding und Abstand zwischen den Elementen setzen
        //Jonas Raemy: Würde die Kommentare löschen, weil man ja sieht, was passiert. (setPadding, setSpacing)
        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.setSpacing(20);

        /* Textfeld, für den Titel der Klassen, erstellen und dem Layout anfügen */
        Text tankText = new Text();
        //ruft die toString Methode des aktuellen Tanks auf und setzt den Text in der View
        tankText.setText(data.getTitel());
        tankText.setFont(Font.font ("Tahoma", FontWeight.EXTRA_BOLD, 20));
        // Optisch ansprechender Hintergrund mittels CSS definieren
        tankText.setStyle("-fx-font-family: monospace;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, darkmagenta 0%, aqua 50%);");
        layout.getChildren().add(tankText);

        /* Eingenschaften erstellen und in einem TilePane Layout anfügen */
        TilePane propertiesPane = new TilePane();
        // Einstellungen damit 2 spalten dargestellt werden
        propertiesPane.setPrefColumns(2);
        propertiesPane.setMaxWidth(Region.USE_PREF_SIZE);

        for (Property property : data.getProperties()) {
           addPropertyToPane(property, propertiesPane);
        }
        layout.getChildren().add(propertiesPane);



        /* Button erstellen und dem Layout anfügen, um zwischen den verschiedenen Tanks navigieren zu können*/
        Button btnNext;
        btnNext = new Button("→");
        btnNext.setOnAction( controller );
        layout.getChildren().add(btnNext);

        /* Scene erstellen und die View darstellen */
        Scene scene = new Scene(layout,700,350);
        stage.setScene(scene);
        stage.show();
    }



    /* Fügt die Angaben der Tanks
    also die einzelnen Properties in das Pane
     */
    protected void addPropertyToPane(Property property, Pane layout) {
        Font propertiesFont = Font.font("Tahoma", FontWeight.BOLD, 16);

        // Label oder eher Textfeld für die Beschreibung erstellen
        // also, das, was dann links stehen soll, dinge wie: "Breite in Cm:", oder ähnlich
        Text keyText = new Text();
        keyText.setText(property.getKey());
        keyText.setFont(propertiesFont);

        //Text für Beschreibung linksbündig darstellen
        keyText.setWrappingWidth(310);
        keyText.setTextAlignment(TextAlignment.LEFT);
        layout.getChildren().add(keyText);


        // Label/Textfeld für die Werte passend zu den einzelnen Beschreibungen
        Text valueText = new Text();
        valueText.setText(property.getValue());
        valueText.setFont(propertiesFont);

        //Text Rechtsbündig darstellen
        valueText.setWrappingWidth(100);
        valueText.setTextAlignment(TextAlignment.RIGHT);
        layout.getChildren().add(valueText);
    }

}
