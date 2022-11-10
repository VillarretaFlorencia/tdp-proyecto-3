package Logica;

import java.util.LinkedList;

import Estados.Estado;
import Estados.EstadoDia;
import Estados.EstadoNoche;
import Excepciones.EmptyListException;
import Fabrica.Factory;
import Fabrica.FactoryDia;
import Fabrica.FactoryNoche;
import TDALista.DoubleLinkedList;
import TDALista.PositionList;
import Zombies.Zombie;
import Zombies.ZombieNormal;

public class Nivel {
	protected int soles;
	protected Entidad grilla;
	protected Estado estado;
	protected int nivelLvl;
	protected Factory fabricaDia;
	protected Factory fabricaNoche;
	//protected Singleton singleton;
    private Entidad[][] nivel = new Entidad[6][9];
    
    public Nivel(int i){
    	nivelLvl = i;
        for(int x = 0; x<6; x++){
            for(int y = 0; y<9; y++){
                nivel[x][y] = null;
            }
        }
        switch(i) {
        	case(1):
        		estado = new EstadoDia();
        		fabricaDia = new FactoryDia();
        		break;
        	case(2):
        		estado = new EstadoDia();
        		fabricaDia = new FactoryDia();
        		break;
        	case(3):
        		estado = new EstadoNoche();
        		fabricaNoche = new FactoryNoche();
        		break;
        	case(4):
        		estado = new EstadoNoche();
        		fabricaNoche = new FactoryNoche();
        		break;		
        }      
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
    
    public int getNivelLVL() {
    	return nivelLvl;
    }
    
    public void modificar(Posicion p, int i) {
    	if (nivel[p.getX()][p.getY()] == null) {
    		if (nivelLvl == 1  || nivelLvl == 2) {
	    		switch(i) {
	    		  case 0:
	    			nivel[p.getX()][p.getY()] = fabricaDia.createPlantaA();
	    		    break;
	    		  case 1:
	    			nivel[p.getX()][p.getY()] = fabricaDia.createPlantaB();
	    		    break;
	    		  case 2:
	    			nivel[p.getX()][p.getY()] = fabricaDia.createPlantaGirasol();
	    		    break;
	    		  case 3:
	    		    nivel[p.getX()][p.getY()] = fabricaDia.createPlantaNuez();
	    		    break;
	    		}
    		}
    		if (nivelLvl == 3  || nivelLvl == 4) {
	    		switch(i) {
	    		  case 0:
	    			nivel[p.getX()][p.getY()] = fabricaNoche.createPlantaA();
	    		    break;
	    		  case 1:
	    			nivel[p.getX()][p.getY()] = fabricaNoche.createPlantaB();
	    		    break;
	    		  case 2:
	    			nivel[p.getX()][p.getY()] = fabricaNoche.createPlantaGirasol();
	    		    break;
	    		  case 3:
	    		    nivel[p.getX()][p.getY()] = fabricaNoche.createPlantaNuez();
	    		    break;
	    		}
    		}
    	}
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
