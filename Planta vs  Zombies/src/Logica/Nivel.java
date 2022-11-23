package Logica;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import Cronometro.Cronometro;
import Estados.EstadoNivel;
import Estados.EstadoDia;
import Estados.EstadoNoche;
import Fabrica.Factory;
import Fabrica.FactoryDia;
import Fabrica.FactoryNoche;
import Fila.ArregloFilas;
import Fila.Fila;
import GUI.PanelJardin;
import Plantas.Planta;
import Proyectil.Proyectil;
import Zombies.Zombie;
import Zombies.ZombieNormal;


public class Nivel {
	protected int cantSoles;
	protected int valorSol;
	protected EstadoNivel estado;
	protected int nivelLvl;
	protected Factory miFabrica;
	protected ArregloFilas filas;
	protected LinkedList<LinkedList<Zombie>> oleadas;
	protected PanelJardin panelJardin;
	protected LinkedList<Entidad> entidadesDinamicas;
	private int [] precios;
	private LevelReader lr;
	Thread hc;
	
	static private Nivel nivel = new Nivel();
	
	//protected Singleton singleton;
    
    private Nivel(){
    	cantSoles = 1000;
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
    		valorSol = 50;
        }
        if (i == 3 || i == 4) {
        	estado = new EstadoNoche();
    		miFabrica = new FactoryNoche();
    		precios [0] = 25;
    		precios [3] = 75;
    		valorSol = 25;
        }
        
        lr = new LevelReader(nivelLvl);
        oleadas = lr.crearOleadas(miFabrica, this);
        
    	System.out.println("GENERANDO NIVEL");
    	        
        
    	System.out.println("dentro del nivel: ");// solo agrege esto flor perdoname //no hay na que perdonar jajaa
    	System.out.println("Estado: "+estado.getClass().getCanonicalName());
    	
    	
    	Cronometro cronometro;
    	cronometro = new Cronometro();
    	hc = new Thread (cronometro);
    	hc.start();
    	
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
    	int precio = precios[i-1];
    	System.out.println("Entro en set planta");
    	if (cantSoles >= precio  && filas.getFila(pos.getY()).hayLugar(pos.getX())) {
    		System.out.println("Entro en set planta");
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
    	}
    	
    	if (p != null) {
			p.setPosicion(pos);
			filas.setPlanta(p);
			cantSoles -= precio;
	    	panelJardin.colocarPlanta (p); //actualiza el label soles 
	    	System.out.println("crea planta");
		}else {
			System.out.println("ya hay planta o crea el saldo");
		}
		//ENVIAR A LA GUI, LA ENTIDAD QUE AGREGAMOS Y LA POSICION (ACTUALIZAR)
		//fila.insertPlanta(p.getY(),nivel[p.getX()][p.getY()]);
    }
    
    public void checkColisiones() {
    	for (int i = 0; i < 6; i++) {
    		filas.getFila(i).colisiones();
    	}
    }
    
    public void aumentarSoles () {
    	cantSoles += valorSol;
    }
    
    public int getSoles () {return cantSoles;}
    
    public Entidad getEntidad (int x, int y) {
    	return filas.getFila(y).plantaEnPos(x);    	
    }
      
    
    public void matarZombie (Zombie z) {
    	Posicion posZ = z.getPosicion();
    	filas.getFila(posZ.getY()).sacarZombie(z);
    	panelJardin.sacarZombie(z);
    	//decir a gui que saque ese zombie, aca es donde es mas facil que zombie herede de labels?, o que el zombie conozca su labels soluciona?
    }
    
    public void matarProyectil (Proyectil p) {
    	Posicion posP = p.getPosicion();
    	filas.getFila(posP.getY()).sacarProyectil(p);
    	panelJardin.sacarProyectil(p);
    	//misma analogia que matar zombie
    }
    
    public void matarPlanta (Planta p) {
    	Posicion posP = p.getPosicion();
    	filas.getFila(posP.getY()).sacarPlanta(p);
    	panelJardin.sacarPlanta(p);
    	//misma analogia que matar zombie
    }
    
    public void setPanelJardin (PanelJardin pj) {
    	panelJardin = pj;
    }
    
    public PanelJardin getPanelJardin () {return panelJardin;}
    
    
    public LinkedList<LinkedList<Zombie>> getOleadas () {
    	
    	return oleadas;
    }
    
        
    private void moverProyectiles() {
    	for (int i = 0; i < 6; i ++) {
    		Fila fila = filas.getFila(i);
		    for(Proyectil p: fila.getProyectiles()) {
		    	p.atacar();
		    	entidadesDinamicas.add(p);
		    }
	    }
    }
    
    private boolean moverZombies() {
    	boolean terminar = false;
    	for (int i = 0; i < 6 && !terminar; i ++) {
    		Fila fila = filas.getFila(i);
    		if (!fila.getZombies().isEmpty()) {
	    		Iterator <Zombie> it = fila.getZombies().iterator();
			    while(it.hasNext() && !terminar) { //usar un iterador para cortarlo y no seguir 
			    	Zombie z = it.next();
			    	if (z.getPosicion().getX() == 1) {
			    		terminar = true;
			    	}
			    	else {
			    		z.atacar();
			    		entidadesDinamicas.add(z);//ver si mandar la entidad o una copia de esta
			    	}
			    }
    		}
	    }
    	return terminar;
    }
    
    
    public boolean moverEntidades() {
    	entidadesDinamicas = new LinkedList<Entidad>();
    	boolean terminar = moverZombies();
    	if (terminar) {
    		terminarJuego();
    	}
    	else { 
    		moverProyectiles();
    		panelJardin.getGameplay().modificarDinamico(entidadesDinamicas);
    	}
    	return terminar;
    }
    
    
    public void activarDefensa () {
    	LinkedList<Planta> todasPlantas = filas.getTodasLasPlantas();
		for (Planta p: todasPlantas) {
			p.atacar();
		}
    }
    
    public void terminarJuego () {
    	for (int i = 0; i< 6; i++) {
    		filas.getFila(i).limpiarFila();
    	}
    	hc.stop();
    	panelJardin.terminarJuego();
    }
    
    
}
