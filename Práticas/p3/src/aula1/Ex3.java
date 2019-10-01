package aula1;

import java.util.Scanner;

import static java.lang.System.*;

public class Ex3 {
	
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		int op;
		
		do {
			out.println("\n1: Quadrado");
			out.println("2: Retângulo");
			out.println("3: Círculo");
			out.println("4: Terminar Programa");
			out.print("Opção: ");
			op = Integer.parseInt(in.nextLine());
			out.println();
			
			switch(op) {
				case 1:
					createSquare();
					break;
				case 2:
					createRectangle();
					break;
				case 3:
					createCircle();
					break;
				case 4:
					out.print("Terminar programa");
					exit(0);
					break;
			}
			
		} while(op != 4);
		
	}

	public static void createSquare() {
		out.println("Selecionou a opção 1");
		
		Ponto[] pontos = new Ponto[4];
		
		for(int i=1 ;i<=4; i++) {
			out.println("Ponto " + i);
			out.print("	x: ");
			double x = Double.parseDouble(in.nextLine());
			out.print("	y: ");
			double y = Double.parseDouble(in.nextLine());
			pontos[i-1] = new Ponto(x, y);
		}
		
		Quadrado q = new Quadrado(pontos[0], pontos[1], pontos[2], pontos[3]);
		
		out.println("\nINFORMAÇÕES DA FIGURA:\n" + q.toString());		
	}
	
	public static void createRectangle() {
		out.println("Selecionou a opção 2");
		
		Ponto[] pontos = new Ponto[4];
		
		for(int i=1 ;i<=4; i++) {
			out.println("Ponto " + i);
			out.print("	x: ");
			double x = Double.parseDouble(in.nextLine());
			out.print("	y: ");
			double y = Double.parseDouble(in.nextLine());
			pontos[i-1] = new Ponto(x, y);
		}
		
		Retangulo r = new Retangulo(pontos[0], pontos[1], pontos[2], pontos[3]);
	
		out.println("\nINFORMAÇÕES DA FIGURA:\n" + r.toString());
	}
	
	private static void createCircle() {
		out.println("Selecionou a opção 3");
		
		out.println("Centro:");
		out.print("	x: ");
		double x = Double.parseDouble(in.nextLine());
		out.print("	y: ");
		double y = Double.parseDouble(in.nextLine());
		
		out.print("Raio: ");
		double r = Double.parseDouble(in.nextLine());
		
		Circulo c = new Circulo(new Ponto(x, y), r);
		
		out.println("\nINFORMAÇÕES DA FIGURA:\n" + c.toString());
	}

}
