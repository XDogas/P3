package aula10.Ex2;

import static java.lang.System.out;

import java.util.Iterator;

public class TestBST {

	public static void main(String[] args) {
		
		Figura f1 = new Quadrado(5);
		Figura f2 = new Quadrado(2,2,4);
		Figura f3 = new Retangulo(4,7);
//		Figura f4 = new Circulo(4,4,3);
//		Figura f5 = new Retangulo(2,3,6,7);
		
		BinarySearchTree<Figura> bst = new BinarySearchTree<>();
		
		bst.insert(f1);
		bst.insert(f2);
		bst.insert(f3);
		
		out.println("Figuras inseridas:");
		Iterator<Figura> it = bst.iterator();
		while(it.hasNext()) out.println(it.next());
		
	}

}
