package aula05.Ex2;

public class BicicletaPolicia extends Bicicleta implements Policia {
	
	private TipoServicos tipo;
	private String id;
	
	public BicicletaPolicia(int ano, Cor cor, int nrodas, int lotacao, double peso, TipoServicos tipo, String id) {
		super(ano, cor, nrodas, lotacao, peso);
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
		
		BicicletaPolicia other = (BicicletaPolicia) obj;
		
		if(this.id == null) {
			if(other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		
		if(this.tipo != other.tipo) return false;
		
		return true;
	}

}
