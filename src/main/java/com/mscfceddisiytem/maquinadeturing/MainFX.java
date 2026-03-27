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

        Button ejecutar = new Button("Ejecutar");

        Label resultado = new Label();

        ejecutar.setOnAction(e -> {
            String cadena = entrada.getText();

            MaquinaTuring mt = new MaquinaTuring(cadena);
            mt.agregarEstadoFinal("qf");

            // Transiciones de ejemplo
            mt.agregarTransicion(new Transicion("q0", '1', "q0", '0', 'R'));
            mt.agregarTransicion(new Transicion("q0", '_', "qf", '_', 'R'));

            String salida = mt.ejecutar();
            resultado.setText(salida);
        });

        VBox root = new VBox(10, titulo, entrada, ejecutar, resultado);

        Scene scene = new Scene(root, 300, 200);

        stage.setTitle("Simulador Máquina de Turing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
