package aula07.Ex1;

public class Companhia implements Comparable<Object> {
	
	private String sigla;
	private String nome;
	private Hora atrasoTotal;
	private int numAtrasos;
	
	public Companhia(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
		this.numAtrasos = 0;
		this.atrasoTotal = new Hora(0,0);
	}
	
	public String getSigla() { return this.sigla; }
	public String getNome() { return this.nome; }
	public int getNumAtrasos() { return this.numAtrasos; }
	public Hora getAtrasoTotal() { return this.atrasoTotal; }
	
	public void addAtraso(Hora atraso) {
		 assert atraso != null : "Hora inválida";
		 atrasoTotal = Hora.sumHoras(atrasoTotal, atraso);
		 numAtrasos++;
	}
	
	public Hora getMedia() {
		if(numAtrasos == 0) return atrasoTotal;
		return new Hora(atrasoTotal.getMinutos() / numAtrasos);
	}
	
	@Override
	public int compareTo(Object o) {
		assert o instanceof Companhia : "Companhia Inválida!";
		Companhia c = (Companhia) o;
	 	return getMedia().compareTo(c.getMedia());
	}

	@Override
	public String toString() {
		return getNome() + "\t" + getMedia();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atrasoTotal == null) ? 0 : atrasoTotal.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numAtrasos;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		Companhia other = (Companhia) obj;
		if (atrasoTotal == null) {
			if (other.atrasoTotal != null)
				return false;
		} else if (!atrasoTotal.equals(other.atrasoTotal))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numAtrasos != other.numAtrasos)
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

}
