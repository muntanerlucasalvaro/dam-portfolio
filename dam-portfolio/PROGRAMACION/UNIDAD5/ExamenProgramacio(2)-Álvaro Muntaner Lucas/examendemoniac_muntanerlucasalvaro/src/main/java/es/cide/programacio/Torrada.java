//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

import java.util.Random;

public class Torrada {
    Random ra = new Random();// RANDOM
    // ATRIBUTS
    protected String festivitat;
    protected String any;
    protected boolean missatjeBenvolgudaTorrada;// Variable per limitar el missatje de benvolguda unicament per la torrada

    // CONSTRUCTOR
    public Torrada(String festivitat, String any,boolean missatjeBenvolgudaTorrada) {// Donam per parametres els atributs demanats.
        this.festivitat = festivitat;
        this.any = any;
        this.missatjeBenvolgudaTorrada=true;//Missatje de benvolguda actiu.
        if (missatjeBenvolgudaTorrada) {//Si el missatje de benvolguda de la torrada = true;
            System.out.println("Benvingut a la torrada de Sant Sebastià 2025.");// Imprimim missatge de bienvenida a la torrada.
        }
    }

    // GETTERS Y SETTERS
    public String getAny() {// Getter per any.
        return any;
    }

    public String getFestivitat() {// Getter per festivitat.
        return festivitat;
    }

    public void setAny(String any) {// Setter per any.
        this.any = any;
    }

    public void setFestivitat(String festivitat) {// Setter per festivitat.
        this.festivitat = festivitat;
    }

    // METODES
    public void levarCarnDeGraella() {//Metode per llevar la carn de la graella (tota la carn de la torrada)
        System.out.println("El botifarró està fet i la sobrassada està fet. Ja puc anar a sopar.");//Missatge per consola per saber que hem llevat tota la carn de la graella.
    }

    public boolean crema() {// Metode per saber si la carn crema (per tota la carn).
        int c = ra.nextInt(2) + 1;// Generam un numero aleatori entre 1 i 2.
        if (c == 1) {// Si es 1 (50%)
            return true;// Si crema.

        } else {// En cas contrari (50%)
            return false;// No crema.
        }
    }
}
