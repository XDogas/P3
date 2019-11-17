package aula08.Ex3.AlternativaIncompleta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Question {
	
	private String imagePath;
	private String question;
	private String answer;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private int difficulty;
	private int value;
	
	public Question(String filePath) throws IOException {
		
		// ler linha a linha, para separar as perguntas por dificuldade, para depois usar rand nas mesmas
		
		assert filePath != null : "Caminho do ficheiro inválido";
		
//		Path path = Paths.get(filePath);
//		List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
		
//		for(String line : lines) {
//			String l[] = line.split("&&");
//			assert l.length == 7;
//			
//			new Question(l[0], l[1], l[2], l[2], l[3], l[4], l[5], Integer.parseInt(l[6]));
//		}
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		
		String line = reader.readLine();	// 1ª Question
		String l[] = line.split("&&");
		new Question(l[0].split(":")[1], l[1], l[2], l[2], l[3], l[4], l[5], Integer.parseInt(l[6]));
		
	}
	
	public Question(String imagePath, String question, String answer, String op1, String op2, String op3, String op4, int difficulty) {
		this.imagePath = imagePath;
		this.question = question;
		this.answer = answer;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.difficulty = difficulty;
	}

	public String getImagePath() {
		return imagePath;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public String getOp1() {
		return op1;
	}

	public String getOp2() {
		return op2;
	}

	public String getOp3() {
		return op3;
	}

	public String getOp4() {
		return op4;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public int getValue() {
		return value;
	}
	
	
	
	
}
