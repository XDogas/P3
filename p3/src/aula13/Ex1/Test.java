package aula13.Ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Localidade cid1 = new Localidade("Szohod", 31212, TipoLocalidade.CIDADE);
		Localidade cid2 = new Localidade("Wadesdah", 23423, TipoLocalidade.CIDADE);
//		Localidade cid3 = new Localidade("BedRock", 23423, TipoLocalidade.VILA);
		Estado est1 = new Estado("North Borduria", 223133, cid1);
		Estado est2 = new Estado("South Borduria", 84321, cid2);
		Pais p1 = new Pais("Borduria", est1.getCapital());
		Pais p2 = new Pais("Khemed", cid2);
		Pais p3 = new Pais("Aurelia");
		Pais p4 = new Pais("Atlantis");
		p1.addRegiao(est1);
		p1.addRegiao(est2);
		p2.addRegiao(new Provincia("Afrinia", 232475, "Aluko Pono"));
		p2.addRegiao(new Provincia("Eriador", 100000, "Dumpgase Liru"));
		p2.addRegiao(new Provincia("Laurania", 30000, "Mukabamba Dabba"));
		List<Pais> org = new ArrayList<Pais>();
		org.add(p1);
		org.add(p2);
		org.add(p3);
		org.add(p4);
		System.out.println("----Iterar sobre o conjunto");
		Iterator<Pais> itr = org.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		System.out.println("\n----Iterar sobre o conjunto - For each (java 8)");
		for (Pais pais: org)
			System.out.println(pais);

		Pais p5 = new Pais("Portugal", new Localidade("Lisboa", 2000000, TipoLocalidade.CIDADE));
		if(!org.contains(p5)) org.add(p5);		
		System.out.println("\n----Iterar sobre o conjunto após adicionar pais 5");
		for (Pais pais: org)
			System.out.println(pais);

		if(org.contains(p5)) org.remove(p3);
		System.out.println("\n----Iterar sobre o conjunto após remover pais 3");
		for (Pais pais: org)
			System.out.println(pais);

		Collections.sort(org, Comparator.comparing(Pais::getNome));
		System.out.println("\n----Iterar sobre o conjunto ordenado alfabeticamente");
		for (Pais pais: org)
			System.out.println(pais);

		Collections.sort(org, Comparator.comparing(Pais::getPopulacao));
		System.out.println("\n----Iterar sobre o conjunto ordenado por população");
		for (Pais pais: org)
			System.out.println(pais);
	}

}
