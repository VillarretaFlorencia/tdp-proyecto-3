package Logica;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import Estados.Estado;
import Estados.EstadoDia;
import Estados.EstadoNoche;
import Excepciones.EmptyListException;
import Fabrica.Factory;
import Fabrica.FactoryDia;
import Fabrica.FactoryNoche;
import Zombies.Zombie;
import Zombies.ZombieNormal;


public class Nivel {
	protected int soles;
	protected Entidad grilla;
	protected Estado estado;
	protected int nivelLvl;
	protected Factory miFabrica;
	protected Map<Integer,Entidad> fila;
	protected LinkedList<LinkedList<Zombie>> oleadas;
	
	
	//protected Singleton singleton;
    private Entidad[][] nivel = new Entidad[9][6]; //cambiar por filas y columnas
    
    
    public Nivel(int i){
    	nivelLvl = i;
    	
    	
    	
        for(int x = 0; x<9; x++){
            for(int y = 0; y<6; y++){
                nivel[x][y] = null;
            }
        }
        if (i == 1 || i == 2) {
        	estado = new EstadoDia();
    		miFabrica = new FactoryDia();
        }
        if (i == 3 || i == 4) {
        	estado = new EstadoNoche();
    		miFabrica = new FactoryNoche();
        }
        
        LevelReader lr = new LevelReader(nivelLvl);
    	oleadas = lr.crearOleadas(miFabrica, this);
    }
    
    public int getColumnas(){
        return nivel[0].length;
    }
    public int getFilas(){
        return nivel.length;
    }
    
    //devuelve la lista de entidades existentes en una fila    
    public LinkedList<Entidad> getEntidadesFila (int fila){
    	LinkedList<Entidad> entidades = new LinkedList<Entidad>();
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
		switch(i) {
		  case 1:
			nivel[p.getX()][p.getY()] = miFabrica.createPlantaA();
		    break;
		  case 2:
			nivel[p.getX()][p.getY()] = miFabrica.createPlantaGirasol();
		    break;
		  case 3:
			nivel[p.getX()][p.getY()] = miFabrica.createPlantaNuez();
		    break;
		  case 4:
		    nivel[p.getX()][p.getY()] = miFabrica.createPlantaB();
		    break;
	    }
		//ENVIAR A LA GUI, LA ENTIDAD QUE AGREGAMOS Y LA POSICION (ACTUALIZAR)
		//fila.insertPlanta(p.getY(),nivel[p.getX()][p.getY()]);
    }
    
      
    
    public LinkedList<LinkedList<Zombie>> getOleadas () {
    	return oleadas;
    }
    
    
}
