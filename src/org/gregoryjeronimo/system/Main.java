
package org.gregoryjeronimo.system;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.gregoryjeronimo.view.CalculadoraView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        CalculadoraView calculadora = new CalculadoraView();

        // Se le pasa la vista directamente a la escena
        Scene scene = new Scene(calculadora.getView(), 260, 460);

        primaryStage.setTitle("Calculoฅ^•ﻌ•^ฅ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

