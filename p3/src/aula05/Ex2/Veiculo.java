package aula05.Ex2;

public abstract class Veiculo implements Comparable<Veiculo> {
	
	private int ano;
	private Cor cor;
	private int nrodas;
	private int lotacao;
	private double peso;
	
	public Veiculo(int ano, Cor cor, int nrodas, int lotacao, double peso) {
		assert ano > 1800 : "O ano tem de ser superior a 1800";
		assert nrodas > 0 : "Número de rodas inválido";
		assert lotacao > 0 : "Lotação inválida";
		assert peso > 0 : "Peso inválido";
		
		this.ano = ano;
		this.cor = cor;
		this.nrodas = nrodas;
		this.lotacao = lotacao;
		this.peso = peso;
	}
	
	public int ano() { return this.ano; }
	public Cor cor() { return this.cor; }
	
	public int nrodas() { return this.nrodas; }
	public int lotacao() { return this.lotacao; }
	public double peso() { return this.peso; }
	
	public int compareTo(Veiculo v) {
		if(this.ano() < v.ano()) return -1;
		if(this.ano() > v.ano()) return 1;
		return 0;
	}
	
	public String toString() {
		return "Ano: " + this.ano()
			 + "; Cor: " + this.cor()
			 + "; Número de rodas: " + this.nrodas()
			 + "; Lotação: " + this.lotacao()
			 + "; Peso: " + this.peso();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(this == obj) return true;
		if(this.getClass() != obj.getClass()) return false;
		
		Veiculo other = (Veiculo) obj;
		
		if(this.ano != other.ano) return false;
		
		if(cor == null)
		{
			if(other.cor != null)
				return false;
		} else if(!cor.equals(other.cor)) return false;
		
		if(this.nrodas != other.nrodas)	return false;
		
		if(this.lotacao != other.lotacao) return false;
		
		if(this.peso != other.peso) return false;
		
		return true;
	}

}
