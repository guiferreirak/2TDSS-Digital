package br.com.fiap.view;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.RetidoPorFalta;
import br.com.fiap.bo.DisciplinaBOStub.RetidoPorFaltaResponse;

public class ConsoleView {

	public static void main(String[] args) {
		
		try {
			//Objeto que possui os métodos para chamar o Web Service
			DisciplinaBOStub stub = new DisciplinaBOStub();
			
			//Objeto que possui os parâmetros
			RetidoPorFalta valores = new RetidoPorFalta();
			valores.setAulas(100);
			valores.setFaltas(20);
			
			//Chamando o Web Service (Projeto 06)
			RetidoPorFaltaResponse resp = stub.retidoPorFalta(valores);
			
			boolean retido = resp.get_return();
			System.out.println("Retido: " + retido);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
