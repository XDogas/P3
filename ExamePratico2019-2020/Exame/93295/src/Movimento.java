
public class Movimento {
	
	private double montante;
	private String data;
	
	public Movimento(double montante, String data) {
		assert data.length() > 0 : "Data inválida";
		
		this.montante = montante;
		this.data = data;
	}

	public double getMontante() {
		return montante;
	}

	public String getData() {
		return data;
	}

	@Override
	public String toString() {
		return "Movimento [montante=" + montante + ", data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montante);
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
		Movimento other = (Movimento) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (Double.doubleToLongBits(montante) != Double.doubleToLongBits(other.montante))
			return false;
		return true;
	}

}
