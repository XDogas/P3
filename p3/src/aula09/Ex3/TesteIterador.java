package aula09.Ex3;

import java.util.Iterator;

public class TesteIterador {

	public static void main(String[] args) {
		
		System.out.println("Iterator:");
		
		VectorPessoas vp = new VectorPessoas();
		
		System.out.println("\nVetor:\n");
		
		for (int i=0; i<10; i++)
			vp.addPessoa(new Pessoa("Bebé no Vector "+i,
							1000+i, Data.today()));
		
		Iterator<Pessoa> vec = vp.iterator();
		
		while ( vec.hasNext() )
			System.out.println( vec.next() );
		
		System.out.println("\nLista:\n");
		
		ListaPessoas lp = new ListaPessoas();
		
		for (int i=0; i<10; i++)
			lp.addPessoa(new Pessoa("Bebé na Lista "+i,
							2000+i, Data.today()));
		
		Iterator<Pessoa> lista = lp.iterator();
		
		while ( lista.hasNext() )
			System.out.println( lista.next() );
		
		System.out.println("\n\nBFIterator:");
		
		VectorPessoasBFI vpBFI = new VectorPessoasBFI();
		
		System.out.println("\nVetor:\n");
		
		for (int i=0; i<10; i++)
			vpBFI.addPessoa(new Pessoa("Bebé no Vector "+i,
							1000+i, Data.today()));
		
		BFIterator vecBFI = vpBFI.iterator();
		
		while ( vecBFI.hasNext() )
			System.out.println( vecBFI.next() );
		
		System.out.println();		
		
		while ( vecBFI.hasPrevious() )
			System.out.println( vecBFI.previous() );
		
		ListaPessoasBFI lpBFI = new ListaPessoasBFI();
		
		System.out.println("\nLista:\n");
		
		for (int i=0; i<10; i++)
			lpBFI.addPessoa(new Pessoa("Bebé na Lista "+i,
							2000+i, Data.today()));
		
		BFIterator listaBFI = lpBFI.iterator();
		
		while ( listaBFI.hasNext() )
			System.out.println( listaBFI.next() );
		
		System.out.println();
		
		while ( listaBFI.hasPrevious() )
			System.out.println( listaBFI.previous() );
	}

}


