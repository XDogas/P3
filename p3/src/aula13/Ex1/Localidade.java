package aula13.Ex1;

public class Localidade {
	
	private String nome;
	private int populacao;
	private TipoLocalidade tipoLocalidade;
	
	public Localidade(String nome, int populacao, TipoLocalidade tipoLocalidade) {
		assert nome.length() >= 0 : "Nome inválido";
		assert populacao >= 10000 && populacao <= 99999 : "População inválido, tem de ter entre 10000 e 99999";
		assert tipoLocalidade != null : "Tipo de localidade inválido";
		
		this.nome = nome;
		this.populacao = populacao;
		this.tipoLocalidade = tipoLocalidade;
	}
	
	public Localidade() {
		this.nome = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int codigo) {
		this.populacao = codigo;
	}

	public TipoLocalidade getTipoLocalidade() {
		return tipoLocalidade;
	}

	public void setTipoLocalidade(TipoLocalidade tipoLocalidade) {
		this.tipoLocalidade = tipoLocalidade;
	}

	@Override
	public String toString() {
		if(this.nome == null) return " (Capital: *Indefinida*)";
		else return " (Capital: " + this.tipoLocalidade + this.nome + ", população " + this.populacao + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + populacao;
		result = prime * result + ((tipoLocalidade == null) ? 0 : tipoLocalidade.hashCode());
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
		Localidade other = (Localidade) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (populacao != other.populacao)
			return false;
		if (tipoLocalidade != other.tipoLocalidade)
			return false;
		return true;
	}
	
}
