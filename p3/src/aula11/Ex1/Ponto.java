package aula11.Ex1;

public class Ponto {
	
	private double x;
	private double y;
	
	public Ponto(double x, double y) {		
		this.x = x;
		this.y = y;
	}
	
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	
	public double distTo(Ponto p2) {
		return Math.sqrt(Math.pow(this.x - p2.getX(), 2) + Math.pow(this.y - p2.getY(), 2));
	}
	
	@Override
	public String toString() {
		return "x: " + getX() + ", y: " + getY();
	}
	
}