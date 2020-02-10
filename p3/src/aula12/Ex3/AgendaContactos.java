package aula12.Ex3;

import java.util.ArrayList;
import java.util.Collections;

public class AgendaContactos {
	
	private ArrayList<Contacto> listaContactos;
	
	public AgendaContactos() {
		listaContactos = new ArrayList<Contacto>();
	}
	
	public void addContacto(Contacto c) {
		listaContactos.add(c);
	}
	
	public void removeContacto(Contacto c) {
		assert !listaContactos.isEmpty() : "A Agenda de Contactos está vazia";
		listaContactos.remove(c);
	}
	
	public int size() {
		return listaContactos.size();
	}
	
	public Contacto[] getContactos() {
		assert !listaContactos.isEmpty() : "A Agenda de Contactos está vazia";
		return listaContactos.toArray(new Contacto[size()]);
	}
	
	public void sortByName() {
		Collections.sort(listaContactos, Contacto.nameComparator);
	}
	
	public void sortByNum() {
		Collections.sort(listaContactos, Contacto.numComparator);
	}

}
