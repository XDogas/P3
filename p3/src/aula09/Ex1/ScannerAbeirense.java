package aula09.Ex1;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

public class ScannerAbeirense implements Iterator<String>, Closeable {
	
	private Scanner sc;
	
	public ScannerAbeirense(InputStream in) {
		sc = new Scanner(in);
	}
	
	public ScannerAbeirense(String str) {
		sc = new Scanner(str);
	}	
	
	public ScannerAbeirense(File file) throws FileNotFoundException {
		sc = new Scanner(file);
	}
	
	@Override
	public boolean hasNext() {
		return sc.hasNext();
	}
	
	@Override
	public String next() {
		return troca(sc.next());
	}
	
	public String nextLine() {
		return troca(sc.nextLine());
	}
	
	public void remove() {
		throw new UnsupportedOperationException("Operação não suportada!");	
	}

	@Override
	public void close() throws IOException {
		sc.close();
	}
	
	public String troca(String s) {
		s = s.replace('V', 'B');
		s = s.replace('v', 'b');
		return s;
	}

}
