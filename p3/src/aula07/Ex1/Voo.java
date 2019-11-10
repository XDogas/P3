package aula07.Ex1;

public class Voo implements Comparable<Object> {
	
	private Hora partida;
	private String vooID;
	private Companhia companhia;
	private String origem;
	private Hora atraso;
	private String obs;
	
	public Voo(Hora partida, String vooID, String origem, Hora atraso) {
		assert partida != null : "Hora de partida inválida";
		assert vooID != null : "Identificação do voo inválida";
		assert companhia != null : "Companhia inválida";
		assert origem != null : "País de origem inválido";
		
		this.partida = partida;
		this.vooID = vooID;
		this.companhia = getCompanyByVooID(vooID);
		this.origem = origem;
		this.atraso = atraso;		
		if(atraso != null) obs = "	Previsto: " + Hora.sumHoras(partida, atraso);
	}
	
	public Voo(Hora partida, String vooID, String origem) {
		this(partida, vooID, origem, new Hora(0,0));
	}
	
	public Hora getPartioda() { return this.partida; }
	public String getVooID() { return this.vooID; }
	public Companhia getCompanhia() { return this.companhia; }
	public String getOrigem() { return this.origem; }
	public Hora getAtraso() { return this.atraso; }
	public String getObs() { return this.obs; }
	
	public void setAtraso(Hora atraso) {
		assert atraso != null : "Atraso inválido";
		this.atraso = atraso;
		this.companhia.addAtraso(atraso);
		
	}
	
	private Companhia getCompanyByVooID(String vooID) {
        assert CompanhiasList.size() != 0 : "A lista de companhias aéreas encontra-se vazia";
        assert vooID != null : "Identificação do voo inválida";
        	
        return CompanhiasList.getCompanhiaBySigla(vooID.substring(0,2)); 
    }

	@Override
	public int compareTo(Object o) {
		assert o instanceof Voo : "Companhia Inválida";
		Voo v = (Voo) o;
		return getPartioda().compareTo(v.getPartioda());
	}

	@Override
	public String toString() {
		
		if(atraso == null)
			return String.format("%-6s\t%-10s\t%-22s\t%-25s", this.partida, this.vooID, this.companhia, this.origem);	
		else
			return String.format("%-6s\t%-10s\t%-22s\t%-25s\t%-8s\t%-15s", this.partida, this.vooID, this.companhia, this.origem, this.atraso, this.obs);	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atraso == null) ? 0 : atraso.hashCode());
		result = prime * result + ((companhia == null) ? 0 : companhia.hashCode());
		result = prime * result + ((obs == null) ? 0 : obs.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((partida == null) ? 0 : partida.hashCode());
		result = prime * result + ((vooID == null) ? 0 : vooID.hashCode());
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
		Voo other = (Voo) obj;
		if (atraso == null) {
			if (other.atraso != null)
				return false;
		} else if (!atraso.equals(other.atraso))
			return false;
		if (companhia == null) {
			if (other.companhia != null)
				return false;
		} else if (!companhia.equals(other.companhia))
			return false;
		if (obs == null) {
			if (other.obs != null)
				return false;
		} else if (!obs.equals(other.obs))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (partida == null) {
			if (other.partida != null)
				return false;
		} else if (!partida.equals(other.partida))
			return false;
		if (vooID == null) {
			if (other.vooID != null)
				return false;
		} else if (!vooID.equals(other.vooID))
			return false;
		return true;
	}
	
}
