package aula07.Ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CompanhiasList {
	
	private static TreeMap<String, Companhia> companhias;
	
	public static void readFile(String filePath) throws IOException {
		
		companhias = new TreeMap<String, Companhia>();
		
		Path path = Paths.get(filePath);
		List<String> lines = Files.readAllLines(path);
		
		for(String line : lines) {
			String l[] = line.split("\t");
			if(!l[0].equals("Sigla")) companhias.put(l[0], new Companhia(l[0], l[1]));
		}
	}
	
	public static Companhia getCompanhiaBySigla(String sigla) {
        assert sigla != null : "Sigla inválida";
        return companhias.get(sigla);
    }
	
	public static int size() {
		return companhias.size();
	}
	
	public static String getCompanhiasByAtraso() {
		
		String str = String.format("%-20s\t%-20s", "Origem", "Atraso médio");
		TreeMap<Hora, List<String>> sorted = new TreeMap<Hora, List<String>>();
		
		for(String name : companhias.keySet()) {
			
			List<String> lista = sorted.get(companhias.get(name).getMedia());
			if (lista == null) {
				
				ArrayList<String> cl = new ArrayList<String>();
				cl.add(name);
				sorted.put(companhias.get(name).getMedia(), cl);
				
			} else lista.add(name);
		}

		for(Hora h : sorted.descendingKeySet()) {
			for(String name : sorted.get(h))
				str += String.format("\n%-20s\t%-5s", companhias.get(name).getNome(), companhias.get(name).getMedia());
		}

		return str;
	}
		
}
