package aula13.Ex1;

public class Estado extends Regiao {

	private Localidade capital;
	
	public Estado(String nome, int populacao, Localidade capital) {
		super(nome, populacao);
		assert capital.getTipoLocalidade() == TipoLocalidade.CIDADE : "Localidade inválida";
		this.capital = capital;
	}

	public Localidade getCapital() {
		return capital;
	}

	public void setCapital(Localidade capital) {
		this.capital = capital;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capital == null) ? 0 : capital.hashCode());
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
		Estado other = (Estado) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		return true;
	}

}
