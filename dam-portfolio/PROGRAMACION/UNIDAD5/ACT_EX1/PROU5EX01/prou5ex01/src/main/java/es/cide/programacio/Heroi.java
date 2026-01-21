//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Scanner;

public abstract class Heroi extends Personatge implements Fight, Speak {

    // ATRIBUTOS
    protected Scanner sc = new Scanner(System.in); // Inicializamos el Scanner.
    protected int seleccionHeroe; // Variable para guardar el numero de opción seleccionada por el jugador.
    protected String[] respostes; // Respuestas posibles para defenderse.
    protected boolean viu = true; // Booleano que indica si el heroe sigue vivo.
    String respuestaSeleccionada; // Respuesta elegida por el jugador.

    // CONSTRUCTOR
    public Heroi(String nom, int vida, String[] respostes) {
        super(nom, vida);
        this.nom = nom; // Guardamos el nombre del héroe.
        this.vida = 10; // Asignamos la vida inicial del héroe.
        this.respostes = respostes; // Guardamos las respuestas posibles.
    }

    // GETTERS Y SETTERS
    public void setNom(String nom) { // Setter para cambiar el nombre del heroe.
        this.nom = nom; // Asignamos el nombre nuevo.
    }

    public String getNom() { // Getter para obtener el nombre del héroe.
        return nom; // Devolvemos el nombre.
    }

    public int getVida() { // Getter para obtener la vida restante del heroe.
        return vida; // Devolvemos la vida.
    }

    public String getRespuestaSeleccionada() {// Getter para saber la respuesta que escoge el heroe
        return respuestaSeleccionada;
    }

    // METODOS
    public void insultar() { // Metodo vacio insultar.
    };

    public void defensar() { // Metodo que gestiona la defensa del héroe.
        System.out.println("Selecciona una respuesta con la que defenderte pirata.");
        System.out.println();
        for (int i = 0; i < respostes.length; i++) {// recorremos el array de las respuestas
            System.out.println((i + 1) + "." + respostes[i]);// imprimimos las respuestas
        }
        do {
            System.out.print("Tu elección: ");
            seleccionHeroe = sc.nextInt();// Se selecciona una respuesta
            if (seleccionHeroe < 1 || seleccionHeroe > respostes.length) {// Si se introduce un numero no valido
                System.out.println("ERROR: LA RESPUESTA SELECCIONADA NO ES VÁLIDA.");// mensaje de error
                System.out.println("VUELVA A INTRODUCIR LA RESPUESTA:");
            }
        } while (seleccionHeroe < 1 || seleccionHeroe > respostes.length);// Se repite mientras el numero no sea valido
        respuestaSeleccionada = respostes[seleccionHeroe - 1];// Asignamos la respuesta seleccionada
    }

    public abstract boolean vida(); // Metodo vacio de vida.

    public abstract void sayHello(); // Metodo vacio para saludar.

    public abstract void sayGoodBye(); // Metodo vacio para depedir.
}
