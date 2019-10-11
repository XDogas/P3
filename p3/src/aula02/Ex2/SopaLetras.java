package aula02.Ex2;

public class SopaLetras {
	
	private char[][] sopa;
	private String[] targets;
	private String[] result;
	private int resultCount;
	private static String[] directions = {"right", "left", "up", "down", "upright", "upleft", "downright", "downleft"};
	
	public SopaLetras(char[][] sopa, String[] targets) {
		
		this.sopa = sopa;
		this.targets = targets;
		this.result = new String[targets.length];
		
		resultCount = 0;
	}
	
	public String[] start() {
		iterar(0,0);
		return result;
	}
	
	public void iterar(int lines, int columns) {
		//int i = 1;
		for(String s : targets) {
			if(Character.toUpperCase(sopa[lines][columns]) == Character.toUpperCase(s.charAt(0))) {
				int dir = verifyDirections(lines,columns,s);
				if(dir != 0) {
					result[resultCount++] = String.format("%10s %d,%d       %s", s,lines+1,columns+1,directions[dir-1]);
					break;
				}
			}
		}
		if(resultCount == targets.length) return;
		
		if(columns == sopa.length - 1) {
			
			if(lines == sopa.length - 1) return;
			iterar(lines+1,0);
		}
		else iterar(lines,columns+1);
	}
	
	public int verifyDirections(int l, int c, String palavra) {
		int i = 1;
		for(; i <= 8; i++) {
			if(verifyDirection(l,c,i,1,palavra)) return i;
		}
		return 0;
	}
	
	public boolean verifyDirection(int l, int c, int direction, int index, String word) {
		
		int line, column;
		
		switch(direction) {
			case 1: 				// Right
				line = l;
				column = c + 1;
				break;
			case 2: 				// Left
				line = l;
				column = c - 1;
				break;
			case 3:					// Up
				line = l - 1;
				column = c;
				break;
			case 4:					// Down
				line = l + 1;
				column = c;
				break;
			case 5: 				// UpRight
				line = l - 1;
				column = c + 1;
				break;
			case 6: 				// UpLeft
				line = l - 1;
				column = c - 1;
				break;
			case 7: 				// DownRight
				line = l + 1;
				column = c + 1;
				break;
			case 8: 				// DownLeft
				line = l + 1;
				column = c - 1;
				break;
			default:
				line = -1;
				column = -1;
				break;
		}
		
		if(line < 0 || column < 0 || line >= sopa.length || column >= sopa.length) return false;
		
		if(Character.toUpperCase(sopa[line][column]) == Character.toUpperCase(word.charAt(index))) {
			
			if(index == word.length() - 1) return true;
			return verifyDirection(line,column,direction,index++,word);
		}
		return false;
		
	}
	
}