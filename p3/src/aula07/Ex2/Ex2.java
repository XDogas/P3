package aula07.Ex2;

import java.io.IOException;

import static java.lang.System.out;

public class Ex2 {

	public static void main(String[] args) throws IOException {

		Bitmap imagem = new Bitmap("src\\aula07\\Ex2\\Files\\Figura.bmp");
		out.println(imagem);
		
		out.println("\n\n");
		
		imagem.saveCopy("src\\aula07\\Ex2\\Files\\Figura(Copy)");
		out.println("Cópia da imagem guardada em Files como Figura(Copy).bmp");
		
		imagem.saveRaw("src\\aula07\\Ex2\\Files\\Figura(RAW)");
		out.println("Imagem em formato RAW guardada em Files como Figura(RAW).raw");
		
		imagem.saveResize("src\\aula07\\Ex2\\Files\\Figura(Resized)");
		out.println("Imagem reduzida a 1/4 guardada em Files como Figura(Resized).bmp");
		
		imagem.saveVerticalFlip("src\\aula07\\Ex2\\Files\\Figura(VerticalFlip)");
		out.println("Imagem inavertida na Vertical guardada em Files como Figura(VerticalFlip).bmp");
		
		imagem.saveHorizontalFlip("src\\aula07\\Ex2\\Files\\Figura(HorizontalFlip)");
		out.println("Imagem inavertida na Horizontal guardada em Files como Figura(HorizontalFlip).bmp");
	}

}
