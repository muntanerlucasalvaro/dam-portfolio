package es.cide.programacio;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       //5. Día de la semana
       //Declara una variable entera dia (1 al 7).
       System.out.println("Introduzca un numero del 1 al 7");
       int a = sc.nextInt();
       //1 → Lunes, 2 → Martes, …, 7 → Domingo.
        switch (a) {
            case (1):
                System.out.println("lunes");
                break;
            case (2): {
                System.out.println("martes");
                break;
            }
             case (3): {
                System.out.println("miercoles");
                break;
            }
             case (4): {
                System.out.println("jueves");
                break;
            }
             case (5): {
                System.out.println("viernes");
                break;
            }
             case (6): {
                System.out.println("sabado");
                break;
            }
             case (7): {
                System.out.println("domingo");
                break;
            }
            //Si el número no está entre 1 y 7, muestra "Día no válido".
            default: System.out.println("Día no válido");
                break;
        }
        sc.close();

    }
}