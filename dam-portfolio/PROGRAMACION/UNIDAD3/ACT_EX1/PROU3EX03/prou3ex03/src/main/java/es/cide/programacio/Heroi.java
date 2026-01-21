//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;
import java.util.Random;
import java.util.Scanner;

public class Heroi {

    // ATRIBUTOS
    private Scanner sc = new Scanner(System.in); //Inicializamos el Scanner.
    private String nom; //Nombre del héroe.
    private int seleccionHeroe; //Variable para guardar el numero de opción seleccionada por el jugador.
    private int vida = 10; //Vida inicial del héroe.
    private String[] respostes; //Respuestas posibles para defenderse.
    private boolean viu = true; //Booleano que indica si el heroe sigue vivo.
    String respuestaSeleccionada; //Respuesta elegida por el jugador.

    // CONSTRUCTOR
    public Heroi(String nom, String[] respostes) { //Constructor del héroe, (nombre y la lista de respuestas por parametros).
        this.nom = nom; //Guardamos el nombre del héroe.
        this.vida = 10; //Asignamos la vida inicial del héroe.
        this.respostes = respostes; //Guardamos las respuestas posibles.
    }

    // GETTERS Y SETTERS
    public void setNom(String nom) { //Setter para cambiar el nombre del heroe.
        this.nom = nom; //Asignamos el nombre nuevo.
    }

    public String getNom() { //Getter para obtener el nombre del héroe.
        return nom; //Devolvemos el nombre.
    }

    public int getVida() { //Getter para obtener la vida restante del héroe.
        return vida; //Devolvemos la vida.
    }

    // METODOS
    public String defensar() { //Metodo que gestiona la defensa del héroe.
        System.out.println("Selecciona una respuesta con la que defenderte pirata."); //Mensaje para el jugador.
        System.out.println(); 
        System.out.println("1." + respostes[0]); //Mostramos la respuesta 1.
        System.out.println("2." + respostes[1]); //Mostramos la respuesta 2.
        System.out.println("3." + respostes[2]); //Mostramos la respuesta 3.
        System.out.println("4." + respostes[3]); //Mostramos la respuesta 4.
        System.out.println("5." + respostes[4]); //Mostramos la respuesta 5.
        System.out.println(); 

        seleccionHeroe = sc.nextInt(); //Leemos la opción del jugador.
        boolean seleccionResp = true; //Controla el bucle hasta que escoja una opción válida.

        while (seleccionResp) { //Mientras seleccionaResp este en true.
            switch (seleccionHeroe) { //Comprobamos la variable seleccionHeroe.
                case 1:
                    respuestaSeleccionada = respostes[0]; //Guardamos la respuesta 1.
                    seleccionResp = false; //Salimos del bucle.
                    break;
                case 2:
                    respuestaSeleccionada = respostes[1]; //Guardamos la respuesta 2.
                    seleccionResp = false;//Salimos del bucle.
                    break;
                case 3:
                    respuestaSeleccionada = respostes[2]; //Guardamos la respuesta 3.
                    seleccionResp = false;//Salimos del bucle.
                    break;
                case 4:
                    respuestaSeleccionada = respostes[3]; //Guardamos la respuesta 4
                    seleccionResp = false;//Salimos del bucle.
                    break;
                case 5:
                    respuestaSeleccionada = respostes[4]; //Guardamos la respuesta 5.
                    seleccionResp = false;//Salimos del bucle.
                    break;

                default: //Si no es una de las opciones determinadas.
                    System.out.println("ERROR: LA RESPUESTA SELECCIONADA NO ES VÁLIDA."); //Mensaje de error.
                    System.out.println(); 
                    System.out.println("VUELVA A INTRODUCIR LA RESPUESTA:"); //Pedimos otra vez la opción.
                    seleccionHeroe = sc.nextInt(); //Leemos la nueva opción.
                    break;
            }
        }
        return respuestaSeleccionada; //Devolvemos la respuesta elegida.
    }

    public boolean vida() { //Metodo para restar vida al héroe.
        this.vida--; //Restamos 1 punto de vida.
        if (vida > 0) { //Si aun le queda vida.
            this.viu = true; //Sigue vivo.
        } else { // Si no.
            this.viu = false; //Muere.
        }
        return viu; //Devolvemos el estado del heroe.
    }
}
