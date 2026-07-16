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
 * @author Gregory Jeronimo 
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
Button btnUno = nuevoBoton("1");


//btnUno.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));

// Segundo Boton 
Button btnDos = nuevoBoton("2");


//Boton tres
Button btnTres = nuevoBoton("3");


//Boton mas
Button btnMas = nuevoBoton("+");


cuadroBotones.add(btnUno, 0, 3);
cuadroBotones.add(btnDos, 1, 3);
cuadroBotones.add(btnTres, 2, 3);
cuadroBotones.add(btnMas, 3, 3);

view.getChildren().addAll(pantalla, cuadroBotones);
        }

//Boton resumido
public VBox  getView(){
 return view;
}
private Button nuevoBoton(String texto) {
Button btn = new Button(texto);


btn.setPrefSize(50, 50);
btn.setStyle("-fx-background-color: #E6E6F2; -fx-text-fill:white; -ft-background-radius:5px; -fx-cursor: hand;");

btn.setOnMousePressed(e ->{
btn.setStyle("-fx-background-color: #E6E6F2;");
btn.setTranslateY(2);
});
btn.setOnMouseReleased(e ->{
btn.setStyle("-fx-background-color: #E1E1EB;");
btn.setTranslateY(0);
});

//configuracion de boton
//tamaño, el estilo, sus fuciones
return btn;
}

}