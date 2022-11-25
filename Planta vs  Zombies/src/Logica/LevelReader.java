package Logica;

import Conversor.Conversor;
import Estados.*;
import Fabrica.Factory;
import Visitores.VisitorZombie;
import Zombies.*;
import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;

public class LevelReader {

  Nivel nivel = Nivel.getNivel();
  LinkedList<LinkedList<Zombie>> oleadas;
  Conversor conversor = Conversor.getConversor();

  private static LevelReader lr = new LevelReader();

  public static LevelReader getLevelReader() {
    return lr;
  }

  private Zombie crearZombie(char c) {
    Factory f = nivel.getFabrica();
    Zombie z = null;
    switch (c) {
      case 'n':
        {
          z = f.createZombieNormal();
          break;
        }
      case 'd':
        {
          z = f.createZombiePeriodico();
          break;
        }
      case 'c':
        {
          z = f.createZombieCono();
          break;
        }
      case 'b':
        {
          z = f.createZombieBalde();
          break;
        }
      case 'p':
        {
          z = f.createZombiePuerta();
          break;
        }
      case 'v':
        {
          z = f.createZombieVolador();
          break;
        }
      case 'B':
        {
          z = f.createZombieBandera();
          break;
        }
    }
    int fila = 5; // y
    int x = 570;
    int yRandom = conversor.convertirPantalla((int) (Math.random() * fila));
    switch (c) {
      case 'v':
        {
          z.setPosicion(
            new Posicion((int) (Math.random() * (315 - x) + x), yRandom)
          ); //x,y eje
          break;
        }
      default:
        {
          z.setPosicion(new Posicion(x, yRandom));

          break;
        }
    }

    z.setEstado(new EstadoZombieNormal(z));
    z.setVisitor(new VisitorZombie(z));
    z.inicializarEntidadGrafica(z.getImagen(), z.getPosicion());
    return z;
  }

  public LinkedList<LinkedList<Zombie>> crearOleadas(int numNivel) {
    oleadas = new LinkedList<LinkedList<Zombie>>();
    File directorio = new File(System.getProperty("user.dir"));
    System.out.println(directorio.getAbsolutePath() + "dddddd");
    String[] arr = directorio.list();
    File dirRecursos = null;
    File dirtxt = null;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].contains("src")) {
        System.out.println(arr[i]);
        dirRecursos = new File(arr[i]);
      }
    }

    File[] arr2 = dirRecursos.listFiles();
    for (int i = 0; i < arr2.length; i++) {
      System.out.println(arr2[i].getAbsolutePath());
      if (arr2[i].getAbsolutePath().contains("recursos")) {
        dirtxt = new File(arr2[i].getAbsolutePath());
      }
    }

    File[] arr3 = dirtxt.listFiles();
    for (int i = 0; i < arr3.length; i++) {
      if (arr3[i].getAbsolutePath().contains(numNivel + ".txt")) {
        dirtxt = new File(arr3[i].getAbsolutePath());
      }
    }

    String ruta = "";

    ruta = dirtxt.getAbsolutePath();

    File file = new File(ruta); // abrimos el archivo dentro de java
    try {
      //prepara el archivo
      Scanner scan = new Scanner(file);

      //comienza a leer el archivo
      while (scan.hasNextLine()) {
        LinkedList<Zombie> oleada = new LinkedList<Zombie>();
        oleadas.add(oleada);
        //empezamos por la fila de mas arriba del texto
        String linea = scan.nextLine();
        System.out.println(linea);
        //leemos cada linea de izquierda a dercha
        for (int i = 0; i < linea.length(); i++) {
          oleada.addLast(crearZombie(linea.charAt(i)));
        }
      }
      //for (Character c : zombies) {System.out.println (c);}
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("tamano oleadas" + oleadas.size());
    return oleadas;
  }
}
