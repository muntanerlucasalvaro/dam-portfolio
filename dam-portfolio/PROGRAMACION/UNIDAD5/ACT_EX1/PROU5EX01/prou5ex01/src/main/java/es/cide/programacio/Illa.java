//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Random;

public class Illa {
    // ATRIBUTOS
    Random ra = new Random();
    private Pirata[] pirataList;// Creo un array de piratas llamado piratalist.
    private int longitudIsla = ra.nextInt(2, 8); // Generamos aleatoriamente el numeri de piratas tendrá la isla (entre 2 y 7).

    // CONSTRUCTOR
    public Illa(String[] insults, String[] respostes) {// Hacemos el constructor de la isla y le pasamos por parametros los insultos y las respuestas.
        this.pirataList = new Pirata[longitudIsla];// Creamos el array de piratas en funcion del tamaño de la isla.
        int tamanyNormal = insults.length - 1;// Creamos un tamaño normal (para definir la cantidad de insultos que tendran los piratas de tipo normal soea todos menos Lechuck)

        for (int i = 0; i < pirataList.length; i++) {// Recorremos el array de piratalist.
            if (i == pirataList.length - 1) {// si es la ultima casilla del array.
                pirataList[i] = new PirataLeChuck("LeChuck", 3, insults, respostes);//Creamos un lechuck
            } else {//Si no es la ultima casilla del array
                String[] insultsNormales = new String[tamanyNormal];//Creamos un nuevo array de insultos limitado al tamaño "normal" (todos los insultos - el ultimo que es el paerticular de Lechuck).
                String[] respostesNormales = new String[tamanyNormal];//Creamos un nuevo array de respuestas limitado al tamaño "normal" (todos los insultos - el ultimo que es el paerticular de Lechuck).

                for (int j = 0; j < tamanyNormal; j++) {// hacemos un bucle for que recorra los insultos de los piratas normales.
                    insultsNormales[j] = insults[j];// Rellenamos el arrays de insultos normales con los insultos del array general.
                    respostesNormales[j] = respostes[j];// Rellenamos el array de respuestas normales con las respuestas del array general.
                }
                pirataList[i] = new PirataNormal("Pirata ", 2, insultsNormales, respostesNormales);// Generamos un pirata normal con los insultos y las respuestas limitadas.
            }
        }
    }
    // GETTERS Y SETTERS
    public int getLongitudIsla() {// Metodo para sacar la longitud de la isla.
        return pirataList.length;
    }

    // METODOS
    public Pirata vullUnPirata(int i) {// Metodo para sacar un pirata concreto.
        return pirataList[i];
    }
}