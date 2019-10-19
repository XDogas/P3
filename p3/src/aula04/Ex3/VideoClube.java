package aula04.Ex3;

import static java.lang.System.*;

import java.util.Arrays;
import java.util.Comparator;

public class VideoClube {
	
	private ClienteList clientes = new ClienteList();
	private VideoList videos = new VideoList();
	private int limiteVideos;
	
	public VideoClube(int N) {
		limiteVideos = N;
	}
	
	public void addUser(Cliente c) {
		clientes.addCliente(c);
	}
	
		
	public void removeUser(int cc) {
		clientes.removeCliente(clientes.getClienteByCC(cc));
	}
	
	public int numUsers() {
		return clientes.size();
	}
	public void printListUserVideos(int cc) {		// Imprime videos alugados
		Cliente c = clientes.getClienteByCC(cc);
		out.println("Lista de Videos para " + c + ":");
		for(Video v : c.getRentedMovies()) {
			out.println(v);
		}
	}
	
	public void addVideo(Video v) {
		videos.addVideo(v);
	}
	
	public void removeVideo(int id) {
		videos.removeVideo(videos.getVideoByID(id));
	}
	
	public int numVideos() {
		return videos.size();
	}
	
	public void availability(int id) {
		String disponibilidade = "disponível";
		if(videos.getVideoByID(id).rented())
			disponibilidade = "indisponível";
		System.out.println("O video " + id + " encontra-se " + disponibilidade);
	}
	
	public void checkOut(int id, int cc) {
		Cliente c = clientes.getClienteByCC(cc);
		Video v = videos.getVideoByID(id);
		
		if(c.getNumberOfRentedMovies() >= this.limiteVideos) {
			out.println("O utilizador " + c.nome() + " atingiu o limite de vídeos alugados");
		}
		else if(v.rented()) { 
			out.println("O vídeo " + id + " encontra-se indisponivel");
		} else {		
			v.checkOut(c);
			c.rentVideo(v);
			out.println("Vídeo alugado com sucesso");
		}
	}
	
	public void checkIn(int id, int cc, int r) {
		assert r >= 0 && r <= 10 : "Rating inválido";
		
		Cliente c = clientes.getClienteByCC(cc);
		Video v = videos.getVideoByID(id);
		
		if(!v.rented()) out.println("O vídeo " + id + " não se encontra alugado");
		
		v.checkIn(r);
		c.returnVideo(v);
		out.println("Vídeo devolvido com sucesso");
	}
	
	public void printUserHistory(int cc) {
		Cliente c = clientes.getClienteByCC(cc);
		
		out.println("Histórico de videos alugados por " + c.nome() + ":");		
		for(Video v : c.getAllRentedMovies()) {
			out.println(v);
		}
	}
	
	public void printVideoList() {
		out.println("Lista de videos:");
		for(Video v : videos.getVideos()) {
			out.println(v);
		}
	}
	
	public void printVideoListByRating() {
		Video[] sortedArray = videos.getVideos().clone();
		
		Arrays.sort(sortedArray, new Comparator<Video>() {
	        @Override
	        public int compare(Video v1, Video v2) {
	        	int i = -2;
	        	if(v1.rating() > v2.rating())
	        		i = -1;
	        	else if(v1.rating() < v2.rating())
	        		i = 1;
	        	else
	        		i = 0;
	            return i;	        
	        }
	    });
		
		out.println("Lista de videos por Rating:");
		for(Video v : sortedArray) {
			System.out.println(v);
		}
	}

}
