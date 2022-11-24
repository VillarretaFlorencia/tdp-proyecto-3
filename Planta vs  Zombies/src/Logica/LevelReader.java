package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import Estados.*;
import Fabrica.Factory;
import Visitores.Visitor;
import Visitores.VisitorZombie;
import Zombies.*;


public class LevelReader {

	Nivel nivel;
	LinkedList<Character> zombies;

	
	public LevelReader(int lvl) {
		
		File directorio = new File(System.getProperty("user.dir"));
		System.out.println(directorio.getAbsolutePath()+"dddddd");
	    String[] arr = directorio.list();
	    File dirRecursos = null;
	    File dirtxt = null;
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i].contains("src")) {
	    	  System.out.println(arr[i]);
	        dirRecursos = new File(arr[i]);
	      }
	    }
	    
	  
	    //System.out.println(dirRecursos.getAbsolutePath()+"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	    File[] arr2 = dirRecursos.listFiles();
	    for (int i = 0; i < arr2.length; i++) {
	      System.out.println(arr2[i].getAbsolutePath());
	      if (arr2[i].getAbsolutePath().contains("recursos")) {
	        //System.out.println("Entra al if de src      " + arr2[i].getAbsolutePath());
	        dirtxt = new File(arr2[i].getAbsolutePath());
	      }
	    }
	    
	    //System.out.println(dirtxt.getAbsolutePath()+"OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	    
	    File[] arr3 = dirtxt.listFiles();
	    for (int i = 0; i < arr3.length; i++) {
	      //System.out.println(arr3[i].getAbsolutePath());
	      if (arr3[i].getAbsolutePath().contains(lvl+".txt")) {
	        //System.out.println("Entra al if de src      " + arr3[i].getAbsolutePath());
	        dirtxt = new File(arr3[i].getAbsolutePath());
	      }
	    }
		
	    
	    //System.out.println(dirtxt.getAbsolutePath()+"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		String ruta = "";
	    
		ruta = dirtxt.getAbsolutePath();
		
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
	      //for (Character c : zombies) {System.out.println (c);}
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
		int fila = 5; // y 
		int x = 400;
		switch (c) {
		case 'v': {
			z.setPosicion(new Posicion ((int)(Math.random()*(315-x)+x), (int)(Math.random()*fila))); //x,y eje 
			break;}
		default: {
			z.setPosicion(new Posicion (x,(int)(Math.random()*fila)));
			
			break;} 
		}

		z.setEstado (new EstadoZombieNormal(z));
		z.setVisitor (new VisitorZombie (z));
		z.inicializarEntidadGrafica(z.getImagen(),z.getPosicion());
		//System.out.println("------------------------" + z.getPosicion().getX() + "-----------------" + z.getPosicion().getY());
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
		
}

