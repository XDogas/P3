package teste14_15;

public class CamaArticulada extends Cama {

	private boolean eletrica;
	
	public CamaArticulada(String designacao, int id, Tipo material, double comprimento, double largura, boolean colchao, boolean eletrica) {
		super(designacao, id, material, comprimento, largura, colchao);
		this.eletrica = eletrica;
	}

	public boolean isEletrica() {
		return eletrica;
	}

	@Override
	public String toString() {
		return "CamaArticulada [eletrica=" + eletrica + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (eletrica ? 1231 : 1237);
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
		CamaArticulada other = (CamaArticulada) obj;
		if (eletrica != other.eletrica)
			return false;
		return true;
	}

}
