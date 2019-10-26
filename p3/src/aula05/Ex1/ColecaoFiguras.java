package aula05.Ex1;

import java.util.ArrayList;

public class ColecaoFiguras {
	
	private double maxArea;
	private ArrayList<Figura> colecao;
	
	public ColecaoFiguras(double maxArea) {	// O construtor define a área máxima da coleção de figuras
		assert maxArea > 0 : "Área máxima inválida(tem de ser suerior a 0)";
		this.maxArea = maxArea;
		this.colecao = new ArrayList<Figura>();
	}
	
	public boolean addFigura(Figura f) {	// Adiciona uma figura à coleção
		assert f != null : "Figura inválida";
		
		if(colecao.contains(f)) return false;
		if(exists(f)) return false;
		if(areaTotal() + f.area() > maxArea) return false;
				
		colecao.add(f);
		
		assert !colecao.isEmpty() : "A coleção encontra-se vazia"; 
		assert areaTotal() > 0 : "Área total inválida";
		
		return true;
	}
	
	public boolean delFigura(Figura f) {	// Remove uma figura da coleção
		assert f != null : "Figura inválida";
		assert !colecao.isEmpty() : "A coleção encontra-se vazia";
		
		if(!exists(f)) return false;
		
		return colecao.remove(f);
	}
	
	public double areaTotal() {				// Retorna a área total das figuras
		double area = 0;		
		for(Figura f : colecao) {
			area += f.area();	
		}		
		return area;
	}
	
	public boolean exists(Figura f) {		// Verifica se uma figura existe na coleção		
		return colecao.contains(f);		
	}
	
	public String toString() {				// Retorna as características da coleção
		return "Coleção de área máxima " + this.maxArea + "e de área total " + areaTotal();
	}
	
	public Figura[] getFiguras() {			// Retorna uma lista com todas as figuras da coleção
		return colecao.toArray(new Figura[colecao.size()]);
	}
	
	public Ponto[] getCentros() {			// Retorna uma lista com todos os centros das figuras da coleção
		Ponto[] centros = new Ponto[colecao.size()];
		
		int i=0;
		for(Figura f : colecao) {
			centros[i++] = f.getCentro();
		}
		return centros;		
	}

}
