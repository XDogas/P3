package aula01.Ex3;

public class Retangulo {											// p1____p2
																	// |	  |
	private Ponto[] pontos = new Ponto[4];							// |	  |
																	// p4____p3
	public Retangulo(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
		assert isRectangle(p1, p2, p3, p4) : "Os pontos n�o formam um ret�ngulo";
		
		pontos[0] = p1;
		pontos[1] = p2;
		pontos[2] = p3;
		pontos[3] = p4;
	}
	
	public String getPoints() {
		return "[" + pontos[0].toString() + ", " + pontos[1].toString() + ", " + pontos[2].toString() + ", " + pontos[3].toString() + "]";
	}
	
	public double getArea() {
		return pontos[0].distTo(pontos[1]) * pontos[1].distTo(pontos[2]);
	}
	
	public double getPerimetro() {
		return 2 * (pontos[0].distTo(pontos[1]) + pontos[1].distTo(pontos[2]));
	}
	
	public String toString() {
		return "Ret�ngulo:\n-> Pontos: " + getPoints() + "\n-> �rea: " + getArea() + "\n-> Per�metro: " + getPerimetro();
	}

	public boolean isRectangle(Ponto p1, Ponto p2, Ponto p3, Ponto p4) {
		
		boolean c = Double.compare(p1.distTo(p2), p4.distTo(p3)) == 0 ? true : false;
		boolean l = Double.compare(p1.distTo(p4), p2.distTo(p3)) == 0 ? true : false;
		
		return c && l;
	}

}
