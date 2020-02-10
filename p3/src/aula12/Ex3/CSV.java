package aula12.Ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSV implements IPlugin {

	@Override
	public ArrayList<Contacto> loadFile(File file) throws FileNotFoundException {
		
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		
		String nome;
		int num;
		String data;
		
		Scanner scf = new Scanner(file);
		
		scf.nextLine();	// primeira linha : CSV
		
		while(scf.hasNextLine()) {
			
			nome = String.valueOf(scf.nextLine().split("\t")[0]);
			num = Integer.valueOf(scf.nextLine().split("\t")[1]);
			data = String.valueOf(scf.nextLine().split("\t")[2]);
				
			lista.add(new Contacto(nome, num, new Data(data)));			
		}
		
		scf.close();
				
		return lista;
	}

	@Override
	public void saveFile(Contacto[] contactos, File file) throws IOException {
		
		PrintWriter pwf = new PrintWriter(file);
		
		pwf.println("CSV");	// primeira linha
		
		for(Contacto c : contactos) {
			pwf.println(c.getNome() + "\t" + c.getNumero() + "\t" + c.getDataNasc());
		}
		
		pwf.close();
	}

}
