
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

//Notas:
//N茫o altere o c贸digo apresentado
//Deve completar o c贸digo da alinea 2
//Comente o c贸digo com erros para garantir que vai executando parcialmente

public class P3_19 {	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Banco obanco = new Banco("PeDeMeia");
		PrintStream fl = new PrintStream(new File("p3_1920L.txt"));
		alinea1(obanco, System.out); // executa e escreve na consola
		alinea2(obanco, fl); // executa e escreve no ficheiro
		fl.close();
	}

	public static void alinea1(Banco b, PrintStream out) {
		out.println("\nAl韓ea 1) ----------------------------------\n");
		
		Cliente c1 = new Individual("Manuel Lima", "281656798", TipoCliente.Balcao); 
		Cliente c2 = new Individual("Laura Marques", "301317832", TipoCliente.Online, "234500232" );
		Cliente c3 = new Individual("Jos茅 Bento", "224456720", TipoCliente.Balcao, "234630535" );
		Cliente c4 = new Empresa("Lima & Irmao", "509434438", TipoCliente.Online, c1);
		Cliente c5 = new Empresa("Reboques Tudo o Bento Leva", "509782153", TipoCliente.Balcao, c3);
		
		//Conta bad = new eConta(c1); 							// Gera uma Excep莽茫o
//		Conta contas[] = {	new Conta(c1), 	new eConta(c2),  new Conta(c3),  new eConta(c4),  new Conta(c5) };
//		System.out.print(b.add(contas[0]) + ", ");  		// true
//		System.out.print(b.add(contas[1]) + ", ");  		// true
//		System.out.print(b.add(contas[2]) + ", ");  		// true
//		System.out.print(b.add(contas[3]) + ", ");  		// true
//		System.out.print(b.add(contas[4]) + ", ");  		// true
//		System.out.print(b.add(contas[1]) + "\n");  		// false
		
//		contas[0].add(new Credito(1000, "20191231"));
//		contas[1].add(new Credito(2000, "20191231"));
//		contas[2].add(new Credito(1400, "20191231"));
//		contas[3].add(new Credito(4000, "20191231"));
		
//		System.out.println("\n----- Listagem de contas -----");
//		for (Iterator<Conta> ri = b.iterator(); ri.hasNext();)
//			System.out.println(ri.next());	

	}
	
	private static void alinea2(Banco b, PrintStream out) throws IOException {
		// Adicione a seguir o c贸digo necess谩rio para ler e processar o ficheiro com os movimentos de conta (usar java streams)
		List<Movimento> movimentos;
//		movimentos.stream().collect(Collector(toList()));
        
        // Adicione a seguir o c贸digo necess谩rio para escrever para ficheiro a lista de contas com saldo negativo (usar java streams)
		out.println("----- Contas com saldo negativo -----");
		List<Conta> contas;
//		contas.stream().filter(c -> c.getSaldo() < 0).collect(Collector(toList));
		

		
        // Adicione a seguir o c贸digo necess谩rio para escrever para ficheiro o saldo total das contas eletr贸nicas (usar java streams)
		out.println("\n----- Saldo total das contas eletr贸nicas -----");
		List<Conta> contas2;
//		contas2.stream().forEach();


	}
}
