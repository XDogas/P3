package aula11.Ex3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.TreeMap;

public class Ementa {
	
	private String nome;
	private String local;
	private TreeMap<DiaSemana, LinkedList<Prato>> ementaDia;
	
	public Ementa(String nome, String local) {
		this.nome = nome;
		this.local = local;
		this.ementaDia = new TreeMap<>();
	}
	
	public String getNome() { return this.nome; }
	public String getLocal() { return this.local; }
	
	public void addPrato(Prato prato, DiaSemana dia) {		
		LinkedList<Prato> pratos;
		if(ementaDia.containsKey(dia))
			pratos = ementaDia.get(dia);
		else
			pratos = new LinkedList<Prato>();
		pratos.add(prato);
		ementaDia.put(dia, pratos);
	}
	
	public void removePrato(Prato prato, DiaSemana dia) {		
		assert !ementaDia.isEmpty() : "A ementa encontra-se vazia";
		assert ementaDia.get(dia).contains(prato) : "O prato não está associado ao dia";
		
		ementaDia.get(dia).remove(prato);
	}
	
	public Prato selPratoByName(String nome, DiaSemana dia) {
		assert ementaDia.containsKey(dia) : "O dia não tem nenhum prato na ementa";
		LinkedList<Prato> pratos;
		DiaSemana[] dias= DiaSemana.getDias();
		for(DiaSemana d : dias){
			if(ementaDia.containsKey(d)){
				pratos = ementaDia.get(d);
				for(Prato p : pratos){
					if(p.getNome().equals(nome)) return p;
				}
			}	
		}
		return null;
	}
	
	public void saveInFile() throws IOException {		
		String filePath = "src\\aula11\\Ex3\\Files\\Ementa.txt";	
		File file = new File(filePath);
						
		PrintWriter pwf = new PrintWriter(file);
		
		pwf.println("Ementa:");
		
		LinkedList<Prato> pratos;
		DiaSemana[] dias= DiaSemana.getDias();
		for(DiaSemana d : dias){
			if(ementaDia.containsKey(d)){
				pratos = ementaDia.get(d);
				for(Prato p : pratos){
					pwf.println(p.toString() + ", dia " + d.toString());
				}
			}	
		}
		
		pwf.close();
	}
	
	@Override
	public String toString() {
		String str = new String();
		LinkedList<Prato> pratos;
		DiaSemana[] dias= DiaSemana.getDias();
		for(DiaSemana d : dias){
			if(ementaDia.containsKey(d)){
				pratos = ementaDia.get(d);
				for(Prato p : pratos){
					str += p.toString() + ", dia " + d.toString() + "\n";
				}
			}	
		}
		return str;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ementaDia == null) ? 0 : ementaDia.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ementa other = (Ementa) obj;
		if (ementaDia == null) {
			if (other.ementaDia != null)
				return false;
		} else if (!ementaDia.equals(other.ementaDia))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
