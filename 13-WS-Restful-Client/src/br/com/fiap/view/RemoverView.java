package br.com.fiap.view;

import br.com.fiap.repository.ReservaRepository;

public class RemoverView {
	
	public static void main(String[] args) {
		ReservaRepository rep = new ReservaRepository();
		
		int codigo = 4;
		
		try {
			rep.remover(codigo);
			System.out.println("Removido");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
