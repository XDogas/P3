package aula08.Ex2;

import java.io.File;

public class FileFilter extends javax.swing.filechooser.FileFilter {

	@Override
	public boolean accept(File file) {
		
		if(file.isDirectory()) {
			return true;
		}
		
		String name = file.getName();
		
		String extension = Utils.getFileExtension(name);
		
		if(extension == null) {
			return false;
		}
		
		if(extension.equals("bmp")) {
			return true;
		}
		
		return false;
	}

	@Override
	public String getDescription() {
		return "Bitmap files (*.bmp)";
	}

}
