package aula08.Ex2;

import static java.lang.System.exit;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class BitmapViewerFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private PanelImage panelImage;
	private Bitmap bmp;
	private JFileChooser fileChooser;
	private JTextArea textArea;
	
	public BitmapViewerFrame() throws IOException {
		super("Bitmap Editor");
		
		this.setLayout(new BorderLayout());
		
		bmp = new Bitmap("src\\aula08\\Ex2\\Files\\Figura.bmp");
		panelImage = new PanelImage(bmp.getPixelData(), bmp.getWidth(), bmp.getHeight());
		
		textArea = new JTextArea(5, 20);
		textArea.setMargin(new Insets(5, 5, 5, 5));
		textArea.setEditable(false);
	    JScrollPane logScrollPane = new JScrollPane(textArea);
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new FileFilter());
		
		this.setJMenuBar(createMenuBar());
		
		this.add(panelImage, BorderLayout.CENTER);	
		this.add(textArea, BorderLayout.NORTH);
		
		this.setMinimumSize(new Dimension(300,450));
		this.setSize(300,500);		
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		JMenuItem showImageItem = new JCheckBoxMenuItem("Image");
		showImageItem.setSelected(true);
		showMenu.add(showImageItem);
		windowMenu.add(showMenu);
		
		JMenu editMenu = new JMenu("Edit");
		JMenuItem flipVerticalItem = new JMenuItem("Flip vertical");
		JMenuItem flipHorizontalItem = new JMenuItem("Flip horizontal");
		JMenuItem redimensionarItem = new JMenuItem("Redimensionar");
		editMenu.add(flipVerticalItem);
		editMenu.add(flipHorizontalItem);
		editMenu.add(redimensionarItem);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		menuBar.add(editMenu);
		
		showImageItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)e.getSource();
				panelImage.setVisible(menuItem.isSelected());
			}			
		});
		
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(BitmapViewerFrame.this, "Tem a certeza que quer sair da aplicação", "Confirmar saida", JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION) {
					exit(0);
				}				
			}			
		});
		
		importDataItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(BitmapViewerFrame.this) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					textArea.append("Saving: " + file.getName() + ".\n");
			      } else {
			    	  textArea.append("Save command cancelled by user.\n");
			      }
				textArea.setCaretPosition(textArea.getDocument().getLength());
			}
		});
		
		exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showSaveDialog(BitmapViewerFrame.this) == JFileChooser.APPROVE_OPTION) {
					
				}
			}
		});
		//não acabado
//		protected static ImageIcon createImageIcon(String path) {
//		    java.net.URL imgURL = BitmapViewerframe.class.getResource(path);
//		    if (imgURL != null) {
//		      return new ImageIcon(imgURL);
//		    } else {
//		      System.err.println("Couldn't find file: " + path);
//		      return null;
//		    }
//		  }
		
		
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		windowMenu.setMnemonic(KeyEvent.VK_W);
		
		editMenu.setMnemonic(KeyEvent.VK_E);
		flipVerticalItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		flipHorizontalItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		redimensionarItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
				
		return menuBar;
	}

}
