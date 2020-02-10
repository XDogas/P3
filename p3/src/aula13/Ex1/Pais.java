package aula13.Ex1;

public class Pais {
	
	private String nome;
	private Localidade capital;
	private int populacao;
	
	public Pais(String nome, Localidade capital) {
		assert nome.length() > 0 : "Nome inválido";
		assert capital.getTipoLocalidade() == TipoLocalidade.CIDADE : "Cidade inválida";
		
		this.nome = nome;
		this.capital = capital;
		this.populacao = 0;
	}
	
	public Pais(String nome) {
		assert nome.length() > 0 : "Nome inválido";		
		this.nome = nome;
		this.capital = new Localidade();
		this.populacao = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Localidade getCapital() {
		return capital;
	}

	public void setCapital(Localidade capital) {
		this.capital = capital;
	}
	
	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public void addRegiao(Regiao reg) {		
		this.populacao += reg.getPopulacao();
	}

	@Override
	public String toString() {
		return "Pais: " + this.nome + ", Populaçao: " + this.populacao + this.capital.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + populacao;
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
		Pais other = (Pais) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (populacao != other.populacao)
			return false;
		return true;
	}
	
}
