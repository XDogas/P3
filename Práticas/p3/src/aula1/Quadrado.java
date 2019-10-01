package aula1;

public class Quadrado {												// p1____p2
																	// |	  |
	private Ponto[] pontos = new Ponto[4];							// |	  |
																	// p4____p3
	public Quadrado(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
		assert isSquare(p1, p2, p3, p4) : "Os pontos fornecidos não formam um quadrado";
		
		pontos[0] = p1;
		pontos[1] = p2;
		pontos[2] = p3;
		pontos[3] = p4;
	}
	
	public String getPoints() {
		return "[" + pontos[0].toString() + ", " + pontos[1].toString() + ", " + pontos[2].toString() + ", " + pontos[3].toString() + "]";
	}
	
	public double getSide() {		// obter comprimento do lado
		return pontos[0].distTo(pontos[1]);
	}
	
	public double getArea() {
		return Math.pow(getSide(), 2);
	}
	
	public double getPerimetro() {
		return 4 * getSide();
	}
	
	public String toString() {
		return "Quadrado:\n-> Pontos: " + getPoints() + "\n-> Área: " + getArea() + "\n-> Perímetro: " + getPerimetro();
	}
	
	private boolean isSquare(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
		
		boolean l12 = Double.compare(p1.distTo(p2), p2.distTo(p3)) == 0 ? true : false;
		boolean l23 = Double.compare(p2.distTo(p3), p3.distTo(p4)) == 0 ? true : false;
		boolean l34 = Double.compare(p3.distTo(p4), p4.distTo(p1)) == 0 ? true : false;
		
		return l12 && l23 && l34;		
	}
	
}
