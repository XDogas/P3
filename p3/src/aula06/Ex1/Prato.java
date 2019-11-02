package aula06.Ex1;

import java.util.LinkedList;

public class Prato implements Comparable<Prato> {
	
	private String nome;
	private LinkedList<Alimento> composicao;
	
	public Prato(String nome) {
		this.nome = nome;
		composicao = new LinkedList<Alimento>();
	}
	
	public String getNome() { return this.nome; }

	public boolean addIngrediente(Alimento a) {
		if(a == null) return false;
		if(composicao.contains(a)) return false;
		return composicao.add(a);
	}
	
	public boolean removeIngrediente(Alimento a) {
		if(a == null) return false;
		if(!composicao.contains(a)) return false;
		return composicao.remove(a);
	}
	
	public int getNumIngredientes() {
		return composicao.size();
	}
	
	public Alimento[] getComposicao() {
		return composicao.toArray(new Alimento[this.getNumIngredientes()]);
	}
	
	public double getTotalCalorias() {
		double cal = 0;
		for(Alimento a : composicao) {
			cal += a.getCalorias();
		}
		return cal;
	}
	
	public double getTotalProteinas() {
		double prt = 0;
		for(Alimento a : composicao) {
			prt += a.getProteinas();
		}
		return prt;
	}
	
	public double getTotalPeso() {
		double pes = 0;
		for(Alimento a : composicao) {
			pes += a.getPeso();
		}
		return pes;
	}

	@Override
	public int compareTo(Prato p) {
		if(this.getTotalCalorias() < p.getTotalCalorias()) return -1;
		if(this.getTotalCalorias() > p.getTotalCalorias()) return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Prato '" + this.getNome() + "' composto por " + this.getNumIngredientes() + " Ingredientes";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((composicao == null) ? 0 : composicao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		if (composicao == null) {
			if (other.composicao != null)
				return false;
		} else if (!composicao.equals(other.composicao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
