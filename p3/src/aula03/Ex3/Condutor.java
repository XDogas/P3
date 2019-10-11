package aula03.Ex3;

public class Condutor extends Pessoa {
	
	private char tipoCarta;

	public Condutor(String nome, int cc, Data dataNasc, char tipoCarta) {
		super(nome, cc, dataNasc);
		this.tipoCarta = tipoCarta;
	}
	
	public Condutor(Pessoa p, char tc){
		this(p.nome(), p.getCC(), p.getDataNasc(), tc);
	}
	
	public Condutor(Condutor c){
		this(c.nome(), c.getCC(), c.getDataNasc(), c.getTipoCarta());
	}

	public char getTipoCarta() { return this.tipoCarta; }
	
	@Override
	public String toString() {
		return super.toString() + ", Tipo de carta: " + getTipoCarta();
	}
	
//	public boolean equals(Object c) {
//		if (c == null) return false;
//		if (c.getClass() != this.getClass()) return false;
//		return super.nome().equals(((Condutor)c).nome()) && super.getCC() == ((Condutor)c).getCC() && super.getDataNasc().equals(((Condutor)c).getDataNasc()) && this.tipoCarta == ((Condutor)c).getTipoCarta();
//	}
	////OU\\\\
	public boolean equals(Condutor c) {
		if (c == null) return false;
		return super.nome().equals(c.nome()) && super.getCC() == c.getCC() && super.getDataNasc().equals(c.getDataNasc()) && this.tipoCarta == c.getTipoCarta();
	}

}
