package aula06.Ex1.AlternativaFalhada;

import java.util.LinkedList;

import aula06.Ex1.DiaSemana;
import aula06.Ex1.Prato;

public class Ementa2 {
	
	private String nome;
	private String local;
	LinkedList<EmentaDia> ementaDia;
	
	public Ementa2(String nome, String local) {
		this.nome = nome;
		this.local = local;
		this.ementaDia = new LinkedList<EmentaDia>();
	}
	
	public String getNome() { return this.nome; }
	public String getLocal() { return this.local; }
	
	public boolean addPrato(Prato prato, DiaSemana dia) {
		if(prato == null || dia == null) return false;
		return this.ementaDia.get(dia.ordinal()).addPrato(prato);
	}
	
	public boolean removePrato(String nome, DiaSemana dia) {
		if(dia == null) return false;
		
		EmentaDia ementaDoDia = ementaDia.get(dia.ordinal());
	
		for(int i=0; i<ementaDoDia.getPratos().length; i++) {
			for(Prato p : ementaDoDia.getPratos()) {
				if(ementaDoDia.getDiaSemana() == dia && p.getNome().equals(nome)) {
					return this.ementaDia.get(dia.ordinal()).removePrato(p);
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return "Ementa [nome=" + nome + ", local=" + local + ", ementaDia=" + ementaDia + "]";
		
//		String str = new String();
//        for (DiaSemana day : DiaSemana.getDias()) {
//        	Prato p = ementaDia.
//            for (Prato p : )
//            	str += p.toString() + ", dia " + day + "\n";
//        }
//        return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ementaDia == null) ? 0 : ementaDia.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Ementa2 other = (Ementa2) obj;
		if (ementaDia == null) {
			if (other.ementaDia != null)
				return false;
		} else if (!ementaDia.equals(other.ementaDia))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
