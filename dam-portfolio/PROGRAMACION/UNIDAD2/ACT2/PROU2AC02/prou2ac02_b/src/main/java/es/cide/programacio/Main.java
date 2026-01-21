package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Fes un programa en Java que demani a l’usuari introduir les notes (valors enters de 0 a 10) de 6 alumnes i les guardi en un array.
        Scanner sc = new Scanner(System.in);
        int[] arrayNotes = new int[6];
        int contadorarray = 0;
        int aprovats = 0;
        int suspes = 0;
        //Un cop introduïdes totes les notes, utilitza un bucle while per recórrer l’array
        while (contadorarray<6) {
            System.out.println("Notas:");
            arrayNotes[contadorarray]=sc.nextInt();
            contadorarray++;
        }
        contadorarray=0;
        while (contadorarray<6){
            if(arrayNotes[contadorarray] >=5){
                aprovats++;
            }
            else{
                suspes++;
            }
            contadorarray=contadorarray+1;
        }
        System.out.println("El nombre d'aprovats és " + aprovats );
        System.out.println("El nombre de suspesos és " + suspes);
        sc.close();
    }
}