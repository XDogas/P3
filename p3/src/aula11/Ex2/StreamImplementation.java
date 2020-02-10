package aula11.Ex2;

import static java.lang.System.out;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StreamImplementation {

	public static void main(String[] args) {
		
		Figura f1 = new Circulo(1,2,5);
		Figura f2 = new Circulo(2);
		Figura f3 = new Circulo(4);
		Figura f4 = new Quadrado(2,2,6);
		Figura f5 = new Quadrado(2);
		Figura f6 = new Quadrado(3);
		Figura f7 = new Retangulo(5,3,2,4);
		Figura f8 = new Retangulo(2,4);
		Figura f9 = new Retangulo(7,10);
		
		List<Figura> figs= new LinkedList<>();
		figs.add(f1);
		figs.add(f2);
		figs.add(f3);
		figs.add(f4);
		figs.add(f5);
		figs.add(f6);
		figs.add(f7);
		figs.add(f8);
		figs.add(f9);
		
		out.println("Figura com maior área: " + maiorFiguraJ8(figs));
		out.println("Figura com maior Perímetro: " + maiorPerimetroJ8(figs));
		out.println("Área total das figuras: " + areaTotalJ8(figs));
		out.println("Soma das áreas dos circulos: " + areaTotalSubTipoJ8(figs,"Circulo"));
		out.println("Soma das áreas dos retangulos: " + areaTotalSubTipoJ8(figs,"Retangulo"));
		out.println("Soma das áreas dos quadrados: " + areaTotalSubTipoJ8(figs,"Quadrado"));
	}
	
	private static Figura maiorFiguraJ8(List<Figura> figs) {
		return figs.stream()
				.max(Comparator.comparing(Figura::area))
				.get();
	}
	
	private static Figura maiorPerimetroJ8(List<Figura> figs) {
		return figs.stream()
				.max(Comparator.comparing(Figura::perimetro))
				.get();
	}
	
	private static double areaTotalJ8(List<Figura> figs) {
		return figs.stream()
				.mapToDouble(Figura::area)
				.sum();
	}
	
	private static double areaTotalSubTipoJ8(List<Figura> figs, String subtipoNome){
		return figs.stream()
				.filter(f -> f.getClass().toString().equals("class aula11.Ex2." + subtipoNome))
				.mapToDouble(Figura::area)
				.sum();
	}


}