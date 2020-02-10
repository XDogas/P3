package aula13.Ex3;

import java.util.ArrayList;
import java.util.List;

public class Empregado {
	
	private String nome;
	private int id;
	private static int idCount;
	private List<String> brinquedos;
	private int bilhetes;
	
	public Empregado(String nome) {
		assert nome.length() > 0 : "Nome de empregado inválido";
		this.nome = nome;
		this.id = idCount++;;
		this.brinquedos = new ArrayList<>();
	}

	public String getNome() {
		return this.nome;
	}
	
	public String getPrimeiroNome() {
		return this.nome.split(" ")[0];
	}
	
	public int getID() {
		return this.id;
	}

	public String[] getBrinquedos() {
		return this.brinquedos.toArray(new String[brinquedos.size()]);
	}
	
	public void addBrinquedo(String b) {
		this.brinquedos.add(b);
	}
	
	public void addBilhete() {
		this.bilhetes++;
	}
	
	public void removeBilhete() {
		this.bilhetes--;
	}
	
	public String getBilhetes() {
		if(this.bilhetes == 0) return this.nome + " não tem bilhetes";
		else if(this.bilhetes == 1) return this.nome + " tem 1 bilhete";
		else return this.nome + " tem " + this.bilhetes + "bilhetes";
		
	}

	@Override
	public String toString() {
		return "ID: " + this.id +  ", " + this.nome + ", brinquedos: " + this.brinquedos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brinquedos == null) ? 0 : brinquedos.hashCode());
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
		Empregado other = (Empregado) obj;
		if (brinquedos == null) {
			if (other.brinquedos != null)
				return false;
		} else if (!brinquedos.equals(other.brinquedos))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
