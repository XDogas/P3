
public class Credito extends Movimento {
	
	public Credito(double montante, String data) {
		super(montante, data);
		assert montante > 0;
	}

	@Override
	public String toString() {
		return "Credito []";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
