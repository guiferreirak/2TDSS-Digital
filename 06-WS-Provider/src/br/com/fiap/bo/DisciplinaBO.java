package br.com.fiap.bo;

public class DisciplinaBO {
	
	public double calcularMedia(float am, float ps, float nac) {
		return am*0.3 + nac*0.2 + ps*0.5;
	}
	
	public boolean retidoPorFalta(int aulas, int faltas) {
		return faltas/aulas > 0.25;
	}
	
	public double calcularPS(float am, float nac) {
		return (6 - (am*0.3 + nac * 0.2))*2;
	}
	
}
