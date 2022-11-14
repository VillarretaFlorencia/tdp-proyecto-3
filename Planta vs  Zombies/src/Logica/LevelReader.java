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
		
		String ruta = "";
		switch (lvl) {
			case 1: {
				ruta = "C:\\Users\\FRAVEGA\\Desktop\\Flor\\Estudios\\Ingenieria en sistemas de la informacion\\(7951) Tecnologia de Programacion\\Proyecto-3\\tdp-proyecto-3\\Planta vs  Zombies\\recursos\\zombies.txt";
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
	
	private Zombie crearZombie (char c, Factory f) {
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
		
		return z;
	}
	
	
	public LinkedList<LinkedList<Zombie>> crearOleadas(Factory f){
		LinkedList<LinkedList<Zombie>> oleadas = new LinkedList<LinkedList<Zombie>>() ;
		for (Character c : zombies) {
			if (c == '/') {
				oleadas.add (new LinkedList<Zombie>());
			}
			else {
				oleadas.getLast().add(crearZombie(c, f));
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

