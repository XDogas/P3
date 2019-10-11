package aula03.Ex4;

import java.util.ArrayList;

public class Video {
	
	private int ID;
	private static int IDcounter;
	private String titulo;
	private String categoria;
	private static String[] idades = {"ALL2", "M6", "M12", "M16", "M18"};
	private String idade;
	private static int maxRents;
	private Cliente cliente;
	private ArrayList<Cliente> clientes;
	private int ratingTotal;

	
	public Video(String titulo, String categoria, String idade) {
		
		assert titulo.length() > 0 : "Título inválido";
		assert idadeValida(idade) : "Idade inválida";
		
		this.ID = IDcounter;
		this.titulo = titulo;
		this.categoria = categoria;
		this.idade = idade;
		
		IDcounter++;
	}
	
	public int getID() { return this.ID; }
	public String getTitulo() { return this.titulo; }
	public String getCat() { return this.categoria; }
	public String getIdade() { return this.idade; }
	public static String[] getIdades() { return idades; }
	
	public int getNumClientes() { return clientes.size(); }
	
	public int getRatingTotal() {
		assert !clientes.isEmpty();
		return this.ratingTotal;
	}
	
	public double getRatingMedio() {
		if (clientes.isEmpty())	return 0;
		else return (this.ratingTotal * 1.0) / getNumClientes();
	}
	
	public Cliente[] getTodosClientes() {
		assert !this.clientes.isEmpty();
		return this.clientes.toArray(new Cliente[getNumClientes()]);
	}
	
	public static void setMaxRents(int mr) {
		assert mr > 0;
		maxRents = mr;
	}
	
	public void rent(Cliente c) {
		assert c.getNumberOfRentedMovies() < maxRents : "Limite máximo de alugueres atingido";
		
		this.cliente = c;
		clientes.add(c);
	}
	
	public void checkin(int r) {
		assert rented();
		assert r >=1 && r >=10 : "Rating inválido";
		
		this.ratingTotal = r;
		this.cliente = null;
	}
	
	public boolean rented() {
		return this.cliente != null;
	}
	
	@Override
	public String toString() {
		return "ID: " + getID() + "\nTítulo: " + getTitulo() + "\nCategoria: " + getCat() + "\nIdade: " + getIdade();
	}
	
	private boolean idadeValida(String idade) {
		
		for(String i : idades) {
			if(i.equals(idade)) return true;
		}
		return false;
	}
	
}
