//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Random;

public abstract class Pirata extends Personatge implements Fight, Speak {
    // ATRIBUTOS
    protected int a, b, c, x; // Variables para elegir insultos aleatorios y el orden de respuestas.
    protected int u = -1; // Variable para controlar la repetición de insultos(Los propios del pirata).
    protected int h = -1; // Variable para controlar la repetición de insultos(Los propios del pirata).
    protected Random ra = new Random(); // Inicializamos el Random.
    protected String[] nomList = { "Hugo Verdugo", "Mateo Teveo", "Dani Pani", "Álvaro Mango", "Francho Pancho",
            "El Quijote", "Pepa pig" }; // Lista de nombres para pirata.
    protected boolean viu = true; // Booleano para indicar si el pirata sigue vivo.
    protected String[] insultsPirata = new String[3]; // Array con los 3 insultos de espacio para los piratas.
    protected String[] insults; // Array con todos los posibles insultos del juego.
    protected String[] respostes; // Array con todas las posibles respuestas del héroe.
    protected int[] insultsCorrectes; // Índices de las respuestas correctas para cada insulto

    // CONSTRUCTOR
    public Pirata(String nom, int vida, String[] insults, String[] respostes) {
        super(nom, vida);
        this.respostes = respostes; // Guardamos el array de respuestas.
        int z = ra.nextInt(7); // Elegimos un numero aleatorio para el nombre del pirata.
        this.nom = nomList[z]; // Asignamos un nombre aleatorio al pirata.
        this.vida = ra.nextInt(1,3); // Asignamos aleatoriamente 1, 2 o 3 vidas al pirata.
        this.insults = insults; // Guardamos el array de insultos.
        this.a = ra.nextInt(5); // Elegimos aleatoriamente la primera respuesta correcta.
        this.b = ra.nextInt(5); // Elegimos aleatoriamente la segunda respuesta y repetimos hasta que no
                                // coincida con la primera.
        while (a == b) {
            b = ra.nextInt(5);
        }
        this.c = ra.nextInt(5); // Elegimos aleatoriamente la tercera respuesta y repetimos hasta que no
                                // coincida con la primera ni con la segunda.
        while (b == c || a == c) {
            c = ra.nextInt(5);
        }
        this.insultsPirata[0] = insults[a]; // Guardamos el primer insulto propio del pirata.
        this.insultsPirata[1] = insults[b]; // Guardamos el segundo insulto propio del pirata.
        this.insultsPirata[2] = insults[c]; // Guardamos el tercer insulto propio del pirata.
        this.insultsCorrectes = new int[] { a, b, c };// Asociamos los insultos con las respestas correctas.
    }

    // GETTERS Y SETTERS
    public void setNom(String nom) { // Setter para cambiar el nombre del pirata.
        this.nom = nom;
    }

    public String getNom() { // Getter para obtener el nombre del pirata.
        return nom;
    }
    public int getVida(){ //Getter para la vida del pirata.
        return vida;
    }
    public String getInsultPirata() {//Getter para un insulto concreto de un pirata.
        return insultsPirata[x];
    }

    // METODOS
    public void defensar() {//Metodo vacio defensar.
    };

    public void insultar() { // Metodo para que el pirata insulte.
        x = ra.nextInt(3); // Elegimos aleatoriamente uno de los 3 insultos.
        while (u == x || h == x) { // Evitamos repetir el insulto anterior o el penúltimo (este while nunca entra en la primera rotacion).
            x = ra.nextInt(3); // Generamos de nuevo hasta que sea diferente.
        }
        h = u; // Guardamos el insulto que tenia la u en al final del ciclo.
        u = x; // Guardamos el insulto que tenia la x en al final del ciclo.
        System.out.println(this.nom + " insulta : " + insultsPirata[x]); // Imprimimos el insulto elegido.
        insultsPirata[x] = insultsPirata[x]; // devolvemos el insulto.
    }

    public boolean replica(String respuestaSeleccionada) { // Metodo para valorar si la respuesta del heroe.
        return respuestaSeleccionada.equals(respostes[insultsCorrectes[x]]); //Devuelve verdadero o falso.
    }

    public abstract boolean vida(); //Metodo vacio de vida.

    public abstract void sayHello(); //Metodo vacio para saludar.

    public abstract void sayGoodBye(); //Metodo vacio para depedir.
}
