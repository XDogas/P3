package teste14_15;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		Cadeira cd1 = new Cadeira("Elite-2", 2034, Mobiliario.Tipo.Sintetico, Cadeira.TipoCadeira.Escritorio, 0.9, 1);
		CadeiraRodas cd2 = new CadeiraRodas("Mobilepluz", 3211, Mobiliario.Tipo.Metal, Cadeira.TipoCadeira.Escritorio, 0.8, 4, 4, false);
		cd2.setTipo(TipoTransporte.MobilidadeRedizuda);		
		Cama c1 = new Cama("Fofinha", 4323, Mobiliario.Tipo.Madeira, 1.90, 1.10, true);
		CamaArticulada ca1 = new CamaArticulada("MaxFlex2000", 4124, Mobiliario.Tipo.Metal, 1.90, 1.20, true, true);		
		Marquesa m1 = new Marquesa("Ix20", 1234, Mobiliario.Tipo.Metal, 1.90, 0.9, true, false);
		Maca ma1 = new Maca("SpeedX2", 9232, Mobiliario.Tipo.Metal, 2.00, 0.8, false, 2);
		ma1.setTipo(TipoTransporte.Urgente);
		
		Clinica cl = new Clinica("Boa Saude");
		
		System.out.println("\n----- Insercao Mobiliário -----");
		System.out.print(cl.addMobiliario(cd1) + ", ");			// true
		System.out.print(cl.addMobiliario(cd1) + ", ");			// false
		System.out.print(cl.addMobiliario(cd2) + ", ");			// true
		System.out.print(cl.addMobiliario(c1) + ", ");			// true
		System.out.print(cl.addMobiliario(ca1) + ", ");			// true
		System.out.print(cl.addMobiliario(m1) + ", ");			// true
		System.out.print(cl.addMobiliario(ma1) + ", ");			// true
		
		System.out.println("\n----- Listagem de todo o Mobiliário -----");
		for(Iterator<Mobiliario> it = cl.getListaMobiliario().iterator(); it.hasNext();)
			System.out.println(it.next());
						
		cl.removeMobiliario(cd1);
		
		System.out.println("\n----- Listagem de Mobiliário de Transporte -----");
		List<Transporte> lo = cl.getListaTransportes();
		for(Iterator<Transporte> it = lo.iterator(); it.hasNext();){
			Transporte tp = it.next();
			System.out.println("Elemento: " + tp + " para transporte " + tp.getTipo());
		}
		
		System.out.println("\n ---- Clínica Files----");
		System.out.println(cl);
		cl.saveClinica("src\\teste14_15\\Files");
		Clinica cl2 = Clinica.loadClinica("src\\teste14_15\\Files");
		System.out.println(cl2);
	}

}
