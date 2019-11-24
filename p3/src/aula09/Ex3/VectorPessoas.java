package aula09.Ex3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VectorPessoas {
	
	private List<Pessoa> vector;
	
	public VectorPessoas() {
		this.vector = new ArrayList<>();
	}
	
	public boolean addPessoa(Pessoa p) {
		if(vector.contains(p)) return false;
		else return vector.add(p);
	}
	
	public boolean removePessoa(Pessoa p) {
		if(!vector.contains(p)) return false;
		else return vector.remove(p);
	}
	
	public int totalPessoas() {
		return vector.size();
	}
	
	public VectorIterator iterator() {
		return new VectorIterator();
	}
	
	
	public class VectorIterator implements Iterator<Pessoa> {
		
		private int i;
		
		public VectorIterator() {
			this.i = 0;
		}
	
		@Override
		public boolean hasNext() {
			return i < totalPessoas();
		}
	
		@Override
		public Pessoa next() {
			assert this.hasNext() : "Não existe seguinte";
			this.i++;
			return vector.get(i - 1);
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada!");	
		}
	}

}
