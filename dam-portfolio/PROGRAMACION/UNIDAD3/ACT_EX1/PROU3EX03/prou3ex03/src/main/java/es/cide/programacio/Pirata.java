//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Random;
import java.util.Scanner;

public class Pirata {

    // ATRIBUTOS
    private int a, b, c, x; //Variables para elegir insultos aleatorios y el orden de respuestas.
    private int u = -1; //Variable para controlar la repetición de insultos(Los propios del pirata).
    private int h = -1; //Variable para controlar la repetición de insultos(Los propios del pirata).
    private Random ra = new Random(); //Inicializamos el Random.
    private String[] nomList = { "Hugo Verdugo", "Mateo Teveo", "Dani Pani", "Álvaro Mango", "Francho Pancho",
            "El Quijote", "Pepa pig" }; //Lista de nombres para pirata.
    private int vida; //Vida del pirata.
    private String nom; //Nombre del pirata.
    private boolean viu = true; //Booleano para indicar si el pirata sigue vivo.
    private String[] insultsPirata = new String[3]; //Array con los 3 insultos propios de este pirata.
    private String[] insults; //Array con todos los posibles insultos del juego.
    private String[] respostes; //Array con todas las posibles respuestas del héroe.

    // CONSTRUCTOR
    public Pirata(String[] insults, String[] respostes) {
        this.respostes = respostes; //Guardamos el array de respuestas.
        int z = ra.nextInt(7); //Elegimos un numero aleatorio para el nombre del pirata.
        this.nom = nomList[z]; //Asignamos un nombre aleatorio al pirata.
        this.vida = ra.nextInt(3) + 1; //Asignamos aleatoriamente 1, 2 o 3 vidas al pirata.
        this.insults = insults; //Guardamos el array de insultos.
        this.a = ra.nextInt(5); //Elegimos aleatoriamente la primera respuesta correcta.
        this.b = ra.nextInt(5); //Elegimos aleatoriamente la segunda respuesta y repetimos hasta que no coincida con la primera.
        while (a == b) { 
            b = ra.nextInt(5);
        }
        this.c = ra.nextInt(5); //Elegimos aleatoriamente la tercera respuesta y repetimos hasta que no coincida con la primera ni con la segunda.
        while (b == c || a == c) { 
            c = ra.nextInt(5);
        }
        this.insultsPirata[0] = insults[a]; //Guardamos el primer insulto propio del pirata.
        this.insultsPirata[1] = insults[b]; //Guardamos el segundo insulto propio del pirata.
        this.insultsPirata[2] = insults[c]; //Guardamos el tercer insulto propio del pirata.
    }

    //GETTERS Y SETTERS
    public void setNom(String nom) { //Setter para cambiar el nombre del pirata.
        this.nom = nom;
    }

    public String getNom() { //Getter para obtener el nombre del pirata.
        return nom;
    }

    //METODOS
    public String insultar() { //Metodo para que el pirata insulte.
        x = ra.nextInt(3); //Elegimos aleatoriamente uno de los 3 insultos.
        while (u == x || h == x) { //Evitamos repetir el insulto anterior o el penúltimo (este while nunca entra en la primera rotacion).
            x = ra.nextInt(3); //Generamos de nuevo hasta que sea diferente.
        }
        h = u; //Guardamos el insulto que tenia la u en al final del ciclo.
        u = x; //Guardamos el insulto que tenia la x en al final del ciclo.
        System.out.println(insultsPirata[x]); //Imprimimos el insulto elegido.
        return insultsPirata[x]; //devolvemos el insulto.
    }

    public boolean replica(String respuestaSeleccionada) { //Metodo para valorar si la respuesta del heroe.
        switch (x) {//Insulto impreso
            case 0:
                if (respuestaSeleccionada.equals(respostes[a])) { //Si coincide con la respuesta correcta.
                    System.out.println("CORRECTO"); //Correcto.
                    return true; //Retornamos true.
                } else {
                    System.out.println("INCORRECTO"); //Si no coincide es incorrecto.
                    return false; //Retornamos false.
                }
            case 1:
                if (respuestaSeleccionada.equals(respostes[b])) { // Comprobación para el segundo insulto.
                    System.out.println("CORRECTO");//Correcto.
                    return true;//Retornamos true.
                } else {
                    System.out.println("INCORRECTO");//Si no coincide es incorrecto.
                    return false;//Retornamos false.
                }
            case 2:
                if (respuestaSeleccionada.equals(respostes[c])) { // Comprobación para el tercer insulto.
                    System.out.println("CORRECTO");//Correcto.
                    return true;//Retornamos true.
                } else {
                    System.out.println("INCORRECTO");//Si no coincide es incorrecto.
                    return false;//Retornamos false.
                }
            default:
                return true;
        }
    }

    public boolean vida() { //Metodo para restar vida al pirata.
        vida--; //Restamos una vida.
        if (vida > 0) { //Si aun tiene vida.
            this.viu = true; //Sigue vivo.
        } else { //Si no tiene vidas.
            this.viu = false; //Muere.
        }
        return viu; //Retornamos si sigue vivo o no.
    }
}
