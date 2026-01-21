//NOM: Álvaro Muntaner Lucas
package es.cide.programacio;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Inicializamos el Scanner.
        Random ra = new Random();//Inicializamos el Random.
        int opcionRonda, nRonda = 0, insultoRandom, respuestaRandom1,//Creo valores enteros para las varianles de opcionRonda(que equivale a la opción solicitada del numero de rondas que quiere jugar), nronda (en la ronda que se està jugando en cada momento), insulto random (donde se guarda el valor aleatorio del insulto que se elige y que coincide con la respuesta correcta), la respuestaRandom1 (el valor aleatorio para randomizar la segunda respuesta que aparecerá, que no ha de coincidir con la respuesta correcta),
                respuestaRandom2, a, b, c;//RespuestaRandom2 (en que se almacena el valor aleatorio con el que se randomizará la tercera respuesta y no puede ser igual que la respuesta ccorrecta ni que la segunda respuesta que se muestra), las variables enteras a, b, y c que se utilizan para randomizar el orden y respuestaUsuario (que es el numero introducido por el usuario que servirá para escoger una de las respuestas imprimidas).
        char respuestaUsuario,opcionRondaChar;//Creo una variable char de la respuesta del usuario y de la opción de ronda para cumplir el reto de salir con la n.
        int respuestaUsuarioNumerica;//Creo una respuesta de usuario versión numerica en la que almacenar el valor numerico de el primer caracter incluido en el char de respuesta usuario.
        int puntuacion = 0;//Además, creo la variable puntuación, que actuara como una especie de "vidas" y servirá para tener un score que evaluar al final del juego.
        String[] arrayInsultos = {//Creo un array de String donde almaceno los insultos, es muy importante que este en orden y coincida insulto 1 con respuesta 1(en un array diferente).
                "¡Llevarás mi espada como si fueras un pincho moruno!",
                "¡Luchas como un granjero!",
                "¡No hay palabras para describir lo asqueroso que eres!",
                "¡He hablado con simios más educados que tu!",
                "¡No pienso aguantar tu insolencia aquí sentado!" };
        boolean[] insultosUsados = { false, false, false, false, false };//Creo un array de tipo booleano que me servirá para "descartar" los insultos que ya han aparecido y de esta manera no se repetirán en una misma partida.
        boolean offPuntos= false;//Creo un booleano de off puntos para solucionar un error al salir del juego en medio de una ronda, para generar una condición en la que que no se muestren los puntos si seleccionas la opción de salida.
        String[] arrayRespuesta = { "Primero deberías dejar de usarla como un plumero.",//Creo un array de respuestas donde se almacenan los strings de las respuestas que han de estar ordenados como se indica en el array de insultos.
                "Qué apropiado, tú peleas como una vaca.", "Sí que las hay, sólo que nunca las has aprendido.",
                "Me alegra que asistieras a tu reunión familiar diaria.",
                "Ya te están fastidiando otra vez las almorranas, ¿Eh?" };
        String[] arrayOpciones = new String[3];//Creo un array de opciones para almacenar las opciones que se van a mostrar (ha de estar la correcta y dos aleatorias).
        // INICIO DEL JUEGO
        System.out.println("¡Bienvenido a BATALLA DE INSULTOS PIRATA!");//Imprimo una bienvenida,
        System.out.println();//Dejo una linea por estetica.
        System.out.println(//Imprimo las reglas del juego y especifico que indiquen un numero de rondas.
                "En este juego tendràs que luchar verbalmente con una serie de piratas para decidir\nquién es el rey de los mares. Para lograrlo, deberás responder con picardía a tus\noponentes y ser más listo que ellos seleccionando la respuesta correcta para ir\nsobreviviendo a cada ronda, de no lograrlo, irás perdiendo puntos de vida hasta\nmorir como un cobarde.\n¡BUENA SUERTE!\n");
        System.out.println("¿CUANTAS RONDAS DESEA JUGAR? (MÁXIMO PERMITIDO 5)");
        //SELECCIÓN DE RONDA Y SALIDA.
        opcionRondaChar = sc.next().charAt(0);//Le doy a la variable opcionronda char el siguiente caracter introducido en el scanner (solo el primero).
        opcionRonda = (int)opcionRondaChar;//Inicializo valor numerico a opción ronda a traves de un cast.
         switch (opcionRondaChar) {//Asigno un valor numerico int a la Opcionronda en función del char introducido de tal manera que opcionRondaChar '1' = opcionRonda 1. 
                case '1':
                    opcionRonda = 1;
                    break;
                case '2':
                    opcionRonda = 2;
                    break;
                case '3':
                    opcionRonda = 3;
                    break;
                case '4':
                    opcionRonda = 4;
                    break;
                case '5':
                    opcionRonda = 5;
                    break;
                default:
                    break;
            } 
            if (opcionRondaChar=='n') { //Creo un if en el que si el valor char introducido por el usuario es n se salga del juego e imprima un mensaje.
                System.out.println("HAS SALIDO DEL JUEGO, HASTA PRONTO!");//Imprimo el mensaje de despedida.
                nRonda = opcionRonda;//Igualo la condición para que no se ejecute el while principal que contiene el juego.
            }
            while (opcionRondaChar !='n'&& opcionRondaChar !='1'&& opcionRondaChar !='2'&& opcionRondaChar !='3'&& opcionRondaChar !='4'&& opcionRondaChar !='5') {//Limito los numeros permitidos en opción ronda para que solo admita los caracteres de los numeros positivos del 1 al 5 (que es el maximo de rondas permitidas) o 'n'.
                System.out.println(//Mientras la condición especificada arriba se cumpla, se ha de imprimir un mensaje de error y se ha de volver a pedir un valor admitido por las opciones de ronda.
                        "¡ERROR! Introduzca los numeros (1-5) para seleccionar el numero de rondas jugables, gracias.");//Imprimo el mensaje de error.
                System.out.println("¿CUANTAS RONDAS DESEA JUGAR? (MÁXIMO PERMITIDO 5)");
               opcionRondaChar = sc.next().charAt(0);//Vuelvo a asignar un valor al Char.
               opcionRonda = (int)opcionRondaChar;

               if (opcionRondaChar=='n') {//Creo un if en el que si el valor char introducido por el usuario es n se salga del juego e imprima un mensaje.
                System.out.println("HAS SALIDO DEL JUEGO, HASTA PRONTO!");//Imprimo el mensaje de despedida.
                nRonda = opcionRonda;//Igualo la condición para que no se ejecute el while principal que contiene el juego.
                switch (opcionRondaChar) {//Asigno un valor numerico int a la Opcionronda en función del char introducido de tal manera que opcionRondaChar '1' = opcionRonda 1. 
                case '1'://Reescribo el valor numerico de opcionRonda,al igual que en la linea 37, pero esta vez de manera continua cada vez que se cumpla la condición del if.
                    opcionRonda = 1;
                    break;
                case '2':
                    opcionRonda = 2;
                    break;
                case '3':
                    opcionRonda = 3;
                    break;
                case '4':
                    opcionRonda = 4;
                    break;
                case '5':
                    opcionRonda = 5;
                    break;
                default:
                    break;
            } 
            }
               }
        //INICIO DEL WHILE PRINCIPAL.
            while (nRonda != opcionRonda && nRonda<opcionRonda) {//Creo un while que ejecute el juego siempre y cuando las rondas jugadas no sean iguales que las rondas solicitadas por el jugador y que ademas el numero de rondas jugadas sea menor.
                //ELEGIMOS Y REGISTRAMOS INSULTO.
                insultoRandom = ra.nextInt(5);//Genero un numero aleatorio del 0-4 para escoger el primer insulto.
                while (insultosUsados[insultoRandom] == true) {//Creo una condición que hace que cuando el la posicion de insulto usado (indicada por el numero aletorio recien creado), sea verdadero, se vuelva a repetir el numero aleatorio.
                    insultoRandom = ra.nextInt(5);//Creo un numero aletorio mientras la condición se cumpla.
                }
                System.out.println(arrayInsultos[insultoRandom]);//Imprimimos el array donde se guardan los Strings de los insultos en la posición indicada por el numero aleatorio.
                insultosUsados[insultoRandom] = true;//Dentro del array de insultosUsados, cambiamos el valor en la MISMA POSICIÓN que el array de String del insulto usado a true. Con esta linea, juntamente con el while de comprobación del insulto usado de ariba, lo que consigo es registrar los Strings de insultos que van saliendo y me permite evitar que se repitan.
                System.out.println();
                System.out.println("Introduzca una de las respuestas 1, 2 o 3");//Imprimo las opciones de respuesta posibles para el usuario.
                System.out.println();
        //RANDOMIZO 2 RESPUESTAS.
                respuestaRandom1 = ra.nextInt(5);//Guardo un numero aleatorio de (0-4) en la variable de respuestaRandom1.
                while (respuestaRandom1 == insultoRandom) {//Siempre y cuando el nuevo numero generado sea igual al primero que generamos al seleccionar el insulto.
                    respuestaRandom1 = ra.nextInt(5);//Genero otro nuevo y lo guardo, de esta manera obtenemos un numero aleatorio que NO coincida con el primero (que es el que equivale a la respuesta correcta).
                }
                respuestaRandom2 = ra.nextInt(5);//Guardo un numero aleatorio de (0-4) en la variable de respuestaRandom2.
                while (respuestaRandom2 == insultoRandom || respuestaRandom1 == respuestaRandom2) {//Siempre y cuando el nuevo numero generado sea igual al primero que generamos al seleccionar el insulto y al numero guardado en la respuestaRandom1.
                    respuestaRandom2 = ra.nextInt(5);//Genero otro nuevo y lo guardo, de esta manera obtenemos un numero aleatorio que NO coincida con el primero (que es el que equivale a la respuesta correcta) y que NO coincida con la primera respuesta randomizada.
                }
        //RANDOMIZO EL ORDEN DE LAS RESPUESTAS.
                a = ra.nextInt(3);//Genero un numero aleatorio  entre (0,1 o 2) y lo guardo en 'a'.
                b = ra.nextInt(3);//Genero un numero alatorio  entre (0,1 o 2) QUE NO SEA IGUAL A 'a' y lo guardo en 'b'.
                while (a == b) {//Mientras el valor numérico de 'a' sea el mismo que 'b'.
                    b = ra.nextInt(3);//Genero y guardo un nuevo valor para 'b'
                }
                c = ra.nextInt(3);//Genero un numero alatorio entre (0,1 o 2) QUE NO SEA IGUAL A 'a' NI A 'b y lo guardo en 'c'.
                while (b == c || a == c) {//Mientras el valor numérico de 'c' sea el mismo que 'b' o que 'a'.
                    c = ra.nextInt(3);//Genero y guardo un nuevo valor para 'c'
                }
        //ASIGNO EL VALOR CORRECTO A UNA DE LAS OPCIONES.
                arrayOpciones[a] = arrayRespuesta[insultoRandom];//En este caso, el array opciones [numero de posicion del valor de a] se va a contener el arrayRespuesta[de la posicion del primer numero que generamos aleatoriamente (el correcto)].

        //ASIGNO  LAS RESPUESTAS ALEATORIAS A LA POSICIÓN ALEATORIA.
                arrayOpciones[b] = arrayRespuesta[respuestaRandom1];//En este caso, el array opciones [[numero de posicion del valor de b] se va a contener el arrayRespuesta[de la posicion del primer numero que generamos en random1].
                arrayOpciones[c] = arrayRespuesta[respuestaRandom2];//En este caso, el array opciones [[numero de posicion del valor de c] se va a contener el arrayRespuesta[de la posicion del primer numero que generamos en random2].

        //IMPRIMO LAS OPCIONES POR PANTALLA.
                System.out.println("1. " + arrayOpciones[0]);//Imprimimos el arrayOpciones guardado en la casilla 0.
                System.out.println("2. " + arrayOpciones[1]);//Imprimimos el arrayOpciones guardado en la casilla 1.
                System.out.println("3. " + arrayOpciones[2]);//Imprimimos el arrayOpciones guardado en la casilla 2.
        //COMPROBACIÓN DE LO QUE PONE EL USUARIO.
                respuestaUsuario = sc.next().charAt(0);//RespuestaUsuario va a guardar el valor char que se indique en el scanner
                respuestaUsuarioNumerica = (int) respuestaUsuario;//Inicializo valor numerico a respuestaUsuarioNumerica a traves de un cast.
                switch (respuestaUsuario) {//Assigno y limito el valor de la variable respuestaUsuarioNumerica en función de lo que se lea en respuestaUsuario
                    case '1'://Si es '1'.
                        respuestaUsuarioNumerica = 1;//Asigno el valor numerico 1 al int respuestaUsuarioNumerica.
                        break;
                      case '2'://Si es '2'.
                        respuestaUsuarioNumerica = 2;//Asigno el valor numerico 2 al int respuestaUsuarioNumerica.
                        break;
                      case '3'://Si es '3'.
                        respuestaUsuarioNumerica = 3;//Asigno el valor numerico 3 al int respuestaUsuarioNumerica.
                        break;
                      case 'n'://Si es 'n'.
                        System.out.println("HAS SALIDO DEL JUEGO, HASTA PRONTO!");//Imprimimos el mensaje de despedida.
                        nRonda = opcionRonda;//Cierro el while principal.
                        offPuntos = true;//Denego toda la parte del codigo relacionada con la impresión de la puntuacion/vidas.
                        break;
                    default://LImito las respuestas para que sean alguno de los casos, si no es asi, fuerzo al usuario a introducir otra vez el valor char a interpretar.
                    System.out.println("ERROR RESPUESTA INCORRECTA: INRODUZCALO DE NUEVO, GRACIAS");//Imprimo el mensaje de error con la advertencia.
                    respuestaUsuario = sc.next().charAt(0);//Solicito de nuevo el char por el scanner de la terminal.
                        break;
                }
        //EVALUO LA RESPUESTA.
                if (respuestaUsuario!='n') {//Una vez que el caracter introducido por el usuario es uno de los permitidos por el switch superior, valoramos que no sea la 'n' que en este caso sirve para salir del juego.
                switch (respuestaUsuarioNumerica) {//Creo otro switch para valorar los casos numericos introducidos y determinar si es acertado o no.
                    case 1://En el caso de que introduzca '1'.
                        if (0 == a) {//Como la casilla del valor asignado a 'a' siempre es la correcta, si el usuario introduce el numero 1 por la terminal (esta escogiendo el primer valor de la lista del arrayOpciones, es decir el [0]) si la casilla 0 del array coincide con la posición aleatoria del a (osea a = 0), la respuesta sera correcta.
                            System.out.println("Correcto");//Imprimo que se ha acertado.
                            puntuacion = puntuacion + 2;//Sumo 2 a la puntuación que actua simultaneamente como vidas.
                        } else {//En el caso de que el usuario introduzca el numero 1 (refiendose a la primera casilla del array osea la 0) y la correcta (la 'a') se encuentre en otro lugar.
                            System.out.println("Incorrecto.");//Imprimo que es incorrecto.
                            puntuacion = puntuacion - 1;//resto 1 a la puntuación que actua simultaneamente como vidas.
                        }
                        break;

                    case 2://En el caso de que introduzca '2'.
                        if (1 == a) {//Como la casilla del valor asignado a 'a' siempre es la correcta, si el usuario introduce el numero 2 por la terminal (esta escogiendo el segundo valor de la lista del arrayOpciones, es decir el [1]) si la casilla 1 del array coincide con la posición aleatoria del a (osea a = 1), la respuesta sera correcta.
                            System.out.println("Correcto");//Imprimo que se ha acertado.
                            puntuacion = puntuacion + 2;//Sumo 2 a la puntuación que actua simultaneamente como vidas.
                        } else {//En el caso de que el usuario introduzca el numero 2 (refiendose a la primera casilla del array osea la 1) y la correcta (la 'a') se encuentre en otro lugar.
                            System.out.println("Incorrecto.");//Imprimo que es incorrecto.
                            puntuacion = puntuacion - 1;//resto 1 a la puntuación que actua simultaneamente como vidas.
                        }
                        break;

                    case 3://En el caso de que introduzca '3'.
                        if (2 == a) {//Como la casilla del valor asignado a 'a' siempre es la correcta, si el usuario introduce el numero 3 por la terminal (esta escogiendo el tercer valor de la lista del arrayOpciones, es decir el [2]) si la casilla 2 del array coincide con la posición aleatoria del a (osea a = 2), la respuesta sera correcta.
                            System.out.println("Correcto");//Imprimo que se ha acertado.
                            puntuacion = puntuacion + 2;//Sumo 2 a la puntuación que actua simultaneamente como vidas.
                        } else {//En el caso de que el usuario introduzca el numero 3 (refiendose a la primera casilla del array osea la 2) y la correcta (la 'a') se encuentre en otro lugar.
                            System.out.println("Incorrecto.");//Imprimo que es incorrecto.
                            puntuacion = puntuacion - 1;//resto 1 a la puntuación que actua simultaneamente como vidas.
                        }
                        break;
                    default://Eb el caso de que el valor numerico de RespuestaUsuarioNumerica no sea ninguna de las permitidas.
                        System.out.println("Opción inválida.");//Imprimo que la opción no es valida
                        break;
                }
                }
                if (puntuacion==-1) {//En el caso de que el computo de puntuacion/vidas sea -1 el jugador queda eliminado y se acaba el juego.
                    System.out.println("HAS PERECIDO DOLOROSAMENTE");//Imprimo el mensaje que indica que el jugador esta eliminado.
                    System.out.println();
                    nRonda=opcionRonda;//Igualo la condición que cierra el bucle principal de juego
                }
                nRonda = nRonda + 1;//Una vez finaliza la ronda, la variable ronda suma 1.
            }
        //COMPROBAMOS LA PUNTUACIÓN.
            if (offPuntos==false) {//Creo un valor booleano para poder cerrar toda la parte del codigo relacionada con los puntos al salir con la 'n', esto mediante la activación de la variable offPuntos = true.
            /*En esta sección del codigo, de manera resumida lo que hago es crear condicionales para poder seleccionar a mi criterio y en función de las rondas jugadas
             * que es lo que se considera una puntuación alta, media o baja. En el enunciado del ejercicio especifica que si la puntuacion de una partida es alta se ha
             * de imprimir el mensaje "Eres el rey de los piratas, enhorabuena!!!" si es media "Te has defendido como un buen marinero" y si es baja "Los loros se rien de ti!".
             * Por esa razón, lo unico que esta sucediendo aqui es que mediante if voy comprobando la variable de puntuación que se recoge y se calcula 
             * después de cada respuesta introducida por el usuario y,en función de las rondas elegidas, decido que es alto medio y bajo e imprimo el mensaje correspondiente.
             */
            if (opcionRonda == 1) {
                System.out.println();
                System.out.println("DESPUÉS DE LUCHAR ARDUAMENTE TU PUNTUACIÓN ES:" + puntuacion);//Imprimo la puntuación para el jugador.
                System.out.println();
                if (puntuacion < 2) {
                    System.out.println("Los loros se rien de ti!");
                }
                if (puntuacion == 2) {
                    System.out.println("Eres el rey de los piratas, enhorabuena!!!");
                }
            }
            if (opcionRonda == 2) {
                System.out.println();
                System.out.println("DESPUÉS DE LUCHAR ARDUAMENTE TU PUNTUACIÓN ES:" + puntuacion);//Imprimo la puntuación para el jugador.
                System.out.println();
                if (puntuacion < 2) {
                    System.out.println("Los loros se rien de ti!");
                }
                if (2 == puntuacion) {
                    System.out.println("Te has defendido como un buen marinero");
                }
                if (4 == puntuacion) {
                    System.out.println("Eres el rey de los piratas, enhorabuena!!!");
                }
            }
            if (opcionRonda == 3) {
                System.out.println();
                System.out.println("DESPUÉS DE LUCHAR ARDUAMENTE TU PUNTUACIÓN ES:" + puntuacion);//Imprimo la puntuación para el jugador.
                System.out.println();
                if (puntuacion <= 2) {
                    System.out.println("Los loros se rien de ti!");
                }
                if (2 < puntuacion && puntuacion <= 4) {
                    System.out.println("Te has defendido como un buen marinero");
                }
                if (4 < puntuacion) {
                    System.out.println("Eres el rey de los piratas, enhorabuena!!!");
                }
            }
            if (opcionRonda == 4) {
                System.out.println();
                System.out.println("DESPUÉS DE LUCHAR ARDUAMENTE TU PUNTUACIÓN ES:" + puntuacion);//Imprimo la puntuación para el jugador.
                System.out.println();
                if (puntuacion < 2) {
                    System.out.println("Los loros se rien de ti!");
                }
                if (4 <= puntuacion && 8>puntuacion) {
                    System.out.println("Te has defendido como un buen marinero");
                }
                if (8 == puntuacion) {
                    System.out.println("Eres el rey de los piratas, enhorabuena!!!");
                }
            }
            if (opcionRonda == 5) {
                System.out.println();
                System.out.println("DESPUÉS DE LUCHAR ARDUAMENTE TU PUNTUACIÓN ES:" + puntuacion);//Imprimo la puntuación para el jugador.
                System.out.println();
                if (puntuacion <= 4) {
                    System.out.println("Los loros se rien de ti!");
                }
                if (4 < puntuacion && puntuacion <= 7) {
                    System.out.println("Te has defendido como un buen marinero");
                }
                if (7 < puntuacion) {
                    System.out.println("Eres el rey de los piratas, enhorabuena!!!");
                }
            }
        }

        
        sc.close();//Finalmente, una vez se ha terminado todo el codigo, cierro el scanner.
    }
}