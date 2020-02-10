package teste14_15;

public class CadeiraRodas extends Cadeira implements Transporte{
	
	private int numRodas;
	private boolean eletrica;
	private TipoTransporte transporte;

	public CadeiraRodas(String designacao, int id, Tipo material, TipoCadeira tipo, double altura, int numApoios, int numRodas, boolean eletrica) {
		super(designacao, id, material, tipo, altura, numApoios);

		assert numRodas > 1 : "Número de rodas inválido";
		this.numRodas = numRodas;
		this.eletrica = eletrica;
		if(eletrica) transporte = TipoTransporte.MobilidadeRedizuda;
		else transporte = TipoTransporte.Urgente;
	}

	public int getNumRodas() {
		return numRodas;
	}

	public boolean isEletrica() {
		return eletrica;
	}
	
	@Override
	public TipoTransporte getTipo() {
		return transporte;
	}

	@Override
	public void setTipo(TipoTransporte tipo) {
		assert tipo != null : "Tipo de transporte inválido";
		this.transporte = tipo;
	}
	
	@Override
	public String toString() {
		return "CadeiraRodas [numRodas=" + numRodas + ", eletrica=" + eletrica + ", transporte=" + transporte + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (eletrica ? 1231 : 1237);
		result = prime * result + numRodas;
		result = prime * result + ((transporte == null) ? 0 : transporte.hashCode());
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
		CadeiraRodas other = (CadeiraRodas) obj;
		if (eletrica != other.eletrica)
			return false;
		if (numRodas != other.numRodas)
			return false;
		if (transporte != other.transporte)
			return false;
		return true;
	}

}
