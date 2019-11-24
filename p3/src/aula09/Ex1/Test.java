package aula09.Ex1;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		out.println("Teste com string lida do teclado:");
		out.print("Introduza uma frase/palavra: ");
		ScannerAbeirense sci = new ScannerAbeirense(System.in);
		out.print(sci.nextLine());
		sci.close();
		
		out.println("\n\nTeste com string de entrada:");
		ScannerAbeirense scs = new ScannerAbeirense("Em Aveiro há gaivotas");
		out.print(scs.nextLine());
		scs.close();
		
		out.println("\n\nTeste com ficheiro de texto de entrada:");
		ScannerAbeirense scf = new ScannerAbeirense(new File("src\\aula09\\Ex1\\Aveiro.txt"));
		while(scf.hasNext()) {
			out.println(scf.nextLine());
		}
		scf.close();
		
		

	}

}
