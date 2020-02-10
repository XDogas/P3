package teste14_15;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaGeneric<T> {
	
	private List<T> lista;
	
	public ListaGeneric() {
		this.lista = new LinkedList<>();
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
	
	public List<T> toList() {
		List<T> l = new LinkedList<>();
		for(int i=0; i<totalElem(); i++) l.add(lista.get(i));
		return l;
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
			return this.i < totalElem();
		}

		@Override
		public T next() {
			assert this.hasNext() : "Não existe seguinte";
			this.i++;
			return lista.get(i-1);
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada");
		}
		
	}
}
