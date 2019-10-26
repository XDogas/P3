package aula05.Ex3;

import static java.lang.System.exit;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ex3 {
	
	private static Scanner in = new Scanner(System.in);
	static AgendaContactos agenda;
	static Nokia nokia = new Nokia();
    static vCard vcard = new vCard();
    static CSV csv = new CSV();

	public static void main(String[] args) throws IOException {
		
		agenda = new AgendaContactos();
		
		int op;
		
		do {
			out.println("Menu da Agenda de Contactos");
			out.println("1: Adicionar contacto");
			out.println("2: Remover contacto");
			out.println("3: Importar contactos de um ficheiro");
			out.println("4: Mostrar agenda de contactos");
			out.println("5: Ordenar agenda por nome");
			out.println("6: Ordenar agenda por número");			
			out.println("7: Guardar agenda num ficheiro");			
			out.println("0: Terminar programa");
			out.print("Opção: ");
			op = Integer.parseInt(in.nextLine());
			out.println();
			
			switch(op) {
				case 1:
					addContacto();
					break;			
				case 2:
					removeContacto();
					break;
				case 3:
					loadContactsFile();
					break;			
				case 4:
					printContactosList();
					break;
				case 5:
					sortByName();
					break;			
				case 6:
					sortByNumber();
					break;
				case 7:
					saveInFile();
					break;
				case 0:
					out.print("Terminar programa");
					exit(0);
					break;
			}
			
			if(op != 1 && op != 2 & op != 3 && op != 4 & op != 5 && op != 6 && op!= 7 && op != 0) out.println("Opção inválida\nTente novamente\n");
			
		} while(op != 0);

	}

	public static void addContacto() {	//1
		out.println("Selecionou a opção 1");
		
		String nome;
		int numero;
		String dataNasc;
		
		
		out.print("Nome: ");
		nome = in.nextLine();
		out.print("Número: ");
		numero = Integer.parseInt(in.nextLine());
		out.print("Data de nacimento (dd/mm/aaaa): ");
		dataNasc = in.nextLine();
		
		agenda.addContacto(new Contacto(nome, numero, new Data(dataNasc)));
		out.println("Contacto de " + nome + " adicionado com sucesso\n");
		
	}
	
	private static void removeContacto() {	//2
		out.println("Selecionou a opção 2");
		
		assert agenda.size() > 0 : "A Agenda de Contactos está vazia";
		
		String op, nome;
		int numero;
		
		do {
			out.print("Escolher contacto através do nome ou número:");
			op = in.nextLine();
			if(!op.equals("nome") && !op.equals("numero")) out.println("Opção inválida\nTem de ser (nome) ou (numero)\nTente novamente\n");
		} while(!op.equals("nome") && !op.equals("numero"));
		
		if(op.equals("nome")) {	
			
			out.print("Nome: ");
			nome = in.nextLine();
			
			for(Contacto c : agenda.getContactos()) {
				if(c.getNome().equals(nome)) {
					agenda.removeContacto(c);
					out.println("Contacto de " + nome + " removido com sucesso\n");
					break;
				} else {
					out.println("Contacto de " + nome + " não existe na agenda de contactos\n");
					break;
				}
			}
			
		} else {
			
			out.print("Número: ");
			numero = Integer.parseInt(in.nextLine());
			
			for(Contacto c : agenda.getContactos()) {
				if(c.getNumero() == numero) {
					agenda.removeContacto(c);
					out.println("Contacto com o número " + numero + " removido com sucesso\n");
					break;
				} else {
					out.println("Contacto com o número " + numero + " não existe na agenda de contactos\n");
					break;
				}
			}
		}
	}
	
	public static void loadContactsFile() throws FileNotFoundException {		//3
		out.println("Selecionou a opção 3");
			
		File starting = new File(System.getProperty("user.dir"));
		File dir = new File(starting,".");
		out.println("Caminho do diretório atual: " + dir.getPath() + "\n");
		
		out.print("Caminho do ficheiro (não é necessário por \".txt\"): ");
		String fileName = in.nextLine();
		
		File file = new File(fileName + ".txt");
		Scanner scf = new Scanner(file);
		
		assert scf.hasNextLine() && !scf.nextLine().equals("Nokia") && !scf.nextLine().equals("vCard") && !scf.nextLine().equals("CSV") : "Ficheiro inválido";
			
		String formato = scf.nextLine();
		if(formato.equals("Nokia")) {
			for(Contacto c : nokia.loadFile(file)) {
				agenda.addContacto(c);
				out.println("Contacto de " + c.getNome() + " foi importado");
			}
		} else if(formato.equals("vCard")) {
			for(Contacto c : vcard.loadFile(file)) {
				agenda.addContacto(c);
				out.println("Contacto de " + c.getNome() + " foi importado");
			}			
		} else if(formato.equals("CSV")) {
			for(Contacto c : csv.loadFile(file)) {
				agenda.addContacto(c);
				out.println("Contacto de " + c.getNome() + " foi importado");
			}			
		}
		
		out.println("Contactos importados com sucesso\n");
		
		scf.close();
		
// OU ------------------------------------------------------------------		
//		Formatos formatoFile = null;	
//		String formato = scf.nextLine();
//		if(formato.equals("Nokia")) {
//			formatoFile = new Nokia();
//		} else if(formato.equals("vCard")) {
//			formatoFile = new vCard();
//		} else if(formato.equals("CSV")) {
//			formatoFile = new CSV();
//		}		
//		for(Contacto c : formatoFile.loadFile(file)) {
//			agenda.addContacto(c);
//			out.println("Contacto de " + c.getNome() + " foi importado");
//		}
//		out.println("Contactos importados com sucesso\n");		
//		scf.close();
//------------------------------------------------------------------------

	}
	
	public static void printContactosList() {	//4
		out.println("Selecionou a opção 4");
		
		out.println("Agenda de contactos:");
		for(Contacto c : agenda.getContactos()) {
			out.println(c);
		}
		
		out.println();
	}
	
	public static void sortByName() {	//5
		out.println("Selecionou a opção 5");
		
		agenda.sortByName();	// ou: UtilCompare.sortArray(agenda.getContactos()); mas não está a funcionar
		out.println("Agenda de contactos ordenada por nome\n");		
	}
	
	public static void sortByNumber() {	//6
		out.println("Selecionou a opção 6");
		
		agenda.sortByNum();		
		out.println("Agenda de contactos ordenada por número\n");
	}
	
	public static void saveInFile() throws IOException {	//7
		out.println("Selecionou a opção 7");
		
		File starting = new File(System.getProperty("user.dir"));
		File dir = new File(starting,".");
		out.println("Caminho do diretório atual: " + dir.getPath() + "\n");
		
		String fileName;
		out.print("Caminho do ficheiro a criar (não é necessário por \".txt\"): ");
		fileName = in.nextLine();
		
		File file = new File(fileName + ".txt");
		
		if(file.exists()) {
			do {
				out.print("O ficheiro já existe.\nEscolha outro nome: ");
				fileName = in.nextLine();
				file = new File(fileName + ".txt");
			} while(file.exists());
		} else file.createNewFile();
		
		out.println("Escolha o formato do ficheiro:");
		out.println("1: Nokia");
		out.println("2: vCard");
		out.println("3: CSV");
		int op;
		do {
			out.print("Opção: ");
			op = Integer.parseInt(in.nextLine());
			if(op != 1 && op != 2 & op != 3) out.println("Opção inválida");
		} while(op != 1 && op != 2 & op != 3);
		
		 switch(op) {
         case 1:
             nokia.saveFile(agenda.getContactos(), file);
             break;
         case 2:
             vcard.saveFile(agenda.getContactos(), file);
             break;
         case 3:
             csv.saveFile(agenda.getContactos(), file);
             break;
		 }
		
		out.println("Ficheiro criado com sucesso\n");
	}
	

}
