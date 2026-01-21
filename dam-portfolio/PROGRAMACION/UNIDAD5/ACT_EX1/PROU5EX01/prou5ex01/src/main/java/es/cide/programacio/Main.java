//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //VARIABLES 
        String[] res = {// Array de strings con las respuestas originales y añadida la de LeChuck
                "Primero deberías dejar de usarla como un plumero.",
                "Qué apropiado, tú peleas como una vaca.",
                "Sí que las hay, sólo que nunca las has aprendido.",
                "Me alegra que asistieras a tu reunión familiar diaria.",
                "Ya te están fastidiando otra vez las almorranas, ¿Eh?",
                "Si no cuentas todos con los que has salido" // Respuesta al insulto de LeCkuck
        };

        String[] ins = {// Array de strings con los insultos originales y añadida la de LeChuck.
                "¡Llevarás mi espada como si fueras un pincho moruno!",
                "¡Luchas como un granjero!",
                "¡No hay palabras para describir lo asqueroso que eres!",
                "¡He hablado con simios más educados que tu!",
                "¡No pienso aguantar tu insolencia aquí sentado!",
                "Eres el monstruo más horrible que ha creado Davy Jones" // Insulto de LeChuck.
        };
        //INICIO
        System.out.println("Bienvenido a The secret of the Monkey Island."); // Mensaje de bienvenida.
        System.out.println(); // Línea en blanco para estética.
        //SELECCION ELAINE  o GUYBRUSG
        System.out.println("¿QUE PJ QUIERES UTILIZAR? 1. Guybrush / 2. Elaine");
        int opcionHeroi = sc.nextInt(); // recogemos la seleccion del usuario,.
        Guybrush g = null; //Inicializamos el guybrush.
        Elaine e = null;// Inicializamos a elaine.
        while (opcionHeroi<1||opcionHeroi>2) {// mientras la selecion no sea 1 o 2.
            System.out.println("ERROR: LA RESPUESTA SELECCIONADA NO ES VÁLIDA.");// mensaje de error
            System.out.println("VUELVA A INTRODUCIR LA RESPUESTA:");
            System.out.print("Tu elección: ");
            opcionHeroi = sc.nextInt();//Introducimos de nuevo
        }
        if (opcionHeroi == 1) {// Si se escoge a Guybrush.
            g = new Guybrush("Guybrush", 10, res);// Creamos un Guybrush.
            System.out.println("¡Hola, Guybrush!, Ahora te enfrentarás a varios piratas para convertirte en el rey de la isla, Mucha suerte."); //explicacion breve para Guybrush.
            System.out.println();
            g.sayHello();// Saludo de Guybrush
        } else  if (opcionHeroi == 2){// Si se escoge a Elaine.
            e = new Elaine("Elaine", 10, res);// Creamos una Elaine
             System.out.println("¡Hola, Elaine!, Ahora te enfrentarás a varios piratas para convertirte en la reina de la isla, Mucha suerte."); //explicacion breve para Elaine.
            System.out.println();
            e.sayHello();// Saludo de Elaine
        }
        //ISLA
        Illa isla = new Illa(ins, res);//Generamos la isla y le pasamos los insultos y las respuestas.
        int comptadorPirates = 0; //Creamos un contador de pirata para limitar el while principal del juego.
        boolean heroiMort = false; // Booleano para controlar si el heroe esta o no muerto.
        //BUCLE PRINCIPAL
        while (comptadorPirates < isla.getLongitudIsla() && !heroiMort) {//Mientras el contador de piratas sea menor que el tamaño del array de la isla y el heroe este vivo.
            Pirata pirataActual = isla.vullUnPirata(comptadorPirates);//Sacamos un pirata de la isla segun la iteracioon en la que estemos.
            System.out.println();
            System.out.println("TE ENFRENTAS A: " + pirataActual.getNom());//Enseñamos contra quien nos vamos a enfrentar.
            System.out.println();
            pirataActual.sayHello();
        //PELEA
            while (pirataActual.getVida() > 0 && !heroiMort) {//Mientras la vida del pirata sea mayor a 0 y el heroe no este muerto.
                pirataActual.insultar(); // El pirata insulta.

                if (opcionHeroi == 1) {//Si usamos a GuyBrush.
                    g.defensar(); // Defensar de guybrush.
                    if (pirataActual.replica(g.getRespuestaSeleccionada())==true) {//Hacemos el metodo replica del pirata actual con la respuesta seleccionada de guybrush, si da True (acertamos).
                        System.out.println("CORRECTO");
                        pirataActual.vida(); // Bajamos la vida del pirata.
                    } else {//Si replica devuelve false (significa que fallamos).
                        System.out.println("FALLO");
                        g.vida(); // bajamos la vida a vida Guybrush.
                    }
                    if (g.getVida() <= 0)// Comprobamos si la vida es menor o 0 sin restar puntos de vida.
                        heroiMort = true;// Si es el caso pasamos el estado de Guybrug a muerto.
                } else {//Si usamos a Elaine
                    e.defensar(); // Defensar de elaine.
                    if (pirataActual.replica(e.getRespuestaSeleccionada())==true) {//Hacemos el metodo replica del pirata actual con la respuesta seleccionada de elaine, si da True (acertamos).
                        System.out.println("CORRECTO");
                        pirataActual.vida();// Bajamos la vida del pirata.
                    } else {//Si replica devuelve false (significa que fallamos).
                        System.out.println("FALLO");
                        e.vida(); // bajamos la vida a vida Guybrush.
                    }
                    if (e.getVida() <= 0)// Comprobamos si la vida es menor o 0 sin restar puntos de vida.
                        heroiMort = true;// Si es el caso pasamos el estado de Elaine a muerta.
                }
            }
            //CUANDO PIRATA O HEROE MUERE
            if (!heroiMort) {// Si acaba la pelea y el heroe sigue vivo.
                pirataActual.sayGoodBye();//El pirata se despide
                comptadorPirates++; // Pasamos al siguiente pirata.
            }
        }
        //FINAL
        if (heroiMort==true) {//SI el heroe esta muerto
            System.out.println("GAME OVER. Has perdido contra los piratas.");
        } else {//SI el heroe esta vivo
            System.out.println("¡GG! ¡ERES EL REY DE LOS PIRATAS!");
        }
        sc.close();//Cerramos el scanner.
    }
}
