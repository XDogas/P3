package aula04.Ex3;

import java.util.ArrayList;

public class ClienteList {
	
	private ArrayList<Cliente> clientes = new ArrayList<>();
		
	public void addCliente(Cliente v) {
		clientes.add(v);
	}
	
	public void removeCliente(Cliente v) {
		clientes.remove(v);
	}
	
	public Cliente getClienteByCC(int cc) {
		for(Cliente c : getClientes()) {
			if(c.cc() == cc) return c;
		}
		throw new IllegalArgumentException();
	}
	
	public int size() {
		return clientes.size();
	}
	
	public Cliente[] getClientes() {	
		return clientes.toArray(new Cliente[size()]);
	}
	
}
