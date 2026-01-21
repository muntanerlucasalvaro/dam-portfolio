//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Scanner;
import java.util.Random;

public class Guybrush extends Heroi {
    // ATRIBUTOS
    Random ra = new Random();
    private String[] opcionsResp = new String[4];//Creo un array de string con las 4 opciones de respuesta que tiene Guybrush ya que solo dispone de la mitad de las totales.

    // CONSTRUCTOR
    public Guybrush(String nom, int vida, String[] respostes) {
        super(nom, vida, respostes);// Atributos heredados de la clase heroi.
        this.nom = "Guybrush Threepwood";// Asigno el nombre de Guybrush.
    }

    // METODOS
    @Override
    public void defensar() {//Metodo para defenderse del pirata.
        System.out.println("Selecciona una respuesta con la que defenderte, pirata:");
        System.out.println();
        int puntInici = ra.nextInt(respostes.length);// Escojo aleatoriamente un punto de inicio del array de respuestas general.
        for (int j = 0; j < 4; j++) {//Hago un for que repita 4 veces (una vez por respuesta de Guybrush).
            if (puntInici >= respostes.length) {// Si me salgo fuera del arrya de las respuestas.
                puntInici = 0;//Vuelvo a la primera.
            }
            opcionsResp[j] = respostes[puntInici];// Guardamos la respuesta ha salido en las opciones de respuesta de guybrush.
            puntInici++;// Avanzamos el punto inicio en 1 para pasar a la siguiente respuesta.
        }
        for (int i = 0; i < opcionsResp.length; i++) {// Hacemos un for que recorra el array de las opciones de respuesta para guybrush.
            System.out.println((i + 1) + ". " + opcionsResp[i]);// Las imprimimos 1 a 1.
        }
        int seleccioUsuari;// Creamos una variable para la selleccion del user.
        do {
            System.out.print("Tu elección: ");
            seleccioUsuari = sc.nextInt();
            if (seleccioUsuari < 1 || seleccioUsuari > 4) {// Comprobador de que pone un numero entre (1-4)
                System.out.println("ERROR: LA RESPUESTA SELECCIONADA NO ES VÁLIDA.");// mensaje de error
                System.out.println("VUELVA A INTRODUCIR LA RESPUESTA:");
            }
        } while (seleccioUsuari < 1 || seleccioUsuari > 4);
        int indexEscollit = seleccioUsuari - 1;// Asignamos la seleccion.
        this.respuestaSeleccionada = opcionsResp[indexEscollit];// Guardamos en respuesta seleccionada directamente el String de opcionResp que se haya elegido.
    }
    @Override
    public boolean vida() { // Metodo para restar vida a Guybrush.
        this.vida = vida - 2; // Restamos 2 puntos de vida.
        if (vida > 0) { // Si aun le queda vida.
            this.viu = true; // Sigue vivo.
        } else { // Si no.
            this.viu = false; // Muere.
        }
        return viu; // Devolvemos el estado del heroe.
    }

    @Override
    public void sayHello() {
        System.out.println("¡Hola! Soy Guybrush Threepwood y vengo a convertirme en un pirata.");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("¿Qué le dice un pirata a otro? ¡Nada, porque ya me voy! ¡Adiós!");
    }
}