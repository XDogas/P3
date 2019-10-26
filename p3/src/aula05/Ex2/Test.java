package aula05.Ex2;

public class Test {

	public static void main(String[] args) {
		
		Veiculo[] listaVeiculos = {
				new Automovel(2012, Cor.cinzento, 4, 5, 1200, Combustivel.Gasolina, 1242, 69, 5.1, 156, "65-MT-25"),
				new Moto(2015, Cor.preto, 2, 2, 140, Combustivel.Gasolina, 125, 15, 2.13, 138, "07-QO-32"),
				new Bicicleta(1995, Cor.vermelho, 2, 1, 15),
				new CarroPolicia(2017, Cor.branco, 4, 5, 1350, Combustivel.Diesel, 1598, 116, 7.1, 186, "17-TV-98", TipoServicos.GNR, "22rt8py"),
				new MotoPolicia(2013, Cor.verde, 3, 2, 200, Combustivel.Gasolina, 1198, 202, 5, 325, "59-AT-10", TipoServicos.PJ, "rgd45rg"),
				new BicicletaPolicia(2018, Cor.vermelho, 2, 1, 10, TipoServicos.Bombeiros, "7toh78t"),
		};
		
		System.out.println("Lista de Veículos: ");
		for(Veiculo v : listaVeiculos) {
			System.out.println(v);
		}
		
		System.out.println("\nLista de Veículos ordenada por ano: ");
		UtilCompare.sortArray(listaVeiculos);
		for(Veiculo v : listaVeiculos) {
			System.out.println(v);
		}

	}

}
