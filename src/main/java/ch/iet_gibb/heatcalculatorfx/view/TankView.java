package ch.iet_gibb.heatcalculatorfx.view;

import ch.iet_gibb.heatcalculatorfx.controller.TankController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TankView {

    protected Stage stage;
    protected TankController controller;

    public TankView(Stage stage, TankController controller) {
        this.stage = stage;
        this.controller = controller;
    }


    public void startView() {
        /* Layout erstellen (https://docs.oracle.com/javafx/2/layout/builtin_layouts.htm
        um mehr Informationen über die Layout typen in JavaFX zu erhalten) */
        VBox layout = new VBox();
        // Padding und Abstand zwischen den Elementen setzen
        layout.setPadding(new Insets(15, 15, 15, 15));
        layout.setSpacing(20);

        /* Textfeld erstellen und dem Layout anfügen */
        Text tankText = new Text();
        //ruft die toString Methode des aktuellen Tanks auf und setzt den Text in der View
        tankText.setText(controller.getTank());
        tankText.setFont(Font.font ("Tahoma", FontWeight.EXTRA_BOLD, 20));
        // Optisch ansprechender Hintergrund mittels CSS definieren
        tankText.setStyle("-fx-font-family: monospace;-fx-fill: linear-gradient(from 0% 0% to 100% 200%, repeat, aqua 0%, red 50%);");
        layout.getChildren().add(tankText);

        /* Button erstellen und dem Layout anfügen, um zwischen den verschiedenen Tanks navigieren zu können*/
        Button btnNext;
        btnNext = new Button("→");
        btnNext.setOnAction( controller );
        layout.getChildren().add(btnNext);

        /* Scene erstellen und die View darstellen */
        Scene scene = new Scene(layout,900,600);
        stage.setScene(scene);
        stage.show();
    }

}
