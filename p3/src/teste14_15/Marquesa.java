package teste14_15;

public class Marquesa extends Cama {
	
	private boolean inclinacao;

	public Marquesa(String designacao, int id, Tipo material, double comprimento, double largura, boolean colchao, boolean inclinacao) {
		super(designacao, id, material, comprimento, largura, colchao);
		this.inclinacao = inclinacao;
	}

	public boolean isInclinacao() {
		return inclinacao;
	}

	@Override
	public String toString() {
		return "Marquesa [inclinacao=" + inclinacao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (inclinacao ? 1231 : 1237);
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
		Marquesa other = (Marquesa) obj;
		if (inclinacao != other.inclinacao)
			return false;
		return true;
	}

}
