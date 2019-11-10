package aula07.Ex1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VoosList {
	
	private TreeMap<String, List<Voo>> voos;
	
	public VoosList() {
		this.voos = new TreeMap<String, List<Voo>>();
	}
	
	public void readFile(String filePath) throws IOException {
		
		assert filePath != null : "Caminho do ficheiro inválido";
		
		this.voos = new TreeMap<String, List<Voo>>();
		
		Path path = Paths.get(filePath);
		List<String> lines = Files.readAllLines(path);
		
		for(String line : lines) {
			String l[] = line.split("\t");
			assert l.length == 3 || l.length == 4;
			
			if(!l[0].equals("Hora")) {
				
				Hora partida = new Hora(Integer.valueOf(l[0].split(":")[0]), Integer.valueOf(l[0].split(":")[1]));
				Voo voo = new Voo(partida, l[1], l[2]);
				
				if(l.length == 4) {
					Hora atraso = new Hora(l[3]);
					voo.setAtraso(atraso);
				}
				
				if(this.voos.get(l[2]) == null) {
					
					ArrayList<Voo> vlist = new ArrayList<Voo>();
					vlist.add(voo);
					this.voos.put(l[2], vlist);
                    
				} else this.voos.get(l[2]).add(voo);
			}
		}
	}
	
	public void readFromBinaryFile(String filePath) throws IOException {
		
		assert filePath != null : "Caminho do ficheiro inválido";
		
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		
		this.voos = new TreeMap<String, List<Voo>>();
		
		byte data[] = new byte[(int)file.length()];
		file.read(data);
        file.close();
        
        String all = new String(data);
        String lines[] = all.split("\n");
        
        for(String line : lines) {
        	String l[] = line.split("\\s{2,}");
            assert l.length == 4 || l.length == 6;

            if(!l[0].equals("Hora")) {
            	
            	Hora partida = new Hora(Integer.valueOf(l[0].split(":")[0]), Integer.valueOf(l[0].split(":")[1]));
                Voo voo = new Voo(partida, l[1], l[3]);
                
                if(l.length == 6) {
                	Hora atraso = new Hora(Integer.valueOf(l[4].split(":")[0]), Integer.valueOf(l[4].split(":")[1]));
                	voo.setAtraso(atraso);
                }
                
                if(this.voos.get(l[3]) == null) {
                	
                	ArrayList<Voo> lf = new ArrayList<Voo>();
                    lf.add(voo);
                    this.voos.put(l[3], lf);
                    
                } else this.voos.get(l[3]).add(voo);
            }
        }
	}
	
	public void saveFile() throws IOException {
		
		Path path = Paths.get("src//aula07//Ex1//Files//Infopublico.txt");

		BufferedWriter bw = Files.newBufferedWriter(path);
		bw.write(this.toString());
	}
	
	public void saveBinFile() throws IOException {
		
		RandomAccessFile file = new RandomAccessFile("src//aula07//Ex1//Files//Infopublico.bin", "rw");
		file.write(this.toString().getBytes());
		file.close();
	}
	
	public void saveCidadesFile() throws IOException {

		Path path = Paths.get("src//aula07//Ex1//Files//cidades.txt");
		
		BufferedWriter bw = Files.newBufferedWriter(path);
		bw.write(this.cidadesToString());
	}
	
	private String cidadesToString() {
		
		String str = String.format("%-8s\t%-20s", "Origem", "Voos");
		TreeMap<Integer, List<String>> sorted = new TreeMap<Integer, List<String>>();

		for(String cidade : this.voos.keySet()) {
			
			List<String> lista = sorted.get(this.voos.get(cidade).size());
			
			if(lista == null) {
				
				List<String> clist = new ArrayList<String>();
				clist.add(cidade);
				sorted.put(this.voos.get(cidade).size(), clist);
				
			} else lista.add(cidade);
		}
			
		for (int i : sorted.descendingKeySet()) {
			for(String cidade : sorted.get(i))
				str += String.format("\n%-8s\t%-20s", i, cidade);
		}

		return str;
	}
	
	@Override
	public String toString() {
		
		String str = String.format("%-6s\t%-10s\t%-22s\t%-25s\t%-8s\t%-15s","Hora", "Voo", "Companhia", "Origem", "Atraso", "Obs");
		
		for(String cidade : this.voos.keySet()) {
			for(Voo voo : this.voos.get(cidade)) str += "\n" + voo.toString();
		}

		return str;
	}

}
