package es.cide.programacio;

public class Main {
    public static void main(String[] args) {
        //VARIABLES DE LOS OBSTACULOS
        int indiceTipos = 0;
        String tipoObstaculoActual;
        int dificultadObstaculoActual;
        //VARIABLES DE LOS ROBOTS
        int energiaRobot;
        Boolean vidaRobot = true;
        //Objetos
        Obstacle[] lliObstacles = new Obstacle[5];//Creamos un array para hacer una lista e 5 obstaculos.
        for (indiceTipos = 0; indiceTipos < lliObstacles.length; indiceTipos++) {
            lliObstacles[indiceTipos] = new Obstacle(indiceTipos);//Recorremos el array de la lista de obstaculos a la vez que el de la lista de tipos y vamos rellenando el array de obstaculos con varios obstaculos de diferentes tipos(porque nunca se repite el indice)
        }

        Robot robotin = new Robot("Pedrito", 45, 10);//Generamos a Robotin.
        String nomRobot = robotin.getNom();//A traves del metodo get.Nom conseguimos el nombre de nuestro robot. (por estetica)

        //SUPERACION DE OBSTACULOS
        for(int i= 0; i<lliObstacles.length;i++){//Bucle for para superar obstaculos que va recorriendo el array de obstaculos.
            if (vidaRobot==true) {//Solo itera si el robt tiene carga.
            tipoObstaculoActual = lliObstacles[i].getTipus();//A traves del metodo get.Tipus, obtenemos el tipo del obstaculo actual.
            dificultadObstaculoActual = lliObstacles[i].getDificultat();//A traves del metodo get.Dificultad, obtenemos la dificultad del obstaculo actual.
            System.out.println("El obstacle numero: "+(i+1)+ " es de tipus "+tipoObstaculoActual+" i la seva dificultat es de "+dificultadObstaculoActual);//Mostramos la información de los obstaculos
            vidaRobot=robotin.superarObstaculo(lliObstacles[i]);//Aplicamos a la vida del robot (osea a la bateria) el metodo superarObstaculo que resta energia y devuelve el estado de con bateria o sin bateria del robot.
            energiaRobot=robotin.getEnergia();//A traves del metodo get.Energia, obtenemos la energia del robot en ese momento.
            System.out.println("La energia actual del robot es "+energiaRobot);//Mostramos la energia 
            System.out.println();
            }
        }
        //FINAL
        if (vidaRobot==true) {//Si el robot esta "vivo"(osea tiene bateria).
            System.out.println("El robot("+nomRobot+") ha superat tots els obstacles!");//Enseñamos el mensaje de victoria
        }
        else{//Si el robot esta "muerto"(osea sin bateria).
            System.out.println("El robot("+nomRobot+") no ha aconseguit superar la prova.");//Enseñamos el mensaje de derrota.
        }
    }
}