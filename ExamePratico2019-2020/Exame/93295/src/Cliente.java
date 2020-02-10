
public class Cliente {
	
	private String nome;
	private String nCont;
	private TipoCliente tipo;
	
	public Cliente(String nome, String nCont, TipoCliente tipo) {
		assert nome.length() > 0 : "Nome inválido";
		assert nCont.length() > 0 : "Número de contribuinte inválido";
		assert tipo != null : "Tipo de cliente inválido";
		
		this.nome = nome;
		this.nCont = nCont;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public String getnCont() {
		return nCont;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", nCont=" + nCont + ", tipo=" + tipo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nCont == null) ? 0 : nCont.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Cliente other = (Cliente) obj;
		if (nCont == null) {
			if (other.nCont != null)
				return false;
		} else if (!nCont.equals(other.nCont))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
