package aula09.Ex3;

import java.util.LinkedList;
import java.util.List;

public class ListaPessoasBFI {
	
	private List<Pessoa> lista;
	
	public ListaPessoasBFI() {
		lista = new LinkedList<>();
	}
	
	public boolean addPessoa(Pessoa p) {
		if(lista.contains(p)) return false;
		else return lista.add(p);
	}
	
	public boolean removePessoa(Pessoa p) {
		if(!lista.contains(p)) return false;
		else return lista.remove(p);
	}
	
	public int totalPessoas() {
		return lista.size();
	}
	
	public Pessoa[] getPessoas() {	
		return lista.toArray(new Pessoa[totalPessoas()]);
	}
	
	public ListaBFIterator iterator() {
		return new ListaBFIterator();
	}
	
	
	public class ListaBFIterator implements BFIterator {
		
		private int i;
		
		public ListaBFIterator() {
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
			return lista.get(i);
		}

		@Override
		public boolean hasNext() {
			return i < totalPessoas();
		}

		@Override
		public Pessoa next() {
			assert this.hasNext() : "Não existe seguinte";
			this.i++;
			return lista.get(i - 1);
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada!");	
		}
		
	}

}
