package aula05.Ex2;

public class MotoPolicia extends Moto implements Policia {
	
	private TipoServicos tipo;
	private String id;
	
	public MotoPolicia(int ano, Cor cor, int nrodas, int lotacao, double peso, Combustivel combustivel, int cilindrada, int potencia, double consumo, double velMax, String matricula, TipoServicos tipo, String id) {
		super(ano, cor, nrodas, lotacao, peso, combustivel, cilindrada, potencia, consumo, velMax, matricula);
		assert id != null : "ID inválido";
		this.tipo = tipo;
		this.id = id;
		
	}
	
	public String toString() {
		return "Polícia: " + super.toString()
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
		
		MotoPolicia other = (MotoPolicia) obj;
		
		if(this.id == null) {
			if(other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		
		if(this.tipo != other.tipo) return false;
		
		return true;
	}

}
