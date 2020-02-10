package aula11.Ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EB {

	public static void main(String[] args) throws IOException {
		List<String> words = Files.readAllLines(Paths.get("src\\aula11\\Ex1\\Aveiro.txt"))
				.stream()
				.flatMap(str -> Arrays.stream(str.trim().replaceAll("[.,()\\[\\]]","").split(" ")))
				.filter(str -> str.length() > 0)
				.collect(Collectors.toList());
				
		System.out.println("Número Total de Palavras: " + words.size());
		System.out.println("Número de Diferentes Palavras: " + words.stream().distinct().count());
		
	}

}
