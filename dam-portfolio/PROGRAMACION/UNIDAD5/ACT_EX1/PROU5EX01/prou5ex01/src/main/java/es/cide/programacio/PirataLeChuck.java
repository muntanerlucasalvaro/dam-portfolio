//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Random;

public class PirataLeChuck extends Pirata {
    // CONSTRUCTOR
    public PirataLeChuck(String nom, int vida, String[] insults, String[] respostes) {
        super("LeChuck", vida, insults, respostes);// Heredamos del padre los atributos.
        this.vida = vida * 2; // Vida doble
        this.nom = "LeChuck";//Sobre escribimos el nombre de LeChuck.
        this.insultsPirata = new String[4];// Sobreescribimos el array de insults pirata para darle un hueco extra.
        this.insultsPirata[0] = insults[a];//Asignamos los insultos en el nuevo array de insultos propios del pirata sgun lo hace la clase pirata
        this.insultsPirata[1] = insults[b];
        this.insultsPirata[2] = insults[c];
        this.insultsPirata[3] = insults[5]; //Metemos el ultimo insulto en la ultima posicion de los insultos de LeChuck.

        // Sincronizamos los índices de las respuestas correctas
        // Usamos tus variables a, b, c y el 5 para el especial
        this.insultsCorrectes = new int[] { a, b, c, 5 };// Asociamos los insultos con las respestas correctas.
    }

    @Override
    public void insultar() {// Metodo para que el pirata insulte.
        x = ra.nextInt(4);//Repetimos el codigo de la clase pirata pero con 4 insultos en lugar de 3.
        while (x == u || x == h) {// Evitamos repetir el insulto anterior o el penúltimo (este while nunca entra en la primera rotacion).
            x = ra.nextInt(4);// Generamos de nuevo hasta que sea diferente.
        }
        h = u;// Guardamos el insulto que tenia la u en al final del ciclo.
        u = x;// Guardamos el insulto que tenia la x en al final del ciclo.
        System.out.println(this.nom + " insulta: " + insultsPirata[x]);// Imprimimos el insulto elegido.
    }

    @Override
    public boolean replica(String respuestaSeleccionada) {// Metodo para valorar si la respuesta del heroe.
        int indiceDeLaCorrecta = insultsCorrectes[x];//Sacamos el indice de la respuesta correcta 
        String fraseCorrecta = respostes[indiceDeLaCorrecta];// Sacamos la respuesta que va con el insulto usado.

        return respuestaSeleccionada.equals(fraseCorrecta);// Devuelve verdadero o falso.
    }

    @Override
    public boolean vida() { // Metodo para restar vida al pirata.
        vida--; // Restamos una vida.
        if (vida > 0) { // Si aun tiene vida.
            this.viu = true; // Sigue vivo.
        } else { // Si no tiene vidas.
            this.viu = false; // Muere.
        }
        return viu; // Retornamos si sigue vivo o no.
    }
    
    @Override
    public void sayHello() {
        System.out.println("¡Soy el Capitán LeChuck! ¡Prepárate para morir!");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("¡ESTE NO SERA MI FINAL! *LeChuck desaparece*");
    }
}
