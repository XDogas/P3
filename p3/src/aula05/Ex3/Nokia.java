package aula05.Ex3;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Nokia implements Formatos {

	@Override
	public ArrayList<Contacto> loadFile(File file) throws FileNotFoundException {
		
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		
		String nome;
		int num;
		String data;
		
		Scanner scf = new Scanner(file);
		
		scf.nextLine();	// primeira linha : Nokia
		
		while(scf.hasNextLine()) {			
			
			nome = scf.nextLine();
			num = Integer.parseInt(scf.nextLine());
			data = scf.nextLine();
			scf.nextLine();
				
			lista.add(new Contacto(nome, num, new Data(data)));			
		}
		
		scf.close();
				
		return lista;
	}

	@Override
	public void saveFile(Contacto[] contactos, File file) throws IOException {
		
		PrintWriter pwf = new PrintWriter(file);
		
		pwf.println("Nokia");	// primeira linha
		
		for(Contacto c : contactos) {
			pwf.println(c.getNome());
			pwf.println(c.getNumero());
			pwf.println(c.getDataNasc());
			pwf.println();
		}
		
		pwf.close();
	}

}
