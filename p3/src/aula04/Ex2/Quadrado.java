package aula04.Ex2;

public class Quadrado extends Retangulo {
	
	public Quadrado(Ponto centro, double lado) {
		super(centro, lado, lado);	
	}
	
	public Quadrado(double x, double y, double lado) {
		this(new Ponto(x,y), lado);
	}
	
	public Quadrado(double lado) {
		this(new Ponto(0,0), lado);
	}

	@Override
	public String toString() {
		return "Quadrado de Centro " + getCentro() + " e de lado " + comprimento();
	}
		
}
