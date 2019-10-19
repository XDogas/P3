package aula04.Ex3;

import java.util.Calendar;
import java.util.Scanner;

import static java.lang.System.*;

public class Ex3 {
	
	private static Scanner in = new Scanner(System.in);
	static VideoClube videoClube;

	public static void main(String[] args) {
		
		int N;
		int op;
		
		out.print("N�mero m�ximo de v�deos que um utilizador pode alugar: ");
		N = Integer.parseInt(in.nextLine());
		videoClube = new VideoClube(N);
		
		do {
			out.println("\nMenu do V�deo Clube");
			out.println(" 1: Introduzir novo utilizador no V�deo Clube");
			out.println(" 2: Remover utilizador do V�deo Clube");
			out.println(" 3: Lista de v�deos de um determinado utilizador");
			out.println(" 4: Lista do hist�rico de v�deos alugados por um determinado utilizador");
			out.println(" 5: Introduzir v�deo no V�deo Clube");
			out.println(" 6: Remover v�deo do V�deo Clube");
			out.println(" 7: Lista de v�deos do V�deo Clube");
			out.println(" 8: Lista de v�deos do V�deo Clube por Rating");
			out.println(" 9: Verificar disponibilidade de um item");
			out.println("10: Alugar um v�deo");
			out.println("11: Devolver um v�deo");			
			out.println(" 0: Terminar programa");
			out.print("Op��o: ");
			op = Integer.parseInt(in.nextLine());
			out.println();
			
			switch(op) {
				case 1:
					addUser();
					break;			
				case 2:
					removeUser();
					break;
				case 3:
					printUserVideoList();
					break;			
				case 4:
					printUserHistoryList();
					break;
				case 5:
					addVideo();					
					break;			
				case 6:
					removeVideo();
					break;
				case 7:
					printVideoList();
					break;			
				case 8:
					printVideoListByRating();
					break;
				case 9:
					checkAvailability();
					break;
				case 10:
					rentVideo();
					break;
				case 11:
					returnVideo();
					break;
				case 0:
					out.print("Terminar programa");
					exit(0);
					break;
			}
			
			if(op != 1 && op != 2 & op != 3 && op != 4 & op != 5 && op != 6 && op!= 7 && op != 8 & op != 9 && op != 0) out.println("Op��o inv�lida\nTente novamente\n");
			
		} while(op != 0);

	}

	public static void addUser() {					//1		
		out.println("Selecionou a op��o 1");
		
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
			out.println("1: Estudante\n2: Funcion�rio");
			out.print("Op��o: ");
			op = Integer.parseInt(in.nextLine());
			
			if(op != 1 && op != 2) out.println("\nOp��o inv�lida\nTente novamente\n");
			
		} while(op != 1 && op != 2);
		
		if(op == 1) {
			
			out.print("N�mero mecanogr�fico: ");
			nmec = Integer.parseInt(in.nextLine());
			out.print("Curso: ");
			curso = in.nextLine();
						
			videoClube.addUser(new Estudante(nome, cc, new Data(dataNasc), dataInsc, nmec, curso));
		}
		else if(op == 2) {
			
			out.print("N�mero de funcion�rio: ");
			nfuncionario = Integer.parseInt(in.nextLine());
			out.print("N�mero fiscal: ");
			nfiscal = Integer.parseInt(in.nextLine());
			
			videoClube.addUser(new Funcionario(nome, cc, new Data(dataNasc), dataInsc, nfuncionario, nfiscal));			
		}
		
		out.println("Utilizador adicionado com sucesso.\n");
	}
	
	public static void removeUser() {					//2
		out.println("Selecionou a op��o 2");
		
		out.print("CC do utilizador: ");
		videoClube.removeUser(Integer.parseInt(in.nextLine()));
		out.println("Utilizador removido com sucesso\n");
	}
	
	public static void printUserVideoList() { 			//3
		out.println("Selecionou a op��o 3");
		
		out.print("CC do utilizador: ");
		videoClube.printListUserVideos(Integer.parseInt(in.nextLine()));
	}
	
	public static void printUserHistoryList() {		//4
		out.println("Selecionou a op��o 4");
		
		out.print("CC do utilizador: ");
		videoClube.printUserHistory(Integer.parseInt(in.nextLine()));
	}		
	
	public static void addVideo() {					//5
		out.println("Selecionou a op��o 5");
		
		String titulo, cat, idade;
		
		out.print("T�tulo: ");
		titulo = in.nextLine();
		out.print("Categoria: ");
		cat = in.nextLine();
		out.print("Idade(ALL, M6, M12, M16, M18): ");
		idade = in.nextLine();
		
		videoClube.addVideo(new Video(titulo,cat,idade));
		out.println("Video adicionado com sucesso");		
	}
	
	public static void removeVideo() {					//6
		out.println("Selecionou a op��o 6");
		
		out.print("ID do video: ");
		videoClube.removeVideo(Integer.parseInt(in.nextLine()));
		
		out.println("V�deo removido com sucesso");		
	}
	
	public static void printVideoList() {		//7
		out.println("Selecionou a op��o 7");
		videoClube.printVideoList();
	}
	
	public static void printVideoListByRating() {		//8
		out.println("Selecionou a op��o 8");
		videoClube.printVideoListByRating();
	}
	
	public static void checkAvailability() {	//9
		out.println("Selecionou a op��o 9");
		
		out.print("ID do v�deo: ");
		videoClube.availability(Integer.parseInt(in.nextLine()));
	}
	
	public static void rentVideo() {		//10		
		out.println("Selecionou a op��o 10");
		
		int id, cc;
		
		out.print("ID do video: ");
		id = Integer.parseInt(in.nextLine());
		out.print("CC do utilizador: ");
		cc = Integer.parseInt(in.nextLine());
		videoClube.checkOut(id,cc);	
		
		out.println("V�deo alugado com sucesso\n");		
	}
	
	public static void returnVideo() {					//11		
		out.println("Selecionou a op��o 11");
		
		int id, cc, r;
		
		out.print("ID do video: ");
		id = Integer.parseInt(in.nextLine());
		out.print("CC do utilizador: ");
		cc = Integer.parseInt(in.nextLine());
		out.print("Rating(0 a 10): ");
		r = Integer.parseInt(in.nextLine());
		videoClube.checkIn(id,cc,r);
		
		out.println("Devolu��o efetuada com sucesso\n");
	}
	
}