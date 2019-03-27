package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

public class PesquisaView {
	
	public static void main(String[] args) {
		//Ler um código e pesquisar no web service
		Scanner tec = new Scanner(System.in);
		ReservaRepository rep = new ReservaRepository();
		
		System.out.println("Digite codigo que deseja pesquisar: ");
		int codigo = tec.nextInt();
		
		try {
			Reserva reserva = rep.pesquisar(codigo);
			System.out.println(reserva.getCliente());
			System.out.println(reserva.getPreco());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		tec.close();
	}
	
}
