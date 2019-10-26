package aula05.Ex3;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Formatos {
	ArrayList<Contacto> loadFile(File file) throws FileNotFoundException;
	void saveFile(Contacto[] contactos, File file) throws IOException;	
}
