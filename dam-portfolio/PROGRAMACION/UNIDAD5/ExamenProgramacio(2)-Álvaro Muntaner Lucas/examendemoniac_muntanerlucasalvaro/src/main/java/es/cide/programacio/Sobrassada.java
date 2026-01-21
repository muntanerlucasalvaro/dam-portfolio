//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Random;

public class Sobrassada extends Torrada implements Graella, Menjar {
    Random ra = new Random();// RANDOM

    // CONSTRUCTOR
    public Sobrassada(String festivitat, String any,boolean missatjeBenvolgudaTorrada) {// Donam per parametres els atributs demanats.
        super(festivitat, any, missatjeBenvolgudaTorrada);// Heretam els atributs del pare amb Super.
        this.missatjeBenvolgudaTorrada=false;//Apagam el missatje de benvolguda de la torrada.
        System.out.println("He comprat una sobrassada.");//Missatge per consola per saber que s'ha comprat una sobrassada (hem creat l'objecte).

    }

    @Override
    public void assaborir() {//Metode per assaborir la sobrasada
        System.out.println("Estic assaborint la sobrassada.");//Missatge per consola per saber que estem assaborint la sobrasada.
    }

    @Override
    public void posarCarnAGraella() {// Metode per posar a la graella
    System.out.println("He posat la sobrassada a la graella.");// Missatge per consola per saber que hem posat la sobrassada a la graella.
    }

    @Override
    public boolean estaFet() {// Metode estaFet
        int f = ra.nextInt(2) + 1;// Generam un numero aleatori entre 1 i 2.
        if (f == 1) {// Si es 1 (50%)
            return false;// Retornam un false.
        } else {// En cas contrari (50%)
            return true;// Retornam true.
        }

    }

}
