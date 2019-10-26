package aula05.Ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class vCard implements Formatos {

	@Override
	public ArrayList<Contacto> loadFile(File file) throws FileNotFoundException {
		
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		
		String nome;
		int num;
		String data;
		
		Scanner scf = new Scanner(file);
		
		scf.nextLine();	// primeira linha : vCard
		
		while(scf.hasNextLine()) {
			
			nome = String.valueOf(scf.nextLine().split("#")[1]);
			num = Integer.valueOf(scf.nextLine().split("#")[2]);
			data = String.valueOf(scf.nextLine().split("#")[3]);
				
			lista.add(new Contacto(nome, num, new Data(data)));			
		}
		
		scf.close();
				
		return lista;
	}

	@Override
	public void saveFile(Contacto[] contactos, File file) throws IOException {
		
		PrintWriter pwf = new PrintWriter(file);
		
		pwf.println("vCard");	// primeira linha
		
		for(Contacto c : contactos) {
			pwf.println("#" + c.getNome() + "#" + c.getNumero() + "#" + c.getDataNasc());
		}
		
		pwf.close();
		
	}

}
