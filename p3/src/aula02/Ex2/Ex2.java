package aula02.Ex2;

import java.util.Scanner;

import java.io.IOException;
import java.io.File;

import static java.lang.System.*;

public class Ex2 {
	
	private static Scanner in = new Scanner(System.in);
	private static Scanner scf;

	public static void main(String[] args) throws IOException {
		
		String fname;
		File fin;
		
		if(args.length != 1) {		
			
			out.print("Introduza o nome do ficheiro que contém a sopa de letras: ");			
			fname = in.nextLine();
			in.skip("\n");
			
		} else fname = args[0];
		
		fin = new File(fname);
		
		assert fin.exists() : "O ficheiro não existe";
		assert fin.canRead() : "O ficheiro não pode ser lido";
		assert fin.isFile() : "O ficheiro não é normal";
		
		scf = new Scanner(fin);
		String line1 = scf.nextLine();
		int size = line1.length();
		
		char[][] sopa = new char[size][size];		
		sopa[0] = line1.toCharArray();		
		for(int i=1; i<size; i++) sopa[i] = scf.nextLine().toCharArray();
		
		String[] targets = new String[0];
		while(scf.hasNextLine()) {
			
			String line = scf.nextLine();
			
			String[] lineArray;
			if(line.contains(",")) lineArray = line.split(",");
			else if(line.contains(";")) lineArray = line.split(";");
			else lineArray = line.split(" ");
			
			String[] s = new String[targets.length + lineArray.length];
			
			System.arraycopy(targets,0,s,0,targets.length);
			System.arraycopy(lineArray,0,s,targets.length,lineArray.length);
			targets = s;
		}
		SopaLetras sopadeletras = new SopaLetras(sopa, targets);
		String[] resultado = sopadeletras.start();
		for(String str : resultado) System.out.println(str);
	}

}
