package aula12.Ex3;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IPlugin {
	ArrayList<Contacto> loadFile(File file) throws FileNotFoundException;
	void saveFile(Contacto[] contactos, File file) throws IOException;	
}
