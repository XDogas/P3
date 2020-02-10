import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Set;

public class Banco {
	
	private String nome;
	private ArrayList<Conta> contas;
	
	public Banco(String nome) {
		assert nome.length() > 0 : "Nome do Banco inv�lido";
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}
	
	public int totalContas() {
		return contas.size();
	}

//	public String add(Conta conta) {
//		if(contas.contains(conta)) return "false";
//		else {
//			contas.add(conta);
//			return "true";
//		}
//	}

	public boolean add(Conta c) {	
		if(contas.contains(c)) return false;
		else return contas.add(c);		
	}

//	public MyIterator iterator() {
//		return new MyIterator();
//	}
	
//	public class MyIterator implements Iterator<Conta>() {
//		
//		private int i;
//		
//		public MyIterator() {
//			this.i = 0;
//		}
//		
//		@Override
//		public boolean hasNext() {
//			return i < totalContas();
//		}
//
//		@Override
//		public Conta next() {
//			assert hasNext();
//			this.i++;
//			contas.get(i-1);
//		}
//		
//	}

	

}
