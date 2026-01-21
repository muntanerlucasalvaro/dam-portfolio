//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Random;

public class Botifarro extends Torrada implements Graella, Menjar {
    Random ra = new Random();// RANDOM
    // ATRIBUTS
    protected boolean coent;//Variable per controlar si es coent

    // CONSTRUCTOR
    public Botifarro(String festivitat, String any,boolean missatjeBenvolgudaTorrada) {// Donam per parametres els atributs demanats.
        super(festivitat, any, missatjeBenvolgudaTorrada);// Heretam els atributs del pare amb Super.
        this.missatjeBenvolgudaTorrada=false;//Apagam el missatje de benvolguda de la torrada.
        int a = ra.nextInt(2) + 1;// Generam un numero aleatori entre 1 y 2.
        if (a == 1) {// Si es 1
            this.coent = true;// Será coent.
        } else {// Si es 2
            this.coent = false;// No sera coent.
        }
        System.out.println("He comprat un botifarró.");//Missatge per consola per saber que s'ha comprat un botifarro (hem creat l'objecte).
    }

    // GETTERS Y SETTERS
    public boolean getCoent() {// Getter per coent.
        return coent;
    }

    public void setCoent(boolean coent) {// Setter per coent
        this.coent = coent;
    }

    // METODES
    @Override
    public void assaborir() {//Metode per assaborir el botifarro.
    if (getCoent()) {//Si es coent
        System.out.println("Estic assaborint el botifarró i es coent.");//Es mostra el missatje coent.
    }else{//Si no es coent.
        System.out.println("Estic assaborint el botifarró i no es coent.");//Es mostra el missatje no coent
    }
    }

    @Override
    public void posarCarnAGraella() {// Metode per posar a la graella
    System.out.println("He posat el botifarró a la graella.");// Missatge per consola per saber que hem posat el botifarro a la graella.
    }

    @Override
    public boolean estaFet() {// Metode estaFet
        int f = ra.nextInt(10) + 1;// Generam un numero aleatori entre 1 y 10;
        if (f <= 7) {// Si el numero és 1,2,3,4,5,6 o 7 (70%)
            return false;// Retornam un false.
        } else {// En cas contrari (30%)
            return true;// Retornam true.
        }

    }

}
