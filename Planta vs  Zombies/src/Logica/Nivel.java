package Logica;

import java.util.Iterator;
import java.util.LinkedList;


import AudioMusic.*;
import Cronometro.Cronometro;
import Estados.*;
import Fabrica.*;
import Fila.*;
import Plantas.*;
import Proyectil.Proyectil;
import Zombies.*;
import GUI.*;


public class Nivel {
	protected int cantSoles;
	protected int valorSol;
	protected EstadoNivel estado;
	protected int nivelLvl;
	protected Factory miFabrica;
	protected ArregloFilas filas;
	protected LinkedList<LinkedList<Zombie>> oleadas;
	protected PanelJardin panelJardin;
	protected Gameplay gameplay;
	protected LinkedList<Entidad> entidadesDinamicas;
	private int [] precios;
	private boolean terminar = false;
	private LevelReader lr;
	Thread hiloGeneral;
	Thread hiloGerneradorOleadas;
	Thread hiloMusica;
	
	static private Nivel nivel = new Nivel();
	
	//protected Singleton singleton;
    
    private Nivel(){
    	cantSoles = 1000;
    }
    
    static public Nivel getNivel() {
        return nivel;
    }
    
    public void iniciarJuego(int numNivel) {
    	if (!terminar) {
	    	nivelLvl = numNivel;
	    	filas = new ArregloFilas();
	    	
	    	precios = new int[4];
	    	precios [2] = precios [1] = 50; 
	    	
	        if (numNivel == 1 || numNivel == 2) {
	        	estado = new EstadoDia();
	    		miFabrica = new FactoryDia();
	    		precios [0] = 100;
	    		precios [3] = 200;   
	    		valorSol = 50;
	        }
	        if (numNivel == 3 || numNivel == 4) {
	        	estado = new EstadoNoche();
	    		miFabrica = new FactoryNoche();
	    		precios [0] = 25;
	    		precios [3] = 75;
	    		valorSol = 25;
	        }
	        
	        lr = new LevelReader(nivelLvl);
	        oleadas = lr.crearOleadas(miFabrica, this);
	        
	    	//System.out.println("GENERANDO NIVEL");
	    	        
	        
	    	//System.out.println("dentro del nivel: ");// solo agrege esto flor perdoname //no hay na que perdonar jajaa
	    	//System.out.println("Estado: "+estado.getClass().getCanonicalName());
	    	
	    	
	    	
	    	HiloZombies hiloZombies = new HiloZombies();
			hiloGerneradorOleadas = new Thread (hiloZombies);
			hiloGerneradorOleadas.start();
			
			Cronometro cronometro;
	    	cronometro = new Cronometro();
	    	hiloGeneral = new Thread (cronometro);
	    	hiloGeneral.start();
	    	
	    	/*AudioPlayer musica = new AudioPlayer();
	    	hiloMusica = new Thread (musica);
	    	hiloGeneral.start();*/
    	}
    	
    }
    
    public int getNivelLVL() {
    	return nivelLvl;
    }
    
    public ArregloFilas getFilas() {
    	return filas;
    }    
    
    public void setZombie (Zombie z){
    	filas.setZombie(z);
    	gameplay.agregarEntidad(z);
    }
    
    public void setProyectil (Proyectil p){
    	filas.setProyectil(p);
    	gameplay.agregarEntidad(p);
    }
    
        
    public void setPlanta(Posicion posicion, int tipoPlanta) {
    	Planta planta = null;
    	int precio = precios[tipoPlanta-1];
    	//System.out.println("Entro en set planta");
    	if (cantSoles >= precio) {
    		//System.out.println("Entro en set planta");
			switch(tipoPlanta) {
			  case 1:{
				planta = miFabrica.createPlantaA();
			    break;
			  }
			  case 2:{
				planta =  miFabrica.createPlantaGirasol();
				break;
			  }
			  case 3:{
				planta =  miFabrica.createPlantaNuez();
				break;
			  }
			  case 4:{
				planta = miFabrica.createPlantaB();
				break;
			  }
		    }
    	}
    	
    	if (planta != null) {
			planta.setPosicion(posicion);
			planta.inicializarEntidadGrafica (planta.getImagen(), planta.getPosicion());
			filas.setPlanta(planta);
			cantSoles -= precio;
	    	gameplay.modificar(planta); //actualiza el label soles 
	    	gameplay.actualizarSoles (cantSoles);
	    	//System.out.println("crea planta");
		}else {
			//System.out.println("ya hay planta o crea el saldo");
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
    	gameplay.actualizarSoles (cantSoles);
    }
    
    public int getSoles () {return cantSoles;}
        
    
    public void matarZombie (Zombie z) {
    	Posicion posZ = z.getPosicion();
    	filas.getFila(posZ.getY()).sacarZombie(z);
    	gameplay.sacarEntidad(z);
    	//decir a gui que saque ese zombie, aca es donde es mas facil que zombie herede de labels?, o que el zombie conozca su labels soluciona?
    }
    
    public void matarProyectil (Proyectil p) {
    	Posicion posP = p.getPosicion();
    	filas.getFila(posP.getY()).sacarProyectil(p);
    	gameplay.sacarEntidad(p);
    	//misma analogia que matar zombie
    }
    
    public void matarPlanta (Planta p) {
    	Posicion posP = p.getPosicion();
    	filas.getFila(posP.getY()).sacarPlanta(p);
    	gameplay.sacarPlanta(p);
    	//misma analogia que matar zombie
    }
    
    public void setPanelJardin (PanelJardin pj) {
    	panelJardin = pj;
    }
    
    public PanelJardin getPanelJardin () {return panelJardin;}
    
    public void setGameplay (Gameplay g) {
    	gameplay = g;
    }
    
    
    public LinkedList<LinkedList<Zombie>> getOleadas () {
    	return oleadas;
    }
    /*
    public LinkedList<Zombie> getOleada(){
    	LinkedList<Zombie> primera = oleadas.getFirst() ;
		oleadas.remove(primera);
		return primera;
    }
    
    public boolean terminoOleada() {
    	return filas.getTodosLosZombies().isEmpty();
    }*/
        
    public void moverProyectiles() {
    	for (int i = 0; i < 6; i ++) {
    		Fila fila = filas.getFila(i);
    		LinkedList <Proyectil> copiaProyectil = (LinkedList<Proyectil>) fila.getProyectiles().clone();
		    for(Proyectil p: copiaProyectil) {
		    	p.atacar();
		    	// entidadesDinamicas.add(p);
		    	gameplay.actualizar(p);
		    }
	    }
    }
    
    public boolean moverZombies() {
    	for (int i = 0; i < 6 && !terminar; i ++) {
    		Fila fila = filas.getFila(i);
    		LinkedList <Zombie> copiaZombies = (LinkedList<Zombie>) fila.getZombies().clone();
    		if (!copiaZombies.isEmpty()) {
	    		Iterator <Zombie> it = fila.getZombies().iterator();
	    		//System.out.println(Math.random() + " " + fila.getZombies().size());
			    while(it.hasNext() && !terminar) { //usar un iterador para cortarlo y no seguir 
			    	Zombie z = it.next();
			    	if (z.getPosicion().getX() == 1) {
			    		terminar = true;
			    		//System.out.println("CHOCO PARED");
			    	}
			    	else {
			    		z.atacar();
			    		gameplay.actualizar(z);
			    		//entidadesDinamicas.add(z);//ver si mandar la entidad o una copia de esta
			    		//panelJardin.actualizar();
			    	}
			    }
    		}
	    }
    	if (terminar) {
    		terminarJuego();
    	}
    	else { 
    		moverProyectiles();
    		//panelJardin.getGameplay().modificarDinamico(entidadesDinamicas);
    	}
    	return terminar;
    }
    
    /*
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
    }*/
    
    
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
        hiloGeneral.stop();
        hiloGerneradorOleadas.stop();
        //hiloMusica.stop();
    	panelJardin.terminarJuego();
    }

    
    
}
