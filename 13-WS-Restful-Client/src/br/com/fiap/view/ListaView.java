package br.com.fiap.view;

import java.util.List;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

public class ListaView {

	public static void main(String[] args) {
		
		//Chamar o WS e exibir as reservas cadastradas
		ReservaRepository rep = new ReservaRepository();
		
		try {
			List<Reserva> lista = rep.listar();
			
			for (Reserva r: lista) {
				System.out.println(r.getCliente());
				System.out.println(r.getPreco());
				System.out.println("------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
