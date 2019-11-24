package aula09.Ex3;

import java.util.ArrayList;
import java.util.List;

public class VectorPessoasBFI {
	
private List<Pessoa> vector;
	
	public VectorPessoasBFI() {
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
	
	public VectorBFIterator iterator() {
		return new VectorBFIterator();
	}
	
	
	public class VectorBFIterator implements BFIterator {
		
		private int i;
		
		public VectorBFIterator() {
			this.i = 0;
		}
		
		@Override
		public boolean hasPrevious() {
			return this.i > 0;
		}
		
		@Override
		public Pessoa previous() {
			assert this.hasPrevious() : "Não existe anterior";
			this.i--;
			return vector.get(i);
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
