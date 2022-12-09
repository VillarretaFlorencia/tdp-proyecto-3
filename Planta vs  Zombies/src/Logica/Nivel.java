package Logica;


import Conversor.Conversor;
import Estados.*;
import Fabrica.*;
import Fila.*;
import GUI.*;
import Hilos.*;
import Plantas.*;
import Proyectil.*;
import Zombies.*;
import Posicion.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Nivel {

  protected int nivelLvl;
  protected int limiteIzquierdo;
  protected int limiteDerecho;
  protected int cantSoles;
  protected int valorSol;
  protected int cantOleadas;
  protected boolean terminarJuego;
  protected int[] precios;
  protected EstadoNivel miEstado;
  protected Factory miFabrica;
  protected ArregloFilas filas;
  protected LinkedList<LinkedList<Zombie>> oleadas;
  protected Gameplay gameplay;
  protected MainFrame mainframe;
  Thread hiloGeneral;
  Thread hiloGerneradorOleadas;
  Thread hiloMusica;
  Conversor conversor = Conversor.getConversor();
  
  private static Nivel nivel = new Nivel();

  private Nivel() {
    terminarJuego = false;
  }

  public void iniciarJuego(int numNivel) {
    if (!terminarJuego) {
      nivelLvl = numNivel;
      limiteIzquierdo = 1;
      limiteDerecho = 540;
      cantSoles = 1000;
      filas = new ArregloFilas();

      precios = new int[4];
      precios[0] = 50;
      precios[1] = 50;

      if (numNivel == 1 || numNivel == 2) {
        miEstado = new EstadoDia();
        miFabrica = new FactoryDia();
        precios[2] = 100;
        precios[3] = 200;
        valorSol = 50;
      }
      if (numNivel == 3 || numNivel == 4) {
        miEstado = new EstadoNoche();
        miFabrica = new FactoryNoche();
        precios[2] = 25;
        precios[3] = 75;
        valorSol = 25;
      }

      oleadas = LevelReader.getLevelReader().crearOleadas(numNivel);
      //cantOleadas = oleadas.size(); //-1

      HiloOleadasZombies lanzaOleadas = new HiloOleadasZombies();
      hiloGerneradorOleadas = new Thread(lanzaOleadas);
      hiloGerneradorOleadas.start();

      HiloGeneral general;
      general = new HiloGeneral();
      hiloGeneral = new Thread(general);
      hiloGeneral.start();
      
      HiloMusica musica = new HiloMusica();
	  hiloMusica = new Thread (musica);
	  hiloMusica.start();
    }
  }

  public void setCantOleadas(int cant) {
	  cantOleadas = cant;
	  gameplay.actualizarOleadas(cantOleadas);
  }
  
  public void setGameplay(Gameplay g) {
    gameplay = g;
  }
  
  public void setMainframe(MainFrame mf) {
	mainframe = mf;
  }
	  
  public static Nivel getNivel() {
    return nivel;
  }
  
  public int getNivelLVL() {
    return nivelLvl;
  }
  
  public int getLimiteIzquierdo() {return limiteIzquierdo;}
  
  public int getLimiteDerecho() {return limiteDerecho;}
  
  public int getSoles() {
    return cantSoles;
  }
  
  public int getValorSol() {return valorSol;}
  
  public boolean getTerminar() {return terminarJuego;}
  
  public int[] getPrecios() {
	return precios;
  }
  
  public Factory getFabrica() {
    return miFabrica;
  }
  
  public ArregloFilas getFilas() {
    return filas;
  }
  
  public LinkedList<LinkedList<Zombie>> getOleadas() {
    return (LinkedList<LinkedList<Zombie>>) oleadas.clone();
  }
    
  public int getCantOleadas() {return cantOleadas;}
  
  public void actualizarSoles(int valor) {
	cantSoles += valor;
    gameplay.actualizarSoles(cantSoles);
  }
  
  
  public void descontarCanOleadas() {
	  gameplay.actualizarOleadas(cantOleadas);
	  cantOleadas--;
  }
  
  public void setPlanta(Posicion posicion, int tipoPlanta) {
    Planta planta = null;
    int precio = precios[tipoPlanta - 1];
    if (cantSoles >= precio) {
      switch (tipoPlanta) {
        case 1:
          {
            planta = miFabrica.createPlantaGirasol();
            break;
          }
        case 2:
          {
            planta = miFabrica.createPlantaNuez();
            break;
          }
        case 3:
          {
            planta = miFabrica.createPlantaA();
            break;
          }
        case 4:
          {
            planta = miFabrica.createPlantaB();
            break;
          }
      }
    }

    if (planta != null) {
      planta.setPosicion(posicion);
      planta.inicializarEntidadGrafica(planta.getImagen(), planta.getPosicion());
      filas.setPlanta(planta);
      actualizarSoles(-precio);
      gameplay.agregarPlanta(planta.getEntidadGrafica());
    }
  }
  public void setZombie(Zombie zombie) {
    filas.setZombie(zombie);
    gameplay.agregarEntidad(zombie.getEntidadGrafica());
  }

  public void setProyectil(Proyectil proyectil) {
    filas.setProyectil(proyectil);
    gameplay.agregarEntidad(proyectil.getEntidadGrafica());
  }

  public void matarPlanta(Planta planta) {
    int posicionPlanta = conversor.convertirFila(planta.getPosicion().getY());
    filas.getFila(posicionPlanta).sacarPlanta(planta);
    gameplay.sacarPlanta(planta.getEntidadGrafica());
  }
	  
  public void matarZombie(Zombie zombie) {
    int posicionZombie = conversor.convertirFila(zombie.getPosicion().getY());
    filas.getFila(posicionZombie).sacarZombie(zombie);
    gameplay.sacarEntidad(zombie.getEntidadGrafica());
  }

  public void matarProyectil(Proyectil proyectil) {
    int posicionProyectil = conversor.convertirFila(proyectil.getPosicion().getY());
    filas.getFila(posicionProyectil).sacarProyectil(proyectil);
    gameplay.sacarEntidad(proyectil.getEntidadGrafica());
  }
  
  public void activarDefensa() {
	  for (int i = 0; i < 6; i++) {
	      Fila fila = filas.getFila(i);
	      LinkedList<Planta> copiaPlantas = (LinkedList<Planta>) fila.getPlantas().clone();
	      if (!copiaPlantas.isEmpty()) {
	    	  Iterator<Planta> it = copiaPlantas.iterator();
	    	  while (it.hasNext()) {
	    		  Planta planta  = it.next();
	    		  planta.atacar();
	    	      //gameplay.actualizarEntidad(planta.getEntidadGrafica());
	    	  }
	      }
	  }
  }

  public void moverZombies() {
    for (int i = 0; i < 6 && !terminarJuego; i++) {
      Fila fila = filas.getFila(i);
      LinkedList<Zombie> copiaZombies = (LinkedList<Zombie>) fila.getZombies().clone();
      if (!copiaZombies.isEmpty()) {
        Iterator<Zombie> it = copiaZombies.iterator();
        while (it.hasNext() && !terminarJuego) { //usar un iterador para cortarlo y no seguir
          Zombie zombie = it.next();
          if (zombie.getPosicion().getX() < 1) {
            terminarJuego = true;
          } else {
            zombie.atacar();
            //gameplay.actualizarEntidad(z.getEntidadGrafica());
          }
        }
      }
    }
    if (terminarJuego) {
    	mainframe.setJuegoGanado(false);
    	terminarJuego();
    } else {
      moverProyectiles();
    }
  }
  
  public void moverProyectiles() {
    for (int i = 0; i < 6; i++) {
      Fila fila = filas.getFila(i);
      LinkedList<Proyectil> copiaProyectil = (LinkedList<Proyectil>) fila.getProyectiles().clone();
      for (Proyectil proyectil : copiaProyectil) {
    	  //if (fila.hayZombies()) {
    		  proyectil.atacar();
    		  if (proyectil.getPosicion().getX() > limiteDerecho) {
    			  matarProyectil(proyectil);
    		  }
    		  //gameplay.actualizarEntidad(p.getEntidadGrafica());
    	  //}
    	 // else matarProyectil(p);
      }
    }
  }
  
  public void checkColisiones() {
    for (int i = 0; i < 6; i++) {
      filas.getFila(i).colisiones();
    }
  }
  
  public void superoNivel() {
	  boolean sinZombies = true;
	  for (int i = 0; i < 6  && sinZombies; i++) {
	      Fila fila = filas.getFila(i);
	      sinZombies = !fila.hayZombies();
	  }
	    if (sinZombies && cantOleadas == 1) {
	    	terminarJuego = true;
	    	mainframe.setJuegoGanado(true);
	    	terminarJuego();
	    }
  }

  public void terminarJuego() {
	mainframe.terminarJuego();
    hiloGeneral.stop();
    hiloGerneradorOleadas.stop();
    for (int i = 0; i < 6; i++) {
        filas.getFila(i).limpiarFila();
    }    
    oleadas.clear();
    hiloMusica.stop();
  }
  
  

  
/*
	public void actualizarEntidad(EntidadGrafica entidadGrafica) {
		gameplay.actualizarEntidad (entidadGrafica);
		
	}*/
/*
	public void actualizarEntidadGrafica(EntidadGrafica entidadGrafica) {
	      gameplay.actualizarEntidad(entidadGrafica);
	}*/

	
}
