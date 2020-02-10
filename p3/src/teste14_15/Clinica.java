package teste14_15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Clinica {
	
	private String nome;
	private ListaGeneric<Mobiliario> lista;
	
	public Clinica(String nome) {
		assert nome.length() > 0 : "Nome inválido";
		this.nome = nome;
		this.lista = new ListaGeneric<>();
	}

	public String getNome() {
		return nome;
	}
	
	public boolean addMobiliario(Mobiliario m) {
		return lista.addElem(m);
	}
	
	public boolean removeMobiliario(Mobiliario m) {
		return lista.removeElem(m);
	}

	public List<Mobiliario> getListaMobiliario() {
		return lista.toList();
	}
	
	public List<Transporte> getListaTransportes() {
		List<Transporte> l = new ArrayList<>();
		for(Mobiliario m : lista.toList())
			if(m instanceof Transporte) l.add((Transporte)m);
		return l;
	}
	
	public void saveClinica(String filePath) throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(this);
		oos.close();
	}
	
	public static Clinica loadClinica(String filePath) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
		Clinica c = (Clinica) ois.readObject();
		ois.close();
		return c;
	}

	@Override
	public String toString() {
		return "Clinica [nome=" + nome + ", lista=" + getListaMobiliario() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
		Clinica other = (Clinica) obj;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
