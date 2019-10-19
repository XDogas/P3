package aula04.Ex3;

import java.util.ArrayList;

public class Video {
	
	private int ID;
	private static int IDcounter;
	private String titulo;
	private String categoria;
	private static String[] idades = {"ALL2", "M6", "M12", "M16", "M18"};
	private String idade;
	private Cliente cliente;
	private ArrayList<Cliente> clientes;
	private int ratingMedio;
	private int ratingTotal;

	
	public Video(String titulo, String categoria, String idade) {
		
		assert titulo.length() > 0 : "Título inválido";
		assert idadeValida(idade) : "Idade inválida";
		
		this.ID = IDcounter++;
		this.titulo = titulo;
		this.categoria = categoria;
		this.idade = idade;
		this.ratingMedio = 0;
		this.ratingTotal = 0;
	}
	
	public int id() { return this.ID; }
	public String titulo() { return this.titulo; }
	public String categoria() { return this.categoria; }
	public String idade() { return this.idade; }
	public static String[] idades() { return idades; }
	public int rating() { return this.ratingMedio; }
	
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
	

	public void checkOut(Cliente c) {		
		this.cliente = c;
		clientes.add(c);
	}
	
	public void checkIn(int r) {
		assert rented();
		assert r >=1 && r >=10 : "Rating inválido";
		
		addRating(r);
		this.cliente = null;
		
		assert !rented();
	}
	
	public boolean rented() {
		return this.cliente != null;
	}
	
	private void addRating(int r) {
		ratingTotal += r;
		ratingMedio = Math.min(Math.max((int)Math.round((double)ratingTotal/(double)clientes.size()), 0), 10);
	}
	
	@Override
	public String toString() {
		return "ID: " + id() + "\nTítulo: " + titulo() + "\nCategoria: " + categoria() + "\nIdade: " + idade();
	}
	
	private boolean idadeValida(String idade) {
		
		for(String i : idades) {
			if(i.equals(idade)) return true;
		}
		return false;
	}
	
}
