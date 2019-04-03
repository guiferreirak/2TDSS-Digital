package br.com.fiap.ws.view;

import br.com.fiap.ws.repository.VendaRepository;
import br.com.fiap.ws.to.Venda;

public class ConsultarView {

	public static void main(String[] args) {
		
		VendaRepository r = new VendaRepository();
		int id = 5;
		
		try {
			Venda v = r.consultar(id);
			System.out.println("Descrição: " + v.getDescricao());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
