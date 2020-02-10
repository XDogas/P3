package aula11.Ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ED {

	public static void main(String[] args) throws IOException {
		new TreeMap<>(Files.readAllLines(Paths.get("src\\aula11\\Ex1\\Aveiro.txt"))
				.stream()
				.flatMap((str) -> Arrays.stream(str.trim().replaceAll("[.,()\\[\\]]","").split(" ")))
				.filter((str) -> str.length() > 0)
				.collect(Collectors.groupingBy(e -> e, Collectors.counting())))
				.forEach((word,counter) -> System.out.printf("%-20s %10d%n", word, counter));
	}

}
