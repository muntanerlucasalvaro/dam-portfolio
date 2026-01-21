//nom: Álvaro Muntaner Lucas
//data: 25/09/2025
package es.cide.programacio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Enunciat: Escriu un programa en Java que implementi una calculadora senzilla utilitzant un menú i un bucle while.
        Scanner sc = new Scanner(System.in);// Establir l'escaner per poder introduir valors en la terminal com usuari.
        int opsol = 0;// Declar i initcialitz la variable (opsol) que servirà per ennmagatzemar les operacions solicitades per l'usuari a la calculadora (es a dir opcions dels nombres enters 1-5).
        double a, b, resultat = 0;// Declaram les variables double, (a) per guardar el primer nombre, (b) per guardar el segón i (resultat) per guardar el resultat de les diferents operacions.
        while (opsol != 5) {// Cream un bucle de tipus "wile" que s'executi sempre que el valor de la operació sol·licitada no sigui l'opció 5.
            System.out.println("----- MENÚ -----");// Impressió del menú amb les diferents opcions al principi del bucle peque ho faci a l'inici de cada cicle d'aquest.
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Sortir");
            System.out.println("Tria una opció de (1-5)");
            opsol = sc.nextInt();// Assignam a la variable (opsol) el següent valor introduït a la terminal per seleccionar l'opcio de la calculadora que es desitgi.
            switch (opsol) {// Establim un switch/ case amb la variable de "opsol" (Operació sol·licitada) per establir els diferents cassos que correspondrien a les opcions del menú de la calculadora (exceptuant el 5).
                case 1:// Establim el primer cas que s'executa quan (opsol = 1)
                    System.out.println("Introdueix el primer número:");// La primera instrucció del case 1 es imprimir "introdueix el primer numero" per indicar a l'usuari que ha d'introduïr el primer nombre de la suma.
                    a = sc.nextInt();// Assignam a la variable double (a) el següent valor introduït per la terminal.
                    System.out.println("Introdueix el segon número:");// La tercera instrucció del case 1 es imprimir "introdueix el segón numero" per indicar a l'usuari que ha d'introduïr el segón nombre de la suma.
                    b = sc.nextInt();// Assignam a la variable double (b) el següent valor introduït per la terminal.
                    resultat = a + b;// Resolem la suma so·licitada i la guardam en la variable (resultat).
                    System.out.println("Resultat: " + resultat);// Imprimim el resultat.
                    opsol = 0;// Reasignam el valor de (opsol) a 0 "resetejar" el valor de la operació solicitada que es vol realitzar. Aixo ens permet mourer-ser a través del switch/case juntament amb el primer scanner de (opsol) a l'inici del wile.
                    break;// Break necesari per sortir del case.
                case 2:// Establim el segón cas que s'executa quan (opsol = 2)
                    System.out.println("Introdueix el primer número:");// La primera instrucció del case 2 es imprimir "introdueix el primer numero" per indicar a l'usuari que ha d'introduïr el primer nombre de la resta.
                    a = sc.nextInt();// Assignam a la variable double (a) el següent valor introduït per la terminal.
                    System.out.println("Introdueix el segon número:");// La tercera instrucció del case 2 es imprimir "introdueix el segón numero" per indicar a l'usuari que ha d'introduïr el segón nombre de la resta.
                    b = sc.nextInt();// Assignam a la variable double (b) el següent valor introduït per la terminal.
                    resultat = a - b;// Resolem la resta so·licitada i la guardam en la variable (resultat).
                    System.out.println("Resultat: " + resultat);// Imprimim el resultat.
                    opsol = 0;// Reasignam el valor de (opsol) a 0 "resetejar" el valor de la operació solicitada que es vol realitzar. Aixo ens permet mourer-ser a través del switch/case juntament amb el primer scanner de (opsol) a l'inici del wile.
                    break;// Break necesari per sortir del case.
                case 3:// Establim el tercer cas que s'executa quan (opsol = 3)
                    System.out.println("Introdueix el primer número:");// La primera instrucció del case 3 es imprimir "introdueix el primer numero" per indicar a l'usuari que ha d'introduïr el primer nombre de la multiplicació.
                    a = sc.nextInt();// Assignam a la variable double (a) el següent valor introduït per la terminal.
                    System.out.println("Introdueix el segon número:");// La tercera instrucció del case 3 es imprimir "introdueix el segón numero" per indicar a l'usuari que ha d'introduïr el segón nombre de la multiplicació.
                    b = sc.nextInt();// Assignam a la variable double (b) el següent valor introduït per la terminal.
                    resultat = a * b;// Resolem la multiplicació so·licitada i la guardam en la variable (resultat).
                    System.out.println("Resultat: " + resultat);// Imprimim el resultat.
                    opsol = 0;// Reasignam el valor de (opsol) a 0 "resetejar" el valor de la operació solicitada que es vol realitzar. Aixo ens permet mourer-ser a través del switch/case juntament amb el primer scanner de (opsol) a l'inici del wile.
                    break;// Break necesari per sortir del case.
                case 4:// Establim el quart cas que s'executa quan (opsol = 4)
                    System.out.println("Introdueix el primer número:");// La primera instrucció del case 4 es imprimir "introdueix el primer numero" per indicar a l'usuari que ha d'introduïr el primer nombre de la divisió.
                    a = sc.nextInt();// Assignam a la variable double (a) el següent valor introduït per la terminal.
                    System.out.println("Introdueix el segon número:");// La tercera instrucció del case 4 es imprimir "introdueix el segón numero" per indicar a l'usuari que ha d'introduïr el segón nombre de la divisió.
                    b = sc.nextInt();// Assignam a la variable double (b) el següent valor introduït per la terminal.
                    if (b == 0) {// L'enunciat diu que quan el denominador d'una divisió és 0 ha de donar error. Per aquesta raó, he creat un if amb la condició que s'executa quan la variable (b) "que fa de denominador en la divisió" sigui 0.
                        System.out.println("Error: no es pot dividir entre zero.");// Quan es compleix el cas (b "denominador" = 0) s'imprimexi en pantalla l'error corresponent.
                        break;// Break necesari per sortir del case.
                    }
                    resultat = a / b;// Si ens trobam en el quart cas i no es compleix el if, guardam en la variable resultat el resultat de la divisió sol·licitada.
                    System.out.println("Resultat: " + resultat);// Imprimim el resultat.
                    opsol = 0;// Reasignam el valor de (opsol) a 0 "resetejar" el valor de la operació solicitada que es vol realitzar. Aixo ens permet mourer-ser a través del switch/case juntament amb el primer scanner de (opsol) a l'inici del wile.
                    break;// Break necesari per sortir del case.
                case 5:// Establim el cinqué cas que s'executa quan (opsol = 5). En aquest cas, si es compleix la condició el programa ha de mostrar un missatge i aturar el bucle es per aixo que no resetejam el valor de (opsol) amb 0 i deixam que es deixi de complir la condicio del while opsol != 5.
                 System.out.println("Gràcies per utilitzar la calculadora!");// En el cas de (opsol = 5) s'imprimexi el misatge pertinent.
                  break;// Break necesari per sortir del case.
                default:// La opció default es la que s'executarà si no es pot executar cap dels "cases" programats (1-4).
                    if (opsol != 0 || opsol != 1 || opsol != 2 || opsol != 3 || opsol != 4) {// Instauram un if en el que la condició sogui que el valor opsol no sigui cap dels valors (0 que equival a execució deñ wile), (1 que equival al case 1), (2 que equival al case 2), (3 que equival al case 3), (4 que equival al case 4) i (5 que equival al case 5 "sortida").
                        System.out.println("Error, opció no valida.");
                        opsol = 0;// Reasignam el valor de (opsol) a 0 "resetejar" el valor de la operació solicitada que es vol realitzar. Aixo ens permet mourer-ser a través del switch/case juntament amb el primer scanner de (opsol) a l'inici del wile.
                        break;// Break necesari per sortir del default.
                    }

            }

        
        }
        sc.close();//Tancam l'entrada del scanner.
    }
}
    