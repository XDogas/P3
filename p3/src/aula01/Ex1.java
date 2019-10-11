package aula01;

import java.util.Scanner;

public class Ex1 {

	private static Scanner in = new Scanner(System.in);;

	public static void main(String[] args) {
				
		String str = in.nextLine();
		String str2 = "";
		
		char s = ' ';
		
		int contD = 0;			//contador dos digitos
		int contW = 0;			//contador das palavras
		int contL = 0;			//contador das letras
		int contMin = 0;		//contador das minusculas
		int contMai = 0;		//contador das maiusculas
		
		boolean allMin = false;
		boolean allMai = false;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if(Character.isDigit(c)) contD++;					//se for digito incrementa 1 ao contador dos digitos 
			
			if(Character.isLetter(c)) {							//se for letra
				contL++;										//incrementa 1 ao contador das letras
				if(Character.toLowerCase(c)==c) contMin++;		//verifica se � minuscula
				if(Character.toUpperCase(c)==c) contMai++;		//verifica se � maiuscula
			}
			if(contMin==contL) allMin=true;
			else allMin=false;
			if(contMai==contL) allMai=true;
			else allMai=false;
						
		}
		
		System.out.println("a) Total de caracteres num�ricos (0..9): " + contD);
		System.out.println("b) S� tem min�sculas: " + allMin);
		System.out.println("c) S� tem mai�sculas: " + allMai);
		
		System.out.print("d) Total de palavras lidas, imprimindo-as no ecr�: ");
		String[] strs = str.split(" ");
		for(int i=0; i<strs.length; i++) {
			if(!strs[i].contains("0")&&!strs[i].contains("1")&&!strs[i].contains("2")&&!strs[i].contains("3")&&!strs[i].contains("4")&&!strs[i].contains("5")&&!strs[i].contains("6")&&!strs[i].contains("7")&&!strs[i].contains("8")&&!strs[i].contains("9")) {
				contW++;
				System.out.printf("%s; ", strs[i]);
			}
		}				
		System.out.println(contW + " palavras");		
		
		for(int i=0; i<str.length(); i++) {
                if(i % 2 == 0) {
                        s = str.charAt(i);
                }
                else {
                		str2 += Character.toString(str.charAt(i))+Character.toString(s);
                        s = ' ';
                }
        }
        if(s != ' ') {
        	str2 += s;
        }

        System.out.println("e) String na qual todos os caracteres foram trocados 2 a 2: " + str2);

	}

}
