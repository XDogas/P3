package aula05.Ex2;

public class Matricula {
	
	private String m1;
	private String m2;
	private String m3;
	
	public Matricula(String matricula) {
//		assert isValida() : "Matrícula é inváida";
		this.m1 = matricula.split("-")[0];
		this.m2 = matricula.split("-")[1];
		this.m3 = matricula.split("-")[2];
	}
	
	public boolean isValida() {
		if(m1.length() != 2 || m2.length() != 2 || m3.length() != 2) return false;
		
		if(!Character.isDigit(m1.charAt(0)) || !Character.isLetter(m1.charAt(0))) return false;
		if(!Character.isDigit(m1.charAt(1)) || !Character.isLetter(m1.charAt(1))) return false;
		
		if(!Character.isDigit(m2.charAt(0)) || !Character.isLetter(m2.charAt(0))) return false;
		if(!Character.isDigit(m2.charAt(1)) || !Character.isLetter(m2.charAt(1))) return false;
		
		if(!Character.isDigit(m3.charAt(0)) || !Character.isLetter(m3.charAt(0))) return false;
		if(!Character.isDigit(m3.charAt(1)) || !Character.isLetter(m3.charAt(1))) return false;
		
		if(Character.isDigit(m1.charAt(0)) && !Character.isDigit(m1.charAt(1))) return false;
		if(Character.isDigit(m2.charAt(0)) && !Character.isDigit(m2.charAt(2))) return false;
		if(Character.isDigit(m2.charAt(0)) && !Character.isDigit(m2.charAt(2))) return false;
		
		return true;
	}
	
	public String toString() {
		return this.m1 + "-" + this.m2 + "-" + this.m3;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this == obj) return true;
		if(this.getClass() != obj.getClass()) return false;
		
		Matricula other = (Matricula) obj;
		
		return this.m1.equals(other.m1) && this.m2.equals(other.m2) && this.m3.equals(other.m3);
	}

}
