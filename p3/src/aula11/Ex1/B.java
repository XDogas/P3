package aula11.Ex1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class B {

	public static void main(String[] args) throws IOException {
		
		Set<String> words = new HashSet<>();
		int count = 0 ;
		
		List<String> lines = Collections.emptyList(); 
		lines = Files.readAllLines(Paths.get("src\\aula11\\Ex1\\Aveiro.txt"), StandardCharsets.UTF_8);
		
		Iterator<String> itr = lines.iterator();
		while (itr.hasNext()) {
			String line = itr.next();
			for(String word : line.replaceAll("[.,()\\[\\]]","").split(" ")) {
				words.add(word);
				count++;
			}			
		}
		
		System.out.println("Número Total de Palavras: " + count);
		System.out.println("Número de Diferentes Palavras: " + words.size());
	}

}
