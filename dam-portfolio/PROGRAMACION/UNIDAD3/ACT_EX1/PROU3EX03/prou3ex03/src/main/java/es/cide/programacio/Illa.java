//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;
import java.util.Random;

public class Illa {

    // ATRIBUTOS
    private Random ra = new Random(); //Random para generar valores aleatorios.
    private String[] insults; //Array con todos los insultos posibles de los piratas.
    private String[] respostes; //Array con todas las respuestas posibles que puede usar el heroe.
    private int longitudIsla; //Numero de piratas que tendra la isla.
    private Pirata[] pirataList = new Pirata[longitudIsla]; //Array que almacena y genera los piratas de la isla.

    // CONSTRUCTOR
    public Illa(String[] insults, String[] respostes) { //Constructor de la isla (los insultos y respuestas por parametros).
        this.insults = insults; //Guardamos el array de insultos.
        this.respostes = respostes; //Guardamos el array de respuestas.
        this.longitudIsla = ra.nextInt(2, 8); //Generamos aleatoriamente el numeri piratas tendrá la isla (entre 2 y 7).
        this.pirataList = new Pirata[longitudIsla]; //Inicializamos el array de piratas con el tamaño elegido.

        for (int i = 0; i < pirataList.length; i++) { //Bucle para generar cada pirata de la isla.
            Pirata nuevoPirata = new Pirata(insults, respostes); //Genero un nuevo pirata con los insultos y respuestas.
            pirataList[i] = nuevoPirata; //Guardo el pirata en el array de piratas con la posicion del indice.
        }
    }

    // GETTER
    public int getLongitudIsla() { //Metodo para obtener el numero de piratas de la isla.
        return longitudIsla; //Devuelvo la longitud de la isla.
    }

    // METODO
    public Pirata vullUnPirata(int indice) { //Metodo para devolver un pirata concreto según el índice.
        return pirataList[indice]; //Retornamos el pirata en la posición indicada.
    }
}
