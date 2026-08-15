package es.cide.programacio;

import java.util.ArrayList;

public class GestioVols implements IGestioPassatgers {//Creo una clase GestioVols y le implemento la interficie
    // ATRIBUTS
    ArrayList<String> llistaPassatgers;//Creo el atributo tipo ArrayList de strings

    // CONSTRUCTOR
    public GestioVols() {
        llistaPassatgers = new ArrayList<>();//Creoo un arrayList vacio
    }
//OTROS METODOS
    @Override
    public void registrarPassatger(String nom) {//Metodo registrar pasager
        llistaPassatgers.add(nom);//uso el .add para añadir un pasajero
    }

    @Override
    public void modificarReserva(int index, String nouNom) {//Metodo para registrar la reserva
        llistaPassatgers.set(index, nouNom);//uso el .set y le paso por parametros el indice de la posicion y el nuevo valor.
    }

    @Override
    public void cancelarReserva(String nom) {//Metodo para cancelar una reserva,
        llistaPassatgers.remove(nom);//uso el .remove para eliminar el valor concreto (lo paso po parametros)
    }

    @Override
    public String obtenirPassatger(int index) {//Metodo para obtener un pasajero
        return llistaPassatgers.get(index);//devuelve el resiltado de .get y el indice que le pasamos por parametros
    }

    @Override
    public void llistarPassatgers() {//Metodo para recorrer la lista
        for(String element : llistaPassatgers){//bucle for que recorre todos los elementos de la lista y los imprime. 
            System.out.println(element);
        }
    }
}
