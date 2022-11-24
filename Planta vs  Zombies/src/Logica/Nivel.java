package Logica;

import java.util.Iterator;
import java.util.LinkedList;


import AudioMusic.*;
import Conversor.Conversor;
import Cronometro.Cronometro;
import Estados.*;
import Fabrica.*;
import Fila.*;
import Plantas.*;
import Proyectil.Proyectil;
import Zombies.*;
import GUI.*;
import Hilos.HiloGeneral;


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
	Thread hiloGeneral;
	Thread hiloGerneradorOleadas;
	Thread hiloMusica;
	Conversor conversor = Conversor.getConversor();
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
	        	        
	        oleadas = LevelReader.getLevelReader().crearOleadas(numNivel);
	        	    	        
	        
	    	//System.out.println("dentro del nivel: ");// solo agrege esto flor perdoname //no hay na que perdonar jajaa
	    	//System.out.println("Estado: "+estado.getClass().getCanonicalName());
	    	
	    	
	    	
	    	HiloZombies lanzaOleadas = new HiloZombies();
			hiloGerneradorOleadas = new Thread (lanzaOleadas);
			hiloGerneradorOleadas.start();
			
			HiloGeneral general;
	    	general = new HiloGeneral();
	    	hiloGeneral = new Thread (general);
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
    	System.out.println("POSICION" + posicion.getX() + ", " + posicion.getY());
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
    	int posZ = conversor.convertirFila(z.getPosicion().getY());
    	filas.getFila(posZ).sacarZombie(z);
    	gameplay.sacarEntidad(z);
    	//decir a gui que saque ese zombie, aca es donde es mas facil que zombie herede de labels?, o que el zombie conozca su labels soluciona?
    }
    
    public void matarProyectil (Proyectil p) {
    	int posP = conversor.convertirFila(p.getPosicion().getY());
    	filas.getFila(posP).sacarProyectil(p);
    	gameplay.sacarEntidad(p);
    	//misma analogia que matar zombie
    }
    
    public void matarPlanta (Planta p) {
    	int posP = conversor.convertirFila(p.getPosicion().getY());
    	filas.getFila(posP).sacarPlanta(p);
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
    		//System.out.println("entre a mover zombies-------" + fila.getZombies().size());
    		//System.out.println("entre a mover zombies-------" + copiaZombies.size());
    		if (!copiaZombies.isEmpty()) {
	    		Iterator <Zombie> it = copiaZombies.iterator();
			    while(it.hasNext() && !terminar) { //usar un iterador para cortarlo y no seguir 
			    	Zombie z = it.next();
			    	//System.out.println("entre a mover zombies-------" + z.getEntidadGrafica().getLabel().getBounds());
			    	if (z.getPosicion().getX() == 1) {
			    		terminar = true;
			    		//System.out.println("CHOCO PARED");
			    	}
			    	else {
			    		//System.out.println("TAMAÑO FILA" + copiaZombies.size());
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
    public Factory getFabrica() {
    	return miFabrica;
    }

    
    
}
