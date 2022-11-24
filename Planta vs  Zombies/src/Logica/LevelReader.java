package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import Conversor.Conversor;
import Estados.*;
import Fabrica.Factory;
import Visitores.Visitor;
import Visitores.VisitorZombie;
import Zombies.*;


public class LevelReader {

	Nivel nivel = Nivel.getNivel();
	LinkedList<LinkedList<Zombie>> oleadas;
	Conversor conversor = Conversor.getConversor();
	
	static private LevelReader lr= new LevelReader();
	
	static public LevelReader getLevelReader() {return lr;}
	
	private Zombie crearZombie (char c) {
		Factory f = nivel.getFabrica();
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
		int yRandom = conversor.convertirPantalla((int)(Math.random()*fila));
		switch (c) {
		case 'v': {
			z.setPosicion(new Posicion ((int)(Math.random()*(315-x)+x), yRandom)); //x,y eje 
			break;}
		default: {
			z.setPosicion(new Posicion (x, yRandom));
			
			break;} 
		}

		z.setEstado (new EstadoZombieNormal(z));
		z.setVisitor (new VisitorZombie (z));
		z.inicializarEntidadGrafica(z.getImagen(),z.getPosicion());
		//System.out.println("------------------------" + z.getPosicion().getX() + "-----------------" + z.getPosicion().getY());
		return z;
	}
	
	
	public LinkedList<LinkedList<Zombie>> crearOleadas(int numNivel){
		oleadas = new LinkedList<LinkedList<Zombie>>();
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
	      if (arr3[i].getAbsolutePath().contains(numNivel + ".txt")) {
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
     
	      
	      //comienza a leer el archivo
	      while (scan.hasNextLine()) { 
	    	  LinkedList<Zombie> oleada = new LinkedList<Zombie>();
	    	  oleadas.add (oleada);
	        //empezamos por la fila de mas arriba del texto
	        String linea = scan.nextLine();
	        System.out.println (linea);
		        //leemos cada linea de izquierda a dercha
		    for (int i = 0; i < linea.length(); i++) {
		       	oleada.addLast (crearZombie(linea.charAt(i)));
		       	//System.out.println("Cree en level Reader-------------------- " + linea.charAt(i));
	        }
	      }
	      //for (Character c : zombies) {System.out.println (c);}
	    } catch (Exception e) { e.printStackTrace(); }

    	System.out.println("tamaño oleadas" + oleadas.size());
	    return oleadas;
	}
	
	
		
}

