package es.cide.programacio;

import java.util.Random;

public class Obstacle {
Random ra= new Random();//RANDOM
//Atributos
private String[] llistaTipus ={"Pedra","Forat","Mur", "Barranc", "Rampa"};//Guardamos los posibles tipos de obstaculo en una lista
private String tipus;//Tipo de obstaculo de ese objeto.
private int indiceTipos;//indice para determinar el tipo de obstaculo
private int dificultat;//Dificultad del obstaculo.
//METODOS
//Constructor
public Obstacle(int indiceTipos) {//Constructor al que le pasaremos un numero entero indice por parametros.
    this.indiceTipos=indiceTipos;
    this.tipus = llistaTipus[indiceTipos];//Asignamos al tipo concreto de ese objeto, uno de la lista de tipos segun la posicion indicada por el indice.
    this.dificultat = ra.nextInt(1,11);//Asignamos una dificultad aleatoria de entre 1 y 10 puntos al obstaculo.
}
//Getters y setter
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
//Otros metodos
}