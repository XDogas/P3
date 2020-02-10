package aula11.Ex1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class D {

	public static void main(String[] args) throws IOException {
		
		Map<String,Integer> words = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		
//		Map<String,Integer> words = new TreeMap<>(new Comparator<String>() {
//			 @Override
//             public int compare(String s1, String s2) {
//                 return s1.compareToIgnoreCase(s2);
//             }
//		});
		
		List<String> lines = Collections.emptyList(); 
		lines = Files.readAllLines(Paths.get("src\\aula11\\Ex1\\Aveiro.txt"), StandardCharsets.UTF_8);
		
		Iterator<String> itr = lines.iterator();
		while (itr.hasNext()) {
			String line = itr.next();
			for(String word : line.replaceAll("[.,()\\[\\]]","").split(" ")) {
				if(!words.containsKey(word)) words.put(word, 1);
				else words.replace(word, words.get(word), words.get(word)+1);
			}			
		}
		
		for(String key : words.keySet()) {
			System.out.printf("%-20s %10d%n", key, words.get(key));
		}
	}

}
