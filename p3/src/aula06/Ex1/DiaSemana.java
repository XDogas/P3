package aula06.Ex1;

public enum DiaSemana {
	
	Segunda, Terça, Quarta, Quinta, Sexta, Sabado, Domingo;
	
	public static DiaSemana[] getDias(){
		return DiaSemana.values();
	}
	
	public static DiaSemana rand() {
        return values()[(int) (Math.random() * values().length)];
    }

}
