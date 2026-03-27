package com.mscfceddisiytem.maquinadeturing;

public class Transicion {
    String estadoActual;
    char simboloLeido;
    String nuevoEstado;
    char simboloEscrito;
    char direccion;

    public Transicion(String estadoActual, char simboloLeido, String nuevoEstado, char simboloEscrito, char direccion) {
        this.estadoActual = estadoActual;
        this.simboloLeido = simboloLeido;
        this.nuevoEstado = nuevoEstado;
        this.simboloEscrito = simboloEscrito;
        this.direccion = direccion;
    }
}