package aula04.Ex1;

import java.util.ArrayList;

import static java.lang.System.*;


public class Disciplina {
	
	private String nome;
	private String areaCientifica;
	private int ects;
	private Professor responsavel;
	private ArrayList<Estudante> alunos;
	
	public Disciplina(String nome, String areaCientifica, int ects, Professor responsavel) {
		this.nome = nome;
		this.areaCientifica = areaCientifica;
		this.ects =ects;
		this.responsavel = responsavel;
		this.alunos = new ArrayList<Estudante>();
	}
	
	public String nome() { return this.nome; }
	public String areaCientifica() { return this.areaCientifica; }
	public int ects() { return this.ects; }
	public Professor responsavel() { return this.responsavel; }
	
	public boolean addAluno(Estudante est) {		// Adiciona um aluno � Disciplina
		assert est != null : "Estudante inv�lido";
		
		if(alunoInscrito(est.nMec())) return false;	// ou -> if(alunos.contains(est)) {
						
		alunos.add(est);
		
		return true;
	}
	
	public boolean delAluno(int nMec) {				// Remove um aluno da Disciplina
		if(!alunoInscrito(nMec)) {
			out.print("O aluno com o n�mero mecanogr�fico " + nMec + "n�o se encontra inscrito");
			return false;
		}
		
		alunos.remove(getIndexByNmec(nMec));
		
		return true;
	}
	
	public boolean alunoInscrito(int nMec) {		// Verifica se aluno est� inscrito � disciplina
		assert nMec >= 100 : "N�mero mecanogr�fico inv�lido(inferior a 100)";
		
		for(int i=0; i<alunos.size(); i++) {
			if(alunos.get(i).nMec() == nMec) return true;
		}
		
		return false;
	}
	
	private int getIndexByNmec(int nMec) {			// Retorna o index do aluno atraves do n�mero mecanogr�fico
		int i;
		for(i=0; i<alunos.size(); i++) {
			if(alunos.get(i).nMec() == nMec) break;
		}
		return i;
	}
	
	public int numAlunos() {						// Retorna o N� de Alunos Inscritos
		return alunos.size();
	}
	
	@Override
	public String toString() {						// Retorna as caracter�sticas da Disciplina
		return "Disciplina: " + nome() + " ( " + ects() + " ECTS) da Area de " + areaCientifica() + "\nRespons�vel: " + responsavel() + "\nExistem " + numAlunos() + " Alunos Inscritos";
	}
	
	public Estudante[] getAlunos() {				// Retorna uma lista com todos os alunos da disciplina
		return alunos.toArray(new Estudante[alunos.size()]);
	}
	
	public Estudante[] getAlunos(String tipo) {		// Retorna uma lista com todos os alunos da disciplina do subtipo �tipo�
		ArrayList<Estudante> alunosTipo = new ArrayList<Estudante>();
		
		for(Estudante e : alunos) {
			if(e.toString().contains(tipo)) alunosTipo.add(e);
		}
		
		return alunosTipo.toArray(new Estudante[alunosTipo.size()]);
	}
 
}
