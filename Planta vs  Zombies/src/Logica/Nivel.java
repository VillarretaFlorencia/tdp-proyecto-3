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
import GUI.PanelJardin;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;
import Zombies.ZombieNormal;


public class Nivel {
	protected int soles;
	protected Estado estado;
	protected int nivelLvl;
	protected Factory miFabrica;
	protected ArregloFilas filas;
	protected LinkedList<LinkedList<Zombie>> oleadas;
	protected PanelJardin panelJardin;
	private int [] precios;
	
	static private Nivel nivel = new Nivel();
	
	//protected Singleton singleton;
    
    private Nivel(){
    	
    }
    
    static public Nivel getNivel() {
        return nivel;
    }
    
    public void iniciarJuego(int i) {
    	nivelLvl = i;
    	filas = new ArregloFilas();
    	
    	precios = new int[4];
    	precios [2] = precios [1] = 50; 
    	
        if (i == 1 || i == 2) {
        	estado = new EstadoDia();
    		miFabrica = new FactoryDia();
    		precios [0] = 100;
    		precios [3] = 200;    		
        }
        if (i == 3 || i == 4) {
        	estado = new EstadoNoche();
    		miFabrica = new FactoryNoche();
    		precios [0] = 25;
    		precios [3] = 75;
        }

    	System.out.println("GENERANDO NIVEL");
    	        
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
    
        
    public void setPlanta(Posicion pos, int i) {
    	Planta p = null;
    	if (soles >= precios[i-1] && filas.getFila(pos.getY()).hayLugar(pos.getX())) {
			switch(i) {
			  case 1:{
				p = miFabrica.createPlantaA();
			    break;
			  }
			  case 2:{
				p =  miFabrica.createPlantaGirasol();
				break;
			  }
			  case 3:{
				p =  miFabrica.createPlantaNuez();
				break;
			  }
			  case 4:{
				p = miFabrica.createPlantaB();
				break;
			  }
		    }
			if (p != null) {
				p.setPosicion(pos);
				filas.setPlanta(p);
		    	panelJardin.colocarPlanta (p);
			}
    	}
		//ENVIAR A LA GUI, LA ENTIDAD QUE AGREGAMOS Y LA POSICION (ACTUALIZAR)
		//fila.insertPlanta(p.getY(),nivel[p.getX()][p.getY()]);
    }
    
    public void checkColisiones() {
    	for (int i = 0; i< 7; i++) {
    		filas.getFila(i).colisiones();
    	}
    }
      
    public void matarZombie (Zombie z) {
    	//decir a gui que saque ese zombie, aca es donde es mas facil que zombie herede de labels?, o que el zombie conozca su labels soluciona?
    }
    
    public void matarProyectil (Proyectil p) {
    	//misma analogia que matar zombie
    }
    
    public void matarPlanta (Planta p) {
    	//misma analogia que matar zombie
    }
    
    public void setPanelJardin (PanelJardin pj) {
    	panelJardin = pj;
    }
    
    public PanelJardin getPanelJardin () {return panelJardin;}
    
    
    public LinkedList<LinkedList<Zombie>> getOleadas () {
    	return oleadas;
    }
    
    
}
