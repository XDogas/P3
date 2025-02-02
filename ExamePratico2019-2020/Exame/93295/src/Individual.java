
public class Individual extends Cliente {
	
	private String nTel;

	public Individual(String nome, String nCont, TipoCliente tipo, String nTel) {
		super(nome, nCont, tipo);
		assert nTel.length() > 0  : "N�mero de telem�vel inv�lido";
		this.nTel = nTel;
	}
	
	public Individual(String nome, String nCont, TipoCliente tipo) {
		this(nome, nCont, tipo, "sem n�mero");
	}

	public String getnTel() {
		return nTel;
	}

	@Override
	public String toString() {
		return "Individual [nTel=" + nTel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nTel == null) ? 0 : nTel.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individual other = (Individual) obj;
		if (nTel == null) {
			if (other.nTel != null)
				return false;
		} else if (!nTel.equals(other.nTel))
			return false;
		return true;
	}

}
