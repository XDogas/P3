package aula03.Ex2;

public class Retangulo extends Figura {
	
	private double comprimento;
	private double largura;
		
	public Retangulo(double comprimento, double largura, Ponto centro) {
				super(centro);
				assert comprimento > 0 && largura > 0 : "O comprimento e largura têm de ser superior a 0";
				this.comprimento = comprimento;
				this.largura = largura;
	}
	
	public Retangulo(double comprimento, double largura, double x, double y) {
		this(comprimento, largura, new Ponto(x,y));		
	}
	
	public Retangulo(double comprimento, double largura) {
		this(comprimento, largura, new Ponto(0,0));		
	}
	
	public Retangulo(Retangulo r) {
		this(r.comprimento(), r.largura(), r.getCentro());		
	}
	
	public double comprimento() { return this.comprimento; }
	public double largura() { return this.largura; }
	
	public double area() {
		return comprimento() * largura();
	}
	
	public double perimetro() {
		return 2 * (comprimento() + largura());
	}
	
	@Override
	public String toString() {
		return "Retângulo:\n" + super.toString() + "tem comprimento: " + comprimento() + "\ntem largura: " + largura() + "\n" ;
	}
	
	public boolean equals(Retangulo r2) {						// Verifica se dois retangulos são iguais
		return super.getCentro().equals(r2.getCentro()) && this.comprimento == r2.comprimento() && this.largura == r2.largura();
	}

}
