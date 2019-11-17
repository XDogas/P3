package aula08.Ex1;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class TTT {

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		
		assert args.length <= 1;
		if(args.length == 0) TTTPanel.player = Player.X;
		else if(args[0].equals("X")) TTTPanel.player = Player.X;
		else if(args[0].equals("O"))  TTTPanel.player = Player.O;
		else System.exit(0);

		SwingUtilities.invokeAndWait(new Runnable() {
			public void run() {
				new TTTFrame();
			}
		});

	}

}
