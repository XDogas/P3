package aula06.Ex2;

public class Retangulo extends Figura {
	
	private double comprimento;
	private double largura;
		
	public Retangulo(Ponto centro, double comprimento, double largura) {
				setCentro(centro);
				assert comprimento > 0 && largura > 0 : "O comprimento e largura têm de ser superior a 0";
				this.comprimento = comprimento;
				this.largura = largura;
	}
	
	public Retangulo(double x, double y, double comprimento, double largura) {
		this(new Ponto(x,y), comprimento, largura);		
	}
	
	public Retangulo(double comprimento, double largura) {
		this(new Ponto(0,0), comprimento, largura);		
	}
	
	public Retangulo(Retangulo r) {
		this(r.getCentro(), r.comprimento(), r.largura());		
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
		return "Retângulo de centro " + getCentro() + ", altura " + largura() + ", comprimento " + comprimento();
	}
	
	@Override
	public boolean equals(Object obj) {		
		// Não é necessário testar a classe, feito em Figura
		if(!super.equals(obj)) return false;
		
			// Verifica se os atributos do objeto são iguais
		return getCentro().equals(((Retangulo)obj).getCentro()) && this.comprimento == ((Retangulo)obj).comprimento && this.largura == ((Retangulo)obj).largura;
		
			// outra forma de verificar se os atributos do objeto são iguais:
//		Retangulo other = (Retangulo)obj;		// Para poder testar esta segunda forma tem de se alterar a visibilidade 
//											// de centro para protected na class Figura
//		if(this.getCentro() == null) {
//			if(other.centro != null) return false;
//		} else if(!this.centro.equals(other.centro)) return false;
//		
//		if(this.comprimento != other.comprimento) return false;
//		
//		if(this.largura != other.largura) return false;
//		
//		return true;		
	}

}
