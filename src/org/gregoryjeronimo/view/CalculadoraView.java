package org.gregoryjeronimo.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene. layout. GridPane;
import javafx.scene.layout. VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Gregory Jeronimo 2026116s
 */


public class CalculadoraView {
private final VBox view;
private final Label pantalla;
private final   GridPane cuadroBotones;

//Controller 

public CalculadoraView() {
view = new VBox(15);
view.setPadding(new Insets(15));
view.setAlignment(Pos.CENTER);
view.setStyle("-fx-background-color: #F2F2FC;");

pantalla = new Label("0");
pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 40));
pantalla.setAlignment(Pos.CENTER_RIGHT);
pantalla.setPrefSize(220, 50);

cuadroBotones = new GridPane();
cuadroBotones.setHgap(10);// Interlineado cuadricula
cuadroBotones.setVgap(10);
cuadroBotones.setAlignment(Pos.CENTER);
view.getChildren().addAll(pantalla, cuadroBotones);//Alineado al centro

//Primer boton
Button btnUno = new Button("1");
btnUno.setPrefSize(50, 50);

btnUno.setOnMousePressed(e -> {
    btnUno.setStyle("-fx-background-color: #E6E6F2;-fx-text-fill:white; -ft-background-radius:5px; -fx-cursor: hand;");
btnUno.setTranslateY(2);
});

btnUno.setOnMouseReleased(e -> {
btnUno.setStyle("-fx-background-color: #E1E1EB;");
btnUno.setTranslateY(0);
});

btnUno.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));

// Segundo Boton 
Button btnDos = new Button("2");
btnDos.setPrefSize(50, 50);

btnDos.setOnMousePressed(e -> {
    btnDos.setStyle("-fx-background-color: #E6E6F2;-fx-text-fill:white; -ft-background-radius:5px; -fx-cursor: hand;");
btnDos.setTranslateY(0);
});
btnDos.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));


btnDos.setOnMouseReleased(e -> {
btnDos.setStyle("-fx-background-color: #E1E1EB;");
btnDos.setTranslateY(0);
});

//Boton tres
Button btnTres = new Button("3");
btnTres.setPrefSize(50, 50);
btnTres.setOnMousePressed(e -> {
    btnTres.setStyle("-fx-background-color: #E6E6F2; -fx-text-fill:white; -ft-background-radius:5px; -fx-cursor: hand;");
btnTres.setTranslateY(0);
});
btnTres.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));

btnTres.setOnMouseReleased(e -> {
btnTres.setStyle("-fx-background-color: #E1E1EB;");
btnTres.setTranslateY(0);
});

//Boton mas
Button btnMas = new Button("+");
btnMas.setPrefSize(50, 50);
btnMas.setOnMousePressed(e -> {
    btnMas.setStyle("-fx-background-color: #E6E6F2;-fx-text-fill:white; -ft-background-radius:5px; -fx-cursor: hand;");
btnMas.setTranslateY(0);
});
btnMas.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));

btnMas.setOnMouseReleased(e -> {
btnMas.setStyle("-fx-background-color: #E1E1EB;");
btnMas.setTranslateY(0);
});

cuadroBotones.add(btnUno, 0, 3);
cuadroBotones.add(btnDos, 1, 3);
cuadroBotones.add(btnTres, 2, 3);
cuadroBotones.add(btnMas, 3, 3);

view.getChildren().addAll(pantalla, cuadroBotones);
        }
public VBox  getView(){
 return view;
}
private Button nuevoBoton(String texto) {
Button btn = new Button(texto);



//configuracion de boton
//tamaño, el estilo, sus fuciones
return btn;
}

}