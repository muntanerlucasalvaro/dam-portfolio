//NOMBRE:ÁLVARO MUNTANER LUCAS
//FECHA: 02/12/2025
package es.cide.programacio;

import java.util.Random;

public class Obstacle {
    // RANDOM
    Random ra = new Random();
    // ATRIBUTOS
    private String[] llistaTipus={"Seto","Barra","Valla"};//Lista de tipos posibles.
    private String tipus;//Tipo del obstaculo
    private int dificultat;//Dificultad del obstaculo
    private int i;//Indice aleatorio para seleccionar el tipo.

    // CONSTRUCTOR
    public Obstacle() {
        i = ra.nextInt(3);//Numero aleatorio del 0-1
        this.tipus = llistaTipus[i];//Asignación de tipo
        this.dificultat = ra.nextInt(1, 8);//Dificultad aleatoria entre 1 y 7.
    }

    // SETTERS Y GETTERS
    public void setDificultat(int dificultat) {
        this.dificultat = dificultat;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getDificultat() {
        return dificultat;
    }

    public String getTipus() {
        return tipus;
    }
}
