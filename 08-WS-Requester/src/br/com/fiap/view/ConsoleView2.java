package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.bo.DisciplinaBOStub;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPS;
import br.com.fiap.bo.DisciplinaBOStub.CalcularPSResponse;

public class ConsoleView2 {

	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		float nac = 0;
		float am = 0;
		
		try {
			DisciplinaBOStub stub = new DisciplinaBOStub();
			
			CalcularPS valores = new CalcularPS();
			
			System.out.println("Digite nota da NAC: ");
			nac = tec.nextFloat();
			System.out.println("Digite nota do AM: ");
			am = tec.nextFloat();
			
			valores.setAm(am);
			valores.setNac(nac);
			
			CalcularPSResponse resp = stub.calcularPS(valores);
			
			double ps = resp.get_return();
			
			System.out.println("Você precisa tirar na PS: " + ps);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tec.close();
	}

}
