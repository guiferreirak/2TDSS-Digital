package br.com.fiap.view;

import java.util.Scanner;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class CorreioView {

	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		try {
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			
			CalcPrazo valores = new CalcPrazo();
			
			valores.setNCdServico("40010");
			System.out.println("Digite CEP origem: ");
			valores.setSCepOrigem(tec.next());
			System.out.println("Digite CEP destino: ");
			valores.setSCepDestino(tec.next());
			
			CalcPrazoResponse resp = stub.calcPrazo(valores);		
			
			System.out.println("Prazo: " + resp.getCalcPrazoResult().getServicos().getCServico()[0].getDataMaxEntrega());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tec.close();

	}

}
