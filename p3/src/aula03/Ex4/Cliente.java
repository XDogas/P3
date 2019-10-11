package aula03.Ex4;

import java.util.ArrayList;
import java.util.Calendar;

public class Cliente {
	
	private int nsocio;
	private static int nsocioCounter;
	private Data dataInsc;
	private String nome;
	private int cc;
	private Data dataNasc;
	private ArrayList<Video> rentedMovies;
	private ArrayList<Video> allRentedMovies;
	
	public Cliente(String nome, int cc, Data dataNasc, Data dataInsc) {
		
		assert nome.length() > 0 : "Nome inválido";
		assert cc > 0 : "cc inválido";
		
		this.nsocio = nsocioCounter;
		this.dataInsc = dataInsc;
		this.nome = nome;
		this.cc = cc;
		this.dataNasc = dataNasc;
		this.rentedMovies = new ArrayList<Video>();
		this.allRentedMovies = new ArrayList<Video>();
		
		nsocioCounter++;
	}
	
	public int getNsocio() { return this.nsocio; }
	public Data getDataInsc() { return this.dataInsc; }
	public String getName() { return this.nome; }
	public int getCC() { return this.cc; }
	public Data getDataNasc() { return this.dataNasc; }
	
	public String toString() {
		return "Número de sócio: " + getNsocio() + "\nData de nascimento: " + getDataNasc() + "\nNome: " + getName() + "\nCC: " + getCC() + "Data de inscrição: " + getDataInsc();
	}
	
	public int getIdade(){
		Calendar todayDate = Calendar.getInstance();
		int idade = todayDate.get(Calendar.YEAR) - this.dataNasc.getAno();
	    if (this.dataNasc.getMes() > todayDate.get(Calendar.MONTH) + 1 || (this.dataNasc.getMes() == todayDate.get(Calendar.MONTH) + 1 && this.dataNasc.getDia() > todayDate.get(Calendar.DAY_OF_MONTH))) {
	        idade--;
	    }
	    return idade;
	}
	
	public void addRentedMovie(Video v) {
		allRentedMovies.add(v);
	}
	
	public Video[] getAllRentedMovies() {		
		assert !allRentedMovies.isEmpty() : "Este cliente ainda não alugou nenhum filme";
		return this.allRentedMovies.toArray(new Video[allRentedMovies.size()]);
	}
	
	public int getNumberOfRentedMovies() {
		return rentedMovies.size();
	}

}
