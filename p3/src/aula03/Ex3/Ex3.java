package aula03.Ex3;

import static java.lang.System.*;

public class Ex3 {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Diogo	 ", 15832426, new Data(5, 10, 2000));
		
		out.println("Não condutor(pessoa sem carta):\n" + p1 + "\n");
		
		Condutor c1 = new Condutor("Diogo	 ", 15832426, new Data(5, 10, 2000), 'A');
		Condutor c2 = new Condutor("Gabriela ", 15019396, new Data(16, 12, 1999), 'B');
		Condutor c3 = new Condutor("Alexandra", 12356789, new Data(23, 1, 1973), 'C');
		Condutor c4 = new Condutor("Agostinho", 19876532, new Data(26, 8, 1969), 'D');
		Condutor c5 = new Condutor(p1, 'A');
		Condutor c6 = new Condutor(c2);
		Condutor c7 = null;
		
		out.println("Condutores:\n" + c1 + "\n" + c2 + "\n" + c3 + "\n" + c4 + "\n" + c5 + "\n" + c6 + "\n" + c7 + "\n");
		
		out.println("Teste dos condutores:");
		out.println("c1 equals to p1? -> " + c1.equals(p1)); // False
		out.println("c1 equals to c2? -> " + c1.equals(c2)); // False
		out.println("c1 equals to c3? -> " + c1.equals(c3)); // False
		out.println("c1 equals to c7? -> " + c1.equals(c7)); // False
		out.println("c2 equals to c3? -> " + c2.equals(c3)); // False
		out.println("c2 equals to c5? -> " + c2.equals(c5)); // False
		out.println("c2 equals to c6? -> " + c2.equals(c6)); // True
		out.println("c3 equals to c4? -> " + c3.equals(c4)); // False
		out.println("c3 equals to c7? -> " + c3.equals(c7)); // False
		
		
		out.println("\nVeículos:");
			
		Motociclo m1 = new Motociclo(1200, 125, 2, 'A', 150);
		Motociclo m2 = new Motociclo(m1);
		
		out.println(m1 + "\n" + m2);		// print motociclos
		
		Ligeiro l1 = new Ligeiro(1197, 85, 5, 'B', 2500);
		Ligeiro l2 = new Ligeiro(2497, 350, 2, 'B', 3000);
		
		out.println(l1 + "\n" + l2);		// print ligeiros
		
		PesadoMercadorias pm = new PesadoMercadorias(3000, 150, 3, 'C', 7500);
		
		out.println(pm);					// print pessado de mercadorias
		
		PesadoPassageiros pp = new PesadoPassageiros(7000, 300, 31, 'D', 5000);
		
		out.println(pp);					// print pessado de passageiros
		
		out.println("\nTeste dos veiculos:");
		out.println("m1 equals to m2? -> " + m1.equals(m2)); // True
		out.println("m1 equals to l2? -> " + m1.equals(l2)); // False
		out.println("m2 equals to l1? -> " + m2.equals(l1)); // False
		out.println("m2 equals to pm? -> " + m2.equals(pm)); // False
		out.println("l1 equals to l2? -> " + l1.equals(l2)); // False
		out.println("l1 equals to pp? -> " + l1.equals(pp)); // False
		out.println("l2 equals to m2? -> " + l2.equals(m2)); // False
		out.println("l2 equals to pp? -> " + l2.equals(pp)); // False
		out.println("pm equals to m1? -> " + pm.equals(m1)); // False
		out.println("pm equals to l2? -> " + pm.equals(l2)); // False
		out.println("pp equals to m1? -> " + pp.equals(m1)); // False
		out.println("pp equals to pm? -> " + pp.equals(pm)); // False
		
		out.println("\nTeste geral:");
		out.println("c1 can drive m1? -> " + m1.canDrive(c1)); // True
		out.println("c1 can drive m2? -> " + m2.canDrive(c1)); // True
		out.println("c1 can drive l1? -> " + l1.canDrive(c1)); // False
		out.println("c1 can drive l2? -> " + l2.canDrive(c1)); // False
		out.println("c1 can drive pm? -> " + pm.canDrive(c1)); // False
		out.println("c1 can drive pp? -> " + pp.canDrive(c1)); // False
		out.println();
		out.println("c2 can drive m1? -> " + m1.canDrive(c2)); // True
		out.println("c2 can drive m2? -> " + m2.canDrive(c2)); // True
		out.println("c2 can drive l1? -> " + l1.canDrive(c2)); // True
		out.println("c2 can drive l2? -> " + l2.canDrive(c2)); // True
		out.println("c2 can drive pm? -> " + pm.canDrive(c2)); // False
		out.println("c2 can drive pp? -> " + pp.canDrive(c2)); // False
		out.println();
		out.println("c3 can drive m1? -> " + m1.canDrive(c3)); // True
		out.println("c3 can drive m2? -> " + m2.canDrive(c3)); // True
		out.println("c3 can drive l1? -> " + l1.canDrive(c3)); // True
		out.println("c3 can drive l2? -> " + l2.canDrive(c3)); // True
		out.println("c3 can drive pm? -> " + pm.canDrive(c3)); // True
		out.println("c3 can drive pp? -> " + pp.canDrive(c3)); // False
		out.println();
		out.println("c4 can drive m1? -> " + m1.canDrive(c4)); // True
		out.println("c4 can drive m2? -> " + m2.canDrive(c4)); // True
		out.println("c4 can drive l1? -> " + l1.canDrive(c4)); // True
		out.println("c4 can drive l2? -> " + l2.canDrive(c4)); // True
		out.println("c4 can drive pm? -> " + pm.canDrive(c4)); // True
		out.println("c4 can drive pp? -> " + pp.canDrive(c4)); // True
		out.println();
		out.println("c5 can drive m1? -> " + m1.canDrive(c5)); // True
		out.println("c5 can drive m2? -> " + m2.canDrive(c5)); // True
		out.println("c5 can drive l1? -> " + l1.canDrive(c5)); // False
		out.println("c5 can drive l2? -> " + l2.canDrive(c5)); // False
		out.println("c5 can drive pm? -> " + pm.canDrive(c5)); // False
		out.println("c5 can drive pp? -> " + pp.canDrive(c5)); // False
		out.println();
		out.println("c6 can drive m1? -> " + m1.canDrive(c6)); // True
		out.println("c6 can drive m2? -> " + m2.canDrive(c6)); // True
		out.println("c6 can drive l1? -> " + l1.canDrive(c6)); // True
		out.println("c6 can drive l2? -> " + l2.canDrive(c6)); // True
		out.println("c6 can drive pm? -> " + pm.canDrive(c6)); // False
		out.println("c6 can drive pp? -> " + pp.canDrive(c6)); // False

	}
	
}