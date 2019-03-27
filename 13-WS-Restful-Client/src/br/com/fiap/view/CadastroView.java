package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

public class CadastroView {
	
	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		ReservaRepository rep = new ReservaRepository(); 
		Reserva r = new Reserva();
		
		System.out.println("Cliente: ");
		r.setCliente(tec.next());
		System.out.println("Preço: ");
		r.setPreco(tec.nextFloat());
		
		try {
			rep.cadastrar(r);
			System.out.println("Sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tec.close();
	}
	
}
