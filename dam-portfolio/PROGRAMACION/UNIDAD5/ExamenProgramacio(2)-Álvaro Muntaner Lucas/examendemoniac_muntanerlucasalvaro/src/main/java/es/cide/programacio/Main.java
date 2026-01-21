//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;

public class Main {
    public static void main(String[] args) {
        Torrada torrada = new Torrada("Sant Antoni", "2025", true);// Cream una torrada.
        Botifarro botifarro = new Botifarro("Sant Vicent", "2025", false);// Cream un botifarro.
        Sobrassada sobrassada = new Sobrassada("Santa Eulalia", "2025", false);// Cream una sobrasada.
        botifarro.posarCarnAGraella();// Posam el botifarro a la graella.
        sobrassada.posarCarnAGraella();// Posam la sobrassada a la graella.
        System.out.println("Vaig a mirar si estan fets:");// Missatge per avisar de la comprobació
        while (!botifarro.estaFet() || !sobrassada.estaFet()) {// Mentres un dels dos tipus de carn no estigui fet.
            if (!botifarro.estaFet() && !sobrassada.estaFet()) {// Si el botifarro no esta fet i la sobrassada tampoc.
                System.out.println("El botifarró està cru i la sobrassada està cru. He d'esperar.");
            } else if (!botifarro.estaFet() && sobrassada.estaFet()) {// Si el botifarro no esta fet, pero la sobrassada
                                                                      // si.
                System.out.println("El botifarró està cru i la sobrassada està fet. He d'esperar.");
            } else if (botifarro.estaFet() && !sobrassada.estaFet()) {// Si el botifarro esta fet, pero la sobrassada
                                                                      // no.
                System.out.println("El botifarró està fet i la sobrassada està cru. He d'esperar.");
            }
        }
        torrada.levarCarnDeGraella();// Llevam tota la carn de la graella.
        botifarro.assaborir();// Assaborim el botifarro
        sobrassada.assaborir();// Assaborim la sobrassada.
        System.out.println("Au, ja està tot fet! Visca Sant Sebastià!");// Missatge final.
    }
}