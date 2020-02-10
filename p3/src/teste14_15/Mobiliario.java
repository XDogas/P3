package teste14_15;

public abstract class Mobiliario {
	
	private String designacao;
	private int id;
	private Tipo material;
	
	public enum Tipo {
		Madeira, Plastico, Metal, Sintetico;
	}
	
	public Mobiliario(String designacao, int id, Tipo material) {
		assert designacao.length() > 0 : "Designação inválida";
		assert id > 0 : "ID inválido";
		assert material != null : "Material inválido";
		
		this.designacao = designacao;
		this.id = id;
		this.material = material;
	}

	public String getDesignacao() {
		return designacao;
	}

	public int getId() {
		return id;
	}

	public Tipo getMaterial() {
		return material;
	}

	@Override
	public String toString() {
		return "Mobiliario [designacao=" + designacao + ", id=" + id + ", material=" + material + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designacao == null) ? 0 : designacao.hashCode());
		result = prime * result + id;
		result = prime * result + ((material == null) ? 0 : material.hashCode());
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
		Mobiliario other = (Mobiliario) obj;
		if (designacao == null) {
			if (other.designacao != null)
				return false;
		} else if (!designacao.equals(other.designacao))
			return false;
		if (id != other.id)
			return false;
		if (material != other.material)
			return false;
		return true;
	}

}
