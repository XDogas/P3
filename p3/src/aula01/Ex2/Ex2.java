package aula01.Ex2;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Comparator;

import static java.lang.System.*;

public class Ex2 {
	
	private static Scanner in = new Scanner(System.in);
	static LinkedList<Pessoa> lista = new LinkedList<Pessoa>();

	public static void main(String[] args) {
		
		int op;
		
		do {
			out.println("\nMENU");
			out.println("1: Adicionar pessoa � lista");
			out.println("2: Retirar pessoa da lista");
			out.println("3: Apresentar lista de pessoas");
			out.println("4: Ordenar lista por nome");
			out.println("5: Ordenar lista por cc");
			out.println("6: Sair do programa");
			out.print("Op��o: ");			
			op = Integer.parseInt(in.nextLine());
			out.println();
			
			switch(op) {
				case 1:
					addP();
					break;
				case 2:
					deleteP();
					break;
				case 3:
					printList();
					break;
				case 4:
					sortByName();
					break;
				case 5:
					sortByCC();
					break;
				case 6:
					out.print("Terminar programa");
					exit(0);
					break;
			}
			
			if(op != 1 && op != 2 & op != 3 && op != 4 & op != 5 && op != 6) out.println("Op��o inv�lida\nTente novamente");
			
		} while(op != 6);
		
	}
	
	private static void addP() {
		out.println("Selecionou a op��o 1");
		
		out.print("Nome: ");
		String nome = in.nextLine();
		
		out.print("CC: ");
		int cc = Integer.parseInt(in.nextLine());
		
		out.print("Data de Nascimento (dd/mm/aaaa): ");
		String dataN = in.nextLine();
		
		lista.add(new Pessoa(nome, cc, new Data(dataN)));
		
		out.println("Pessoa adicionada");		
	}
	
	private static void deleteP() {
		assert !lista.isEmpty() : "Nenhuma pessoa adicionada";
		
		out.println("Selecionou a op��o 2");
		
		String op;		
		do {
			out.print("Retirar pessoa pelo nome ou cc: ");
			op = in.nextLine();
			
			boolean existe = false;
			if(op.equals("nome")) {
				
				out.print("Nome da pessoa a retirar da lista: ");
				String nome = in.nextLine();
				for(int i=0; i<lista.size(); i++) {
					
					if(lista.get(i).getNome().equals(nome)) {
						
						lista.remove(i);
						existe = true;
					}
				}
				
				if(existe) out.println("Pessoa removida");
				else out.println("Pessoa n�o presente na lista");
				
			} else if(op.equals("cc")) {
				
				out.print("CC da pessoa a retirar da lista: ");
				int cc = Integer.parseInt(in.nextLine());
				for(int i=0; i<lista.size(); i++) {
					
					if(lista.get(i).getCC() == cc) {
						
						lista.remove(i);
						existe = true;
					}
				}
				
				if(existe) out.println("Pessoa removida");
				else out.println("Pessoa n�o presente na lista");
				
			} else out.println("Op��o inv�lida. Tente novamente");
			
		} while(!op.equals("nome")&&!op.equals("cc"));
		
	}

	private static void printList() {
		out.println("Lista de pessoas:");
		
		out.println("NOME | CC | DATA NASCIMENTO");
		
		for(int i=0; i<lista.size(); i++) {
			
			out.println(lista.get(i).toString());
		}		
	}
	
	private static void sortByName() {
		lista.sort(Comparator.comparing(Pessoa::getNome));
		out.println("Lista ordenada por Nome");
	}
	
	private static void sortByCC() {
		lista.sort(Comparator.comparing(Pessoa::getCC));
		out.println("Lista ordenada por CC");
	}
	
}
