//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

public class Elaine extends Heroi {
    // CONSTRUCTOR
    public Elaine(String nom, int vida, String[] respostes) {
        super(nom, vida, respostes);// Atributos heredados de la clase heroi,
        this.nom = "Elaine Marley";// Asigno el nombre de Elaine.
    }

    // METODOS
    @Override
    public boolean vida() { // Metodo para ir restandole vida
        this.vida = vida - 1;// Elaine solo pierede 1 de vida.
        if (vida > 0) {// Si aun le queda vida.
            this.viu = true;// Sigue viva
        } else {// En caso contrario
            this.viu = false;// Muere.
        }
        return viu;// Devuelve el estado de su vida
    }

    @Override
    public void sayHello() {
        System.out.println("Hola, soy Elaine Marley. Es un placer saludarte.");
    }

    @Override
    public void sayGoodBye() {
        System.out.println(
                "Ha sido un duelo interesante. Espero que nos volvamos a ver en mejores circunstancias. Adiós.");
    }
}
