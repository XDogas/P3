package aula08.Ex2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class BitmapViewer {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				try {
					new BitmapViewerFrame();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
