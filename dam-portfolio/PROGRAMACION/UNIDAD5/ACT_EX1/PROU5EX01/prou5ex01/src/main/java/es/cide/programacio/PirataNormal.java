//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

public class PirataNormal extends Pirata {
    // ATRIBUTOS
    private boolean viu = true; // Booleano para indicar si el pirata sigue vivo.

    // CONSTRUCTOR
    public PirataNormal(String nom, int vida, String[] insults, String[] respostes) {
        super(nom, vida, insults, respostes);
    }

    // METODOS
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
        System.out.println("¡Eyy, cara de calamar! ¿Qué viento te trae por aquí, o solo vienes a quejarte?");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("¡Vete ya, mequetrefe, y no vuelvas a pisar mi cubierta!");
    }
}
