//NOMBRE:ÁLVARO MUNTANER LUCAS
//FECHA: 02/12/2025
package es.cide.programacio;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // RANDOM
        Random ra = new Random();
        Pony myLittlePony = new Pony("Pepa", 10);//Creamos un pony llamado Pepa que tiene 10 de energia.
        int numeroObstacles = ra.nextInt(4, 8);//Generamos el numero de obstaculos aleatorio entre 5 y 7.
        Obstacle[] arrayObstacles = new Obstacle[numeroObstacles];//Creamos un array de obstaculos con un tamaño indicado por la variable aleatoria de arriba.
        // INICIO DE LA CARRERA DE OBSTACULOS
            for (int i = 0; i < arrayObstacles.length; i++) {//Bucle for para recorrer el array de obstaculos uno a uno.
                arrayObstacles[i] = new Obstacle();//Generamos un obstaculo y lo guardamos en la posicion del array de la iteracion en curso del bucle for.
                System.out.println("Obstacle número: " + (i + 1));//Imprimimos en la terminal en que obstaculo nos encontramos.
                System.out.println("Tipus de l'obstacle: " + arrayObstacles[i].getTipus());//Mostramos el tipo del obstaculo.
                System.out.println("Dificultat obstacle: " + arrayObstacles[i].getDificultat());//Mostramos la dificultad del obstaculo.
                System.out.println();
                if (myLittlePony.superarObstacle(arrayObstacles[i]) == true) {//Si el metodo de superar obstaculo del pony nos devuelve true (osea que supera el obstaculo).
                    System.out.println("El pony (" + myLittlePony.getNom() + "), ha superat l'obstacle");//Imprimimos que el pony ha superado el obstaculo.
                    System.out.println("L'energia actual del pony es de: " + myLittlePony.getEnergia());//Mostramos la energia restante.
                    System.out.println();
                } else {//Si el metodo de superar obstaculo del pony nos devuelve false (osea que NO supera el obstaculo).
                    System.out.println("El pony (" + myLittlePony.getNom() + "), no ha superat l'obstacle");//Imprimimos que el pony NO ha superado el obstaculo.
                    System.out.println("L'energia actual del pony es de: " + myLittlePony.getEnergia());//Mostramos la energia restante.
                    System.out.println();
                }
                if (myLittlePony.getEnergia() <= 0) {//Si la energia del pony llega a 0 o inferior.
                    i = arrayObstacles.length;//Termina la carrera (Cerramos el bucle for).
                }
            }//FIN DE LA CARRERA DE OBSTACULOS
        
        // VALORACIÓN FINAL
        if (myLittlePony.getEnergia() > 0) {//Si, una vez acabada la carrera, el pony aun tiene energia.
            System.out.println("El pony ha superat tots els obstacles, el pots dur a competir!");//Supera el reto y gana
        } else {//En el caso contrario.
            System.out.println("El pony no ha aconseguit superar la prova, només serveix per fer hamburgueses.");//No supera el reto y pierde.
        }
    }

}
