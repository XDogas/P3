package aula06.Ex1.AlternativaFalhada;

import java.util.LinkedList;

import aula06.Ex1.DiaSemana;
import aula06.Ex1.Prato;

public class EmentaDia {
	
	private DiaSemana dia;
	private LinkedList<Prato> pratos;
	
	public EmentaDia(DiaSemana dia) {
		this.dia = dia;
		this.pratos = new LinkedList<Prato>();
	}
	
	public DiaSemana getDiaSemana() { return this.dia; }
	
//	public int getDiaOrdinal(DiaSemana d) {
//		return d.ordinal();
//	}
	
	public boolean addPrato(Prato p) {
		return pratos.add(p);
	}
	
	public boolean removePrato(Prato p) {
		return pratos.remove(p);
	}
	
	public int getNumPratos() {
		return pratos.size();
	}
	
	public Prato[] getPratos() {
		return pratos.toArray(new Prato[this.getNumPratos()]);
	}

	@Override
	public String toString() {
		return "Ementa de " + this.getDiaSemana() + ": Pratos: " + this.getPratos();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((pratos == null) ? 0 : pratos.hashCode());
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
		EmentaDia other = (EmentaDia) obj;
		if (dia != other.dia)
			return false;
		if (pratos == null) {
			if (other.pratos != null)
				return false;
		} else if (!pratos.equals(other.pratos))
			return false;
		return true;
	}
	
}
