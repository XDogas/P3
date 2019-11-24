package aula09.Ex2;

public abstract class GelDecorador implements Gelado {
	
	protected Gelado gelado;
	
	public GelDecorador(Gelado gelado) {
		this.gelado = gelado;
	}

	@Override
	public void base(int b) {
		gelado.base(b);
	}

}
