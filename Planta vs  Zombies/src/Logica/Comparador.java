package Logica;

public class Comparador<E> implements java.util.Comparator<E> {

	public int compare(E o1, E o2) {
		
		return ((Comparable<E>) o1).compareTo(o2);
	}
	
}