package aula09.Ex3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListaPessoas {
	
	private List<Pessoa> lista;
	
	public ListaPessoas() {
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
	
	public ListaIterator iterator() {
		return new ListaIterator();
	}
	
	
	public class ListaIterator implements Iterator<Pessoa> {
		
		private int i;
		
		public ListaIterator() {
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
			return lista.get(i - 1);
		}
		
		public void remove() {
			throw new UnsupportedOperationException("Operação não suportada!");	
		}
		
	}
	
}
