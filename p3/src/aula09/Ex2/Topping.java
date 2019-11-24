package aula09.Ex2;

import static java.lang.System.out;

public class Topping extends GelDecorador {
	
	private String top;

	public Topping(Gelado gelado, String top) {
		super(gelado);
		this.top = top;
	}
	
	@Override
	public void base(int b) {
		gelado.base(b);
		out.print(" com " + this.top);
	}

}
