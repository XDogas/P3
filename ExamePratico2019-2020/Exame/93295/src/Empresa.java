
public class Empresa extends Cliente {
	
	private Cliente gerente;

	public Empresa(String nome, String nCont, TipoCliente tipo, Cliente gerente) {
		super(nome, nCont, tipo);
		assert gerente != null;
		this.gerente = gerente;
	}

	public Cliente getGerente() {
		return gerente;
	}

	@Override
	public String toString() {
		return "Empresa [gerente=" + gerente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((gerente == null) ? 0 : gerente.hashCode());
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
		Empresa other = (Empresa) obj;
		if (gerente == null) {
			if (other.gerente != null)
				return false;
		} else if (!gerente.equals(other.gerente))
			return false;
		return true;
	}

}
