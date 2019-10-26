package aula05.Ex1;

import java.util.ArrayList;

public class ColecaoFiguras {
	
	private double maxArea;
	private ArrayList<Figura> colecao;
	
	public ColecaoFiguras(double maxArea) {	// O construtor define a �rea m�xima da cole��o de figuras
		assert maxArea > 0 : "�rea m�xima inv�lida(tem de ser suerior a 0)";
		this.maxArea = maxArea;
		this.colecao = new ArrayList<Figura>();
	}
	
	public boolean addFigura(Figura f) {	// Adiciona uma figura � cole��o
		assert f != null : "Figura inv�lida";
		
		if(colecao.contains(f)) return false;
		if(exists(f)) return false;
		if(areaTotal() + f.area() > maxArea) return false;
				
		colecao.add(f);
		
		assert !colecao.isEmpty() : "A cole��o encontra-se vazia"; 
		assert areaTotal() > 0 : "�rea total inv�lida";
		
		return true;
	}
	
	public boolean delFigura(Figura f) {	// Remove uma figura da cole��o
		assert f != null : "Figura inv�lida";
		assert !colecao.isEmpty() : "A cole��o encontra-se vazia";
		
		if(!exists(f)) return false;
		
		return colecao.remove(f);
	}
	
	public double areaTotal() {				// Retorna a �rea total das figuras
		double area = 0;		
		for(Figura f : colecao) {
			area += f.area();	
		}		
		return area;
	}
	
	public boolean exists(Figura f) {		// Verifica se uma figura existe na cole��o		
		return colecao.contains(f);		
	}
	
	public String toString() {				// Retorna as caracter�sticas da cole��o
		return "Cole��o de �rea m�xima " + this.maxArea + "e de �rea total " + areaTotal();
	}
	
	public Figura[] getFiguras() {			// Retorna uma lista com todas as figuras da cole��o
		return colecao.toArray(new Figura[colecao.size()]);
	}
	
	public Ponto[] getCentros() {			// Retorna uma lista com todos os centros das figuras da cole��o
		Ponto[] centros = new Ponto[colecao.size()];
		
		int i=0;
		for(Figura f : colecao) {
			centros[i++] = f.getCentro();
		}
		return centros;		
	}

}
