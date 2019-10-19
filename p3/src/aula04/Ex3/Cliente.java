package aula04.Ex3;

import java.util.ArrayList;

public abstract class Cliente extends Pessoa{
	
	private int nsocio;
	private static int nsocioCounter;
	private Data dataInsc;
	private ArrayList<Video> rentedVideos;
	private ArrayList<Video> allRentedVideos;
	
	public Cliente(String nome, int cc, Data dataNasc, Data dataInsc) {		
		super(nome, cc, dataNasc);
		this.nsocio = nsocioCounter++;
		this.dataInsc = dataInsc;		
		this.rentedVideos = new ArrayList<Video>();
		this.allRentedVideos = new ArrayList<Video>();
	}
	
	public int nsocio() { return this.nsocio; }
	public Data dataInsc() { return this.dataInsc; }
	public String nome() { return nome; }
	public int cc() { return cc; }
	public Data dataNasc() { return dataNasc; }
	
	public String toString() {
		return "Número de sócio: " + nsocio() + "\nData de nascimento: " + dataNasc() + "\nNome: " + nome() + "\nCC: " + cc() + "Data de inscrição: " + dataInsc();
	}
	
	public void rentVideo(Video v) {
		rentedVideos.add(v);
		allRentedVideos.add(v);		
	}
	
	public void returnVideo(Video v) {
		rentedVideos.remove(v);
	}
	
	public int getNumberOfRentedMovies() {
		return rentedVideos.size();
	}
	
	public Video[] getRentedMovies() {		
		assert !rentedVideos.isEmpty() : "Este cliente não tem nenhum filme alugado";
		return this.rentedVideos.toArray(new Video[rentedVideos.size()]);
	}
	
	public Video[] getAllRentedMovies() {		
		assert !allRentedVideos.isEmpty() : "Este cliente ainda não alugou nenhum filme";
		return this.allRentedVideos.toArray(new Video[allRentedVideos.size()]);
	}	

}
