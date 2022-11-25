package Logica;

import AudioMusic.*;
import Conversor.Conversor;
import Estados.*;
import Fabrica.*;
import Fila.*;
import GUI.*;
import Hilos.*;
import Plantas.*;
import Proyectil.Proyectil;
import Zombies.*;
import java.util.Iterator;
import java.util.LinkedList;

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
  protected MainFrame mainframe;
  protected LinkedList<Entidad> entidadesDinamicas;
  private int[] precios;
  private boolean terminar;
  private int cantOleadas;
  Thread hiloGeneral;
  Thread hiloGerneradorOleadas;
  Thread hiloMusica;
  Conversor conversor = Conversor.getConversor();
  private static Nivel nivel = new Nivel();

  private Nivel() {
    cantSoles = 1000;
    terminar = false;
  }

  public static Nivel getNivel() {
    return nivel;
  }

  public void iniciarJuego(int numNivel) {
    if (!terminar) {
      nivelLvl = numNivel;
      filas = new ArregloFilas();

      precios = new int[4];
      precios[2] = precios[1] = 50;

      if (numNivel == 1 || numNivel == 2) {
        estado = new EstadoDia();
        miFabrica = new FactoryDia();
        precios[0] = 100;
        precios[3] = 200;
        valorSol = 50;
      }
      if (numNivel == 3 || numNivel == 4) {
        estado = new EstadoNoche();
        miFabrica = new FactoryNoche();
        precios[0] = 25;
        precios[3] = 75;
        valorSol = 25;
      }

      oleadas = LevelReader.getLevelReader().crearOleadas(numNivel);
      cantOleadas = oleadas.size();

      HiloZombies lanzaOleadas = new HiloZombies();
      hiloGerneradorOleadas = new Thread(lanzaOleadas);
      hiloGerneradorOleadas.start();

      HiloGeneral general;
      general = new HiloGeneral();
      hiloGeneral = new Thread(general);
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
  
  public void descontarCanOleadas() {
	  cantOleadas--;
  }

  public void setZombie(Zombie z) {
    filas.setZombie(z);
    gameplay.agregarEntidad(z);
  }

  public void setProyectil(Proyectil p) {
    filas.setProyectil(p);
    gameplay.agregarEntidad(p);
  }

  public void setPlanta(Posicion posicion, int tipoPlanta) {
    Planta planta = null;
    int precio = precios[tipoPlanta - 1];
    if (cantSoles >= precio) {
      switch (tipoPlanta) {
        case 1:
          {
            planta = miFabrica.createPlantaA();
            break;
          }
        case 2:
          {
            planta = miFabrica.createPlantaGirasol();
            break;
          }
        case 3:
          {
            planta = miFabrica.createPlantaNuez();
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
      planta.inicializarEntidadGrafica(
        planta.getImagen(),
        planta.getPosicion()
      );
      filas.setPlanta(planta);
      cantSoles -= precio;
      gameplay.modificar(planta); //actualiza el label soles
      gameplay.actualizarSoles(cantSoles);
    }
  }

  public void checkColisiones() {
    for (int i = 0; i < 6; i++) {
      filas.getFila(i).colisiones();
    }
  }

  public void aumentarSoles() {
    cantSoles += valorSol;
    gameplay.actualizarSoles(cantSoles);
  }

  public int getSoles() {
    return cantSoles;
  }

  public void matarZombie(Zombie z) {
    int posZ = conversor.convertirFila(z.getPosicion().getY());
    filas.getFila(posZ).sacarZombie(z);
    gameplay.sacarEntidad(z);
  }

  public void matarProyectil(Proyectil p) {
    int posP = conversor.convertirFila(p.getPosicion().getY());
    filas.getFila(posP).sacarProyectil(p);
    gameplay.sacarEntidad(p);
  }

  public void matarPlanta(Planta p) {
    int posP = conversor.convertirFila(p.getPosicion().getY());
    filas.getFila(posP).sacarPlanta(p);
    gameplay.sacarPlanta(p);
  }

  public void setPanelJardin(PanelJardin pj) {
    panelJardin = pj;
  }

  public PanelJardin getPanelJardin() {
    return panelJardin;
  }

  public void setGameplay(Gameplay g) {
    gameplay = g;
  }

  public LinkedList<LinkedList<Zombie>> getOleadas() {
    return oleadas;
  }

  public void moverProyectiles() {
    for (int i = 0; i < 6; i++) {
      Fila fila = filas.getFila(i);
      LinkedList<Proyectil> copiaProyectil = (LinkedList<Proyectil>) fila.getProyectiles().clone();
      for (Proyectil p : copiaProyectil) {
        p.atacar();
        gameplay.actualizar(p);
      }
    }
  }

  public void moverZombies() {
    for (int i = 0; i < 6 && !terminar; i++) {
      Fila fila = filas.getFila(i);
      LinkedList<Zombie> copiaZombies = (LinkedList<Zombie>) fila.getZombies() .clone();
      if (!copiaZombies.isEmpty()) {
        Iterator<Zombie> it = copiaZombies.iterator();
        while (it.hasNext() && !terminar) { //usar un iterador para cortarlo y no seguir
          Zombie z = it.next();
          if (z.getPosicion().getX() < 10) {
            terminar = true;
          } else {
            z.atacar();
            gameplay.actualizar(z);
          }
        }
      }
    }
    if (terminar) {
    	mainframe.gameover();
      terminarJuego();
    } else {
      moverProyectiles();
    }
  }

  public void activarDefensa() {
    LinkedList<Planta> todasPlantas = filas.getTodasLasPlantas();
    for (Planta p : todasPlantas) {
      p.atacar();
    }
  }

  public void terminarJuego() {
    for (int i = 0; i < 6; i++) {
      filas.getFila(i).limpiarFila();
    }    
    hiloGeneral.stop();
    hiloGerneradorOleadas.stop();
    oleadas.clear();
    //hiloMusica.stop();
    panelJardin.terminarJuego();
  }
  
  public boolean getTerminar() {return terminar;}
  
  public boolean superoJuego() {
	    if (!filas.getTodosLosZombies().isEmpty() && cantOleadas == 0) {
	    	System.out.println("entre a ganar" + terminar);
	    	terminar = true;
	    	mainframe.win();
	    }
	    return terminar;
  }

  public Factory getFabrica() {
    return miFabrica;
  }

	public void setMainframe(MainFrame mf) {
		mainframe = mf;
		
	}
}
