package aula07.Ex1;

public class Hora implements Comparable<Hora> {
	
	private int minutos;
	
	public Hora(int horas, int minutos) {
		assert horas >= 0 && horas <= 23 : "Hora inválida";
		assert minutos >= 0 && minutos <= 59 : "Minuto inválido";
		this.minutos = horas * 60 + minutos;
	}
	
	public Hora(String hora) {
		int horas = Integer.valueOf(hora.split(":")[0]);
		int minutos = Integer.valueOf(hora.split(":")[1]);
		
		assert horas >= 0 && horas <= 23 : "Hora inválida";
		assert minutos >= 0 && minutos <= 59 : "Minuto inválido";
		
		this.minutos = horas * 60 + minutos;
	}
	
	public Hora(int minutos) {
		assert minutos >= 0 && minutos <= 59 : "Minuto inválido";
		this.minutos = minutos;
	}
	
	public int getMinutos() { return this.minutos; }
	
	public static Hora sumHoras(Hora h1, Hora h2) {
		if(h1 == null) return h2;
        if(h2 == null) return h1;
        return new Hora(h1.getMinutos() + h2.getMinutos());
	}

	@Override
	public int compareTo(Hora h) {
		if(this.getMinutos() < h.getMinutos()) return -1;
		if(this.getMinutos() > h.getMinutos()) return 1;
		return 0;
	}

	@Override
	public String toString() {
		int h = this.getMinutos() / 60;
		int m = this.getMinutos() % 60;
		return String.format("%02d:%02d", h, m);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + minutos;
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
		Hora other = (Hora) obj;
		if (minutos != other.minutos)
			return false;
		return true;
	}
}
