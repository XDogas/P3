package aula08.Ex2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Bitmap {
	
	private BitmapFileHeader bitmapFileHeader;
	private BitmapInfoHeader bitmapInfoHeader;	
	@SuppressWarnings("unused")
	private byte[] rgbQuad;	// color pallete – opcional (ver abaixo)
	private byte[] data;	// pixel data
	private String name;
	private Pixel[][] pixels;
	
	public Bitmap(File file) throws IOException {
		this(file.getAbsolutePath());
	}

	public Bitmap(String path) throws IOException {
		
		RandomAccessFile file = new RandomAccessFile(path,"r");
			
		this.name = path.split("\\.")[0];
		
		bitmapFileHeader = new BitmapFileHeader(Short.reverseBytes(file.readShort()),
												Integer.reverseBytes(file.readInt()),
												Short.reverseBytes(file.readShort()),
												Short.reverseBytes(file.readShort()),
												Integer.reverseBytes(file.readInt()));
			
		bitmapInfoHeader = new BitmapInfoHeader(Integer.reverseBytes(file.readInt()),
												Integer.reverseBytes(file.readInt()),
												Integer.reverseBytes(file.readInt()),
												Short.reverseBytes(file.readShort()),
												Short.reverseBytes(file.readShort()),
												Integer.reverseBytes(file.readInt()),
												Integer.reverseBytes(file.readInt()),
												Integer.reverseBytes(file.readInt()),
												Integer.reverseBytes(file.readInt()),
												Integer.reverseBytes(file.readInt()),
												Integer.reverseBytes(file.readInt()));
		
		if(bitmapInfoHeader.bitCount < 16) {
			System.out.println("This program does not support a bit count of less than 16-bit");
			System.exit(0);
		}
		
		int byteDataLength = (int)file.length()-bitmapFileHeader.offBits;
		data = new byte[byteDataLength];
		file.read(data);
		file.close();
		
		pixels = byteToPixelArray(data, Math.abs(bitmapInfoHeader.height), Math.abs(bitmapInfoHeader.width));
	
	}
	
	public String name() {
		return name;
	}
	
	public int getWidth() {
		return Math.abs(bitmapInfoHeader.width);
	}
	
	public int getHeight() {
		return Math.abs(bitmapInfoHeader.height);
	}
	
	public byte[] getPixelData() {
		return data;
	}
	
	public int offBits() {
		return bitmapFileHeader.offBits;
	}

	public void saveCopy(String nome) throws IOException {
		write(pixelToByteArray(pixels), nome + ".bmp", bitmapInfoHeader.height, bitmapInfoHeader.width, bitmapFileHeader.size);
	}
	
	public void saveRaw(String nome) throws IOException {
		write(pixelToByteArray(pixels), nome + ".raw", bitmapInfoHeader.height, bitmapInfoHeader.width, bitmapFileHeader.size - bitmapFileHeader.offBits);		
	}	
	
	public void saveResize(String nome) throws IOException {        
		int width = Math.abs(bitmapInfoHeader.width);
		int height = Math.abs(bitmapInfoHeader.height);
        int newWidth = (int) width/2; 
        int newHeight = (int) height/2;
        write(pixelToByteArray(scaleDown(pixels)), nome + ".bmp", newHeight, newWidth, bitmapFileHeader.size/4);
	}
	
	public static Bitmap resize(Bitmap bmp) {
		bmp.pixels = scaleDown(bmp.pixels);
		bmp.bitmapInfoHeader.width = bmp.bitmapInfoHeader.width/2;
		bmp.bitmapInfoHeader.height = bmp.bitmapInfoHeader.height/2;
		bmp.data = Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	private static Pixel[][] scaleDown(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length / 2][pixelData[0].length / 2];
		
		int pixelsX = 0;
        int pixelsY = 0;
        
		for(int y=0; y<pixelData.length/2; y++) {
			
			for(int x = 0; x < pixelData[0].length/2; x++) {
				
				newPixelData[y][x] = pixelData[pixelsY][pixelsX];
				pixelsX += 2;
			}
			
			pixelsX = 0;
			pixelsY += 2;
		}
		return newPixelData;
	}
	
	public void saveHorizontalFlip(String nome) throws IOException {
		write(pixelToByteArray(horizontalFlip(pixels)), nome + ".bmp", bitmapInfoHeader.height, bitmapInfoHeader.width, bitmapFileHeader.size);
	}
	
	private static Pixel[][] horizontalFlip(Pixel[][] pixelData){
		
		Pixel[][] newPixelData = new Pixel[pixelData.length][pixelData[0].length];
		
		for(int y=0; y<pixelData.length; y++) {
			for(int x=0; x<pixelData[0].length; x++) newPixelData[y][x] = pixelData[pixelData.length - y - 1][x];
		}
		
		return newPixelData;
	}
	
	public static byte[] horizontalFlip(byte[] byteArray, int height, int width) {
		return pixelToByteArray(horizontalFlip(byteToPixelArray(byteArray,height,width)));
	}
	
	public static Bitmap horizontalFlip(Bitmap bmp) {
		bmp.pixels = horizontalFlip(bmp.pixels);
		bmp.data = Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	public static Bitmap horizontalFlip(File file) throws IOException {
		return horizontalFlip(new Bitmap(file));
	}
	
	
	public void saveVerticalFlip(String nome) throws IOException {
		write(pixelToByteArray(verticalFlip(pixels)), nome + ".bmp", bitmapInfoHeader.height, bitmapInfoHeader.width, bitmapFileHeader.size);
	}
	
	private static Pixel[][] verticalFlip(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length][pixelData[0].length];
		
		for(int y=0; y<pixelData.length; y++) {
			
			for(int x = 0; x < pixelData[0].length; x++) newPixelData[y][x] = pixelData[y][pixelData[0].length - x - 1];
		}
		
		return newPixelData;
	}
	
	private static byte[] pixelToByteArray(Pixel[][] pixelArray) {
		
		byte[] b = new byte[pixelArray.length * pixelArray[0].length * 3];
		
		int i = 0;
		for(int y=0; y<pixelArray.length; y++) {
			
			for(int x = 0; x < pixelArray[0].length; x++) {
				
				b[i++] = pixelArray[y][x].B;
				b[i++] = pixelArray[y][x].G;
				b[i++] = pixelArray[y][x].R;
			}
		}
		
		return b;
	}
	
	public static Bitmap verticalFlip(Bitmap bmp) {
		bmp.pixels = horizontalFlip(verticalFlip(horizontalFlip(bmp.pixels)));
		bmp.data = Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	public void write(byte[] byteArray, String newFileName, int height, int width, int size) throws IOException {
		write(this, byteArray, newFileName, height, width, size);
	}
	
	public static void write(Bitmap bmp, byte[] byteArray, String newFileName, int height, int width, int size) throws IOException {
		
		RandomAccessFile newFile = new RandomAccessFile(newFileName, "rw");
		
		newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.type));
		newFile.writeInt(Integer.reverseBytes(size));
		newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.reserved1));
		newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.reserved2));
		newFile.writeInt(Integer.reverseBytes(bmp.bitmapFileHeader.offBits));
		newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.size));
		newFile.writeInt(Integer.reverseBytes(width));
		newFile.writeInt(Integer.reverseBytes(-Math.abs(height)));
		newFile.writeShort(Short.reverseBytes(bmp.bitmapInfoHeader.planes));
		newFile.writeShort(Short.reverseBytes(bmp.bitmapInfoHeader.bitCount));
		newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.compression));
		newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.sizeImage));
		newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.xPelsPerMeter));
		newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.yPelsPerMeter));
		newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.clrUsed));
		newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.clrImportant));        
		newFile.write(byteArray);
		newFile.close();
	}
	
	private static Pixel[][] byteToPixelArray(byte[] data, int height, int width) {
		
		Pixel[][] newPixels = new Pixel[height][width];
		
		int i = 0;
		for(int y = 0; y < newPixels.length; y++) {
			for(int x = 0; x < newPixels[0].length; x++) newPixels[y][x] = new Pixel(data[i++],data[i++],data[i++]);
		}
		
		return newPixels;
	}
	
	@Override
	public String toString() {
		return "Informação:\n" + this.bitmapFileHeader + "\n" + this.bitmapInfoHeader;
	}

}
