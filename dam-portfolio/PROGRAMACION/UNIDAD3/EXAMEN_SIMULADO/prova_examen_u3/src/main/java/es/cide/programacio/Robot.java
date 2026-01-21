package es.cide.programacio;

public class Robot {
//Atributos
private String nom;//Creamos una variable nom para el nombre del robot.
private int energia;//Creamos una variable energia para su "Vida".
private int força;//Creamos una variable fuerza.
private boolean carregat = true;//Creamos una variable para saber si el robot tiene o no energia.
//METODOS
//Constructor
public Robot(String nom,int energia,int força) {
    this.nom = nom;
    this.energia = energia;
    this.força=força;
}
//Getters y setters
public void setNom(String nom) {
    this.nom = nom;
}
public void setForça(int força) {
    this.força = força;
}
public void setEnergia(int energia) {
    this.energia = energia;
}
public String getNom() {
    return nom;
}
public int getForça() {
    return força;
}
public int getEnergia() {
    return energia;
}
//Otros metodos
public boolean superarObstaculo(Obstacle o) {//Creamos un metodo para superar obstaculos que ha de devolver el estado de con bateria o sin bateria del robot segun la energia de este. Para ello le hemos de pasar por parametros un obstaculo (ha de reducir la energia del robot en funcion de la dificultad del obstaculo).
    energia -= o.getDificultat() * 2;
    if (energia<=0) {
        carregat = false;
    }
    return carregat;
}
}
