package aula10.Ex1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaGeneric<T> {
	
	private List<T> lista;
	
	public ListaGeneric() {
		lista = new LinkedList<>();
	}
	
	public boolean addElem(T e) {
		if(lista.contains(e)) return false;
		else return lista.add(e);
	}
	
	public boolean removeElem(T e) {
		if(!lista.contains(e)) return false;
		else return lista.remove(e);
	}
	
	public int totalElem() {
		return lista.size();
	}
	
	public ListaIterator iterator() {
		return new ListaIterator();
	}
	
	
	public class ListaIterator implements Iterator<T> {
		
		private int i;
		
		public ListaIterator() {
			this.i = 0;
		}

		@Override
		public boolean hasNext() {
			return i < totalElem();
		}

		@Override
		public T next() {
			assert this.hasNext() : "N�o existe seguinte";
			this.i++;
			return lista.get(i - 1);
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Opera��o n�o suportada!");	
		}
		
	}

}
