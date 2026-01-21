//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Inicializamos el Scanner.
        boolean on = true; //Booleano para mantener el juego en marcha.

        while (on == true) { //Mientras on == true, seguimos ejecutando.

            //Array de insultos de los piratas.
            String[] insults = {
                    "¡Llevarás mi espada como si fueras un pincho moruno!",
                    "¡Luchas como un granjero!",
                    "¡No hay palabras para describir lo asqueroso que eres!",
                    "¡He hablado con simios más educados que tu!",
                    "¡No pienso aguantar tu insolencia aquí sentado!"
            };

            //Array de posibles respuestas del héroe.
            String[] respostes = {
                    "Primero deberías dejar de usarla como un plumero.",
                    "Qué apropiado, tú peleas como una vaca.",
                    "Sí que las hay, sólo que nunca las has aprendido.",
                    "Me alegra que asistieras a tu reunión familiar diaria.",
                    "Ya te están fastidiando otra vez las almorranas, ¿Eh?"
            };

            String respuestaSeleccionada; //Variable para almacenar la respuesta elegida por el héroe.

            System.out.println("Bienvenido a The secret of the Monkey Island."); //Mensaje de bienvenida.
            System.out.println(); // Línea en blanco para estética.
            System.out.println("Antes de empezar, indique un nombre para su heroe:"); //Pedimos nombre del heroe al usuario.
            String nombreHeroe = sc.nextLine();
            System.out.println();
            System.out.println("¡Hola, " + nombreHeroe + "!, Ahora te enfrentarás a varios piratas para convertirte en el rey de la isla, Mucha suerte."); //explicacion breve.
            System.out.println();

            Heroi h = new Heroi(nombreHeroe, respostes); //Generamos el heroe.
            Illa i = new Illa(insults, respostes); //Creamos la isla con piratas.

            int longitudIsla = i.getLongitudIsla(); //Obtenemos el numero de piratas en la isla (la longitud).

            boolean hViu = true; //Booleano para controlar si el heroe está vivo.

            //BUCLE DE PIRATAS
            for (int indiceIlla = 0; indiceIlla < longitudIsla; indiceIlla++) { //For para recorrer el array de piratas.
                if (hViu) { //Solo entramos en el combate si el heroe esta vivo.

                    boolean pViu = true; //Booleano para controlar que el pirata sigue vivo.
                    Pirata p = i.vullUnPirata(indiceIlla); //Obtenemos el pirata actual.
                    String nomPirata = p.getNom(); //Guardamos el nombre del pirata con el getter.
                    int numeroEnemigo = indiceIlla + 1; //Numero de enemigo para mostrar por pantalla.
                    int vidaHeroe= h.getVida(); //Guardamos el numero de vidas que le quedan al heroe.

                    System.out.println("ENEMIGO: " + numeroEnemigo); //Indicamos el numero de enemigo al que se enfrenta.
                    System.out.println("Ahora te enfrentaras contra el pirata " + nomPirata); //Mostramos nombre del pirata.
                    System.out.println();
                    System.out.println("Te quedan "+vidaHeroe+ " vidas");//Muestro las vidas que le quedan al heroe.
                    System.out.println("INSULTO:");

                    //COMBATE
                    while (pViu && hViu) { //Se ejecuta mientras el pirata y el heroe esten vivos.
                        p.insultar(); //Metodo para insultar.
                        respuestaSeleccionada = h.defensar(); //El heroe elige una respuesta con el metodo defensar.

                        if (p.replica(respuestaSeleccionada) == true) { //Evaluamos si el heroe ha acertado la respuesta.
                            pViu = p.vida(); //Aplicamos el metodo vida al pirata si se acierta la respuesta.
                        } else {
                            hViu = h.vida(); //Aplicamos el metodo vida al heroe si se falla la respuesta.
                        }
                    } 

                    if (pViu == false) { //Si el pirata muere.
                        System.out.println("Has matado al pirata " + nomPirata + "."); //Avisamos al jugador.
                    }

                    if (hViu == false) { //Si el heroe muerre.
                        System.out.println("HAS MUERTO EN BATALLA."); //Mensaje de derrota.
                        on = false; //Termina el juego.
                    }

                } 
            }

            //CUANDO SE ACABA LA ISLA (SE RECORRE EL fOR DE LA LONGITUD DE LA ISLA)
            if (on == true) { //Si el heroe sigue vivo.
                System.out.println("ENHORABUENA " + nombreHeroe + " HAS CONQUISTADO LA ISLA."); //Mensaje de victoria.
                on = false; //Termina el juego.
            }

        } //Fin while del on.

        sc.close();
    }
}
