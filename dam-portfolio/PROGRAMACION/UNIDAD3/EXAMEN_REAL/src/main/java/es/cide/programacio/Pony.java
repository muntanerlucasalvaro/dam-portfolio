//NOMBRE:ÁLVARO MUNTANER LUCAS
//FECHA: 02/12/2025
package es.cide.programacio;

import java.util.Random;

public class Pony {
    // RANDOM
    Random ra = new Random();
    // ATRIBUTOS
    private String nom;//Variable String para el nombre del pony.
    private int energia;//Variable int para la energia del pony.
    private int força;//Variable int para la fuerza de pony.

    // CONSTRUCTOR
    public Pony(String nom, int energia){//Creamos un constructor y le pasamos el nombre, y la energia por parametros.
        this.nom=nom;
        this.energia=energia;
        this.força=ra.nextInt(1,6);//Generamos un numero entero aleatorio entre 1 y 5 para la fuerza de nuestro pony.
    }

    // SETTERS Y GETTERS
    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setForça(int força) {
        this.força = força;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEnergia() {
        return energia;
    }

    public int getForça() {
        return força;
    }

    public String getNom() {
        return nom;
    }

    // OTROS METODOS
    public boolean superarObstacle(Obstacle o) {//Creamos el metodo superarObstacle (le pasamos un obstaculo por parametros).
        if (força > o.getDificultat() && energia>0) {//Si la fuerza del pony es suficiente para superar el obstaculo y la energia del pony es mayor a 0.
            energia = energia - (o.getDificultat() / 2);//Reducimos la energia en función de la mitad de la dificultad del obstaculo.
            return true;//Devolvemos que el pony SI ha superado el obstaculo "true"
        } else {//Si el pony no tiene suficiente fuerza o no tiene energia.
            energia = energia - (o.getDificultat() / 2);//Reducimos la energia en función de la mitad de la dificultad del obstaculo.
            return false;//Devolvemos que el pony NO ha superado el obstaculo "true"
        }
    }
}
