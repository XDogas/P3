package aula10.Ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VectorGeneric<T> {
	
	private List<T> vector;
	
	public VectorGeneric() {
		this.vector = new ArrayList<>();
	}
	
	public boolean addElem(T e) {
		if(vector.contains(e)) return false;
		else return vector.add(e);
	}
	
	public boolean removeElem(T e) {
		if(!vector.contains(e)) return false;
		else return vector.remove(e);
	}
	
	public int totalElem() {
		return vector.size();
	}
	
	public VectorIterator iterator() {
		return new VectorIterator();
	}
	
	public class VectorIterator implements Iterator<T> {
		
		private int i;
		
		public VectorIterator() {
			this.i = 0;
		}
	
		@Override
		public boolean hasNext() {
			return i < totalElem();
		}
	
		@Override
		public T next() {
			assert this.hasNext() : "Não existe seguinte";
			this.i++;
			return vector.get(i - 1);
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada!");	
		}
	}

}
