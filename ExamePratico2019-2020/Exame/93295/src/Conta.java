import java.util.LinkedList;
import java.util.List;

public class Conta {
	
	private int nSeq;
	private Cliente cliente;
	private double saldo;
	private List<Movimento> movimentos;
	
	public Conta(Cliente cliente) {
		assert cliente != null : "Cliente inv�lido";
		this.cliente = cliente;
		this.movimentos = new LinkedList<>();
	}

	public int getnSeq() {
		return nSeq;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	@Override
	public String toString() {
		return "Conta [nSeq=" + nSeq + ", cliente=" + cliente + ", saldo=" + saldo + ", movimentos=" + movimentos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((movimentos == null) ? 0 : movimentos.hashCode());
		result = prime * result + nSeq;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (movimentos == null) {
			if (other.movimentos != null)
				return false;
		} else if (!movimentos.equals(other.movimentos))
			return false;
		if (nSeq != other.nSeq)
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		return true;
	}

	public void add(Credito c) {
		movimentos.add(c);		
	}

}

	