package aula05.Ex2;

public class CarroPolicia extends Automovel implements Policia {
	
	private TipoServicos tipo;
	private String id;
	
	public CarroPolicia(int ano, Cor cor, int nrodas, int lotacao, double peso, Combustivel combustivel, int cilindrada, int potencia, double consumo, double velMax, String matricula, TipoServicos tipo, String id) {
		super(ano, cor, nrodas, lotacao, peso, combustivel, cilindrada, potencia, consumo, velMax, matricula);
		assert id != null : "ID inv�lido";
		this.tipo = tipo;
		this.id = id;
		
	}
	
	public String toString() {
		return "Pol�cia: " + super.toString()
						   + "; Tipo: " + this.getTipo()
						   + "; ID: " + this.getID();
	}

	@Override
	public TipoServicos getTipo() {	return this.tipo; }

	@Override
	public String getID() {	return this.id; }
	
	@Override
	public boolean equals(Object obj)
	{
		if(!super.equals(obj)) return false;
		
		CarroPolicia other = (CarroPolicia) obj;
		
		if(this.id == null) {
			if(other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		
		if(this.tipo != other.tipo) return false;
		
		return true;
	}

}
