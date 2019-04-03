package br.com.fiap.ws.view;

import br.com.fiap.ws.repository.VendaRepository;
import br.com.fiap.ws.to.Venda;

public class RemoverView {

	public static void main(String[] args) {
		
		VendaRepository r = new VendaRepository();
		Venda v = new Venda();
		
		v.setId(2);
		
		try {
			r.remover(v.getId());
			System.out.println("Removido");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
