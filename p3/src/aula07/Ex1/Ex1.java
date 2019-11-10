package aula07.Ex1;

import java.io.IOException;

public class Ex1 {

	public static void main(String[] args) throws IOException {
		
		CompanhiasList.readFile("src//aula07//Ex1//Files//companhias.txt");
		VoosList vlist = new VoosList();
		
		vlist.readFile("src//aula07//Ex1//Files//voos.txt");
		System.out.println(vlist);
		
		System.out.println(CompanhiasList.getCompanhiasByAtraso());
		
		vlist.saveFile();
		vlist.saveBinFile();
		vlist.saveCidadesFile();
		
		vlist.readFromBinaryFile("src//aula07//Ex1//Files//Infopublico.bin");
		System.out.println("Ficheiro binário:\n" + vlist);

	}

}
