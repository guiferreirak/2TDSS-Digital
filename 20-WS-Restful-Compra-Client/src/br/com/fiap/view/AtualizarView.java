package br.com.fiap.view;

import br.com.fiap.repository.CompraRepository;
import br.com.fiap.to.CompraTO;

public class AtualizarView {
	
	public static void main(String[] args) {
		
		CompraRepository r = new CompraRepository();
		
		CompraTO c = new CompraTO(3, "Panela de Press�o El�trica 220V");
		
		try {
			r.atualizar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
