package aula08.Ex3;

public enum Premio {
	
	VINTECINCO(25),CINQUENTA(50),CENTOEVINTECINCO(125),DUZENTOSECINQUENTA(250),QUINHENTOS(500),SETECENTOSECINQUENTA(750),MILEQUINHENTOS(1500),
	DOISMILEQUINHENTOS(2500),CINCOMIL(5000),DEZMIL(10000),DEZASSEISMIL(16000),TRINTAEDOISMIL(32000),SESSENTAEQUATROMIL(64000),CENTOEVINTECINCOMIL(125000),DUZENTOSECINQUENTAMIL(250000);
	
	private int value;
	Premio(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
	
	public static Premio next(Premio p){
		
		Premio next = null;
		
		switch(p.getValue()){
		case 25:
			next = CINQUENTA;
			break;
		case 50:
			next = CENTOEVINTECINCO;
			break;
		case 125:
			next = DUZENTOSECINQUENTA;
			break;
		case 250:
			next = QUINHENTOS;
			break;
		case 500:
			next = SETECENTOSECINQUENTA;
			break;
		case 750:
			next = MILEQUINHENTOS;
			break;
		case 1500:
			next = DOISMILEQUINHENTOS;
			break;
		case 2500:
			next = CINCOMIL;
			break;
		case 5000:
			next = DEZMIL;
			break;
		case 10000:
			next = DEZASSEISMIL;
			break;
		case 16000:
			next = TRINTAEDOISMIL;
			break;
		case 32000:
			next = SESSENTAEQUATROMIL;
			break;
		case 64000:
			next = CENTOEVINTECINCOMIL;
			break;
		case 125000:
			next = DUZENTOSECINQUENTAMIL;
			break;
		case 250000:
			break;
		}
		return next;
	}

}
