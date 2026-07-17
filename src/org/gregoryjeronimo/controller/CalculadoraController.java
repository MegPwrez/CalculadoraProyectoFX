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
        if (entrada.equals("C")) {
            opcion1 = "";
            operador = "";
            opcion2 = "";
            pant.setText("");
            return;
        }

        // si ya se completo el calculo // reiniciar
        if (calculoTerminado && entrada.matches("[0-9]")) {
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
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }
            actualizarPantalla(pant);
        } 
        else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("/") || entrada.equals("^")) { 
            operador = entrada;
            actualizarPantalla(pant);
        } 
     
        // Porcentaje 
        else if (entrada.equals("%")) {
            if (!opcion2.isEmpty()) {
                opcion2 = resultadoPorcentaje(opcion2);
            } else if (!opcion1.isEmpty()) {
                opcion1 = resultadoPorcentaje(opcion1);
            }
            actualizarPantalla(pant);
        } 
        // Raíz cuadrada 
        else if (entrada.equals("√") || entrada.equalsIgnoreCase("sqrt")) {
            if (!opcion2.isEmpty()) {
                opcion2 = resultadoRaizCuadrada(opcion2);
            } else if (!opcion1.isEmpty()) {
                opcion1 = resultadoRaizCuadrada(opcion1);
            }
            actualizarPantalla(pant);
        }
        else if (entrada.equals("=")) {
            if (opcion1.isEmpty() || opcion1.equals("Error")) {
                return;
            }

            
            if (opcion2.isEmpty()) {
                opcion2 = opcion1;
            }

            if (operador.equals("+")) {
                opcion1 = resultadoSuma(opcion1, opcion2);
            } else if (operador.equals("-")) {
                opcion1 = resultadoResta(opcion1, opcion2);
            } else if (operador.equals("*")) {
                opcion1 = resultadoMultiplicacion(opcion1, opcion2);
            } else if (operador.equals("/")) {
                opcion1 = resultadoDivision(opcion1, opcion2);
            } else if (operador.equals("^")) {
                opcion1 = resultadoPotencia(opcion1, opcion2);
            } 

            operador = "";
            opcion2 = "";
            calculoTerminado = true;
            actualizarPantalla(pant);
        }
    }

    private void actualizarPantalla(Label pantalla) {
        if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }

    // Suma
    private String resultadoSuma(String numeroUno, String numeroDos) {
        if (numeroUno.isEmpty() || numeroUno.equals("Error")) numeroUno = "0";
        if (numeroDos.isEmpty() || numeroDos.equals("Error")) numeroDos = "0";
        double suma = Double.parseDouble(numeroUno) + Double.parseDouble(numeroDos);
        return formatearResultado(suma);
    }

    // Resta
    private String resultadoResta(String numeroUno, String numeroDos) {
        if (numeroUno.isEmpty() || numeroUno.equals("Error")) numeroUno = "0";
        if (numeroDos.isEmpty() || numeroDos.equals("Error")) numeroDos = "0";
        double resta = Double.parseDouble(numeroUno) - Double.parseDouble(numeroDos);
        return formatearResultado(resta);
    }

    // Multiplicación
    private String resultadoMultiplicacion(String numeroUno, String numeroDos) {
        if (numeroUno.isEmpty() || numeroUno.equals("Error")) numeroUno = "0";
        if (numeroDos.isEmpty() || numeroDos.equals("Error")) numeroDos = "1";
        double multiplicacion = Double.parseDouble(numeroUno) * Double.parseDouble(numeroDos);
        return formatearResultado(multiplicacion);
    }

    // División
    private String resultadoDivision(String numeroUno, String numeroDos) {
        if (numeroUno.isEmpty() || numeroUno.equals("Error")) numeroUno = "0";
        if (numeroDos.isEmpty() || numeroDos.equals("Error") || Double.parseDouble(numeroDos) == 0) {
            return "Error";
        }
        double division = Double.parseDouble(numeroUno) / Double.parseDouble(numeroDos);
        return formatearResultado(division);
    }

    // Potencia 
    private String resultadoPotencia(String numeroUno, String numeroDos) {
        if (numeroUno.isEmpty() || numeroUno.equals("Error")) return "0";
        if (numeroDos.isEmpty() || numeroDos.equals("Error")) return numeroUno;
        
        try {
            double base = Double.parseDouble(numeroUno);
            double exponente = Double.parseDouble(numeroDos);
            double potencia = Math.pow(base, exponente);
            return formatearResultado(potencia);
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

    // Raíz cuadrada
    private String resultadoRaizCuadrada(String numero) {
        if (numero.isEmpty() || numero.equals("Error")) return "0";
        
        try {
            double dato = Double.parseDouble(numero);
            if (dato < 0) {
                return "Error"; 
            }
            double raiz = Math.sqrt(dato);
            return formatearResultado(raiz);
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

    // Porcentaje
    private String resultadoPorcentaje(String numero) {
        if (numero.isEmpty() || numero.equals("Error")) return "0";
        
        try {
            double dato = Double.parseDouble(numero);
            double porcentaje = dato / 100.0;
            return formatearResultado(porcentaje);
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

    // Cambio de signo
    private String cambioDeSigno(String numero) {
        if (numero.isEmpty() || numero.equals("Error")) return "0";
        
        try {
            double dato = Double.parseDouble(numero);
            dato = dato * -1;
            return formatearResultado(dato);
        } catch (NumberFormatException e) {
            return "Error";
        }
    }

    // Método auxiliar para limpiar formatos decimales innecesarios (.0) y capturar errores de desbordamiento
    private String formatearResultado(double resultado) {
        if (Double.isNaN(resultado) || Double.isInfinite(resultado)) {
            return "Error";
        }
        if (resultado % 1 == 0) {
            return String.valueOf((long) resultado);
        }
        return String.valueOf(resultado);
    }
}


