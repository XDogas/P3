package aula02.Ex1;

import java.util.Scanner;
import java.util.Calendar;
//import java.util.Comparator;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.*;

public class Ex1 {
	
	private static Scanner in = new Scanner(System.in);
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	static HashMap<Integer, Video> VideoClub = new HashMap<Integer, Video>();
	static ArrayList<Integer> videoIDs = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		int op;
		
		do {
			out.println("MENU");
			out.println(" 1: Introduzir utilizador");
			out.println(" 2: Remover utilizador");
			out.println(" 3: Lista de filmes disponibilizados para determinado utilizador");
			out.println(" 4: Introduzir filme no sistema");
			out.println(" 5: Remover filme do sistema");
			out.println(" 6: Verificar disponibilidade de um item");
			out.println(" 7: Alugar filme");
			out.println(" 8: Devolução de filme");
			out.println(" 9: Lista de utilizadores que requisitaram determinado filme");
			out.println("10: Listar por rating");
			out.println(" 0: Terminar programa");
			out.print("Opção: ");
			op = Integer.parseInt(in.nextLine());
			out.println();
			
			switch(op) {
				case 1:
					addUser();
					break;			
				case 2:
					delUser();
					break;
				case 3:
					printListVidforUser();
					break;			
				case 4:
					addMovie();
					break;
				case 5:
					delMovie();
					break;			
				case 6:
					verificarDisponbilidade();
					break;
				case 7:
					rentMovie();
					break;			
				case 8:
					returnMovie();
					break;
				case 9:
					printListUsersRent();
					break;
				case 10:
					sortByRating();
					break;
				case 0:
					out.print("Terminar programa");
					exit(0);
					break;
			}
			
			if(op != 1 && op != 2 & op != 3 && op != 4 & op != 5 && op != 6 && op!= 7 && op != 8 & op != 9 && op != 0) out.println("Opção inválida\nTente novamente\n");
			
		} while(op != 0);

	}

	public static void addUser() {					//1
		
		out.println("Selecionou a opção 1");
		
		String nome, dataNasc, curso;
		int cc, op, nmec, nfuncionario, nfiscal;
		Data dataInsc;
		
		out.print("Nome: ");
		nome = in.nextLine();
		out.print("CC: ");
		cc = Integer.parseInt(in.nextLine());
		out.print("Data de nacimento (dd/mm/aaaa): ");
		dataNasc = in.nextLine();
		
		Calendar hoje = Calendar.getInstance();
		dataInsc = new Data(hoje.get(Calendar.DAY_OF_MONTH), hoje.get(Calendar.MONTH), hoje.get(Calendar.YEAR));
		
		do {
			out.println("1: Estudante\n2: Funcionário");
			out.print("Opção: ");
			op = Integer.parseInt(in.nextLine());
			
			if(op != 1 && op != 2) out.println("\nOpção inválida\nTente novamente\n");
			
		} while(op != 1 && op != 2);
		
		if(op == 1) {
			
			out.print("Número mecanográfico: ");
			nmec = Integer.parseInt(in.nextLine());
			out.print("Curso: ");
			curso = in.nextLine();
						
			clientes.add(new Estudante(nome, cc, new Data(dataNasc), dataInsc, nmec, curso));
		}
		else if(op == 2) {
			
			out.print("Número de funcionário: ");
			nfuncionario = Integer.parseInt(in.nextLine());
			out.print("Número fiscal: ");
			nfiscal = Integer.parseInt(in.nextLine());
			
			clientes.add(new Funcionario(nome, cc, new Data(dataNasc), dataInsc, nfuncionario, nfiscal));			
		}
		
		out.println("Utilizador adicionado com sucesso.\n");
	}
	
	public static void delUser() {					//2
		
		assert !clientes.isEmpty() : "Não existe nenhum utilizador";
		
		out.println("Selecionou a opção 2");
		
		if(clientes.remove(searchCliente(clientes))) out.println("Utilizador removido com sucesso\n");
		else out.println("Nenhum utilizador removido\n");	
	}
	
	public static void printListVidforUser() { 		//3
		
		assert !VideoClub.isEmpty() : "Não existe nenhum Filme";
		
		out.println("Selecionou a opção 3");
		
		Cliente c;
		int idade;
		Video[] videosDisponiveis;
		
		c = searchCliente(clientes);		
		idade = c.getIdade();
		
		videosDisponiveis = availableMovies(idade);		
		out.println("\nLista:");
		for (Video video : videosDisponiveis) out.println(video);
		
		out.println();
	}
	
	public static void addMovie() {					//4
		
		out.println("Selecionou a opção 4");
		
		String titulo, cat, idade;
		
		out.print("Título: ");
		titulo = in.nextLine();
		out.print("Categoria: ");
		cat = in.nextLine();
		out.print("Idade(ALL, M6, M12, M16, M18): ");
		idade = in.nextLine();
		
		Video v = new Video(titulo, cat, idade);
		VideoClub.put(v.getID(), v);
		
		out.println("Filme adicionado com sucesso\n");
		
		videoIDs.add(v.getID());
		
		assert !VideoClub.isEmpty();
	}
	
	public static void delMovie() {					//5
		
		assert !VideoClub.isEmpty() : "Não existe nenhum Filme";
		
		out.println("Selecionou a opção 5");
		
		String titulo;
		int videoID;
		
		out.print("Título: ");
		titulo = in.nextLine();
		
		videoID = getMovieIDbyTitle(titulo);
		if(videoID != -1 ) {
			VideoClub.remove(videoID);
			out.println("Filme removido com sucesso\n");
		}
		else out.println("Filme não encontrado\n");
	}
	
	public static void verificarDisponbilidade() {	//6
		
		
		out.println("Selecionou a opção 6");
		
		String titulo;
		int movieID;
		
		out.print("Título: ");
		titulo = in.nextLine();
		
		movieID = getMovieIDbyTitle(titulo);
		
		if (movieID != -1) {
			
			if (VideoClub.get(movieID).rented()) out.println("O filme com o ID " + movieID + " está alugado\n");			
			else out.println("O filme com o ID " + movieID + " está disponível\n");
			
		} else out.println("Não há nenhum filme com o título indicado\n");
	}
	
	public static void rentMovie() {				//7
		
		out.println("Selecionou a opção 7");
		
		Cliente c;
		int id;
		Video v;
		
		c = searchCliente(clientes);
		
		System.out.print("ID do filme: ");
		id = Integer.parseInt(in.nextLine());
		
		assert existsID(id) : "Não existe nenhum filme com o ID indicado";
		
		v = VideoClub.get(id);		
		v.rent(c);
		c.addRentedMovie(v);
		
		out.println("Filme alugado com sucesso\n");		
	}
	
	public static void returnMovie() {					//8
		
		out.println("Selecionou a opção 8");
		
		int id, r;
		
		out.print("ID do filme: ");
		id = Integer.parseInt(in.nextLine());
		
		do {
			out.print("Rating do filme(1 a 10): ");
			r = Integer.parseInt(in.nextLine());
			
			if(r != 1 && r != 2 && r != 3 && r != 4 && r != 5 && r != 6 && r != 7 && r != 8 && r != 9 && r != 10) out.println("Rating inválido\nTente novamente");
			
		} while(r != 1 && r != 2 && r != 3 && r != 4 && r != 5 && r != 6 && r != 7 && r != 8 && r != 9 && r != 10);
		
		checkinMovie(id, r);
		
		out.println("Devolução efetuada com sucesso");
	}
	
	public static void printListUsersRent() {			//9
		
		out.println("Selecionou a opção 9");
		
		String titulo;
		int movieID;
		Cliente[] clts;
		
		out.print("Titulo do filme: ");
		titulo = in.nextLine();
		
		movieID = getMovieIDbyTitle(titulo);
		
		try {
			out.println("\nLista:");
			clts = VideoClub.get(movieID).getTodosClientes();
			for (Cliente cliente : clts) out.println(cliente);
			
		} catch (AssertionError e) {			
			out.println("Este filme não fui alugado");
		}		
	}
	
	public static void sortByRating() {					//10
		
		out.println("Selecionou a opção 10");
		
//		ArrayList<Video> filmes = VideoClub.get(todos os ids dos filmes);
		
//		filmes.sort(Comparator.comparing(Video::getRatingMedio));
	}
	
	
	
	
	public static Cliente searchCliente(ArrayList<Cliente> clientes) {
		
		int cc;
		Cliente c = null;
		
		System.out.print("CC: ");
		cc = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < clientes.size(); i++) {
			
			if (cc == clientes.get(i).getCC()) {
				
				c = clientes.get(i);
				out.println("Utilizador encontrado");
			}
			else out.println("Não existe nenhum utilizador associado ao CC indicado");
		}
		return c;
	}	
	
	public static int getMovieIDbyTitle(String titulo) {
		assert !VideoClub.isEmpty();
		
		for (int i = 0; i < videoIDs.size(); i++) {
			
			if (VideoClub.get(videoIDs.get(i)).getTitulo().equals(titulo)) {
				return videoIDs.get(i);
			}
		}		
		return -1;
	}
	
	public static void checkinMovie(int id, int r) {
		
		assert existsID(id) : "Não há nenhum filme com o ID indicado";
		assert r >=1 && r >=10 : "Rating inválido";

		VideoClub.get(id).checkin(r);
		
	}

	public static Video[] availableMovies(int idade) {
		
		assert !VideoClub.isEmpty();
		assert idade > 0 : "A idade não pode ser negativa";

		String[] idades = allowedRates(idade);
		ArrayList<Video> videos = new ArrayList<Video>();
		
		for (int i = 0; i < videoIDs.size(); i++) {
			String age = VideoClub.get(videoIDs.get(i)).getIdade();
			for (String r : idades) {
				if (r.equals(age) && !VideoClub.get(videoIDs.get(i)).rented()) {
					videos.add(VideoClub.get(videoIDs.get(i)));
					break;
				}
			}
		}
		
		return videos.toArray(new Video[videos.size()]);
	}
	
	private static String[] allowedRates(int idade) {
		
		assert idade > 0 : "A idade não pode ser negativa";
		
		String[] allRates = Video.getIdades();
		
		int maxIdx = 1;
		
		if (idade < 12) maxIdx = 2;
		else if (idade < 16) maxIdx = 3;
		else if (idade < 18) maxIdx = 4;
		else maxIdx = 5;
		
		String[] allowedRates = new String[maxIdx];
		System.arraycopy(allRates, 0, allowedRates, 0, maxIdx);
		return allowedRates;
	}

	private static boolean existsID(int id) {
		
		for (int i = 0; i < videoIDs.size(); i++) {
			if (videoIDs.get(i) == id)
				return true;
		}
		return false;
	}
}