package aula11.Ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class A {

	public static void main(String[] args) {
		
		List<Pessoa> vp = new ArrayList<Pessoa>();
		for (int i=0; i<10; i++)
			vp.add(new Pessoa("Beb� no Vector "+i, 1000+i, Data.today()));
		Iterator<Pessoa> vec = vp.iterator();
		
		System.out.println("ArrayList:");
		printSet(vp.iterator());
		
		List<Pessoa> lp = new LinkedList<Pessoa>();
		while ( vec.hasNext() )
			lp.add( vec.next() );
		
		System.out.println("\nLinkedList:");		
		Iterator<Pessoa> lista = lp.iterator();
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		List<Figura> figList = new LinkedList<Figura>();
		figList.add(new Circulo (1,3, 1));
		figList.add(new Quadrado(3,4, 2));
		figList.add(new Retangulo(1,2, 2,5));
		
		System.out.println("\nLista Figuras:");
		printSet(figList.iterator());
		
		System.out.println("\nSoma da Area de Lista de Figuras: " + sumArea(figList));
		
		// Partindo do principio que Quadrado extends Rectangulo:
		List<Retangulo> quadList = new LinkedList<Retangulo>();
		quadList.add(new Quadrado(3,4, 2));
		quadList.add(new Retangulo(1,2, 2,5));
		
		System.out.println("Soma da Area de Lista de Quadrados: " + sumArea(quadList));		
	}

	@SuppressWarnings("rawtypes")
	private static double sumArea(List<? extends Figura> figList) {
		double areaTotal = 0;
		Iterator it = figList.iterator();
		while(it.hasNext()) {
			areaTotal += ((Figura) it.next()).area();
		}
		return areaTotal;
	}

	private static <T> void printSet(Iterator<T> iterator) {
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}

}
