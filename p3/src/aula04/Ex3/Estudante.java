package aula04.Ex3;

public class Estudante extends Cliente {
		
	private int nmec;
	private String curso;
	
	public Estudante(String nome, int cc, Data dataNasc, Data dataInsc ,int nmec, String curso) {
		
		super(nome, cc, dataNasc, dataInsc);
		
		assert curso.length() > 0 : "Curso inv�lido";
		assert nmec > 0 : "N�mero mecanogr�fico inv�lido";
		
		this.nmec = nmec;
		this.curso = curso;	
	}

	public int getNmec() { return this.nmec; }
	public String getCurso() { return this.curso; }
	
	@Override
	public String toString() {
		return super.toString() + "\nN�mero mecanogr�fico: " + getNmec() + "\nCurso: " + getCurso();
	}

}
