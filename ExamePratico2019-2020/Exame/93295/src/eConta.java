
public class eConta extends Conta implements Eletronica {

	public eConta(Cliente cliente) {
		super(cliente);
		cliente.setTipo(TipoCliente.Online);
	}

	@Override
	public String toString() {
		return "eConta []";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
