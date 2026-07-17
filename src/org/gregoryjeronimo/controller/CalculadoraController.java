package org.gregoryjeronimo.controller;

import javafx.scene.control.Label;

public class CalculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = true;

    public CalculadoraController() {
    }

    public void procesoDeEntrada(String entrada, Label pant) {
        if (entrada.equals("C")){
              opcion1 = "";
              operador = "";
              opcion2 = "";
              pant.setText("");
        }
        
        // si ya se completo el calculo // reiniciar
        if ( calculoTerminado && entrada.matches("[0-9]")){
              opcion1 = "";
              operador = "";
              opcion2 = "";
        }
        calculoTerminado = false;
//       if (calculoTerminado){
//        opcion1 = "";
//        operador = "";
//        opcion2 = "";
//       }
        if (entrada.matches("[0-9]")) {
            if  (operador.isEmpty()){
               opcion1 += entrada;
        }else {
            opcion2 += entrada;}
            
            actualizarPantalla(pant); // Pasamos la pantalla correcta
        } else if (entrada.equals("+")) { // Usamos equals en vez de regex con comillas
            operador = entrada;
            actualizarPantalla(pant);
            
        } else if (entrada.equals("=")){
        if(operador.equals("+")){
         opcion1 = resultadoSuma(opcion1, opcion2);
          operador = "";
        opcion2 = "";
         calculoTerminado = false;
        }
        
            actualizarPantalla(pant);
        }
    }

    private void actualizarPantalla(Label pantalla) {
            if (operador.isEmpty()) {
                pantalla.setText(opcion1);
            } else {
                pantalla.setText(opcion1 + " " + operador+ " "+opcion2 );
            }
        }
    private String resultadoSuma(String numeroUno, String numeroDos){
         String resultado;
         int datoUno = Integer.parseInt(opcion1);
         int datoDos = Integer.parseInt(opcion2);
         int suma =datoUno + datoDos;
       
        return  resultado = String. valueOf(suma);
    }
    }
