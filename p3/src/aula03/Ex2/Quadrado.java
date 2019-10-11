package aula03.Ex2;

public class Quadrado extends Figura {
	
	private double lado;
	
	public Quadrado(double lado, Ponto centro) {
		super(centro);	
		assert lado > 0 : "O lado tem de ser superior a 0";
		this.lado = lado;
	}
	
	public Quadrado(double lado, double x, double y) {
		this(lado, new Ponto(x,y));
	}
	
	public Quadrado(double lado) {
		this(lado, new Ponto(0,0));
	}
	
	public Quadrado(Quadrado q) {
		this(q.getLado(), q.getCentro());
	}
	
	public double getLado() { return this.lado; }
	
	public double perimetro() {
		return 4 * getLado();
	}
	
	public double area() {
		return Math.pow(getLado(), 2);
	}	
	
	@Override
	public String toString() {
		return "Quadrado:\n" + super.toString() + "tem lado: " + getLado()  + "\n";
	}
	
//	public boolean equals(Object s) {
//		if (s == null) return false;
//		if (s.getClass() != this.getClass()) return false;
//		return super.getCentro().equals(((Quadrado)s).getCentro()) && this.lado == ((Quadrado)s).getLado();
//	}
	////OU\\\\
	public boolean equals(Quadrado q2) {						// Verifica se dois quadrados são iguais
		return super.getCentro().equals(q2.getCentro()) && this.lado == q2.getLado();
	}
		
}
