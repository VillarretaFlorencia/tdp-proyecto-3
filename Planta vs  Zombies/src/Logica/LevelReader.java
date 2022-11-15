package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import Fabrica.Factory;
import Zombies.*;


public class LevelReader {

	Nivel nivel;
	LinkedList<Character> zombies;

	
	public LevelReader(int lvl) {
		
		File directorio = new File(System.getProperty("user.dir"));
	    String[] arr = directorio.list();
	    File dirRecursos = null;
	    File dirtxt = null;
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i].contains("recursos")) {
	        dirRecursos = new File(arr[i]);
	      }
	    }
	    //System.out.println(dirRecursos.getAbsolutePath());
	    File[] arr2 = dirRecursos.listFiles();
	    for (int i = 0; i < arr2.length; i++) {
	      //System.out.println(arr2[i].getAbsolutePath());
	      if (arr2[i].getAbsolutePath().contains("zombies")) {
	        //System.out.println("Entra al if de src      " + arr2[i].getAbsolutePath());
	        dirtxt = new File(arr2[i].getAbsolutePath());
	      }
	    }
		
		String ruta = "";
		switch (lvl) {
			case 1: {
				ruta = dirtxt.getAbsolutePath();
				//System.out.println(dirtxt);
				break;} 
		}
		
		File file = new File(ruta); // abrimos el archivo dentro de java
	    try {
	      //prepara el archivo
	      Scanner scan = new Scanner(file);

	      zombies = new LinkedList<Character>();
	     
	      
	      //comienza a leer el archivo
	      while (scan.hasNextLine()) {
	    	zombies.add ('/');
	        //empezamos por la fila de mas arriba del texto
	        String linea = scan.nextLine();
	        System.out.println (linea);
		        //leemos cada linea de izquierda a dercha
		    for (int i = 0; i < linea.length(); i++) {
		       	zombies.add (linea.charAt(i));
	        }
	      }
	      for (Character c : zombies) {System.out.println (c);}
	      
	      //cerrar archivo?
	    } catch (Exception e) { e.printStackTrace(); }
	}
	
	private Zombie crearZombie (char c, Factory f, Nivel n) {
		Zombie z = null;
		switch (c) {
		case 'n': {
			z = f.createZombieNormal();
			break;}
		case 'd': {
			z = f.createZombiePeriodico();
			break;} 
		case 'c': {
			z = f.createZombieCono();
			break;} 
		case 'b': {
			z = f.createZombieBalde();
			break;} 
		case 'p': {
			z = f.createZombiePuerta();
			break;} 
		case 'v': {
			z = f.createZombieVolador();
			break;} 
		case 'B': {
			z = f.createZombieBandera();
			break;} 
		}
		int fila = n.getFilas()-1;
		int columna = n.getColumnas()-1;
		switch (c) {
		case 'v': {
			z.setPosicion(new Posicion ((int)(Math.random()*fila),(int)(Math.random()*(2-columna)+columna))); //filas,columnas
			break;}
		default: {
			z.setPosicion(new Posicion ((int)(Math.random()*fila),columna));
			break;} 
		}
		return z;
	}
	
	
	public LinkedList<LinkedList<Zombie>> crearOleadas(Factory f, Nivel n){
		LinkedList<LinkedList<Zombie>> oleadas = new LinkedList<LinkedList<Zombie>>() ;
		for (Character c : zombies) {
			if (c == '/') {
				oleadas.add (new LinkedList<Zombie>());
			}
			else {
				oleadas.getLast().add(crearZombie(c, f, n));
			}
		}
		return oleadas;
	}
	
	/*public LinkedList<Zombie> [] crearOleadas(Factory f){
		LinkedList<Zombie> [] oleadas = (LinkedList<Zombie>[]) new Object [5];
		int i = -1; //numero de oleada
		for (Character c : zombies) {
			if (c == '/') {
				i++;
				oleadas [i] = new LinkedList<Zombie>();
			}
			else {
				oleadas[i].add(crearZombie(c, f));
			}
		}
		return oleadas;
	}*/
	
	
}

