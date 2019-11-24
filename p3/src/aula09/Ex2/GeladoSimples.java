package aula09.Ex2;

import static java.lang.System.out;

public class GeladoSimples implements Gelado {
	
	private String sabor;
	
	public GeladoSimples(String sabor) {
		this.sabor = sabor;
	}

	@Override
	public void base(int b) {
		assert b > 0 : "O gelado tem de ter pelo menos 1 bola";
		if(b == 1) out.print("\n" +b + " bola de gelado de " + this.sabor);
		else out.print("\n" +b + " bolas de gelado de " + this.sabor);
		
	}

}
