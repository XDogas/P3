package aula13.Ex3;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class BrincaBeira {

	public static void main(String[] args) {

		Empregado e0 = new Empregado(GerarNome());
		Empregado e1 = new Empregado(GerarNome());
		Empregado e2 = new Empregado(GerarNome());
		Empregado e3 = new Empregado(GerarNome());
		Empregado e4 = new Empregado(GerarNome());
		Empregado e5 = new Empregado(GerarNome());
		Empregado e6 = new Empregado(GerarNome());
		Empregado e7 = new Empregado(GerarNome());
		Empregado e8 = new Empregado(GerarNome());
		Empregado e9 = new Empregado(GerarNome());

		List<Empregado> empregados = new ArrayList<>();
		empregados.add(e0);
		empregados.add(e1);
		empregados.add(e2);
		empregados.add(e3);
		empregados.add(e4);
		empregados.add(e5);
		empregados.add(e6);
		empregados.add(e7);
		empregados.add(e8);
		empregados.add(e9);

		out.println("Registo de empregados:");
		empregados.stream().forEach(System.out::println);
		
		
		Map<Empregado,String> brinquedos= new HashMap<>();

		int sorteado = (int)(Math.random()*empregados.size());
		out.println("\nSorteio do mês:");
		out.println("ID do empregado sorteado: " + sorteado);
		
		if(e0.getID() == sorteado) {
			e0.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e0, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e0.toString());
		}
		else if(e1.getID() == sorteado) {
			e1.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e1, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e1.toString());
		}
		else if(e2.getID() == sorteado) {
			e2.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e2, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e2.toString());
		}
		else if(e3.getID() == sorteado) {
			e3.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e3, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e3.toString());
		}
		else if(e4.getID() == sorteado) {			
			e4.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e4, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e4.toString());
		}
		else if(e5.getID() == sorteado) {
			e5.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e5, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e5.toString());
		}
		else if(e6.getID() == sorteado) {
			e6.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e6, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e6.toString());
		}
		else if(e7.getID() == sorteado) {
			e7.addBrinquedo("Brinquedo do mês");
			brinquedos.put(e7, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e7.toString());
		}
		else if(e8.getID() == sorteado) {
			e8.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e8, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e8.toString());
		}
		else {
			e9.addBrinquedo("Brinquedo do mês");			
			brinquedos.put(e9, "Brinquedo do mês");
			out.println("Vencedor do mês: " + e9.toString());
		}
		
		
		Map<String, Integer> funcNames = new HashMap<>();
        for (Empregado emp : empregados) {
            if (funcNames.containsKey(emp.getPrimeiroNome()))
                funcNames.put(emp.getPrimeiroNome(), funcNames.get(emp.getPrimeiroNome()) + 1);
            else
                funcNames.put(emp.getPrimeiroNome(), 1);
        }
        out.println("\nRepetição de nomes de Empregados para brinquedos:");
        funcNames.keySet().stream().map(key -> key + ": " + funcNames.get(key)).forEach(System.out::println);
		
		
		out.println("\nBilhetes:");
		Queue<Empregado> bilhetes= new LinkedList<>();		
		
		for(Empregado e : empregados) {
			bilhetes.add(e);
		}
		
		int numeroBilhetes = 10;
		for (int i = 0; i <numeroBilhetes ; i++) {
			Empregado aux = bilhetes.peek();
			aux.addBilhete();
			bilhetes.remove();
			bilhetes.add(aux);
		}
		for(Empregado e:bilhetes){
			out.println(e.getBilhetes());
		}	
		
	}
	
	public static String GerarNome() {

		String[] primeirosNomes= {"João", "Diogo", "Gabriela", "Miguel", "Manuel", "António", "Ana", "Maria", "Gabriel", "Vitor", "Pedro", "Ema", "Marta", "Carolina", "Marco", "Elsa", "Eva", "Raquel", "Mafalda", "Cristina", "Mara", "Rafael", "Rafaela", "Rui", "Vicente"};
		String[] ultimosNomes = {"Oliveira", "Videira", "Santos", "Gomes", "Ribeiro", "Soares", "Fernandes", "Felicio", "Freitas", "Pinto", "Domingues", "Leite", "Teixeira", "Maia", "Fontoura", "Cardoso"};

		int tamanho = ValorEntre(3,5);
		String nome ="";
		String nome1="";
		String nome2="";
		String nome3=""; 
		String nome4="";
		String nome5="";

		if(tamanho == 3) {
			nome1 = primeirosNomes[ValorEntre(0,primeirosNomes.length-1)];

			nome2 = ultimosNomes[ValorEntre(0,ultimosNomes.length-1)];

			do {
				nome3 = ultimosNomes[ValorEntre(0,ultimosNomes.length-1)];
			} while(nome2 == nome3);

			nome = nome1 + " " + nome2 + " " + nome3;
		}
		if(tamanho ==4) {
			nome1 = primeirosNomes[ValorEntre(0,primeirosNomes.length-1)];

			do {
				nome2 = primeirosNomes[ValorEntre(0,primeirosNomes.length-1)];
			} while(nome1 == nome2);

			nome3 = ultimosNomes[ValorEntre(0,ultimosNomes.length-1)];

			do {
				nome4 = ultimosNomes[ValorEntre(0,ultimosNomes.length-1)];
			} while(nome3 == nome4);

			nome = nome1 + " " + nome2 + " " + nome3 + " " + nome4;
		}

		if(tamanho ==5) {
			nome1 = primeirosNomes[ValorEntre(0,primeirosNomes.length-1)];

			do {
				nome2 = primeirosNomes[ValorEntre(0,primeirosNomes.length-1)];
			} while(nome1 == nome2);

			nome3 = ultimosNomes[ValorEntre(0,ultimosNomes.length-1)];

			do {
				nome4 = ultimosNomes[ValorEntre(0,ultimosNomes.length-1)];
			} while(nome3 == nome4);

			do {
				nome5 = ultimosNomes[ValorEntre(0,ultimosNomes.length-1)];
			} while(nome5 == nome4);

			nome = nome1 + " " + nome2 + " " + nome3 + " " + nome4 + " " + nome5;

		}
		return nome;
	}

	private static int ValorEntre(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
