package teste14_15;

public class Cama extends Mobiliario {
	
	private Dimensao dimensao;
	private boolean colchao;

	public Cama(String designacao, int id, Tipo material, double comprimento, double largura , boolean colchao) {
		super(designacao, id, material);
		this.dimensao = new Dimensao(comprimento,largura);
		this.colchao = colchao;
	}

	public Dimensao getDimensao() {
		return dimensao;
	}

	public boolean isColchao() {
		return colchao;
	}

	@Override
	public String toString() {
		return "Cama [dimensao=" + dimensao + ", colchao=" + colchao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (colchao ? 1231 : 1237);
		result = prime * result + ((dimensao == null) ? 0 : dimensao.hashCode());
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
		Cama other = (Cama) obj;
		if (colchao != other.colchao)
			return false;
		if (dimensao == null) {
			if (other.dimensao != null)
				return false;
		} else if (!dimensao.equals(other.dimensao))
			return false;
		return true;
	}

}
