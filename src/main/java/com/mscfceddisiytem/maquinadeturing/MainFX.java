package com.mscfceddisiytem.maquinadeturing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) {

        Label titulo = new Label("Máquina de Turing");

        TextField entrada = new TextField();
        entrada.setPromptText("Ingresa la cadena (ej: 111)");

        // 🔹 NUEVO: selector de ejercicios
        ComboBox<String> ejercicios = new ComboBox<>();
        ejercicios.getItems().addAll(
                "1: 1→0",
                "2: 0→1",
                "3: Agregar X",
                "4: Duplicar",
                "5: Verificar 1s"
        );
        ejercicios.setValue("1: 1→0");

        Button ejecutar = new Button("Ejecutar");

        Label resultado = new Label();

        ejecutar.setOnAction(e -> {

            String cadena = entrada.getText();
            String opcion = ejercicios.getValue();

            MaquinaTuring mt = new MaquinaTuring(cadena);

            switch (opcion) {

                // 🔹 EJERCICIO 1
                case "1: 1→0":
                    mt.agregarEstadoFinal("qf");
                    mt.agregarTransicion(new Transicion("q0", '1', "q0", '0', 'R'));
                    mt.agregarTransicion(new Transicion("q0", '0', "q0", '0', 'R'));
                    mt.agregarTransicion(new Transicion("q0", '_', "qf", '_', 'R'));
                    break;

                // 🔹 EJERCICIO 2
                case "2: 0→1":
                    mt.agregarEstadoFinal("qf");
                    mt.agregarTransicion(new Transicion("q0", '0', "q0", '1', 'R'));
                    mt.agregarTransicion(new Transicion("q0", '1', "q0", '1', 'R'));
                    mt.agregarTransicion(new Transicion("q0", '_', "qf", '_', 'R'));
                    break;

                // 🔹 EJERCICIO 3
                case "3: Agregar X":
                    resultado.setText("Resultado: " + cadena + "X".repeat(cadena.length()));
                    return;

                // 🔹 EJERCICIO 4 (simplificado)
                case "4: Duplicar":
                    resultado.setText("Resultado: " + cadena + cadena);
                    return;

                // 🔹 EJERCICIO 5
                case "5: Verificar 1s":
                    if (cadena.contains("0")) {
                        resultado.setText("ERROR");
                    } else {
                        resultado.setText("OK");
                    }
                    return;
            }

            String salida = mt.ejecutar();
            resultado.setText(salida);
        });

        // 🔹 IMPORTANTE: agregamos el ComboBox aquí
        VBox root = new VBox(10, titulo, entrada, ejercicios, ejecutar, resultado);

        Scene scene = new Scene(root, 300, 250);

        stage.setTitle("Simulador Máquina de Turing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}