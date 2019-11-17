package aula08.Ex3;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class QQSM {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				try {
					new QQSMFrame();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
