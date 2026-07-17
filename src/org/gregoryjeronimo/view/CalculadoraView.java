package org.gregoryjeronimo.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.gregoryjeronimo.controller.CalculadoraController;

public class CalculadoraView {

    private final VBox view;
    private final Label pantalla;
    private final GridPane cuadroBotones;
    private final CalculadoraController controller; // Agregado

    public CalculadoraView() {
        controller = new CalculadoraController(); // Inicializado

        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #F2F2FC;");

        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(220, 50);

        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(10);
        cuadroBotones.setVgap(10);
        cuadroBotones.setAlignment(Pos.CENTER);

        // Creación e inserción de botones
        Button btnUno = nuevoBoton("1");
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnIgual = nuevoBoton("=");
        Button btnMas = nuevoBoton("+");
        Button btnClean = nuevoBoton("C");
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
        Button btnNueve = nuevoBoton("9");
         Button btnCero = nuevoBoton("0");
        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);
        cuadroBotones.add(btnIgual, 3, 4);
         cuadroBotones.add(btnClean, 0, 6);
          cuadroBotones.add(btnCuatro, 1, 4);
          cuadroBotones.add(btnCinco, 2, 4);
          cuadroBotones.add(btnSeis, 2, 4);
          cuadroBotones.add(btnSiete, 0, 5);
          cuadroBotones.add(btnOcho, 1, 5);
          cuadroBotones.add(btnNueve, 2, 5);
          cuadroBotones.add(btnCero, 3, 5);
          

        view.getChildren().addAll(pantalla, cuadroBotones);
    }

    public VBox getView() {
        return view;
    }

    private Button nuevoBoton(String texto) {
        Button btn = new Button(texto);

        btn.setPrefSize(50, 50);
        btn.setStyle("-fx-background-color: #E6E6F2; -fx-text-fill: #333333; -fx-background-radius: 5px; -fx-cursor: hand;");

        // --- ESTA LÍNEA ES LA QUE HACE QUE FUNCIONEN LOS CLICS ---
        btn.setOnAction(e -> controller.procesoDeEntrada(texto, pantalla));

        btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color: #D1D1E0; -fx-text-fill: #333333; -fx-background-radius: 5px;");
            btn.setTranslateY(2);
        });
        btn.setOnMouseReleased(e -> {
            btn.setStyle("-fx-background-color: #E6E6F2; -fx-text-fill: #333333; -fx-background-radius: 5px;");
            btn.setTranslateY(0);
        });

        return btn;
    }
}