package br.com.fiap.view;

import br.com.fiap.repository.ReservaRepository;
import br.com.fiap.to.Reserva;

public class AtualizarView {
	
	public static void main(String[] args) {
		ReservaRepository rep = new ReservaRepository();
		Reserva r = new Reserva();
		
		r.setCodigo(2);
		r.setCliente("Alfredo");
		r.setPreco(200);
		
		try {
			rep.atualizar(r);
			System.out.println("Atualizado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
