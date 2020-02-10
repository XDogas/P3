package aula12.Ex3;

import java.util.Comparator;

public class Contacto extends Pessoa implements Comparable<Contacto>{
	
	private int numero;

	public Contacto(String nome, int cc, Data dataNasc, int numero) {
		super(nome, cc, dataNasc);
		assert numero > 0 : "Número inválido";
		this.numero = numero;
	}
	
	public Contacto(String nome, int numero, Data dataNasc) {
		this(nome, 0, dataNasc, numero);
	}
	
	public int getNumero() { return this.numero; }

	@Override
	public boolean equals(Object obj)
	{
		if(!super.equals(obj)) return false;		
		return this.numero == ((Contacto)obj).getNumero();
	}

	@Override
	public String toString()
	{
		return "Nome: " + getNome() + ", Número: " + this.getNumero() + ", Data de nascimento: " + getDataNasc();
	}

	@Override
	public int compareTo(Contacto c) {
		if(this.numero < c.getNumero()) return -1;
		if(this.numero > c.getNumero()) return 1;
		return 0;
	}
	
	public static Comparator<Contacto> nameComparator = new Comparator<Contacto>() {
		
		public int compare(Contacto c1, Contacto c2) {
			String c1nome = c1.getNome().toUpperCase();
			String c2nome = c2.getNome().toUpperCase();
			
			//ordem ascendente
			return c1nome.compareTo(c2nome);
			
			//ordem descendente
			//return c2nome.compareTo(c1nome);
	}};
	
	public static Comparator<Contacto> numComparator = new Comparator<Contacto>() {
		
		public int compare(Contacto c1, Contacto c2) {
			int c1num = c1.getNumero();
			int c2num = c2.getNumero();
			
			//ordem ascendente
			return c1num - c2num;
			
			//ordem descendente
			//return c2num - c1num;
	}};

}
