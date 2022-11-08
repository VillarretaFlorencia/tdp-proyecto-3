package Logica;

import Excepciones.EmptyListException;
import TDALista.DoubleLinkedList;
import TDALista.PositionList;
import Zombies.Zombie;
import Zombies.ZombieNormal;

public class Nivel {
    private Entidad[][] nivel = new Entidad[6][10];
    
    public Nivel(){
        for(int x = 0; x<6; x++){
            for(int y = 0; y<10; y++){
                nivel[x][y]= new Celda();
            }
        }
    }

    public void modificar(int x, int y, Entidad ent){
        nivel[x][y] = ent;
    }
    
    public int getColumnas(){
        return nivel[0].length;
    }
    public int getFilas(){
        return nivel.length;
    }
    
    //devuelve la lista de entidades existentes en una fila    
    public PositionList<Entidad> getEntidadesFila (int fila){
    	PositionList<Entidad> entidades = new DoubleLinkedList<Entidad>();
    	for (int i=0; i < getColumnas(); i++) {
    		entidades.addLast(nivel[fila][i]);
    	}
    	return entidades;
    }
    
    public Entidad getEntidad(int x, int y){
    return nivel[x][y];
    }
    
    //listas de oleadas implementar bien, esta es una "pruba"
    public PositionList<PositionList<Zombie>> getOleadas (){
    	PositionList<PositionList<Zombie>> oleadas = new DoubleLinkedList<PositionList<Zombie>>();
    	//agrego lista la primer oleada
    	oleadas.addLast(new DoubleLinkedList<Zombie>());
    	//agregozombie a la oleada
    	try {
			oleadas.last().element().addLast(new ZombieNormal());
    	} catch (EmptyListException e) {e.printStackTrace();}
    	return oleadas;
    }
}
