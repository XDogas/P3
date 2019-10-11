package aula03.Ex2;

public class Circulo extends Figura{
	
	private double raio;
	private Ponto centro;
	
	public Circulo(double raio, Ponto centro) {
		super(centro);
		assert raio > 0 : "O raio tem de ser superior a 0";
		this.raio = raio;
	}
	
	public Circulo(double r, double x, double y) {
		this(r, new Ponto(x,y));
	}
	
	public Circulo(double raio) {
		this(raio, new Ponto(0,0));
	}
	
	public Circulo(Circulo c) {
		this(c.getRaio(), c.getCentro());
	}
		
	public double getRaio() { return this.raio; }
	public Ponto getCentro() { return this.centro; }
	
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}
	
	public double perimetro() {
		return 2 * Math.PI * raio;
	}
	
	@Override
	public String toString() {
		return "Circulo:\ntem centro: " + super.getCentro() + "\ntem raio: " + getRaio() + "\n";
	}
	
	public boolean equals(Circulo c2) {						// Verifica se dois Círculos são iguais
		return this.raio == c2.getRaio();
	}
	
	public boolean intercepts(Circulo c2) {						// Verifica se dois Círculos se interceptam
		return this.centro.distTo(c2.getCentro()) <= this.raio;	
	}

}
