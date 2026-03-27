package com.mscfceddisiytem.maquinadeturing;

import java.util.*;

public class MaquinaTuring {

    private List<Character> cinta;
    private int cabezal;
    private String estadoActual;
    private Set<String> estadosFinales;
    private List<Transicion> transiciones;

    public MaquinaTuring(String entrada) {
        cinta = new ArrayList<>();
        for (char c : entrada.toCharArray()) {
            cinta.add(c);
        }
        cinta.add('_');
        cabezal = 0;
        estadoActual = "q0";
        estadosFinales = new HashSet<>();
        transiciones = new ArrayList<>();
    }

    public void agregarEstadoFinal(String estado) {
        estadosFinales.add(estado);
    }

    public void agregarTransicion(Transicion t) {
        transiciones.add(t);
    }

    public String ejecutar() {
        while (!estadosFinales.contains(estadoActual)) {

            char simbolo = cinta.get(cabezal);
            boolean encontrado = false;

            for (Transicion t : transiciones) {
                if (t.estadoActual.equals(estadoActual) && t.simboloLeido == simbolo) {

                    cinta.set(cabezal, t.simboloEscrito);
                    estadoActual = t.nuevoEstado;

                    if (t.direccion == 'R') {
                        cabezal++;
                        if (cabezal == cinta.size()) cinta.add('_');
                    } else {
                        cabezal--;
                        if (cabezal < 0) {
                            cinta.add(0, '_');
                            cabezal = 0;
                        }
                    }

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                return "Error: no hay transición válida";
            }
        }

        return "Resultado: " + obtenerCinta();
    }

    private String obtenerCinta() {
        StringBuilder sb = new StringBuilder();
        for (char c : cinta) {
            sb.append(c);
        }
        return sb.toString();
    }
}