package aula09.Ex2;

import static java.lang.System.out;

public class Copo extends GelDecorador {

	public Copo(Gelado gelado) {
		super(gelado);
	}
	
	@Override
	public void base(int b) {
		gelado.base(b);
		out.print(" em copo");
	}

}
