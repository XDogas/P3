package aula11.Ex2;

public class Circulo extends Figura {
	
	private double raio;
	
	public Circulo(Ponto centro, double raio) {
		setCentro(centro);
		assert raio > 0 : "O raio tem de ser superior a 0";
		this.raio = raio;
	}
	
	public Circulo(double x, double y, double raio) {
		this(new Ponto(x,y), raio);
	}
	
	public Circulo(double raio) {
		this(new Ponto(0,0), raio);
	}
	
	public Circulo(Circulo c) {
		this(c.getCentro(), c.getRaio());
	}
		
	public double getRaio() { return this.raio; }
	
	public double area() {
		return Math.PI * Math.pow(raio, 2);
	}
	
	public double perimetro() {
		return 2 * Math.PI * raio;
	}
	
	@Override
	public String toString() {
		return "Circulo de centro " + getCentro() + " e de raio " + getRaio();
	}
	
	public boolean intercepts(Circulo c2) {						// Verifica se dois Círculos se interceptam
		return getCentro().distTo(c2.getCentro()) <= this.raio;	
	}
	
	public boolean equals(Circulo c2) {						// Verifica se dois Círculos são iguais
		return this.raio == c2.getRaio();
	}	
	
	@Override
	public boolean equals(Object obj) {		
			// Não é necessário testar a classe, feito em Figura
		if(!super.equals(obj)) return false;
			// Verifica se os atributos do objeto são iguais
		return getCentro().equals(((Circulo)obj).getCentro()) && this.raio == ((Circulo)obj).raio;
		
			// outra forma de verificar se os atributos do objeto são iguais:
//		Circulo other = (Circulo)obj;		 
//		
//		if(this.getCentro() == null) {
//			if(other.getCentro() != null) return false;
//		} else if(!getCentro().equals(other.getCentro())) return false;
//		
//		if(this.raio != other.raio) return false;
//		
//		return true;		
	}	

}
