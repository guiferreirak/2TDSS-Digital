package br.com.fiap.view;

import java.util.List;

import br.com.fiap.repository.CompraRepository;
import br.com.fiap.to.CompraTO;

public class ListarView {

	public static void main(String[] args) {
		
		CompraRepository r = new CompraRepository();
		
		try {
			List<CompraTO> compras = r.listar();
			for (CompraTO  c: compras) {
				System.out.println("Compras: " + c.getDescricao());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}

}
