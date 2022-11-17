package Logica;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

import Estados.Estado;
import Estados.EstadoDia;
import Estados.EstadoNoche;
import Fabrica.Factory;
import Fabrica.FactoryDia;
import Fabrica.FactoryNoche;
import Fila.ArregloFilas;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;
import Zombies.ZombieNormal;


public class Nivel {
	protected int soles;
	protected Entidad grilla;
	protected Estado estado;
	protected int nivelLvl;
	protected Factory miFabrica;
	protected ArregloFilas filas;
	protected LinkedList<LinkedList<Zombie>> oleadas;
	
	
	
	//protected Singleton singleton;
    
    public Nivel(int i){
    	
    	System.out.println("GENERANDO NIVEL");
    	nivelLvl = i;
    	filas = new ArregloFilas();
    	
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
    	System.out.println("dentro del nivel: ");// solo agrege esto flor perdoname //no hay na que perdonar jajaa
    	System.out.println("Estado: "+estado.getClass().getCanonicalName());
    }
    
    
    public int getNivelLVL() {
    	return nivelLvl;
    }
    
    public ArregloFilas getFilas() {
    	return filas;
    }    
    
    public void setZombie (Zombie z){
    	filas.setZombie(z);
    }
    
    public void setProyectil (Proyectil p){
    	filas.setProyectil(p);
    }
    
    public void setPlanta (Planta p){
    	filas.setPlanta(p);
    }
    
    public void modificar(Posicion pos, int i) {
		switch(i) {
		  case 1:{
			Planta p = miFabrica.createPlantaA();
			p.setPosicion(pos);
			filas.setPlanta(p);
		    break;
		  }
		  case 2:{
			Planta p =  miFabrica.createPlantaGirasol();
			p.setPosicion(pos);
			filas.setPlanta(p);
			break;
		  }
		  case 3:{
			Planta p =  miFabrica.createPlantaNuez();
			p.setPosicion(pos);
			filas.setPlanta(p);
			break;
		  }
		  case 4:{
			Planta p = miFabrica.createPlantaB();
			p.setPosicion(pos);
			filas.setPlanta(p);
			break;
		  }
	    }
		//ENVIAR A LA GUI, LA ENTIDAD QUE AGREGAMOS Y LA POSICION (ACTUALIZAR)
		//fila.insertPlanta(p.getY(),nivel[p.getX()][p.getY()]);
    }
      
    
    public LinkedList<LinkedList<Zombie>> getOleadas () {
    	return oleadas;
    }
    
    
}
