package aula06.Ex1;

public class Legume extends Alimento implements AlimentoVegetariano {
	
	private String nome;

	public Legume(String nome, double proteinas, double calorias, double peso) {
		super(proteinas, calorias, peso);
		this.nome = nome;
	}
	
	@Override
	public String getNome() { return this.nome; }
	
	@Override
	public String toString() {
		return "Legume " + this.getNome() + super.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj)) return false;
		Legume other = (Legume) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
