package aula04.Ex3;

public class Funcionario extends Cliente {
		
	private int nfuncionario;
	private int nfiscal;
	
	public Funcionario(String nome, int cc, Data dataNasc, Data dataInsc ,int nfuncionario, int nfiscal) {
		
		super(nome, cc, dataNasc, dataInsc);
		
		assert nfuncionario > 0 : "Número de funcionário inválido";
		assert nfiscal > 0 : "Número fiscal inválido";
		
		this.nfuncionario = nfuncionario;
		this.nfiscal = nfiscal;
	}
	
	public int getNfunc() { return this.nfuncionario; }
	public int getNfis() { return this.nfiscal; }
	
	@Override
	public String toString() {
		return super.toString() + "\nNúmero de funcionário: " + getNfunc() + "\nNúmero fiscal: " + getNfis();
	}

}
